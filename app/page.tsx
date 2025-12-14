'use client';

import Link from 'next/link';
import { GlowingCard } from '@/components/GlowingCard';
import { motion } from 'framer-motion';

const features = [
  {
    title: 'Adaptive HUD Overhaul',
    description:
      'Context-aware overlays that adapt between combat, exploration, and crafting. Includes modular widgets, minimap layering, and auto-scaling action bar.',
    icon: '🛡️'
  },
  {
    title: 'Cinematic UI Animations',
    description:
      'Framer inspired easing curves power new transitions for inventory, pause, and chat screens with customizable motion profiles.',
    icon: '🎞️'
  },
  {
    title: 'Utility Command Suite',
    description:
      'Quick actions menu, waypoint editor, macro manager, and XP tracker accessible through a radial launcher compatible with PojavLauncher touch input.',
    icon: '🧭'
  }
];

const utilities = [
  {
    title: 'Prism Overlay Composer',
    description: 'Forge config UI inside Minecraft for toggling modules, fine-tuning transparency, and binding gesture controls.',
    icon: '🧩'
  },
  {
    title: 'Session Diagnostics',
    description: 'Real-time FPS, tick-time, GPU load, and connection telemetry with exportable logs for troubleshooting mobile performance.',
    icon: '📈'
  },
  {
    title: 'Replay Bookmarks',
    description: 'Mark gameplay highlights on-the-fly and replay them with smooth camera keyframes using the built-in cinematic timeline.',
    icon: '📽️'
  }
];

const highlights = [
  'Native Forge 1.14.4 build tailored for PojavLauncher environments',
  'Modular architecture with mixins for rendering, input, networking, and config layers',
  'Accessible colorblind palettes, high-contrast text, and haptic-ready cues'
];

