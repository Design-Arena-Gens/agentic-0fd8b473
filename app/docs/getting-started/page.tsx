import Link from 'next/link';

export default function GettingStartedPage() {
  return (
    <main className="mx-auto max-w-4xl space-y-12 px-6 py-16">
      <div className="space-y-4">
        <p className="text-sm uppercase tracking-[0.2em] text-emerald">Docs</p>
        <h1 className="text-4xl font-semibold text-white">Getting Started</h1>
        <p className="text-base text-slate-200/80">
          Follow these steps to build, install, and customize PrismForge UI for Minecraft Java 1.14.4. The mod is tuned for both desktop and
          PojavLauncher environments.
        </p>
      </div>

      <section className="space-y-6">
        <h2 className="text-2xl font-semibold text-white">Requirements</h2>
        <ul className="space-y-2 text-slate-200/80">
          <li>Java 8 (Adoptium/OpenJDK) configured in your PATH.</li>
          <li>Minecraft Forge 1.14.4 - 28.2.x (installer included in the repo release).</li>
          <li>Gradle Wrapper included with the project (no external installation required).</li>
        </ul>
      </section>

      <section className="space-y-6">
        <h2 className="text-2xl font-semibold text-white">Desktop Setup</h2>
        <ol className="list-decimal space-y-3 pl-6 text-slate-200/80">
          <li>Extract `prismforge-ui-mod.tar.gz` and open a terminal in the project root.</li>
          <li>Run `./gradlew genIntellijRuns` (or `genEclipseRuns`) to generate run configs.</li>
          <li>Execute `./gradlew build` to produce the mod JAR in `build/libs`.</li>
          <li>Copy `PrismForge-1.14.4.jar` into `%APPDATA%/.minecraft/mods` (Windows) or `~/.minecraft/mods` (macOS/Linux).</li>
        </ol>
      </section>

      <section className="space-y-6">
        <h2 className="text-2xl font-semibold text-white">PojavLauncher Deployment</h2>
        <ol className="list-decimal space-y-3 pl-6 text-slate-200/80">
          <li>Copy the built JAR to your device&apos;s Downloads folder.</li>
          <li>Navigate to `Android/data/net.kdt.pojavlaunch/files/games/PojavLauncher/.minecraft/mods`.</li>
          <li>Paste the JAR, then launch Minecraft 1.14.4 Forge profile in PojavLauncher.</li>
          <li>Use the in-game PrismForge Menu (`F6` or touch gesture) to configure modules.</li>
        </ol>
      </section>

      <section className="space-y-4">
        <h2 className="text-2xl font-semibold text-white">Resources</h2>
        <ul className="space-y-2 text-slate-200/80">
          <li>
            <Link href="/docs/modules" className="text-emerald hover:text-emerald/80">
              Module Reference
            </Link>
          </li>
          <li>
            <Link href="/docs/config" className="text-emerald hover:text-emerald/80">
              Config Schema
            </Link>
          </li>
        </ul>
      </section>
    </main>
  );
}
