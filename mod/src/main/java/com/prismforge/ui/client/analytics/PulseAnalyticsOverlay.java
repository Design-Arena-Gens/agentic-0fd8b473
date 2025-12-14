package com.prismforge.ui.client.analytics;

import com.mojang.blaze3d.platform.GlStateManager;
import com.prismforge.ui.PrismForgeConfig;
import com.prismforge.ui.PrismForgeTelemetry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class PulseAnalyticsOverlay {
    private static final int WIDTH = 120;
    private static final int HEIGHT = 46;

    @SubscribeEvent
    public void handleOverlay(final RenderGameOverlayEvent.Post event) {
        if (!PrismForgeConfig.ANALYTICS_ENABLE.get()) {
            return;
        }

        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        final Minecraft minecraft = Minecraft.getInstance();
        final SessionMetrics metrics = PrismForgeTelemetry.metrics();

        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();

        final int x = event.getWindow().getGuiScaledWidth() - WIDTH - 14;
        final int y = 14;

        AbstractOverlayDrawer.drawBackdrop(x, y, WIDTH, HEIGHT);
        AbstractOverlayDrawer.drawMetric(minecraft.font, x + 12, y + 10, "FPS", metrics.getFps());
        AbstractOverlayDrawer.drawMetric(minecraft.font, x + 12, y + 22, "Tick", metrics.getTickTimeMs());
        AbstractOverlayDrawer.drawMetric(minecraft.font, x + 12, y + 34, "Ping", metrics.getPingMs());

        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
}
