# PrismForge UI — Minecraft 1.14.4 Forge Mod & Companion Site

PrismForge UI is a cinematic interface and utility mod targeting Minecraft Java Edition 1.14.4 with first-class support for PojavLauncher. This repository ships both the Forge mod source code (Java) and a Next.js documentation/download portal ready for deployment on Vercel.

## Contents

- `mod/` — ForgeGradle 3 project implementing the PrismForge UI mod.
- `public/downloads/` — Packaged archive of the mod project (`prismforge-ui-mod.tar.gz`).
- `app/`, `components/`, `lib/` — Next.js 14 app router project that showcases features, docs, and downloads.

## Requirements

- Node.js 18+
- npm (bundled with Node)
- Java 8 runtime (for building the Forge mod)

## Web App Development

```bash
npm install
npm run dev
```

Visit `http://localhost:3000` to explore the documentation site. Use `npm run build` for a production bundle and `npm start` to serve the compiled output.

## Building the Forge Mod

```bash
cd mod
./gradlew setup
./gradlew build
```

The mod jar (`PrismForge-1.14.4.jar`) will be produced in `mod/build/libs`. Drop it into your `.minecraft/mods` directory (desktop) or `games/PojavLauncher/.minecraft/mods` on Android.

## Key Features

- Adaptive Aurora HUD with modular widgets and touch-ready layout
- Spectra radial command launcher with animated sectors
- Pulse analytics overlay for FPS, tick timing, and latency snapshots
- Configurable animation curves and scaling via Forge config spec

## License

The mod source and documentation site are provided under the LGPL-3.0 license as declared in `mod/src/main/resources/META-INF/mods.toml`.
