package com.prismforge.ui.client;

import com.prismforge.ui.PrismForgeConfig;
import com.prismforge.ui.client.analytics.PulseAnalyticsOverlay;
import com.prismforge.ui.client.hud.AuroraHudOverlay;
import com.prismforge.ui.client.menu.SpectraRadialMenu;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class PrismForgeClient {
    private static final AuroraHudOverlay HUD_OVERLAY = new AuroraHudOverlay();
    private static final PulseAnalyticsOverlay ANALYTICS_OVERLAY = new PulseAnalyticsOverlay();
    private static final SpectraRadialMenu RADIAL_MENU = new SpectraRadialMenu();

    private PrismForgeClient() {}

    public static void init() {
        MinecraftForge.EVENT_BUS.register(HUD_OVERLAY);
        MinecraftForge.EVENT_BUS.register(ANALYTICS_OVERLAY);
        MinecraftForge.EVENT_BUS.register(RADIAL_MENU);
        MinecraftForge.EVENT_BUS.register(new GestureTicker());
    }

    private static final class GestureTicker {
        @SubscribeEvent
        public void handleTick(final TickEvent.ClientTickEvent event) {
            if (event.phase != TickEvent.Phase.END) {
                return;
            }

            if (PrismForgeConfig.RADIAL_ENABLE.get()) {
                RADIAL_MENU.tick();
            }
        }
    }
}
