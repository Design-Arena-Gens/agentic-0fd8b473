package com.prismforge.ui;

import com.prismforge.ui.client.analytics.SessionMetrics;
import net.minecraft.client.Minecraft;

public final class PrismForgeTelemetry {
    private static final SessionMetrics METRICS = new SessionMetrics();

    private PrismForgeTelemetry() {}

    public static SessionMetrics metrics() {
        return METRICS;
    }

    public static void pushFrame() {
        final Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || minecraft.level == null) {
            return;
        }

        METRICS.captureSnapshot(minecraft);
    }
}
