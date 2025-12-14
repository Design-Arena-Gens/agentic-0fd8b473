'use client';

import { motion } from 'framer-motion';
import { cn } from '@/lib/utils';

type Props = {
  title: string;
  description: string;
  icon: React.ReactNode;
  accent?: 'emerald' | 'amethyst' | 'sky';
};

const accentMap = {
  emerald: 'from-emerald to-sky-400 shadow-emerald/40',
  amethyst: 'from-amethyst to-sky-400 shadow-amethyst/40',
  sky: 'from-sky-400 to-emerald shadow-sky-400/40'
};

export function GlowingCard({ title, description, icon, accent = 'emerald' }: Props) {
  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      whileInView={{ opacity: 1, y: 0 }}
      viewport={{ once: true, amount: 0.3 }}
      transition={{ duration: 0.4 }}
      className={cn(
        'relative overflow-hidden rounded-3xl border border-white/10 bg-white/5 p-8 shadow-lg transition hover:border-white/30',
        'backdrop-blur-xl'
      )}
    >
      <div
        className={cn(
          'absolute -right-28 -top-28 h-56 w-56 rounded-full bg-gradient-to-br opacity-30 blur-3xl',
          accentMap[accent]
        )}
      />
      <div className="mb-6 inline-flex h-14 w-14 items-center justify-center rounded-2xl border border-white/10 bg-white/10 text-2xl">
        {icon}
      </div>
      <h3 className="text-2xl font-semibold text-white">{title}</h3>
      <p className="mt-4 text-base text-slate-200/80">{description}</p>
    </motion.div>
  );
}
