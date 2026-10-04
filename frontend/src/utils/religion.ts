// Mesmos ids de ReligionFilter.SELECTABLE no backend. O cristianismo é dividido em três
// denominações: o usuário escolhe "cristianismo" e, em seguida, a sua vertente.
export const CHRISTIAN_DENOMINATIONS = ['catholic', 'protestant', 'orthodox'] as const;
export type ChristianDenomination = (typeof CHRISTIAN_DENOMINATIONS)[number];

export const RELIGIONS = [...CHRISTIAN_DENOMINATIONS, 'judaism', 'islam', 'buddhism', 'hinduism'] as const;
export type Religion = (typeof RELIGIONS)[number];

// Alternativas da primeira pergunta de religião (antes da escolha da denominação cristã).
export const RELIGION_CHOICES = ['christianity', 'judaism', 'islam', 'buddhism', 'hinduism'] as const;
export type ReligionChoice = (typeof RELIGION_CHOICES)[number];

// Link antigo com religion=christianity (antes das denominações) vira "sem filtro".
export function parseReligion(raw: string | null | undefined): Religion | null {
  const value = raw?.trim().toLowerCase();
  return (RELIGIONS as readonly string[]).includes(value ?? '') ? (value as Religion) : null;
}

// Keep E for "none" so saved quiz progress retains its original meaning.
export const RELIGION_OPTION_IDS: Record<ReligionChoice | 'none', string> = {
  christianity: 'A', judaism: 'B', islam: 'C', buddhism: 'D', hinduism: 'F', none: 'E'
};

export function religionForOption(option: string | undefined): ReligionChoice | null {
  return RELIGION_CHOICES.find(religion => RELIGION_OPTION_IDS[religion] === option) ?? null;
}
