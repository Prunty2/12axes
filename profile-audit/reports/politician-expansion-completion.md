# Notable political figures — upstream submission

31 new profiles; 439 total personalities. The requested 32-person scope is covered: David Ben-Gurion was added upstream independently and remains unchanged. Base: `811b0ad0447eda27b84bc51ce8257e93edb61f1f`.

## Included figures

| Country | New profiles |
| --- | --- |
| Australia | Anthony Albanese, Pauline Hanson, Angus Taylor, John Howard, Robert Menzies, Gough Whitlam, Bob Hawke, Paul Keating, Kevin Rudd, Julia Gillard, Tony Abbott, Malcolm Turnbull, Scott Morrison, Joh Bjelke-Petersen |
| United Kingdom | Margaret Thatcher, Clement Attlee, Boris Johnson, Keir Starmer, Nigel Farage, Rupert Lowe, David Lloyd George |
| United States | Kamala Harris, Hillary Clinton, Jimmy Carter, Lyndon B. Johnson |
| Germany | Angela Merkel, Olaf Scholz, Helmut Kohl |
| Canada | Mark Carney |
| Poland | Lech Wałęsa |
| Israel | Golda Meir |

Already present and preserved: **David Ben-Gurion**. His upstream metadata, portrait, vector, book and answer archive are untouched. His separate review is retained as unused audit history, not applied to production.

Winston Churchill, Justin Trudeau, Dominik Tarczyński, Xi Jinping and Kim Jong Un were also already present; no duplicate entries are introduced.

## What users gain

A broader set of recognisable political comparisons across Australia, the UK, the US, Germany, Canada, Poland and Israel. Each new entry works in results and generated profile pages in Portuguese and English, with a real credited portrait and a vector computed from 240 independently answered questions plus five archetype choices. Twenty-nine self-authored political books are added. No qualifying book was verified for Anthony Albanese or Rupert Lowe.

## Verification

- Full backend suite: **159 passed, 1 failed, 0 errors/skips (160 total)**. All 31 new-profile integration cases passed, each submitting all 240 answers plus archetypes in both languages and returning that person at 100%.
- The single failure is `IdeologyCountryMappingTest.everyCountryFlagIsAValidRasterAsset`: upstream `reino-de-israel` uses a Reddit reconstruction while the test requires Wikimedia Commons. A separate untouched checkout of the exact upstream base reproduces the same failure: **128 passed, 1 failed (129 total)**. No country data, country assets or existing tests are changed here.
- `python scripts/check_i18n.py` passed: no missing translations.
- `npm ci`, all **13 frontend tests**, TypeScript and production build passed; **1,738 static pages** generated.
- All 62 new PT/EN generated profile pages exist with the expected names. Browser results checks verified all 31 new profiles at 100% in both languages. Generated Joh profile pages, questionnaire entry and exported Joh share cards were inspected in both languages. The portrait/name render in both exports; the PT share exporter displays two near-centre axes at 50% instead of their result values (representation 53.7 and technology 55.8), while the EN export displays 54% and 56%. Share-export code is unchanged from upstream; this observed limitation is not claimed as a passing numerical export check. The browser checks use saved vectors; full-answer submissions are covered by the integration tests.
- Every existing upstream personality, translation, vector and book record is unchanged. All 31 new portraits are the previously downloaded, immediately compressed and visually reviewed files.
- All initial answer archives remain preserved in `answers/personality/revisions/initial-expansion/`; the independently answered questionnaires are at the standard `answers/personality/<id>.json` paths, so default validation reads the active answers.
- Current upstream creation instructions, validator and scoring code are unchanged. Religion tags are sourced from the independent religion-axis research and recorded in `politician-religions.json`.

## Similarity disposition

The current unmodified validator passes 8 additions and blocks 23 solely for ≥97% similarity. All 31 exceed the new-profile document’s ≥95% review threshold. Question coverage, archetypes, neutral limits and religion metadata have no blocking failures. Abbott, Attlee and Hillary Clinton technology-neutral warnings were reviewed against their briefs and evidence without changing answers to suppress warnings.

After receiving the exact overlap report and the required retain/reduce question, the requester explicitly instructed that all 32 figures be submitted to the original repository. Their inclusion choice is recorded in STATE. This is not maintainer approval and does not make the validator green. The PR requests acceptance of these overlaps because recognisable public figures are useful comparisons even when their twelve-axis positions are close. Raw outputs and exact matches remain in [politician-validation.json](politician-validation.json). No scoring or validation thresholds were relaxed.

## Process and evidence

The corrective review follows `.claude/skills/new-personality/SKILL.md`, `profile-audit/NEW_PROFILE.md` and `profile-audit/README.md`: one fresh independent agent per figure, sourced axis-specific research before answering, exact 240-question and archetype templates, original validation, computed vectors, permanent archives, qualifying-book checks, tests and UI verification. The original coordinator-only answer history is preserved rather than represented as independent work. Original creation order cannot be retroactively claimed; the independent review corrects that earlier process gap.

Research records distinguish documented policy from bounded hypothetical application. These are editorial simulations, not questionnaires completed by the politicians. Current-role metadata is scoped and dated in each research file.

## Profiles, vectors and exact calculated matches

### Anthony Albanese (`anthony-albanese`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and progressive morality.

Vector (repository left-pole percentages): estrutura 49.8, representacao 82.3, poder 60.3, imigracao 31.9, diplomacia 51.7, intervencao 36.4, economia 67.5, controle 59.2, comercio 33.0, religiao 57.1, moral 74.0, tecnologia 52.4.

Archetypes: sociedade D, poder C, economia C, mundo B, tecnologia C.

Personality: Julia Gillard (`julia-gillard`) 98.4%; Keir Starmer (`keir-starmer`) 98.3%.
Ideology: Social-Democracia Nórdica (`social-democracia-nordica`) 93.2%; Centrismo Social (`centrismo-social`) 92.4%.
Country: Rio de Janeiro (Brasil) (`rio-de-janeiro`) 93.6%; União Europeia (`uniao-europeia`) 93.4%.

Book: none. No qualifying complete self-authored political book verified. Karen Middleton biography excluded; contributed chapter in edited anthology insufficient to attribute the whole book to Albanese.

[Active answers](../answers/personality/anthony-albanese.json) · [Research and sources](../research/personality/anthony-albanese.json) · [Independent review](../research/process-review/anthony-albanese.json)

### Pauline Hanson (`pauline-hanson`)

Catalog: personality. The calculated profile leans most strongly toward cultural assimilation and democratic representation.

Vector (repository left-pole percentages): estrutura 47.4, representacao 85.9, poder 48.4, imigracao 89.6, diplomacia 67.1, intervencao 29.3, economia 49.4, controle 45.7, comercio 76.4, religiao 39.0, moral 22.0, tecnologia 54.6.

Archetypes: sociedade A, poder C, economia E, mundo B, tecnologia D.

Personality: Robert Menzies (`robert-menzies`) 95.3%; Rupert Lowe (`rupert-lowe`) 93.4%.
Ideology: Conservadorismo Americano (`conservadorismo-americano`) 94.3%; Democracia Nacional (`democracia-nacional`) 94.2%.
Country: Polônia (`polonia`) 91.7%; Roma Republicana (`roma-republicana`) 89.6%.