export default function Home() {
  return (
    <main className="relative mx-auto flex min-h-screen max-w-6xl flex-col gap-24 px-6 pb-32 pt-20">
      <div className="absolute inset-0 -z-10 overflow-hidden">
        <div className="absolute left-1/2 top-1/5 h-72 w-72 -translate-x-1/2 rounded-full bg-emerald/20 blur-[120px]" />
        <div className="absolute left-10 top-1/2 h-60 w-60 rounded-full bg-sky-400/20 blur-[120px]" />
        <div className="absolute right-0 top-1/3 h-72 w-72 rounded-full bg-amethyst/20 blur-[120px]" />
      </div>

      <section className="grid gap-12 lg:grid-cols-[1.2fr_1fr] lg:items-center">
        <div className="space-y-8">
          <motion.span
            initial={{ opacity: 0, y: -12 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.6 }}
            className="inline-flex items-center gap-3 rounded-full border border-white/10 bg-white/5 px-4 py-2 text-sm uppercase tracking-[0.2em] text-emerald"
          >
            PrismForge UI
          </motion.span>
          <motion.h1
            initial={{ opacity: 0, y: 18 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.7, delay: 0.1 }}
            className="text-4xl font-bold leading-tight text-white sm:text-5xl"
          >
            Reimagine Minecraft 1.14.4 interfaces with precision-tuned motion and utility overlays.
          </motion.h1>
          <motion.p
            initial={{ opacity: 0, y: 18 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.7, delay: 0.25 }}
            className="max-w-xl text-lg text-slate-200/80"
          >
            PrismForge UI refactors the vanilla HUD into a responsive dashboard built for touch and desktop alike, layering high-fidelity
            animations, productivity tools, and diagnostics into a single Forge mod fully compatible with PojavLauncher.
          </motion.p>
          <motion.div
            initial={{ opacity: 0, y: 18 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.7, delay: 0.35 }}
            className="flex flex-wrap items-center gap-4"
          >
            <Link
              href="/downloads/prismforge-ui-mod.tar.gz"
              className="group inline-flex items-center gap-3 rounded-full bg-emerald px-6 py-3 font-semibold text-slate-900 transition hover:scale-105 hover:bg-emerald/90"
            >
              Download Mod (Forge 1.14.4)
            </Link>
            <Link
              href="#features"
              className="inline-flex items-center gap-3 rounded-full border border-white/20 px-6 py-3 text-sm text-slate-200 transition hover:border-white/50"
            >
              Read Documentation
            </Link>
          </motion.div>
        </div>

        <motion.div
          initial={{ opacity: 0, scale: 0.95 }}
          animate={{ opacity: 1, scale: 1 }}
          transition={{ duration: 0.6, delay: 0.2 }}
          className="relative flex aspect-square items-center justify-center rounded-[3rem] border border-white/10 bg-white/5 p-10"
        >
          <div className="absolute inset-4 rounded-[2.5rem] border border-white/10 bg-gradient-to-br from-slate-900 via-slate-950 to-slate-900" />
          <div className="relative grid w-full max-w-xs gap-6 text-sm text-slate-200">
            <div className="rounded-2xl border border-emerald/40 bg-emerald/10 p-5 shadow-lg shadow-emerald/10">
              <p className="font-semibold text-emerald">Adaptive HUD</p>
              <p className="mt-1 text-xs text-slate-200/80">Touch-friendly quickbar, radial wheel, contextual tooltips.</p>
            </div>
            <div className="rounded-2xl border border-sky-400/40 bg-sky-400/10 p-5 shadow-lg shadow-sky-400/10">
              <p className="font-semibold text-sky-300">Motion Studio</p>
              <p className="mt-1 text-xs text-slate-200/80">Curated easing presets with per-widget profiles.</p>
            </div>
            <div className="rounded-2xl border border-amethyst/40 bg-amethyst/10 p-5 shadow-lg shadow-amethyst/10">
              <p className="font-semibold text-amethyst">Session Analytics</p>
              <p className="mt-1 text-xs text-slate-200/80">Overlay graphs w/ exportable telemetry snapshots.</p>
            </div>
          </div>
        </motion.div>
      </section>

      <section id="features" className="space-y-12">
        <div className="space-y-3">
          <h2 className="text-3xl font-semibold text-white">Feature Suite</h2>
          <p className="max-w-2xl text-base text-slate-200/80">
            Each module is written as a dedicated Forge capability and injected via mixins for efficient rendering and minimal tick overhead.
          </p>
        </div>
        <div className="grid gap-8 md:grid-cols-3">
          {features.map((feature) => (
            <GlowingCard key={feature.title} title={feature.title} description={feature.description} icon={feature.icon} />
          ))}
        </div>
      </section>

      <section className="space-y-12">
        <div className="space-y-3">
          <h2 className="text-3xl font-semibold text-white">Utility Arsenal</h2>
          <p className="max-w-2xl text-base text-slate-200/80">
            Productivity modules integrate seamlessly with datapacks, servers, and single-player worlds with synced configuration profiles.
          </p>
        </div>
        <div className="grid gap-8 md:grid-cols-3">
          {utilities.map((feature) => (
            <GlowingCard key={feature.title} title={feature.title} description={feature.description} icon={feature.icon} accent="amethyst" />
          ))}
        </div>
      </section>

      <section className="rounded-3xl border border-white/10 bg-white/5 p-10 backdrop-blur-xl">
        <div className="grid gap-10 lg:grid-cols-[1fr,1.2fr]">
          <div className="space-y-6">
            <h2 className="text-3xl font-semibold text-white">Build Highlights</h2>
            <ul className="space-y-4 text-base text-slate-200/80">
              {highlights.map((line) => (
                <li key={line} className="flex items-start gap-3">
                  <span className="mt-1 inline-flex h-2 w-2 shrink-0 translate-y-1 rounded-full bg-emerald" />
                  <span>{line}</span>
                </li>
              ))}
            </ul>
            <Link
              href="/docs/getting-started"
              className="inline-flex w-fit items-center gap-2 rounded-full border border-white/10 bg-white/5 px-5 py-3 text-sm text-slate-200 transition hover:border-white/40"
            >
              View Setup Guide →
            </Link>
          </div>
          <div className="space-y-6">
            <h3 className="text-2xl font-semibold text-white">Release Package</h3>
            <p className="text-slate-200/80">
              The downloadable zip ships with the Forge Gradle project, Kotlin-powered mixins, resource assets, and JSON-driven UI layouts.
              Build the mod with `gradlew build` and drop the resulting JAR into your `.minecraft/mods` folder on desktop or the
              `games/PojavLauncher/.minecraft/mods` directory on Android.
            </p>
            <div className="rounded-2xl border border-white/10 bg-black/30 p-6">
              <pre className="text-sm text-emerald">
{`
./gradlew setup
./gradlew build
mods/PrismForge-1.14.4.jar
`}
              </pre>
            </div>
          </div>
        </div>
      </section>

      <footer className="border-t border-white/5 pt-10 text-sm text-slate-400/70">
        Crafted for Minecraft 1.14.4 · PrismForge UI is licensed under LGPL-3.0.
      </footer>
    </main>
  );
}
