const exampleConfig = `{
  "hud": {
    "layout": "aurora",
    "widgets": ["health", "armor", "compass", "radar"],
    "animations": {
      "enter": "spring",
      "exit": "ease-in-out"
    },
    "touch": {
      "gesture": "edge-swipe",
      "tolerance": 12
    }
  },
  "spectra": {
    "slots": 8,
    "quickActions": ["waypoint", "macro", "screenshot"],
    "theme": "emerald"
  },
  "pulse": {
    "logging": true,
    "exportInterval": 120,
    "metrics": ["fps", "tick", "gpu", "ping"]
  }
}`;

export default function ConfigPage() {
  return (
    <main className="mx-auto max-w-4xl space-y-12 px-6 py-16">
      <header className="space-y-4">
        <p className="text-sm uppercase tracking-[0.2em] text-emerald">Docs</p>
        <h1 className="text-4xl font-semibold text-white">Configuration Schema</h1>
        <p className="text-base text-slate-200/80">
          PrismForge uses a hybrid JSON/TOML config layer with live reload support. Copy the example below into `config/prismforge.json` or
          configure in-game using the Aurora HUD composer.
        </p>
      </header>

      <section className="rounded-2xl border border-white/10 bg-black/40 p-6">
        <pre className="overflow-x-auto text-sm text-emerald">
          <code>{exampleConfig}</code>
        </pre>
      </section>
    </main>
  );
}
