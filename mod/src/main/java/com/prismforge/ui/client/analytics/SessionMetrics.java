package com.prismforge.ui.client.analytics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.NetworkPlayerInfo;

public final class SessionMetrics {
    private int fps;
    private float tickTimeMs;
    private int pingMs;

    public void captureSnapshot(final Minecraft minecraft) {
        this.fps = Minecraft.fps;
        this.tickTimeMs = fps <= 0 ? 0.0F : 1000.0F / fps;

        if (minecraft.player != null && minecraft.getConnection() != null) {
            final NetworkPlayerInfo info = minecraft.getConnection().getPlayerInfo(minecraft.player.getUUID());
            this.pingMs = info == null ? 0 : info.getLatency();
        } else {
            this.pingMs = 0;
        }
    }

    public String getFps() {
        return fps + " fps";
    }

    public String getTickTimeMs() {
        return String.format("%.1f ms", tickTimeMs);
    }

    public String getPingMs() {
        return pingMs + " ms";
    }
}
