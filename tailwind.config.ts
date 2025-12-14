import type { Config } from 'tailwindcss';

const config: Config = {
  content: [
    './app/**/*.{ts,tsx}',
    './components/**/*.{ts,tsx}'
  ],
  theme: {
    extend: {
      colors: {
        obsidian: '#0f172a',
        emerald: '#1fdd94',
        amethyst: '#a855f7'
      }
    }
  },
  plugins: []
};

export default config;