Book: *Pauline: In Her Own Words* (2018). PT: Pauline: In Her Own Words. Collection of her own political speeches on taxation, farming, immigration and family policy; Tom Ravlic is compiler, not replacement author. More directly expresses political positions than the 2007 memoir. No Portuguese edition found, so retain original title.

[Active answers](../answers/personality/pauline-hanson.json) · [Research and sources](../research/personality/pauline-hanson.json) · [Independent review](../research/process-review/pauline-hanson.json)

### Angus Taylor (`angus-taylor`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and assertive national interests.

Vector (repository left-pole percentages): estrutura 48.6, representacao 82.3, poder 59.1, imigracao 61.2, diplomacia 62.4, intervencao 23.3, economia 38.9, controle 30.7, comercio 27.0, religiao 37.7, moral 34.9, tecnologia 60.6.

Archetypes: sociedade B, poder C, economia C, mundo B, tecnologia D.

Personality: John Howard (`john-howard`) 98.6%; Scott Morrison (`scott-morrison`) 97.9%.
Ideology: Neoconservadorismo (`neoconservadorismo`) 95.8%; Liberalismo Conservador (`liberalismo-conservador`) 94.3%.
Country: Madrid (Espanha) (`madrid`) 95.2%; Roma Republicana (`roma-republicana`) 94.7%.

Book: *The Promise of Digital Government: Transforming Public Services, Regulation, and Citizenship* (2016). PT: The Promise of Digital Government: Transforming Public Services, Regulation, and Citizenship. Self-authored 80-page published political/public-administration monograph, April 2016, ISBN 9781925501025. Directly concerns government, regulation and citizenship. No PT edition verified; original title retained in both languages.

[Active answers](../answers/personality/angus-taylor.json) · [Research and sources](../research/personality/angus-taylor.json) · [Independent review](../research/process-review/angus-taylor.json)

### John Howard (`john-howard`)

Catalog: personality. The calculated profile leans most strongly toward assertive national interests and democratic representation.

Vector (repository left-pole percentages): estrutura 39.0, representacao 78.7, poder 62.7, imigracao 50.5, diplomacia 58.8, intervencao 19.8, economia 35.3, controle 31.9, comercio 23.4, religiao 37.7, moral 27.7, tecnologia 53.4.

Archetypes: sociedade B, poder C, economia C, mundo B, tecnologia D.

Personality: Angus Taylor (`angus-taylor`) 98.6%; Scott Morrison (`scott-morrison`) 98.5%.
Ideology: Neoconservadorismo (`neoconservadorismo`) 94.9%; Liberalismo Conservador (`liberalismo-conservador`) 93.6%.
Country: Roma Republicana (`roma-republicana`) 95.3%; Madrid (Espanha) (`madrid`) 93.7%.

Book: *Lazarus Rising: A Personal and Political Autobiography* (2010). PT: Lazarus Rising: A Personal and Political Autobiography. Self-authored substantive political memoir covering governing decisions; publisher description establishes bestseller status and scope. Select this major memoir; original year 2010, not revised edition 2011.

[Active answers](../answers/personality/john-howard.json) · [Research and sources](../research/personality/john-howard.json) · [Independent review](../research/process-review/john-howard.json)

### Robert Menzies (`robert-menzies`)

Catalog: personality. The calculated profile leans most strongly toward cultural assimilation and traditional morality.

Vector (repository left-pole percentages): estrutura 46.2, representacao 72.8, poder 65.1, imigracao 80.2, diplomacia 69.5, intervencao 22.1, economia 48.4, controle 59.2, comercio 54.4, religiao 28.2, moral 20.6, tecnologia 64.1.

Archetypes: sociedade B, poder C, economia C, mundo B, tecnologia D.

Personality: Pauline Hanson (`pauline-hanson`) 95.3%; Richard Nixon (`richard-nixon`) 94.7%.
Ideology: Neoconservadorismo (`neoconservadorismo`) 95.5%; Democracia Nacional (`democracia-nacional`) 95.3%.
Country: Polônia (`polonia`) 96.1%; Paquistão (`paquistao`) 94.2%.

Book: *The Forgotten People and Other Studies in Democracy* (1943). PT: The Forgotten People and Other Studies in Democracy. Coletânea de discursos próprios sobre democracia e filosofia política, obra central de sua doutrina; mais diretamente relevante que memórias. Sem tradução PT verificada, título original mantido.

[Active answers](../answers/personality/robert-menzies.json) · [Research and sources](../research/personality/robert-menzies.json) · [Independent review](../research/process-review/robert-menzies.json)

### Gough Whitlam (`gough-whitlam`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and public ownership.

Vector (repository left-pole percentages): estrutura 39.0, representacao 82.3, poder 44.9, imigracao 30.7, diplomacia 28.8, intervencao 54.1, economia 77.0, controle 72.3, comercio 46.0, religiao 66.7, moral 74.0, tecnologia 54.8.

Archetypes: sociedade D, poder C, economia C, mundo C, tecnologia C.

Personality: Pedro Sánchez (`pedro-sanchez`) 97.2%; John Rawls (`john-rawls`) 97.0%.
Ideology: Social-Democracia (`social-democracia`) 98.2%; Socialismo de Mercado (`socialismo-de-mercado`) 97.4%.
Country: Argentina (`argentina`) 96.8%; Noruega (`noruega`) 95.1%.

Book: *The Whitlam Government 1972–1975* (1985). PT: The Whitlam Government 1972–1975. Self-authored detailed political-government account; selected as the most directly relevant comprehensive statement for the premiership model. No existing books.json entry found. No verified Brazilian translation.

[Active answers](../answers/personality/gough-whitlam.json) · [Research and sources](../research/personality/gough-whitlam.json) · [Independent review](../research/process-review/gough-whitlam.json)

### Bob Hawke (`bob-hawke`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and free trade.

Vector (repository left-pole percentages): estrutura 29.5, representacao 79.9, poder 49.6, imigracao 26.0, diplomacia 38.6, intervencao 38.8, economia 62.7, controle 53.3, comercio 23.4, religiao 61.9, moral 72.9, tecnologia 51.2.

Archetypes: sociedade D, poder C, economia C, mundo B, tecnologia C.

Personality: Barack Obama (`barack-obama`) 97.5%; Julia Gillard (`julia-gillard`) 97.4%.
Ideology: Social-Democracia Nórdica (`social-democracia-nordica`) 95.6%; Terceira Via (`terceira-via`) 94.5%.
Country: Chile (`chile`) 95.3%; Portugal (`portugal`) 94.1%.

Book: *The Hawke Memoirs* (1994). PT: The Hawke Memoirs. Self-authored political memoir, first published 1994; verified library author and politics subjects. No existing entry. No Brazilian translation verified; retain original title in both locales.

[Active answers](../answers/personality/bob-hawke.json) · [Research and sources](../research/personality/bob-hawke.json) · [Independent review](../research/process-review/bob-hawke.json)

### Paul Keating (`paul-keating`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and free trade.

Vector (repository left-pole percentages): estrutura 42.6, representacao 84.7, poder 55.6, imigracao 23.6, diplomacia 34.8, intervencao 48.2, economia 56.8, controle 52.1, comercio 17.5, religiao 57.1, moral 56.2, tecnologia 54.8.

