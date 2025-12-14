import Link from 'next/link';

const modules = [
  {
    name: 'Aurora HUD',
    summary: 'Adaptive HUD with modular widgets and snapshots.',
    hotkey: 'F6 / Touch edge swipe',
    config: 'hud.toml'
  },
  {
    name: 'Spectra Menu',
    summary: 'Animated radial command wheel with customizable sectors.',
    hotkey: 'R',
    config: 'spectra.json'
  },
  {
    name: 'Pulse Analytics',
    summary: 'Performance dashboard with tick graphs and session exporter.',
    hotkey: 'Shift + P',
    config: 'analytics.yml'
  }
];

export default function ModulesPage() {
  return (
    <main className="mx-auto max-w-4xl space-y-12 px-6 py-16">
      <header className="space-y-4">
        <p className="text-sm uppercase tracking-[0.2em] text-emerald">Docs</p>
        <h1 className="text-4xl font-semibold text-white">Module Reference</h1>
        <p className="text-base text-slate-200/80">
          Every PrismForge module is opt-in and configurable. Use this reference to understand lifecycle hooks, shortcuts, and configuration
          files.
        </p>
      </header>

      <section className="grid gap-6">
        {modules.map((module) => (
          <article key={module.name} className="space-y-3 rounded-2xl border border-white/10 bg-white/5 p-6">
            <div className="flex items-center justify-between">
              <h2 className="text-2xl font-semibold text-white">{module.name}</h2>
              <span className="text-xs uppercase tracking-wide text-slate-200/70">Hotkey: {module.hotkey}</span>
            </div>
            <p className="text-slate-200/80">{module.summary}</p>
            <p className="text-xs text-slate-400/70">Config file: {module.config}</p>
          </article>
        ))}
      </section>

      <Link href="/docs/getting-started" className="text-sm text-emerald hover:text-emerald/80">
        ← Back to Getting Started
      </Link>
    </main>
  );
}
