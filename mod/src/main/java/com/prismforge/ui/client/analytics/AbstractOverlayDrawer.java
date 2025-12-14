package com.prismforge.ui.client.analytics;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.AbstractGui;

final class AbstractOverlayDrawer extends AbstractGui {
    private AbstractOverlayDrawer() {}

    static void drawBackdrop(final int x, final int y, final int width, final int height) {
        fill(x, y, x + width, y + height, 0x990A1120);
        fill(x, y, x + width, y + 1, 0x331FDD94);
        fill(x, y + height - 2, x + width, y + height - 1, 0x331FDD94);
    }

    static void drawMetric(final FontRenderer font, final int x, final int y, final String label, final String value) {
        GlStateManager.pushMatrix();
        GlStateManager.translatef(0.0F, 0.0F, 200.0F);
        font.drawShadow(label + ":", x, y, 0xFF60A5FA);
        font.drawShadow(value, x + 46, y, 0xFFE2E8F0);
        GlStateManager.popMatrix();
    }
}