Archetypes: sociedade D, poder C, economia C, mundo C, tecnologia C.

Personality: Sergio Mattarella (`sergio-mattarella`) 97.1%; Bob Hawke (`bob-hawke`) 96.8%.
Ideology: Liberalismo Islâmico (`liberalismo-islamico`) 96.8%; Social-Democracia Brasileira (`social-democracia-brasileira`) 96.2%.
Country: Chile (`chile`) 94.8%; Portugal (`portugal`) 94.4%.

Book: *Engagement: Australia Faces the Asia-Pacific* (2000). PT: Engagement: Australia Faces the Asia-Pacific. Self-authored political account of Asia-Pacific engagement; most directly relevant sustained exposition of his foreign-policy thought. First publication March 2000. No prior catalog book; no Brazilian edition found.

[Active answers](../answers/personality/paul-keating.json) · [Research and sources](../research/personality/paul-keating.json) · [Independent review](../research/process-review/paul-keating.json)

### Kevin Rudd (`kevin-rudd`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and multicultural openness.

Vector (repository left-pole percentages): estrutura 43.8, representacao 82.3, poder 61.5, imigracao 33.6, diplomacia 38.6, intervencao 37.6, economia 61.5, controle 58.0, comercio 34.1, religiao 35.7, moral 64.1, tecnologia 53.4.

Archetypes: sociedade F, poder C, economia C, mundo B, tecnologia D.

Personality: Sergio Mattarella (`sergio-mattarella`) 97.2%; Angela Merkel (`angela-merkel`) 96.6%.
Ideology: Centrismo Social (`centrismo-social`) 93.4%; Liberalismo Islâmico (`liberalismo-islamico`) 93.2%.
Country: Colômbia (`colombia`) 93.4%; Rio de Janeiro (Brasil) (`rio-de-janeiro`) 93.3%.

Book: *The Avoidable War: The Dangers of a Catastrophic Conflict between the US and Xi Jinping's China* (2022). PT: The Avoidable War: The Dangers of a Catastrophic Conflict between the US and Xi Jinping's China. Self-authored political strategy book, directly relevant to his international thought; publisher verifies author and first year. No existing books.json entry; original title used because Brazilian translation not verified.

[Active answers](../answers/personality/kevin-rudd.json) · [Research and sources](../research/personality/kevin-rudd.json) · [Independent review](../research/process-review/kevin-rudd.json)

### Julia Gillard (`julia-gillard`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and progressive morality.

Vector (repository left-pole percentages): estrutura 43.8, representacao 83.5, poder 62.7, imigracao 34.3, diplomacia 45.7, intervencao 28.1, economia 67.5, controle 54.5, comercio 31.8, religiao 65.5, moral 76.4, tecnologia 52.4.

Archetypes: sociedade D, poder C, economia C, mundo B, tecnologia C.

Personality: Anthony Albanese (`anthony-albanese`) 98.4%; Olaf Scholz (`olaf-scholz`) 97.8%.
Ideology: Terceira Via (`terceira-via`) 94.5%; Social-Democracia Nórdica (`social-democracia-nordica`) 93.6%.
Country: Taiwan (`taiwan`) 92.4%; Bélgica (`belgica`) 92.3%.

Book: *My Story* (2014). PT: My Story. Self-authored political memoir most directly covers her political thought in government; no existing catalogue book; original title retained without verified Brazilian translation.

[Active answers](../answers/personality/julia-gillard.json) · [Research and sources](../research/personality/julia-gillard.json) · [Independent review](../research/process-review/julia-gillard.json)

### Tony Abbott (`tony-abbott`)

Catalog: personality. The calculated profile leans most strongly toward assertive national interests and traditional morality.

Vector (repository left-pole percentages): estrutura 46.2, representacao 77.5, poder 55.6, imigracao 74.1, diplomacia 66.0, intervencao 19.8, economia 34.1, controle 28.3, comercio 28.2, religiao 26.0, moral 22.0, tecnologia 60.6.

Archetypes: sociedade A, poder C, economia C, mundo B, tecnologia D.

Personality: Friedrich Merz (`friedrich-merz`) 98.3%; Nigel Farage (`nigel-farage`) 97.2%.
Ideology: Nacional-Liberalismo (`nacional-liberalismo`) 95.9%; Neoconservadorismo (`neoconservadorismo`) 95.8%.
Country: Israel (`israel`) 95.0%; Roma Republicana (`roma-republicana`) 94.6%.

Book: *Battlelines* (2009). PT: Battlelines. Battlelines is Abbott’s own substantial policy manifesto and political memoir, first published 2009; chosen over narrower constitutional works. No existing books.json item. Portuguese/Brazilian edition searches yielded no verified translation, so retain original title. No book file modified.

[Active answers](../answers/personality/tony-abbott.json) · [Research and sources](../research/personality/tony-abbott.json) · [Independent review](../research/process-review/tony-abbott.json)

### Malcolm Turnbull (`malcolm-turnbull`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and free trade.

Vector (repository left-pole percentages): estrutura 60.5, representacao 83.5, poder 60.3, imigracao 35.5, diplomacia 44.5, intervencao 41.2, economia 42.5, controle 35.4, comercio 21.0, religiao 53.6, moral 70.5, tecnologia 58.2.

Archetypes: sociedade D, poder C, economia C, mundo B, tecnologia D.

Personality: João Doria (`joao-doria`) 97.0%; Anders Fogh Rasmussen (`anders-fogh-rasmussen`) 95.4%.
Ideology: Meritocracia (`meritocracia`) 93.2%; Social-Democracia Brasileira (`social-democracia-brasileira`) 92.7%.
Country: São Paulo (Brasil) (`sao-paulo`) 94.7%; Austrália (`australia`) 94.7%.

Book: *A Bigger Picture* (2020). PT: A Bigger Picture. Self-authored political memoir; publisher calls it a bestselling political memoir of 2020. No existing entry was found; original title retained without verified Brazilian translation.

[Active answers](../answers/personality/malcolm-turnbull.json) · [Research and sources](../research/personality/malcolm-turnbull.json) · [Independent review](../research/process-review/malcolm-turnbull.json)

### Scott Morrison (`scott-morrison`)

Catalog: personality. The calculated profile leans most strongly toward assertive national interests and democratic representation.

Vector (repository left-pole percentages): estrutura 46.2, representacao 77.5, poder 65.1, imigracao 45.7, diplomacia 62.4, intervencao 22.1, economia 41.3, controle 39.0, comercio 30.6, religiao 27.0, moral 27.7, tecnologia 63.0.

Archetypes: sociedade B, poder C, economia C, mundo B, tecnologia D.

Personality: John Howard (`john-howard`) 98.5%; Angus Taylor (`angus-taylor`) 97.9%.
Ideology: Neoconservadorismo (`neoconservadorismo`) 94.8%; Democracia Islâmica (`democracia-islamica`) 94.4%.
Country: Roma Republicana (`roma-republicana`) 94.4%; Israel (`israel`) 93.6%.

Book: *Plans for Your Good: A Prime Minister’s Testimony of God’s Faithfulness* (2024). PT: Plans for Your Good: A Prime Minister’s Testimony of God’s Faithfulness. Self-authored mixed spiritual and political memoir. Although marketed primarily as pastoral encouragement, independently verified discussions of government policy, Afghanistan, China and AUKUS provide substantial political content; not a personal-only memoir. No Brazilian translation verified; retain original title. Existing books.json had no entry.

