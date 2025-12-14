package com.prismforge.ui.client.menu;

import com.mojang.blaze3d.platform.GlStateManager;
import com.prismforge.ui.PrismForgeConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.util.InputMappings;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public final class SpectraRadialMenu extends AbstractGui {
    private static final int SECTORS = 8;
    private boolean active;
    private float animationProgress;
    private int selectedIndex;

    public void tick() {
        if (!active) {
            return;
        }

        animationProgress = Math.min(animationProgress + 0.08F * PrismForgeConfig.ANIMATION_SPEED.get().floatValue(), 1.0F);
        updateSelection();
    }

    @SubscribeEvent
    public void onRenderOverlay(final RenderGameOverlayEvent.Post event) {
        if (!active || event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        final Minecraft minecraft = Minecraft.getInstance();
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();

        final int cx = event.getWindow().getGuiScaledWidth() / 2;
        final int cy = event.getWindow().getGuiScaledHeight() / 2;
        final int radius = (int) (90 * animationProgress);

        for (int i = 0; i < SECTORS; i++) {
            final float start = (float) (i * (2 * Math.PI / SECTORS) - Math.PI / 2);
            final float end = start + (float) (2 * Math.PI / SECTORS);
            final int color = i == selectedIndex ? 0xAA1FDD94 : 0x6646C3F7;
            fillSector(cx, cy, radius, start, end, color);
        }

        drawCenteredString(minecraft.font, "Spectra", cx, cy - 6, 0xFFFFFFFF);
        drawCenteredString(minecraft.font, actionFor(selectedIndex), cx, cy + 8, 0xFFE0F2FE);

        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        final Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || minecraft.screen != null) {
            deactivate();
            return;
        }

        final long window = minecraft.getWindow().getWindow();
        final boolean trigger = InputMappings.isKeyDown(window, 82); // R key

        if (trigger && PrismForgeConfig.RADIAL_ENABLE.get()) {
            activate();
        } else {
            deactivate();
        }
    }

    private void activate() {
        if (!active) {
            animationProgress = 0.0F;
            selectedIndex = 0;
        }
        active = true;
    }

    private void deactivate() {
        active = false;
    }

    private void updateSelection() {
        final Minecraft minecraft = Minecraft.getInstance();
        final double mouseX = minecraft.mouseHandler.xpos();
        final double mouseY = minecraft.mouseHandler.ypos();
        final double screenWidth = minecraft.getWindow().getScreenWidth();
        final double screenHeight = minecraft.getWindow().getScreenHeight();

        final double centeredX = (mouseX - screenWidth / 2.0);
        final double centeredY = (mouseY - screenHeight / 2.0);
        double angle = Math.atan2(centeredY, centeredX) + Math.PI / 2;
        if (angle < 0) {
            angle += Math.PI * 2;
        }
        final int index = MathHelper.floor(angle / (Math.PI * 2 / SECTORS)) % SECTORS;
        selectedIndex = MathHelper.clamp(index, 0, SECTORS - 1);
    }

    private void fillSector(final int cx, final int cy, final int radius, final float start, final float end, final int color) {
        final int segments = 16;
        final int alpha = (color >> 24) & 0xFF;
        final int red = (color >> 16) & 0xFF;
        final int green = (color >> 8) & 0xFF;
        final int blue = color & 0xFF;

        GlStateManager.disableTexture();
        GlStateManager.disableAlphaTest();
        GlStateManager.disableDepthTest();

        final Tessellator tessellator = Tessellator.getInstance();
        final BufferBuilder buffer = tessellator.getBuilder();
        buffer.begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION_COLOR);
        buffer.vertex(cx, cy, 0.0F).color(red, green, blue, alpha).endVertex();
        for (int i = 0; i <= segments; i++) {
            final float angle = start + (end - start) * i / segments;
            final float x = cx + MathHelper.cos(angle) * radius;
            final float y = cy + MathHelper.sin(angle) * radius;
            buffer.vertex(x, y, 0.0F).color(red, green, blue, alpha).endVertex();
        }
        tessellator.end();

        GlStateManager.enableDepthTest();
        GlStateManager.enableAlphaTest();
        GlStateManager.enableTexture();
    }

    private String actionFor(final int index) {
        switch (index) {
            case 0:
                return "Waypoint";
            case 1:
                return "Macro";
            case 2:
                return "Screenshot";
            case 3:
                return "Analytics";
            case 4:
                return "Replay";
            case 5:
                return "Chat";
            case 6:
                return "Inventory";
            case 7:
            default:
                return "Config";
        }
    }
}
