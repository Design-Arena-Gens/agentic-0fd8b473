package com.prismforge.ui.client.hud;

import com.mojang.blaze3d.platform.GlStateManager;
import com.prismforge.ui.PrismForgeConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class AuroraHudOverlay extends AbstractGui {
    private static final ResourceLocation HUD_ATLAS = new ResourceLocation("prismforge", "textures/gui/aurora_hud.png");
    private float animationTime = 0.0F;

    @SubscribeEvent
    public void onRenderOverlay(final RenderGameOverlayEvent.Post event) {
        if (!PrismForgeConfig.HUD_ENABLE.get()) {
            return;
        }

        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        final Minecraft minecraft = Minecraft.getInstance();
        final PlayerEntity player = minecraft.player;
        if (player == null) {
            return;
        }

        final float scale = PrismForgeConfig.HUD_SCALE.get().floatValue();
        final int width = event.getWindow().getGuiScaledWidth();
        final int height = event.getWindow().getGuiScaledHeight();

        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.9F);
        GlStateManager.scalef(scale, scale, scale);

        minecraft.getTextureManager().bind(HUD_ATLAS);

        final int baseX = (int) ((width / scale) / 2.0F) - 91;
        final int baseY = (int) ((height / scale) - 49);

        this.blit(baseX, baseY, 0, 0, 182, 22);
        renderAdaptiveBars(player, baseX + 1, baseY + 1);
        renderCompass(width, baseY - 24);

        GlStateManager.disableBlend();
        GlStateManager.popMatrix();

        updateAnimation();
    }

    private void renderAdaptiveBars(final PlayerEntity player, final int x, final int y) {
        final int health = (int) Math.ceil(player.getHealth());
        final int maxHealth = (int) Math.ceil(player.getMaxHealth());
        final float ratio = maxHealth == 0 ? 0 : (float) health / maxHealth;
        final int filled = (int) (ratio * 180);

        this.fill(x, y, x + filled, y + 2, 0xFF1FDD94);
        this.fill(x + filled, y, x + 180, y + 2, 0x661FDD94);

        final int armor = player.getArmorValue();
        final int armorWidth = Math.min(armor * 9, 180);
        this.fill(x, y + 4, x + armorWidth, y + 6, 0xFF60A5FA);

        final int foodLevel = player.getFoodData().getFoodLevel();
        final int foodWidth = (int) (Math.min(foodLevel / 20.0F, 1.0F) * 180);
        this.fill(x, y + 8, x + foodWidth, y + 10, 0xFFA855F7);
    }

    private void renderCompass(final int screenWidth, final int y) {
        final Minecraft minecraft = Minecraft.getInstance();
        final int centerX = screenWidth / 2;
        final String direction = minecraft.player == null ? "" : minecraft.player.getDirection().getSerializedName().toUpperCase();
        final String coords = minecraft.player == null
            ? ""
            : String.format("X %.1f Z %.1f", minecraft.player.getX(), minecraft.player.getZ());

        drawCenteredString(minecraft.font, direction, centerX, y, 0xFFFFFFFF);
        drawCenteredString(minecraft.font, coords, centerX, y + 10, 0xFF60A5FA);
    }

    private void updateAnimation() {
        final float speed = PrismForgeConfig.ANIMATION_SPEED.get().floatValue();
        animationTime += 0.01F * speed;
    }
}