[Active answers](../answers/personality/scott-morrison.json) · [Research and sources](../research/personality/scott-morrison.json) · [Independent review](../research/process-review/scott-morrison.json)

### Margaret Thatcher (`margaret-thatcher`)

Catalog: personality. The calculated profile leans most strongly toward free trade and religious public values.

Vector (repository left-pole percentages): estrutura 29.5, representacao 71.6, poder 63.9, imigracao 65.8, diplomacia 68.3, intervencao 22.1, economia 36.3, controle 26.6, comercio 13.7, religiao 16.4, moral 22.0, tecnologia 53.6.

Archetypes: sociedade A, poder C, economia F, mundo B, tecnologia C.

Personality: Tony Abbott (`tony-abbott`) 97.0%; Irving Kristol (`irving-kristol`) 95.7%.
Ideology: Nacional-Liberalismo (`nacional-liberalismo`) 96.2%; Democracia Intervencionista (`democracia-intervencionista`) 93.1%.
Country: Israel (`israel`) 94.0%; Geórgia (`georgia`) 92.8%.

Book: *The Downing Street Years* (1993). PT: The Downing Street Years. Self-authored substantive political memoir of the modelled premiership; most directly relevant major work. No existing book entry. 1993 original year verified; original PT fallback because Brazilian edition remains unverified.

[Active answers](../answers/personality/margaret-thatcher.json) · [Research and sources](../research/personality/margaret-thatcher.json) · [Independent review](../research/process-review/margaret-thatcher.json)

### Clement Attlee (`clement-attlee`)

Catalog: personality. The calculated profile leans most strongly toward economic planning and public ownership.

Vector (repository left-pole percentages): estrutura 37.9, representacao 78.7, poder 59.1, imigracao 44.8, diplomacia 61.2, intervencao 29.3, economia 84.6, controle 85.3, comercio 51.4, religiao 57.5, moral 28.6, tecnologia 53.4.

Archetypes: sociedade E, poder C, economia B, mundo B, tecnologia D.

Personality: Golda Meir (`golda-meir`) 97.4%; Franklin D. Roosevelt (`franklin-roosevelt`) 96.6%.
Ideology: Liberalismo New Deal (`liberalismo-new-deal`) 90.4%; Nacional-Desenvolvimentismo (`nacional-desenvolvimentismo`) 89.8%.
Country: França (`franca`) 87.7%; México de Cárdenas (`mexico-de-cardenas`) 85.5%.

Book: *The Labour Party in Perspective* (1937). PT: Bases e fundamentos do trabalhismo. Self-authored political exposition; relevant to parliamentary-socialist doctrine. No existing books.json entry. Verified original 1937 and actual Brazilian title, rather than translating title ad hoc.

[Active answers](../answers/personality/clement-attlee.json) · [Research and sources](../research/personality/clement-attlee.json) · [Independent review](../research/process-review/clement-attlee.json)

### Boris Johnson (`boris-johnson`)

Catalog: personality. The calculated profile leans most strongly toward assertive national interests and democratic representation.

Vector (repository left-pole percentages): estrutura 45.0, representacao 76.3, poder 56.8, imigracao 46.0, diplomacia 68.3, intervencao 11.4, economia 48.4, controle 45.0, comercio 33.0, religiao 46.9, moral 65.7, tecnologia 70.1.

Archetypes: sociedade C, poder C, economia C, mundo A, tecnologia D.

Personality: Tony Blair (`tony-blair`) 95.8%; Keir Starmer (`keir-starmer`) 95.1%.
Ideology: Atlantismo (`atlantismo`) 96.5%; Terceira Via (`terceira-via`) 93.5%.
Country: Reino Unido (`reino-unido`) 97.4%; Washington, D.C. (Estados Unidos) (`eua-washington-dc`) 95.3%.

Book: *Unleashed* (2024). PT: Unleashed. Self-authored political memoir directly covering his premiership and political ideas; more directly relevant to this profile than his Churchill biography. No existing books.json entry; no verified Brazilian translation.

[Active answers](../answers/personality/boris-johnson.json) · [Research and sources](../research/personality/boris-johnson.json) · [Independent review](../research/process-review/boris-johnson.json)

### Keir Starmer (`keir-starmer`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and assertive national interests.

Vector (repository left-pole percentages): estrutura 52.1, representacao 82.3, poder 58.0, imigracao 43.8, diplomacia 57.6, intervencao 30.5, economia 65.1, controle 55.7, comercio 37.7, religiao 61.9, moral 69.3, tecnologia 64.1.

Archetypes: sociedade D, poder C, economia C, mundo B, tecnologia D.

Personality: Anthony Albanese (`anthony-albanese`) 98.3%; Julia Gillard (`julia-gillard`) 97.2%.
Ideology: Terceira Via (`terceira-via`) 93.3%; Social-Democracia Nórdica (`social-democracia-nordica`) 92.6%.
Country: Reino Unido (`reino-unido`) 94.6%; Taiwan (`taiwan`) 94.5%.

Book: *The Three Pillars of Liberty: Political Rights and Freedoms in the United Kingdom* (1996). PT: The Three Pillars of Liberty: Political Rights and Freedoms in the United Kingdom. Political civil-liberties book coauthored by Starmer with Francesca Klug and Stuart Weir; selected for direct relevance to constitutional and political thought over a technical European human-rights law handbook. First edition 1996 verified by publisher and library; no Brazilian edition verified. Existing books.json has no Starmer entry.

[Active answers](../answers/personality/keir-starmer.json) · [Research and sources](../research/personality/keir-starmer.json) · [Independent review](../research/process-review/keir-starmer.json)

### Nigel Farage (`nigel-farage`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and cultural assimilation.

Vector (repository left-pole percentages): estrutura 47.4, representacao 82.3, poder 55.6, imigracao 81.4, diplomacia 63.6, intervencao 29.3, economia 34.1, controle 29.5, comercio 41.3, religiao 30.6, moral 32.5, tecnologia 51.0.

Archetypes: sociedade B, poder C, economia C, mundo B, tecnologia D.

Personality: Tony Abbott (`tony-abbott`) 97.2%; Angus Taylor (`angus-taylor`) 97.1%.
Ideology: Neoconservadorismo (`neoconservadorismo`) 96.8%; Conservadorismo (`conservadorismo`) 94.2%.
Country: Roma Republicana (`roma-republicana`) 94.9%; Polônia (`polonia`) 94.8%.

Book: *The Purple Revolution: The Year That Changed Everything* (2015). PT: The Purple Revolution: The Year That Changed Everything. Self-authored political account of UKIP strategy and sovereignty. More directly political than Fighting Bull/Flying Free. Publisher confirms authorship and 2015 first edition; no verified Brazilian translation, so retain original. No existing entry to alter.

[Active answers](../answers/personality/nigel-farage.json) · [Research and sources](../research/personality/nigel-farage.json) · [Independent review](../research/process-review/nigel-farage.json)

### Rupert Lowe (`rupert-lowe`)

Catalog: personality. The calculated profile leans most strongly toward cultural assimilation and market allocation.

