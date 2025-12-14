package com.prismforge.ui;

import com.prismforge.ui.client.PrismForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PrismForgeMod.MOD_ID)
@Mod.EventBusSubscriber(modid = PrismForgeMod.MOD_ID, bus = Bus.MOD)
public final class PrismForgeMod {
    public static final String MOD_ID = "prismforge";

    public PrismForgeMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(this::onClientSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, PrismForgeConfig.SPEC);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        PrismForgeLifecycle.bootstrap();
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        PrismForgeClient.init();
    }
}
