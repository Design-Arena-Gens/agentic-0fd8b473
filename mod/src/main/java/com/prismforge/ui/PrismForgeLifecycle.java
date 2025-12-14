package com.prismforge.ui;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class PrismForgeLifecycle {
    private static boolean bootstrapped = false;
    private static int tickCounter = 0;

    private PrismForgeLifecycle() {}

    public static void bootstrap() {
        if (bootstrapped) {
            return;
        }

        MinecraftForge.EVENT_BUS.register(new PrismForgeLifecycle());
        bootstrapped = true;
    }

    @SubscribeEvent
    public void handleClientTick(final TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        tickCounter++;
        if (tickCounter % 40 == 0) {
            PrismForgeTelemetry.pushFrame();
        }
    }
}
