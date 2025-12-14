package com.prismforge.ui;

import net.minecraftforge.common.ForgeConfigSpec;

public final class PrismForgeConfig {
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue HUD_ENABLE;
    public static final ForgeConfigSpec.BooleanValue RADIAL_ENABLE;
    public static final ForgeConfigSpec.BooleanValue ANALYTICS_ENABLE;

    public static final ForgeConfigSpec.DoubleValue HUD_SCALE;
    public static final ForgeConfigSpec.DoubleValue ANIMATION_SPEED;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("hud");
        HUD_ENABLE = builder.comment("Enable the Aurora HUD overlay")
            .define("enabled", true);
        HUD_SCALE = builder.comment("HUD global scaling factor")
            .defineInRange("scale", 1.0D, 0.5D, 2.0D);
        builder.pop();

        builder.push("spectra");
        RADIAL_ENABLE = builder.comment("Enable Spectra radial menu")
            .define("enabled", true);
        builder.pop();

        builder.push("analytics");
        ANALYTICS_ENABLE = builder.comment("Enable Pulse analytics overlay")
            .define("enabled", true);
        builder.pop();

        builder.push("animation");
        ANIMATION_SPEED = builder.comment("Base animation speed multiplier")
            .defineInRange("speed", 1.0D, 0.1D, 3.0D);
        builder.pop();

        SPEC = builder.build();
    }

    private PrismForgeConfig() {}
}