Vector (repository left-pole percentages): estrutura 35.5, representacao 76.3, poder 44.9, imigracao 90.8, diplomacia 70.7, intervencao 26.9, economia 30.3, controle 23.0, comercio 51.8, religiao 26.0, moral 25.6, tecnologia 52.4.

Archetypes: sociedade A, poder C, economia F, mundo A, tecnologia C.

Personality: Nigel Farage (`nigel-farage`) 96.9%; Tony Abbott (`tony-abbott`) 96.3%.
Ideology: Neoconservadorismo (`neoconservadorismo`) 94.9%; Nacional-Liberalismo (`nacional-liberalismo`) 94.8%.
Country: Roma Republicana (`roma-republicana`) 93.8%; Israel (`israel`) 93.2%.

Book: none. No self-authored qualifying political book verified. Dedicated general author/book, memoir and WorldCat-targeted searches found biographies and political books by other authors, plus party policy papers; authorship criteria prevent substituting those. No existing books entry.

[Active answers](../answers/personality/rupert-lowe.json) · [Research and sources](../research/personality/rupert-lowe.json) · [Independent review](../research/process-review/rupert-lowe.json)

### Kamala Harris (`kamala-harris`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and progressive morality.

Vector (repository left-pole percentages): estrutura 55.7, representacao 89.4, poder 44.9, imigracao 23.6, diplomacia 44.5, intervencao 31.7, economia 61.5, controle 58.0, comercio 49.6, religiao 54.8, moral 82.4, tecnologia 57.1.

Archetypes: sociedade D, poder C, economia C, mundo B, tecnologia C.

Personality: Mark Carney (`mark-carney`) 98.3%; Hillary Clinton (`hillary-clinton`) 98.0%.
Ideology: Liberalismo de Estado (`liberalismo-de-estado`) 94.1%; Nacionalismo Cívico (`nacionalismo-civico`) 91.9%.
Country: União Europeia (`uniao-europeia`) 95.3%; Nova York (Estados Unidos) (`eua-nova-york`) 93.6%.

Book: *The Truths We Hold: An American Journey* (2019). PT: As verdades que nos movem. Self-authored bestselling political memoir, substantive across political issues; chosen for broad political relevance over the narrower Smart on Crime and retrospective 107 Days. No existing entry was present at review.

[Active answers](../answers/personality/kamala-harris.json) · [Research and sources](../research/personality/kamala-harris.json) · [Independent review](../research/process-review/kamala-harris.json)

### Hillary Clinton (`hillary-clinton`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and assertive national interests.

Vector (repository left-pole percentages): estrutura 54.5, representacao 82.3, poder 49.6, imigracao 26.0, diplomacia 52.9, intervencao 19.8, economia 56.8, controle 53.3, comercio 48.4, religiao 52.4, moral 76.4, tecnologia 54.8.

Archetypes: sociedade D, poder C, economia C, mundo B, tecnologia C.

Personality: Mark Carney (`mark-carney`) 98.8%; Kamala Harris (`kamala-harris`) 98.0%.
Ideology: Centrismo Social (`centrismo-social`) 89.8%; Terceira Via (`terceira-via`) 88.9%.
Country: Austrália (`australia`) 92.9%; União Europeia (`uniao-europeia`) 92.6%.

Book: *Hard Choices* (2014). PT: Escolhas difíceis. Self-authored political/diplomatic memoir directly relevant to her foreign-policy doctrine. Existing books catalogue contains no entry for this personality. Publisher credits Hillary Rodham Clinton; Brazilian title verified against Globo-associated coverage and Brazilian edition listing. Selected for political relevance, not an unsupported claim of highest sales.

[Active answers](../answers/personality/hillary-clinton.json) · [Research and sources](../research/personality/hillary-clinton.json) · [Independent review](../research/process-review/hillary-clinton.json)

### Jimmy Carter (`jimmy-carter`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and pacifism.

Vector (repository left-pole percentages): estrutura 54.5, representacao 87.0, poder 38.9, imigracao 33.6, diplomacia 27.6, intervencao 41.0, economia 54.4, controle 46.1, comercio 42.5, religiao 39.3, moral 53.4, tecnologia 45.2.

Archetypes: sociedade F, poder C, economia C, mundo C, tecnologia C.

Personality: Angela Merkel (`angela-merkel`) 96.0%; Tomáš Garrigue Masaryk (`masaryk`) 94.9%.
Ideology: Liberalismo Islâmico (`liberalismo-islamico`) 95.8%; Centrismo Social (`centrismo-social`) 95.6%.
Country: Brasil (`brasil`) 95.2%; Colômbia (`colombia`) 94.9%.

Book: *Our Endangered Values: America’s Moral Crisis* (2005). PT: Nossos valores em risco: A crise moral dos EUA. Self-authored political argument, selected for broad relevance across Carter’s political thought over the narrower Palestine book and general memoirs. Publisher and Carter bibliography verify first publication 2005; Manole Brazilian title verified separately. No Carter book existed in books.json when checked.

[Active answers](../answers/personality/jimmy-carter.json) · [Research and sources](../research/personality/jimmy-carter.json) · [Independent review](../research/process-review/jimmy-carter.json)

### Lyndon B. Johnson (`lyndon-b-johnson`)

Catalog: personality. The calculated profile leans most strongly toward assertive national interests and democratic representation.

Vector (repository left-pole percentages): estrutura 51.0, representacao 78.7, poder 55.6, imigracao 36.7, diplomacia 66.0, intervencao 15.0, economia 59.1, controle 64.0, comercio 35.3, religiao 39.3, moral 34.8, tecnologia 53.6.

Archetypes: sociedade D, poder C, economia C, mundo A, tecnologia C.

Personality: David Lloyd George (`david-lloyd-george`) 97.4%; Harry S. Truman (`harry-truman`) 96.4%.
Ideology: Atlantismo (`atlantismo`) 88.1%; Liberalismo New Deal (`liberalismo-new-deal`) 87.9%.
Country: Reino Unido (`reino-unido`) 91.9%; Ucrânia (`ucrania`) 89.9%.

Book: *The Vantage Point: Perspectives of the Presidency, 1963–1969* (1971). PT: The Vantage Point: Perspectives of the Presidency, 1963–1969. Self-authored political presidential memoir, most directly relevant major book; first publication 1971. No pre-existing books entry. Original title retained because no Brazilian translation verified. Bibliographic author: Lyndon B. Johnson; editorial assistance does not make this a third-party biography.

[Active answers](../answers/personality/lyndon-b-johnson.json) · [Research and sources](../research/personality/lyndon-b-johnson.json) · [Independent review](../research/process-review/lyndon-b-johnson.json)

### Angela Merkel (`angela-merkel`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and free trade.

Vector (repository left-pole percentages): estrutura 58.1, representacao 83.5, poder 59.1, imigracao 42.1, diplomacia 34.8, intervencao 35.1, economia 55.6, controle 47.3, comercio 24.6, religiao 38.9, moral 53.9, tecnologia 47.6.

Archetypes: sociedade B, poder C, economia C, mundo C, tecnologia C.

Personality: Kevin Rudd (`kevin-rudd`) 96.6%; Jimmy Carter (`jimmy-carter`) 96.0%.
Ideology: Centrismo (`centrismo`) 92.9%; Centrismo Social (`centrismo-social`) 92.8%.
Country: Rio de Janeiro (Brasil) (`rio-de-janeiro`) 93.6%; Porto Rico (Estados Unidos) (`porto-rico`) 93.2%.

Book: *Freedom: Memoirs 1954–2021* (2024). PT: Liberdade. Self-authored political memoir with Beate Baumann, covering governing and diplomatic decisions. Verified first publication 2024 and Brazilian publisher title; no existing entry to preserve.

[Active answers](../answers/personality/angela-merkel.json) · [Research and sources](../research/personality/angela-merkel.json) · [Independent review](../research/process-review/angela-merkel.json)

### Olaf Scholz (`olaf-scholz`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and progressive morality.

Vector (repository left-pole percentages): estrutura 53.3, representacao 83.5, poder 49.6, imigracao 40.2, diplomacia 42.1, intervencao 38.8, economia 67.5, controle 64.0, comercio 28.2, religiao 65.5, moral 81.2, tecnologia 53.4.

Archetypes: sociedade D, poder C, economia C, mundo B, tecnologia D.

Personality: Anthony Albanese (`anthony-albanese`) 97.9%; Julia Gillard (`julia-gillard`) 97.8%.
Ideology: Liberalismo de Estado (`liberalismo-de-estado`) 95.7%; Social-Democracia Nórdica (`social-democracia-nordica`) 94.5%.
Country: Noruega (`noruega`) 96.0%; Espanha (`espanha`) 95.9%.

Book: *Hoffnungsland: Eine neue deutsche Wirklichkeit* (2017). PT: Hoffnungsland: Eine neue deutsche Wirklichkeit. Self-authored political book by Olaf Scholz, first published 2017; most relevant verified authored political book. No existing books.json entry. No verified PT/EN translations.

[Active answers](../answers/personality/olaf-scholz.json) · [Research and sources](../research/personality/olaf-scholz.json) · [Independent review](../research/process-review/olaf-scholz.json)

### Mark Carney (`mark-carney`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and progressive morality.

Vector (repository left-pole percentages): estrutura 60.5, representacao 81.1, poder 46.0, imigracao 28.3, diplomacia 52.9, intervencao 34.0, economia 55.6, controle 50.9, comercio 43.7, religiao 56.0, moral 78.8, tecnologia 58.2.

Archetypes: sociedade D, poder C, economia C, mundo B, tecnologia D.

Personality: Hillary Clinton (`hillary-clinton`) 98.8%; Kamala Harris (`kamala-harris`) 98.3%.
Ideology: Liberalismo de Estado (`liberalismo-de-estado`) 92.0%; Centrismo Social (`centrismo-social`) 91.8%.
Country: União Europeia (`uniao-europeia`) 95.7%; Austrália (`australia`) 94.3%.

Book: *Value(s): Building a Better World for All* (2021). PT: Value(s): Building a Better World for All. Self-authored political economy; publisher confirms 2021. No existing catalog book. No verified Brazilian translation, so original title in both languages.

[Active answers](../answers/personality/mark-carney.json) · [Research and sources](../research/personality/mark-carney.json) · [Independent review](../research/process-review/mark-carney.json)

### David Lloyd George (`david-lloyd-george`)

Catalog: personality. The calculated profile leans most strongly toward assertive national interests and free trade.

Vector (repository left-pole percentages): estrutura 53.3, representacao 68.0, poder 68.7, imigracao 47.9, diplomacia 61.2, intervencao 22.1, economia 58.0, controle 70.0, comercio 28.2, religiao 44.0, moral 30.8, tecnologia 64.1.

Archetypes: sociedade F, poder C, economia C, mundo B, tecnologia D.

Personality: Lyndon B. Johnson (`lyndon-b-johnson`) 97.4%; Harry S. Truman (`harry-truman`) 95.3%.
Ideology: Liberalismo New Deal (`liberalismo-new-deal`) 92.6%; Neoconservadorismo (`neoconservadorismo`) 87.4%.
Country: Reino Unido (`reino-unido`) 91.1%; Coreia do Sul (`coreia-do-sul`) 90.3%.

Book: *War Memoirs of David Lloyd George* (1933). PT: War Memoirs of David Lloyd George. Self-authored political and wartime leadership memoir; the major six-volume account is a stronger representative work than the shorter jointly credited 1929 election programme. First volume 1933; no verified Brazilian title found.

[Active answers](../answers/personality/david-lloyd-george.json) · [Research and sources](../research/personality/david-lloyd-george.json) · [Independent review](../research/process-review/david-lloyd-george.json)

### Helmut Kohl (`helmut-kohl`)

Catalog: personality. The calculated profile leans most strongly toward democratic representation and religious public values.

Vector (repository left-pole percentages): estrutura 65.2, representacao 81.1, poder 60.3, imigracao 63.6, diplomacia 48.1, intervencao 36.4, economia 53.2, controle 34.2, comercio 28.2, religiao 21.0, moral 26.5, tecnologia 44.0.

Archetypes: sociedade B, poder C, economia C, mundo B, tecnologia C.

Personality: Konrad Adenauer (`konrad-adenauer`) 97.1%; Lech Wałęsa (`lech-walesa`) 96.1%.
Ideology: Democracia Islâmica (`democracia-islamica`) 91.6%; Ecoconservadorismo (`ecoconservadorismo`) 89.0%.
Country: Baviera (Alemanha) (`baviera`) 94.7%; Santa Catarina (Brasil) (`santa-catarina`) 91.9%.

Book: *Ich wollte Deutschlands Einheit* (1996). PT: Ich wollte Deutschlands Einheit. Authored political memoir of reunification, especially relevant to defining political achievement. Kohl is the memoir voice; Kai Diekmann and Ralf Georg Reuth are credited as presenting/editing collaborators. First edition 1996 confirmed; later paperback is not first publication. No verified PT-BR or English book edition found, so retain German original in both fields. Existing books catalog has no Kohl entry.

[Active answers](../answers/personality/helmut-kohl.json) · [Research and sources](../research/personality/helmut-kohl.json) · [Independent review](../research/process-review/helmut-kohl.json)

### Lech Wałęsa (`lech-walesa`)

Catalog: personality. The calculated profile leans most strongly toward traditional morality and religious public values.

Vector (repository left-pole percentages): estrutura 52.1, representacao 76.3, poder 53.2, imigracao 46.8, diplomacia 42.1, intervencao 42.4, economia 52.0, controle 41.4, comercio 33.0, religiao 17.6, moral 17.2, tecnologia 46.4.

Archetypes: sociedade A, poder C, economia C, mundo B, tecnologia C.

Personality: Helmut Kohl (`helmut-kohl`) 96.1%; Konrad Adenauer (`konrad-adenauer`) 94.1%.
Ideology: Democracia Islâmica (`democracia-islamica`) 94.9%; Democracia Cristã (`democracia-crista`) 92.1%.
Country: Peru (`peru`) 93.2%; Baviera (Alemanha) (`baviera`) 91.7%.

Book: *A Way of Hope* (1987). PT: Um caminho de esperança: uma autobiografia. Self-authored political autobiography about Solidarity and resistance to communist rule; 1987 first edition verified against publisher and Brazilian library. No existing books.json entry found.

[Active answers](../answers/personality/lech-walesa.json) · [Research and sources](../research/personality/lech-walesa.json) · [Independent review](../research/process-review/lech-walesa.json)

### Golda Meir (`golda-meir`)

Catalog: personality. The calculated profile leans most strongly toward public ownership and democratic representation.

Vector (repository left-pole percentages): estrutura 29.5, representacao 76.3, poder 67.5, imigracao 58.1, diplomacia 73.1, intervencao 25.7, economia 79.8, controle 75.8, comercio 49.0, religiao 51.2, moral 39.5, tecnologia 58.2.

Archetypes: sociedade D, poder C, economia B, mundo B, tecnologia D.

Personality: Franklin D. Roosevelt (`franklin-roosevelt`) 97.4%; Clement Attlee (`clement-attlee`) 97.4%.
Ideology: Liberalismo New Deal (`liberalismo-new-deal`) 93.7%; Sionismo Trabalhista (`sionismo-trabalhista`) 92.5%.
Country: França (`franca`) 90.4%; Polônia (`polonia`) 89.6%.

Book: *My Life* (1975). PT: Minha Vida. Self-authored political memoir, more relevant and widely known than collected speeches. No existing books.json entry. Author Golda Meir; Brazilian title verified separately; first publication 1975.

[Active answers](../answers/personality/golda-meir.json) · [Research and sources](../research/personality/golda-meir.json) · [Independent review](../research/process-review/golda-meir.json)

### Joh Bjelke-Petersen (`joh-bjelke-petersen`)

Catalog: personality. The calculated profile leans most strongly toward traditional morality and religious public values.

Vector (repository left-pole percentages): estrutura 77.1, representacao 53.7, poder 72.2, imigracao 67.0, diplomacia 66.0, intervencao 24.5, economia 32.7, controle 34.9, comercio 32.7, religiao 8.1, moral 3.0, tecnologia 55.8.

Archetypes: sociedade A, poder C, economia F, mundo B, tecnologia D.

Personality: Jefferson Davis (`jefferson-davis`) 95.3%; William F. Buckley Jr. (`william-f-buckley`) 95.2%.
Ideology: Conservadorismo Reaganista (`conservadorismo-reaganista`) 92.3%; Conservadorismo Confederado (`conservadorismo-confederado`) 91.2%.
Country: Estados Confederados da América (`eua-confederados`) 94.3%; Texas (Estados Unidos) (`eua-texas`) 92.3%.

Book: *Don't You Worry About That! The Joh Bjelke-Petersen Memoirs* (1990). PT: Don't You Worry About That! The Joh Bjelke-Petersen Memoirs. Autobiografia de autoria catalogada com conteúdo substancial sobre governo e carreira política; não são memórias apenas pessoais.

[Active answers](../answers/personality/joh-bjelke-petersen.json) · [Research and sources](../research/personality/joh-bjelke-petersen.json) · [Independent review](../research/process-review/joh-bjelke-petersen.json)

## Changed files

Runtime changes are limited to catalogue data and portraits. The new integration test and integrity verifier check the additions; research, answer archives and reports provide review evidence. Existing runtime Java/TypeScript, scoring code, validators, instructions and other catalogue entries are untouched.

- `backend/src/main/resources/data/books.json`
- `backend/src/main/resources/data/i18n/en/personalities.json`
- `backend/src/main/resources/data/personalities.json`
- `backend/src/main/resources/data/personality-profiles.json`
- `backend/src/test/java/com/twelveaxes/ExpandedPersonalityTest.java`
- `frontend/public/personalities/portraits/angela-merkel.jpg`
- `frontend/public/personalities/portraits/angus-taylor.jpg`
- `frontend/public/personalities/portraits/anthony-albanese.jpg`
- `frontend/public/personalities/portraits/bob-hawke.jpg`
- `frontend/public/personalities/portraits/boris-johnson.jpg`
- `frontend/public/personalities/portraits/clement-attlee.jpg`
- `frontend/public/personalities/portraits/david-lloyd-george.jpg`
- `frontend/public/personalities/portraits/golda-meir.jpg`
- `frontend/public/personalities/portraits/gough-whitlam.jpg`
- `frontend/public/personalities/portraits/helmut-kohl.jpg`
- `frontend/public/personalities/portraits/hillary-clinton.jpg`
- `frontend/public/personalities/portraits/jimmy-carter.jpg`
- `frontend/public/personalities/portraits/joh-bjelke-petersen.jpg`
- `frontend/public/personalities/portraits/john-howard.jpg`
- `frontend/public/personalities/portraits/julia-gillard.jpg`
- `frontend/public/personalities/portraits/kamala-harris.jpg`
- `frontend/public/personalities/portraits/keir-starmer.jpg`
- `frontend/public/personalities/portraits/kevin-rudd.jpg`
- `frontend/public/personalities/portraits/lech-walesa.jpg`
- `frontend/public/personalities/portraits/lyndon-b-johnson.jpg`
- `frontend/public/personalities/portraits/malcolm-turnbull.jpg`
- `frontend/public/personalities/portraits/margaret-thatcher.jpg`
- `frontend/public/personalities/portraits/mark-carney.jpg`
- `frontend/public/personalities/portraits/nigel-farage.jpg`
- `frontend/public/personalities/portraits/olaf-scholz.jpg`
- `frontend/public/personalities/portraits/paul-keating.jpg`
- `frontend/public/personalities/portraits/pauline-hanson.jpg`
- `frontend/public/personalities/portraits/robert-menzies.jpg`
- `frontend/public/personalities/portraits/rupert-lowe.jpg`
- `frontend/public/personalities/portraits/scott-morrison.jpg`
- `frontend/public/personalities/portraits/tony-abbott.jpg`
- `profile-audit/STATE.json`
- `profile-audit/answers/personality/angela-merkel.json`
- `profile-audit/answers/personality/angus-taylor.json`
- `profile-audit/answers/personality/anthony-albanese.json`
- `profile-audit/answers/personality/bob-hawke.json`
- `profile-audit/answers/personality/boris-johnson.json`
- `profile-audit/answers/personality/clement-attlee.json`
- `profile-audit/answers/personality/david-lloyd-george.json`
- `profile-audit/answers/personality/golda-meir.json`
- `profile-audit/answers/personality/gough-whitlam.json`
- `profile-audit/answers/personality/helmut-kohl.json`
- `profile-audit/answers/personality/hillary-clinton.json`
- `profile-audit/answers/personality/jimmy-carter.json`
- `profile-audit/answers/personality/joh-bjelke-petersen.json`
- `profile-audit/answers/personality/john-howard.json`
- `profile-audit/answers/personality/julia-gillard.json`
- `profile-audit/answers/personality/kamala-harris.json`
- `profile-audit/answers/personality/keir-starmer.json`
- `profile-audit/answers/personality/kevin-rudd.json`
- `profile-audit/answers/personality/lech-walesa.json`
- `profile-audit/answers/personality/lyndon-b-johnson.json`
- `profile-audit/answers/personality/malcolm-turnbull.json`
- `profile-audit/answers/personality/margaret-thatcher.json`
- `profile-audit/answers/personality/mark-carney.json`
- `profile-audit/answers/personality/nigel-farage.json`
- `profile-audit/answers/personality/olaf-scholz.json`
- `profile-audit/answers/personality/paul-keating.json`
- `profile-audit/answers/personality/pauline-hanson.json`
- `profile-audit/answers/personality/revisions/2026-10-01/david-ben-gurion-independent.json`
- `profile-audit/answers/personality/revisions/initial-expansion/angela-merkel.json`
- `profile-audit/answers/personality/revisions/initial-expansion/angus-taylor.json`
- `profile-audit/answers/personality/revisions/initial-expansion/anthony-albanese.json`
- `profile-audit/answers/personality/revisions/initial-expansion/bob-hawke.json`
- `profile-audit/answers/personality/revisions/initial-expansion/boris-johnson.json`
- `profile-audit/answers/personality/revisions/initial-expansion/clement-attlee.json`
- `profile-audit/answers/personality/revisions/initial-expansion/david-ben-gurion.json`
- `profile-audit/answers/personality/revisions/initial-expansion/david-lloyd-george.json`
- `profile-audit/answers/personality/revisions/initial-expansion/golda-meir.json`
- `profile-audit/answers/personality/revisions/initial-expansion/gough-whitlam.json`
- `profile-audit/answers/personality/revisions/initial-expansion/helmut-kohl.json`
- `profile-audit/answers/personality/revisions/initial-expansion/hillary-clinton.json`
- `profile-audit/answers/personality/revisions/initial-expansion/jimmy-carter.json`
- `profile-audit/answers/personality/revisions/initial-expansion/joh-bjelke-petersen.json`
- `profile-audit/answers/personality/revisions/initial-expansion/john-howard.json`
- `profile-audit/answers/personality/revisions/initial-expansion/julia-gillard.json`
- `profile-audit/answers/personality/revisions/initial-expansion/kamala-harris.json`
- `profile-audit/answers/personality/revisions/initial-expansion/keir-starmer.json`
- `profile-audit/answers/personality/revisions/initial-expansion/kevin-rudd.json`
- `profile-audit/answers/personality/revisions/initial-expansion/lech-walesa.json`
- `profile-audit/answers/personality/revisions/initial-expansion/lyndon-b-johnson.json`
- `profile-audit/answers/personality/revisions/initial-expansion/malcolm-turnbull.json`
- `profile-audit/answers/personality/revisions/initial-expansion/margaret-thatcher.json`
- `profile-audit/answers/personality/revisions/initial-expansion/mark-carney.json`
- `profile-audit/answers/personality/revisions/initial-expansion/nigel-farage.json`
- `profile-audit/answers/personality/revisions/initial-expansion/olaf-scholz.json`
- `profile-audit/answers/personality/revisions/initial-expansion/paul-keating.json`
- `profile-audit/answers/personality/revisions/initial-expansion/pauline-hanson.json`
- `profile-audit/answers/personality/revisions/initial-expansion/robert-menzies.json`
- `profile-audit/answers/personality/revisions/initial-expansion/rupert-lowe.json`
- `profile-audit/answers/personality/revisions/initial-expansion/scott-morrison.json`
- `profile-audit/answers/personality/revisions/initial-expansion/tony-abbott.json`
- `profile-audit/answers/personality/robert-menzies.json`
- `profile-audit/answers/personality/rupert-lowe.json`
- `profile-audit/answers/personality/scott-morrison.json`
- `profile-audit/answers/personality/tony-abbott.json`
- `profile-audit/reports/politician-expansion-completion.md`
- `profile-audit/reports/politician-religions.json`
- `profile-audit/reports/politician-validation.json`
- `profile-audit/research/personality/angela-merkel.json`
- `profile-audit/research/personality/angus-taylor.json`
- `profile-audit/research/personality/anthony-albanese.json`
- `profile-audit/research/personality/bob-hawke.json`
- `profile-audit/research/personality/boris-johnson.json`
- `profile-audit/research/personality/clement-attlee.json`
- `profile-audit/research/personality/david-lloyd-george.json`
- `profile-audit/research/personality/golda-meir.json`
- `profile-audit/research/personality/gough-whitlam.json`
- `profile-audit/research/personality/helmut-kohl.json`
- `profile-audit/research/personality/hillary-clinton.json`
- `profile-audit/research/personality/jimmy-carter.json`
- `profile-audit/research/personality/joh-bjelke-petersen.json`
- `profile-audit/research/personality/john-howard.json`
- `profile-audit/research/personality/julia-gillard.json`
- `profile-audit/research/personality/kamala-harris.json`
- `profile-audit/research/personality/keir-starmer.json`
- `profile-audit/research/personality/kevin-rudd.json`
- `profile-audit/research/personality/lech-walesa.json`
- `profile-audit/research/personality/lyndon-b-johnson.json`
- `profile-audit/research/personality/malcolm-turnbull.json`
- `profile-audit/research/personality/margaret-thatcher.json`
- `profile-audit/research/personality/mark-carney.json`
- `profile-audit/research/personality/nigel-farage.json`
- `profile-audit/research/personality/olaf-scholz.json`
- `profile-audit/research/personality/paul-keating.json`
- `profile-audit/research/personality/pauline-hanson.json`
- `profile-audit/research/personality/robert-menzies.json`
- `profile-audit/research/personality/rupert-lowe.json`
- `profile-audit/research/personality/scott-morrison.json`
- `profile-audit/research/personality/tony-abbott.json`
- `profile-audit/research/process-review/angela-merkel.json`
- `profile-audit/research/process-review/angus-taylor.json`
- `profile-audit/research/process-review/anthony-albanese.json`
- `profile-audit/research/process-review/bob-hawke.json`
- `profile-audit/research/process-review/boris-johnson.json`
- `profile-audit/research/process-review/clement-attlee.json`
- `profile-audit/research/process-review/david-ben-gurion.json`
- `profile-audit/research/process-review/david-lloyd-george.json`
- `profile-audit/research/process-review/golda-meir.json`
- `profile-audit/research/process-review/gough-whitlam.json`
- `profile-audit/research/process-review/helmut-kohl.json`
- `profile-audit/research/process-review/hillary-clinton.json`
- `profile-audit/research/process-review/jimmy-carter.json`
- `profile-audit/research/process-review/joh-bjelke-petersen.json`
- `profile-audit/research/process-review/john-howard.json`
- `profile-audit/research/process-review/julia-gillard.json`
- `profile-audit/research/process-review/kamala-harris.json`
- `profile-audit/research/process-review/keir-starmer.json`
- `profile-audit/research/process-review/kevin-rudd.json`
- `profile-audit/research/process-review/lech-walesa.json`
- `profile-audit/research/process-review/lyndon-b-johnson.json`
- `profile-audit/research/process-review/malcolm-turnbull.json`
- `profile-audit/research/process-review/margaret-thatcher.json`
- `profile-audit/research/process-review/mark-carney.json`
- `profile-audit/research/process-review/nigel-farage.json`
- `profile-audit/research/process-review/olaf-scholz.json`
- `profile-audit/research/process-review/paul-keating.json`
- `profile-audit/research/process-review/pauline-hanson.json`
- `profile-audit/research/process-review/robert-menzies.json`
- `profile-audit/research/process-review/rupert-lowe.json`
- `profile-audit/research/process-review/scott-morrison.json`
- `profile-audit/research/process-review/tony-abbott.json`
- `profile-audit/verify_expansion.py`
- `profile-audit/reports/politician-verification.json`
