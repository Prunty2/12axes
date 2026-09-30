# Question-wording audit — issue #7

Source: [Improve question wording](https://github.com/RomanCypherpunk/12axes/issues/7).
Baseline: [`a1dc5b4`](https://github.com/RomanCypherpunk/12axes/commit/a1dc5b448d85845d62b7e99509dc007255b16bdb), “feat(quiz): review some questions”. That fix changed 131 Portuguese and 147 English texts and correctly made `representacao_12` a conditional preference for authoritarian government. The follow-up report asks to finish the factual-statement audit and separate bundled propositions.

## Scope and decision rule

Reviewed all 240 main-pool items in Portuguese and English, including the prior fix. An answer should express a political, institutional, ethical or lifestyle preference. Predictions, claims of necessity, and observations about benefits must not stand in for support. Explicit ethical judgements (for example, “morally acceptable”), preferences and conditional tradeoffs are valid; merely using “should” does not excuse an extra factual claim or unrelated policy bundle.

Independent policies are separated across existing items where suitable. Otherwise, the item is narrowed to one proposition and the rationale explicitly records the retired subtopic. This retains the 240-question structure, 20 items per axis, existing IDs/order, agreement poles and weights. It does not preserve every former subtopic. Jurisdiction names, synonyms, examples of the same policy target, and a policy's purpose are not automatically separate propositions. A conditional tradeoff asks whether to accept the policy *if* the condition holds, not whether that condition is true.

Portuguese retains its Brazilian context where appropriate; English retains its international context. Each changed item below has both original and revised translations plus a rationale. The live Portuguese profile-audit template uses exactly the revised pool text.

Election and archetype questionnaires are separate instruments and were not part of the #7 main-pool fix or this audit. Existing saved results, profile vectors, and historical profile answers are not recomputed: stable IDs and weights preserve the mechanics, not empirical equivalence of responses to reworded or narrowed items. Fresh profile audits must use the updated template; old answers must not be presented as answers to these new texts. Profile recalibration is a separate follow-up.

## Review inventory

All twelve axes were reviewed. Unchanged items already express a preference, permission, obligation, priority or ethical judgement, with one governing proposition. The inventory lists every unchanged ID to make the scope checkable; changed IDs appear individually below.

| Axis | Changed | Unchanged IDs reviewed |
| --- | ---: | --- |
| estrutura | 4 | `estrutura_01`, `estrutura_02`, `estrutura_05`, `estrutura_07`, `estrutura_08`, `estrutura_09`, `estrutura_10`, `estrutura_11`, `estrutura_12`, `estrutura_13`, `estrutura_14`, `estrutura_15`, `estrutura_16`, `estrutura_17`, `estrutura_18`, `estrutura_20` |
| representacao | 7 | `representacao_01`, `representacao_02`, `representacao_03`, `representacao_04`, `representacao_05`, `representacao_08`, `representacao_09`, `representacao_11`, `representacao_12`, `representacao_14`, `representacao_15`, `representacao_16`, `representacao_17` |
| poder | 4 | `poder_01`, `poder_03`, `poder_04`, `poder_05`, `poder_07`, `poder_08`, `poder_09`, `poder_10`, `poder_11`, `poder_12`, `poder_13`, `poder_14`, `poder_17`, `poder_18`, `poder_19`, `poder_20` |
| imigracao | 6 | `imigracao_02`, `imigracao_04`, `imigracao_05`, `imigracao_06`, `imigracao_07`, `imigracao_09`, `imigracao_10`, `imigracao_11`, `imigracao_13`, `imigracao_14`, `imigracao_16`, `imigracao_17`, `imigracao_18`, `imigracao_19` |
| diplomacia | 5 | `diplomacia_01`, `diplomacia_02`, `diplomacia_03`, `diplomacia_04`, `diplomacia_05`, `diplomacia_06`, `diplomacia_07`, `diplomacia_08`, `diplomacia_10`, `diplomacia_12`, `diplomacia_14`, `diplomacia_16`, `diplomacia_17`, `diplomacia_18`, `diplomacia_20` |
| intervencao | 0 | `intervencao_01`, `intervencao_02`, `intervencao_03`, `intervencao_04`, `intervencao_05`, `intervencao_06`, `intervencao_07`, `intervencao_08`, `intervencao_09`, `intervencao_10`, `intervencao_11`, `intervencao_12`, `intervencao_13`, `intervencao_14`, `intervencao_15`, `intervencao_16`, `intervencao_17`, `intervencao_18`, `intervencao_19`, `intervencao_20` |
| economia | 8 | `economia_02`, `economia_03`, `economia_04`, `economia_05`, `economia_07`, `economia_08`, `economia_11`, `economia_13`, `economia_14`, `economia_16`, `economia_17`, `economia_18` |
| controle | 7 | `controle_03`, `controle_05`, `controle_06`, `controle_07`, `controle_09`, `controle_10`, `controle_11`, `controle_12`, `controle_14`, `controle_15`, `controle_17`, `controle_18`, `controle_20` |
| comercio | 5 | `comercio_01`, `comercio_02`, `comercio_03`, `comercio_04`, `comercio_05`, `comercio_06`, `comercio_09`, `comercio_10`, `comercio_11`, `comercio_12`, `comercio_14`, `comercio_15`, `comercio_16`, `comercio_19`, `comercio_20` |
| religiao | 9 | `religiao_03`, `religiao_04`, `religiao_05`, `religiao_08`, `religiao_09`, `religiao_10`, `religiao_11`, `religiao_12`, `religiao_13`, `religiao_14`, `religiao_17` |
| moral | 11 | `moral_01`, `moral_02`, `moral_03`, `moral_07`, `moral_09`, `moral_12`, `moral_13`, `moral_14`, `moral_20` |
| tecnologia | 10 | `tecnologia_05`, `tecnologia_06`, `tecnologia_07`, `tecnologia_08`, `tecnologia_10`, `tecnologia_11`, `tecnologia_13`, `tecnologia_16`, `tecnologia_17`, `tecnologia_18` |

## Changes (76 paired items)

### `estrutura_03` — agree → LEFT

- **PT before:** As leis devem ser definidas e os serviços administrados o mais próximo possível da população local.
- **PT after:** As leis sobre assuntos locais devem ser definidas pelos governos municipais.
- **EN before:** Laws should be made and public services managed as close to local communities as possible.
- **EN after:** Laws on local matters should be made by local governments.
- **Rationale:** Separate local lawmaking from service administration, which is asked independently in estrutura_19.

### `estrutura_04` — agree → RIGHT

- **PT before:** Um currículo escolar único para todo o país é melhor do que cada estado ensinar de um jeito.
- **PT after:** Prefiro um currículo escolar nacional único a currículos definidos por cada estado.
- **EN before:** A single national school curriculum is better than allowing each region to set its own.
- **EN after:** I prefer a single national school curriculum to curricula set by each region.
- **Rationale:** Ask for the preferred level of control instead of an assessment of which curriculum is better.

### `estrutura_06` — agree → RIGHT

- **PT before:** Uma polícia única e nacional funcionaria melhor do que várias polícias estaduais autônomas.
- **PT after:** Prefiro uma polícia nacional única a várias polícias estaduais autônomas.
- **EN before:** A single national police force would work better than several autonomous regional forces.
- **EN after:** I prefer a single national police force to several autonomous regional forces.
- **Rationale:** A belief about police effectiveness need not imply support for centralization; ask directly for the institutional preference.

### `estrutura_19` — agree → LEFT

- **PT before:** A educação pública deve ser administrada pelas prefeituras, não pelo governo federal.
- **PT after:** Os serviços públicos locais devem ser administrados pelas prefeituras, não pelo governo federal.
- **EN before:** Public education should be managed by local governments rather than the national government.
- **EN after:** Local public services should be managed by local governments rather than the national government.
- **Rationale:** Carry the service-administration half of estrutura_03 here; education remains included as a local public service.

### `representacao_06` — agree → RIGHT

- **PT before:** Um líder competente deveria poder governar sem eleições frequentes ou alternância obrigatória de poder.
- **PT after:** Um líder competente deveria poder governar sem eleições frequentes.
- **EN before:** A competent leader should be able to govern without frequent elections or mandatory changes in leadership.
- **EN after:** A competent leader should be able to govern without frequent elections.
- **Rationale:** Separate election frequency from compulsory leadership turnover; the latter is asked in representacao_18.

### `representacao_07` — agree → LEFT

- **PT before:** O voto secreto e universal é inegociável, mesmo para eleitores mal informados.
- **PT after:** Todo cidadão adulto deve ter direito de voto, mesmo quando for pouco informado sobre política.
- **EN before:** Secret and universal suffrage is non-negotiable, even for poorly informed voters.
- **EN after:** Every adult citizen should have the right to vote, even when poorly informed about politics.
- **Rationale:** Separate universal suffrage from ballot secrecy; secrecy moves to representacao_19.

### `representacao_10` — agree → RIGHT

- **PT before:** Governantes deveriam ser escolhidos por competência, tradição ou sucessão, em vez de eleições populares.
- **PT after:** O chefe de governo deveria ser escolhido por sucessão hereditária, em vez de eleições populares.
- **EN before:** Leaders should be chosen by competence, tradition, or succession rather than by popular vote.
- **EN after:** The head of government should be chosen by hereditary succession rather than popular elections.
- **Rationale:** Separate hereditary rule from selection by expertise, already asked in representacao_14. Tradition is made concrete as hereditary succession.

### `representacao_13` — agree → LEFT

- **PT before:** Cargos públicos poderiam ser sorteados entre cidadãos comuns, como num júri, em vez de eleitos.
- **PT after:** Prefiro que cargos públicos sejam preenchidos por sorteio entre cidadãos comuns, em vez de eleições.
- **EN before:** Public offices could be filled by randomly selected citizens, as juries are, rather than by election.
- **EN after:** I prefer public offices to be filled by randomly selected citizens rather than by election.
- **Rationale:** Replace a statement that selection by lottery is possible with an explicit preference for it.

### `representacao_18` — agree → RIGHT

- **PT before:** Reformas profundas não deveriam ser interrompidas por eleições frequentes ou alternância de poder.
- **PT after:** Um governante deveria poder permanecer no poder até concluir reformas profundas, mesmo após o fim de seu mandato.
- **EN before:** Major reforms should not be interrupted by frequent elections or changes in government.
- **EN after:** A leader should be allowed to remain in power until major reforms are completed, even after their term ends.
- **Rationale:** Ask separately about overriding a term limit to complete reforms; election frequency stays in representacao_06. This is an autocratic exception, not ordinary reelection.

### `representacao_19` — agree → LEFT

- **PT before:** Mesmo um governo eleito com enorme maioria deve respeitar todos os direitos da oposição.
- **PT after:** O voto deve ser secreto, sem que eleitores precisem revelar sua escolha.
- **EN before:** Even a government elected by a huge majority must respect all the rights of the opposition.
- **EN after:** Voting should be secret, without voters having to reveal their choice.
- **Rationale:** Carry the ballot-secrecy half of representacao_07 in a separate item. Opposition protection remains in representacao_03; the former broad all-rights wording is retired.

### `representacao_20` — agree → RIGHT

- **PT before:** Prefiro um regime autocrático que garanta ordem, segurança e prosperidade à democracia eleitoral.
- **PT after:** Prefiro um regime autocrático à democracia eleitoral se ele garantir maior segurança pública.
- **EN before:** I would prefer an autocratic regime that guarantees order, security, and prosperity over electoral democracy.
- **EN after:** I prefer an autocratic regime to electoral democracy if it guarantees greater public safety.
- **Rationale:** Isolate the security tradeoff instead of bundling order, security and prosperity. Economic development is already a separate tradeoff in representacao_12.

### `poder_02` — agree → RIGHT

- **PT before:** O consumo de maconha por adultos deveria ser legalizado ou descriminalizado.
- **PT after:** O consumo de maconha por adultos não deveria ser crime.
- **EN before:** Adult cannabis use should be legalized or decriminalized.
- **EN after:** Adult cannabis use should not be a criminal offense.
- **Rationale:** Ask about decriminalization alone; legalization of all drugs remains a distinct stronger position in poder_08.

### `poder_06` — agree → RIGHT

- **PT before:** Condutas consensuais entre adultos, como uso de drogas, apostas e prostituição, não deveriam ser criminalizadas.
- **PT after:** Apostas entre adultos que participem voluntariamente não deveriam ser crime.
- **EN before:** Consensual activities among adults, such as drug use, gambling, and sex work, should not be criminalized.
- **EN after:** Gambling among consenting adults should not be a criminal offense.
- **Rationale:** Separate gambling from drugs (poder_02 and poder_08) and consensual sex work (poder_16).

### `poder_15` — agree → LEFT

- **PT before:** A pena de morte deveria ser adotada para crimes como estupro e assassinato.
- **PT after:** A pena de morte deveria ser adotada para assassinato.
- **EN before:** The death penalty should be adopted for crimes such as rape and murder.
- **EN after:** The death penalty should be adopted for murder.
- **Rationale:** Narrow the list of offenses to murder so respondents need not give one answer for rape and murder; the separate rape proposition is retired.

### `poder_16` — agree → RIGHT

- **PT before:** Toda lei que proíbe o que adultos fazem em privado é um abuso do Estado.
- **PT after:** A prestação consensual de serviços sexuais entre adultos não deveria ser crime.
- **EN before:** Any law that bans what adults do in private is an abuse by the state.
- **EN after:** Consensual sex work between adults should not be a criminal offense.
- **Rationale:** Carry the sex-work half of poder_06 separately. Replace the blanket claim about all private conduct, which could include harm to others, with a specific civil-liberty preference.

### `imigracao_01` — agree → LEFT

- **PT before:** Quem imigra para um país deve aprender o idioma e adotar os costumes locais.
- **PT after:** Quem imigra para um país deve aprender o idioma predominante.
- **EN before:** Those who immigrate to a country should learn the language and adopt local customs.
- **EN after:** People who immigrate to a country should learn its main language.
- **Rationale:** Separate language learning from adopting local customs, already asked in imigracao_11.

### `imigracao_03` — agree → LEFT

- **PT before:** Fechar as fronteiras pode ser necessário para preservar a identidade cultural de um país.
- **PT after:** Sou a favor de fechar as fronteiras à imigração para preservar a identidade cultural do país.
- **EN before:** Closing the borders may be necessary to preserve a country's cultural identity.
- **EN after:** I support closing the borders to immigration to preserve the country's cultural identity.
- **Rationale:** Replace a claim about possible necessity with personal support for the restrictive policy.

### `imigracao_08` — agree → RIGHT

- **PT before:** A convivência de diferentes línguas e culturas deve ser incentivada no país.
- **PT after:** O país deve incentivar a preservação das culturas trazidas por imigrantes.
- **EN before:** The coexistence of different languages and cultures should be encouraged in a country.
- **EN after:** The country should encourage the preservation of cultures brought by immigrants.
- **Rationale:** Separate cultural preservation from multilingual everyday life, already asked in imigracao_02.

### `imigracao_12` — agree → RIGHT

- **PT before:** O Brasil deve continuar acolhendo imigrantes venezuelanos e haitianos.
- **PT after:** O Brasil deve acolher imigrantes de países que enfrentam crises graves.
- **EN before:** My country should continue to welcome immigrants from countries facing severe crises.
- **EN after:** My country should welcome immigrants from countries facing severe crises.
- **Rationale:** Remove the paired nationalities and align the Portuguese criterion with English; support for one nationality need not imply support for the other.

### `imigracao_15` — agree → LEFT

- **PT before:** Bairros cujos moradores imigrantes vivem isolados em sua própria cultura criam problemas para o país.
- **PT after:** O governo deve promover a integração dos bairros de imigrantes à cultura predominante do país.
- **EN before:** Neighborhoods whose immigrant residents remain culturally isolated create problems for the country.
- **EN after:** The government should promote the integration of immigrant neighborhoods into the country's predominant culture.
- **Rationale:** Ask for an assimilation policy instead of agreement that cultural isolation causes problems.

### `imigracao_20` — agree → RIGHT

- **PT before:** A ideia de identidade nacional está ultrapassada: somos todos cidadãos do mundo.
- **PT after:** Prefiro uma identidade de cidadão do mundo a uma identidade nacional.
- **EN before:** The idea of national identity is outdated: we are all citizens of the world.
- **EN after:** I prefer an identity as a citizen of the world to a national identity.
- **Rationale:** Replace assertions that national identity is obsolete and everyone is a world citizen with one identity preference.

### `diplomacia_09` — agree → LEFT

- **PT before:** O serviço militar obrigatório é necessário para preparar o país para uma guerra.
- **PT after:** O serviço militar deve ser obrigatório para preparar o país para uma guerra.
- **EN before:** Mandatory military service is necessary to prepare a country for war.
- **EN after:** Military service should be compulsory to prepare the country for war.
- **Rationale:** Supporting conscription is distinct from believing it is necessary or effective.

### `diplomacia_11` — agree → LEFT

- **PT before:** A capacidade de fabricar armamentos próprios é essencial à defesa nacional.
- **PT after:** O país deve priorizar a fabricação nacional de armamentos para sua defesa.
- **EN before:** The ability to manufacture weapons domestically is essential to national defense.
- **EN after:** The country should prioritize domestic weapons manufacturing for its defense.
- **Rationale:** Ask for a defense priority rather than treating domestic manufacturing as an established necessity.

### `diplomacia_13` — agree → LEFT

- **PT before:** Espionagem e operações militares secretas são ferramentas legítimas de um Estado.
- **PT after:** O Estado deve poder realizar espionagem contra outros países.
- **EN before:** Espionage and covert military operations are legitimate tools of a state.
- **EN after:** The state should be allowed to conduct espionage against other countries.
- **Rationale:** Separate espionage from covert military operations, now asked in diplomacia_15.

### `diplomacia_15` — agree → LEFT

- **PT before:** Drones e armas autônomas dão vantagem decisiva, e o Brasil deveria desenvolvê-los.
- **PT after:** O Estado deve poder realizar operações militares secretas em outros países.
- **EN before:** Drones and autonomous weapons provide a decisive advantage, and my country should develop them.
- **EN after:** The state should be allowed to conduct covert military operations in other countries.
- **Rationale:** Carry the military-operations half of diplomacia_13 separately. Retire the bundled drones/autonomous-weapons proposal and its unqualified claim of decisive advantage; specific weapons procurement is no longer tested here.

### `diplomacia_19` — agree → LEFT

- **PT before:** A paz só existe quando o inimigo sabe que a resposta a um ataque será devastadora.
- **PT after:** O país deve ameaçar uma resposta militar devastadora para dissuadir ataques.
- **EN before:** Peace only exists when the enemy knows the response to an attack will be devastating.
- **EN after:** The country should threaten a devastating military response to deter attacks.
- **Rationale:** Ask whether respondents support this deterrence policy, not whether they believe it is the only cause of peace.

### `economia_01` — agree → LEFT

- **PT before:** Uma revolução pode ser necessária para tirar o poder econômico das mãos de poucos.
- **PT after:** Sou a favor de uma revolução para redistribuir o poder econômico concentrado nas mãos de poucos.
- **EN before:** A revolution may be necessary to take economic power out of the hands of the few.
- **EN after:** I support a revolution to redistribute economic power concentrated in the hands of a few.
- **Rationale:** Replace a claim that revolution may be necessary with explicit support for revolutionary redistribution.

### `economia_06` — agree → RIGHT

- **PT before:** Até estradas, polícia e tribunais poderiam ser administrados por empresas privadas.
- **PT after:** A polícia deveria ser administrada por empresas privadas.
- **EN before:** Even roads, police, and courts could be managed by private companies.
- **EN after:** The police should be run by private companies.
- **Rationale:** Separate privatized policing from roads and courts; roads move to economia_20. Privatized courts are retired rather than implied by support for policing.

### `economia_09` — agree → LEFT

- **PT before:** Saúde, educação e água não deveriam funcionar sob a lógica do lucro.
- **PT after:** Os serviços de saúde não deveriam ser prestados com fins lucrativos.
- **EN before:** Healthcare, education, and water should not operate under the logic of profit.
- **EN after:** Healthcare services should not be provided for profit.
- **Rationale:** Isolate healthcare from education and water. The latter two sector-specific propositions are retired; agreement no longer requires the same ownership preference for all three.

### `economia_10` — agree → RIGHT

- **PT before:** Cobrar impostos é, no fundo, uma forma de roubo.
- **PT after:** Sou contra a cobrança obrigatória de impostos.
- **EN before:** Collecting taxes is, in the end, a form of theft.
- **EN after:** I oppose compulsory taxation.
- **Rationale:** Express the anti-tax position directly rather than asking respondents to classify taxation as theft.

### `economia_12` — agree → RIGHT

- **PT before:** A estabilidade vitalícia dos servidores públicos deveria ser reduzida ou eliminada.
- **PT after:** A estabilidade vitalícia dos servidores públicos deveria ser eliminada.
- **EN before:** Lifetime job security for public employees should be limited or eliminated.
- **EN after:** Lifetime job security for public employees should be abolished.
- **Rationale:** Choose one concrete policy rather than combining limitation and abolition; respondents can distinguish this stronger position from partial reform.

### `economia_15` — agree → LEFT

- **PT before:** A reforma agrária ainda é uma medida necessária no Brasil.
- **PT after:** O Brasil deveria redistribuir grandes propriedades rurais por meio de uma reforma agrária.
- **EN before:** Land reform is still a necessary measure in my country.
- **EN after:** My country should redistribute large rural estates through land reform.
- **Rationale:** Ask for support for a defined land-reform policy instead of agreement that an unspecified reform is necessary.

### `economia_19` — agree → LEFT

- **PT before:** O risco de vender estatais por menos do que valem justifica mantê-las sob controle público.
- **PT after:** Prefiro manter estatais sob controle público a vendê-las por menos do que valem.
- **EN before:** The risk of selling state-owned companies for less than they are worth justifies keeping them under public control.
- **EN after:** I prefer keeping state-owned companies under public control to selling them for less than they are worth.
- **Rationale:** Make the ownership tradeoff explicit without requiring agreement about the likelihood of undervaluation.

### `economia_20` — agree → RIGHT

- **PT before:** A gestão de serviços públicos deveria priorizar o setor privado.
- **PT after:** As estradas deveriam ser administradas por empresas privadas.
- **EN before:** Private companies should take priority in the management of public services.
- **EN after:** Roads should be run by private companies.
- **Rationale:** Carry the roads half of economia_06 separately. The broader preference for private service provision remains in economia_02.

### `controle_01` — agree → LEFT

- **PT before:** O governo deve planejar setores estratégicos como energia, moradia e indústria.
- **PT after:** O governo deve planejar o setor de energia.
- **EN before:** The government should plan strategic sectors such as energy, housing, and industry.
- **EN after:** The government should plan the energy sector.
- **Rationale:** Isolate energy planning from housing and industry. Those additional sector-specific propositions are retired; general state planning remains in controle_13.

### `controle_02` — agree → RIGHT

- **PT before:** Preços e salários deveriam ser definidos pelo mercado, sem intervenção do governo.
- **PT after:** Os preços dos produtos deveriam ser definidos pelo mercado, sem intervenção do governo.
- **EN before:** Prices and wages should be set by the market without government intervention.
- **EN after:** Product prices should be set by the market without government intervention.
- **Rationale:** Separate product prices from wages, which move to controle_04.

### `controle_04` — agree → RIGHT

- **PT before:** Empresas devem definir relações de trabalho com o mínimo de interferência do governo.
- **PT after:** Os salários deveriam ser definidos pelo mercado, sem intervenção do governo.
- **EN before:** Companies should set the terms of employment with minimal government interference.
- **EN after:** Wages should be set by the market without government intervention.
- **Rationale:** Carry the wage half of controle_02 separately. Replace the broader employment-terms item; general opposition to new regulation remains in controle_14.

### `controle_08` — agree → RIGHT

- **PT before:** O salário mínimo não deve ser alto demais, pois isso reduz os empregos disponíveis para os mais pobres.
- **PT after:** Prefiro limitar aumentos do salário mínimo se eles reduzirem as oportunidades de emprego dos trabalhadores mais pobres.
- **EN before:** The minimum wage should not be set too high, because that reduces jobs available to the poorest workers.
- **EN after:** I prefer limiting minimum-wage increases if they reduce job opportunities for the poorest workers.
- **Rationale:** Replace an undefined excessive wage and asserted causal effect with a conditional policy preference. Agreement supports the tradeoff, not a prediction that every increase destroys jobs.

### `controle_13` — agree → LEFT

- **PT before:** Uma economia totalmente planejada pelo Estado funcionaria melhor do que o livre mercado.
- **PT after:** Prefiro uma economia totalmente planejada pelo Estado a uma economia de livre mercado.
- **EN before:** An economy fully planned by the state would work better than the free market.
- **EN after:** I prefer an economy fully planned by the state to a free-market economy.
- **Rationale:** Ask for the preferred system rather than a prediction about comparative performance.

### `controle_16` — agree → RIGHT

- **PT before:** Um Banco Central independente vale mais do que a vontade política do governo da vez.
- **PT after:** O Banco Central deve ter autonomia para decidir a política monetária, mesmo contra a vontade do governo.
- **EN before:** An independent central bank is worth more than the current government's political wishes.
- **EN after:** The central bank should have autonomy over monetary policy, even against the government's wishes.
- **Rationale:** Make the institutional preference explicit rather than asking which institution is worth more.

### `controle_19` — agree → LEFT

- **PT before:** O salário mínimo definido por lei protege o trabalhador mais do que a livre negociação.
- **PT after:** Deve haver um salário mínimo definido por lei, em vez de deixar todos os salários à livre negociação.
- **EN before:** A minimum wage set by law protects workers more than free negotiation does.
- **EN after:** There should be a legal minimum wage rather than leaving all wages to free negotiation.
- **Rationale:** Support for a wage floor is distinct from believing it protects workers more effectively.

### `comercio_07` — agree → LEFT

- **PT before:** O governo deve limitar importações que ameacem a indústria e o emprego local.
- **PT after:** O governo deve limitar importações que ameacem empregos locais.
- **EN before:** The government should limit imports that threaten local industry and jobs.
- **EN after:** The government should limit imports that threaten local jobs.
- **Rationale:** Isolate jobs from industry protection, already asked in comercio_01.

### `comercio_08` — agree → RIGHT

- **PT before:** O mundo estaria melhor sem fronteiras econômicas, funcionando como um único mercado global.
- **PT after:** Sou a favor de um mercado global único, sem fronteiras econômicas.
- **EN before:** The world would be better off without economic borders, working as a single global market.
- **EN after:** I support a single global market without economic borders.
- **Rationale:** Replace a broad prediction that the world would be better off with support for economic integration.

### `comercio_13` — agree → LEFT

- **PT before:** As compras do governo e das estatais devem priorizar empresas brasileiras.
- **PT after:** As compras do governo devem priorizar empresas brasileiras.
- **EN before:** Purchases by governments and state-owned companies should give priority to domestic companies.
- **EN after:** Government purchases should give priority to domestic companies.
- **Rationale:** Narrow procurement to government purchases; the separate rule for state-owned companies is retired.

### `comercio_17` — agree → LEFT

- **PT before:** Cadeias estratégicas, como remédios e chips, devem ser protegidas da concorrência externa.
- **PT after:** A produção nacional de medicamentos deve ser protegida da concorrência externa.
- **EN before:** Strategic supply chains, such as medicines and chips, should be protected from foreign competition.
- **EN after:** Domestic medicine production should be protected from foreign competition.
- **Rationale:** Isolate medicines from chips; semiconductor protection is retired rather than treating both industries as one answer.

### `comercio_18` — agree → RIGHT

- **PT before:** As multinacionais são benéficas porque geram empregos e qualificam os trabalhadores locais.
- **PT after:** Sou a favor de permitir que multinacionais operem no país, mesmo concorrendo com empresas locais.
- **EN before:** Multinational companies are beneficial because they create jobs and train local workers.
- **EN after:** I support allowing multinational companies to operate in the country, even when they compete with local companies.
- **Rationale:** Replace asserted job and training benefits with explicit support for multinational market access and its competition tradeoff.

### `religiao_01` — agree → LEFT

- **PT before:** Religião é assunto pessoal e não deve influenciar políticas públicas.
- **PT after:** A religião não deve influenciar políticas públicas.
- **EN before:** Religion is a personal matter and should not influence public policy.
- **EN after:** Religion should not influence public policy.
- **Rationale:** Remove the additional assertion that religion is a personal matter; ask only about its role in policy.

### `religiao_02` — agree → RIGHT

- **PT before:** A religião deve orientar minhas escolhas morais e políticas.
- **PT after:** A fé religiosa deve orientar minhas escolhas morais.
- **EN before:** Faith should be the guide for my moral and political choices.
- **EN after:** Religious faith should guide my moral choices.
- **Rationale:** Separate personal moral guidance from political influence, already asked in religiao_04 and religiao_09.

### `religiao_06` — agree → RIGHT

- **PT before:** A religião torna a vida em comunidade mais forte e deve ser incentivada.
- **PT after:** A prática religiosa deve ser incentivada na vida em comunidade.
- **EN before:** Religion strengthens community life and should be encouraged.
- **EN after:** Religious practice should be encouraged in community life.
- **Rationale:** Remove the claim that religion strengthens communities; ask whether it should be encouraged regardless of that empirical assessment.

### `religiao_07` — agree → LEFT

- **PT before:** Prédios públicos, como escolas e tribunais, não deveriam exibir símbolos religiosos.
- **PT after:** Escolas públicas não deveriam exibir símbolos religiosos.
- **EN before:** Public buildings, such as schools and courts, should not display religious symbols.
- **EN after:** Public schools should not display religious symbols.
- **Rationale:** Isolate schools from courts; the separate courthouse-symbol proposition is retired.

### `religiao_15` — agree → LEFT

- **PT before:** A palavra 'Deus' não deveria aparecer na Constituição e em discursos políticos.
- **PT after:** A palavra 'Deus' não deveria aparecer na Constituição.
- **EN before:** The word 'God' should not appear in the constitution or in political speeches.
- **EN after:** The word 'God' should not appear in the constitution.
- **Rationale:** Separate constitutional references from political speech; the latter proposition is retired so support for secular law need not imply restrictions on politicians' speech.

### `religiao_16` — agree → RIGHT

- **PT before:** A fé religiosa é necessária para dar sentido à vida.
- **PT after:** Prefiro buscar na fé religiosa o sentido da minha vida.
- **EN before:** Religious faith is necessary to give life meaning.
- **EN after:** I prefer to seek the meaning of my life in religious faith.
- **Rationale:** Ask for the respondent's religious orientation, not the factual or theological claim that everyone needs faith for a meaningful life.

### `religiao_18` — agree → RIGHT

- **PT before:** Quando a lei dos homens contraria a lei de Deus, a lei de Deus vem primeiro.
- **PT after:** Quando uma lei contraria minha fé religiosa, devo seguir minha fé.
- **EN before:** When the law of men contradicts the law of God, the law of God comes first.
- **EN after:** When a law conflicts with my religious faith, I should follow my faith.
- **Rationale:** Make the priority a personal normative choice rather than an assertion of divine legal authority.

### `religiao_19` — agree → LEFT

- **PT before:** A moral pública não precisa se apoiar na crença em Deus.
- **PT after:** A moral pública deve ser fundamentada em princípios que não dependam da crença em Deus.
- **EN before:** Public morality does not need to be based on belief in God.
- **EN after:** Public morality should be grounded in principles that do not depend on belief in God.
- **Rationale:** Distinguish support for secular moral foundations from acknowledging that morality without faith is possible.

### `religiao_20` — agree → RIGHT

- **PT before:** A fé religiosa é parte da identidade nacional e merece proteção.
- **PT after:** A fé religiosa deve ser protegida como parte da identidade nacional.
- **EN before:** Religious faith is part of the national identity and deserves protection.
- **EN after:** Religious faith should be protected as part of the national identity.
- **Rationale:** Ask whether to protect a religious national identity, without requiring agreement that it is already a fact about every country.

### `moral_04` — agree → RIGHT

- **PT before:** Mudanças culturais não devem ser rápidas demais, porque acabam desestruturando a sociedade.
- **PT after:** Prefiro mudanças culturais graduais a mudanças culturais rápidas.
- **EN before:** Cultural changes that come too fast end up destabilizing the whole of society.
- **EN after:** I prefer gradual cultural change to rapid cultural change.
- **Rationale:** Remove the destabilization claim and fix the English translation, which still lacked the Portuguese preference introduced by the earlier fix.

### `moral_05` — agree → LEFT

- **PT before:** Cotas raciais ainda são necessárias para enfrentar desigualdades.
- **PT after:** Sou a favor de cotas raciais para enfrentar desigualdades.
- **EN before:** Race-based quotas are still needed to address inequality.
- **EN after:** I support race-based quotas to address inequality.
- **Rationale:** Ask for support for quotas instead of an assessment of their necessity.

### `moral_06` — agree → RIGHT

- **PT before:** Casamento de verdade é entre um homem e uma mulher.
- **PT after:** O casamento deve ser reconhecido apenas entre um homem e uma mulher.
- **EN before:** Real marriage is between a man and a woman.
- **EN after:** Marriage should be recognized only between a man and a woman.
- **Rationale:** Make the traditionalist preference explicit instead of asking for agreement with a definition of real marriage.

### `moral_08` — agree → RIGHT

- **PT before:** Cotas raciais deveriam ser encerradas para evitar divisões por cor.
- **PT after:** Sou a favor de encerrar as cotas raciais.
- **EN before:** Race-based quotas should be ended to avoid divisions along racial lines.
- **EN after:** I support ending race-based quotas.
- **Rationale:** Separate opposition to quotas from a causal claim that they produce racial division.

### `moral_10` — agree → RIGHT

- **PT before:** O aborto é errado porque interrompe uma vida humana.
- **PT after:** Considero o aborto moralmente errado.
- **EN before:** Abortion is wrong because it ends a human life.
- **EN after:** I consider abortion morally wrong.
- **Rationale:** Ask directly for the moral judgement; remove the additional premise about why it is wrong.

### `moral_11` — agree → LEFT

- **PT before:** Adolescentes deveriam aprender sobre sexualidade e gênero sem tabus.
- **PT after:** Adolescentes deveriam receber educação sobre identidade de gênero.
- **EN before:** Teenagers should learn about sexuality and gender without taboos.
- **EN after:** Teenagers should receive education about gender identity.
- **Rationale:** Separate gender education from sexuality education, whose authority is independently addressed in moral_12; remove the undefined without-taboos qualification.

### `moral_15` — agree → LEFT

- **PT before:** Reduzir o consumo de carne por respeito aos animais é um avanço moral.
- **PT after:** Devemos reduzir o consumo de carne por respeito aos animais.
- **EN before:** Reducing meat consumption out of respect for animals is a moral advance.
- **EN after:** We should reduce meat consumption out of respect for animals.
- **Rationale:** Ask for the ethical preference directly rather than an assessment of whether a social change counts as progress.

### `moral_16` — agree → RIGHT

- **PT before:** Consumir pornografia ou drogas é um sinal de decadência moral.
- **PT after:** Considero o consumo de pornografia moralmente errado.
- **EN before:** Using pornography or drugs is a sign of moral decline.
- **EN after:** I consider pornography use morally wrong.
- **Rationale:** Isolate pornography from drugs and replace a societal-decline claim with a moral judgement. Drug legality remains in poder_02 and poder_08, but drug morality is no longer tested here.

### `moral_17` — agree → LEFT

- **PT before:** Relações abertas e poliamor são escolhas tão legítimas quanto o casamento tradicional.
- **PT after:** Relações afetivas consensuais com mais de um parceiro devem ser tão respeitadas quanto o casamento monogâmico.
- **EN before:** Open relationships and polyamory are choices as legitimate as traditional marriage.
- **EN after:** Consensual romantic relationships with more than one partner should be respected as much as monogamous marriage.
- **Rationale:** Ask one principle about consensual non-monogamy instead of bundling named relationship arrangements with a claim about their existing legitimacy.

### `moral_18` — agree → RIGHT

- **PT before:** O papel mais importante da mulher é cuidar da família e do lar.
- **PT after:** Cuidar da família deve ser a principal prioridade na vida de uma mulher.
- **EN before:** A woman's most important role is caring for the family and the home.
- **EN after:** Caring for the family should be the main priority in a woman's life.
- **Rationale:** Make the traditional gender-role preference explicit instead of stating a universal fact about women's roles.

### `moral_19` — agree → LEFT

- **PT before:** A nudez no cinema, na arte e nas praias não deveria ser considerada ofensiva.
- **PT after:** A nudez em filmes deve ser socialmente aceita.
- **EN before:** Nudity in films, art, and on beaches should not be considered offensive.
- **EN after:** Nudity in films should be socially accepted.
- **Rationale:** Isolate film nudity from art and beaches, which may elicit different judgements; those additional contexts are retired.

### `tecnologia_01` — agree → LEFT

- **PT before:** Energia nuclear, IA e engenharia genética devem ser adotadas sem medo excessivo.
- **PT after:** Sou a favor de ampliar o uso da energia nuclear.
- **EN before:** Nuclear energy, AI, and genetic engineering should be embraced without excessive fear.
- **EN after:** I support expanding the use of nuclear energy.
- **Rationale:** Separate nuclear energy from AI (tecnologia_03) and genetic engineering (tecnologia_05 and tecnologia_09); remove the loaded excessive-fear phrase.

### `tecnologia_02` — agree → RIGHT

- **PT before:** A humanidade viveria melhor com menos tecnologia, num modo de vida mais simples e natural.
- **PT after:** Prefiro um modo de vida com menos tecnologia.
- **EN before:** Humanity would live better with less technology, in a simpler, more natural way of life.
- **EN after:** I prefer a way of life with less technology.
- **Rationale:** Ask for a lifestyle preference rather than predicting that humanity would live better with less technology.

### `tecnologia_03` — agree → LEFT

- **PT before:** IA e automação são bem-vindas, mesmo que eliminem muitas profissões atuais.
- **PT after:** Sou a favor de ampliar o uso de IA no trabalho, mesmo que isso elimine muitas profissões atuais.
- **EN before:** AI and automation are welcome, even if they eliminate many of today's professions.
- **EN after:** I support expanding the use of AI at work, even if that eliminates many of today's professions.
- **Rationale:** Isolate AI adoption from automation in general while retaining the explicit employment tradeoff.

### `tecnologia_04` — agree → RIGHT

- **PT before:** Tecnologias que mexem no corpo, na mente ou na reprodução humana devem ser limitadas.
- **PT after:** Tecnologias usadas para alterar a reprodução humana devem ser limitadas.
- **EN before:** Technologies that alter the human body, mind, or reproduction should be restricted.
- **EN after:** Technologies used to alter human reproduction should be restricted.
- **Rationale:** Separate reproductive technology from mental enhancement (tecnologia_15) and bodily enhancement (tecnologia_20).

### `tecnologia_09` — agree → LEFT

- **PT before:** A edição genética deve ser permitida para aumentar a inteligência e prevenir doenças.
- **PT after:** A edição genética em humanos deve ser permitida para prevenir doenças.
- **EN before:** Gene editing should be permitted to increase intelligence and prevent disease.
- **EN after:** Human gene editing should be permitted to prevent disease.
- **Rationale:** Separate therapeutic editing from enhancement of intelligence, which is independently addressed in tecnologia_14.

### `tecnologia_12` — agree → RIGHT

- **PT before:** Mesmo uma mineração limpa na Amazônia ultrapassa um limite que não deveria ser cruzado.
- **PT after:** A mineração na Amazônia não deveria ser permitida, mesmo com baixo impacto ambiental.
- **EN before:** Even low-impact mining in the Amazon rainforest crosses a line that should not be crossed.
- **EN after:** Mining in the Amazon rainforest should not be allowed, even with low environmental impact.
- **Rationale:** State the environmental policy preference directly rather than relying on an undefined ethical line.

### `tecnologia_14` — agree → RIGHT

- **PT before:** Editar embriões para escolher inteligência ou aparência ultrapassa um limite ético.
- **PT after:** A edição genética de embriões para aumentar a inteligência deveria ser proibida.
- **EN before:** Editing embryos to choose intelligence or looks crosses an ethical line.
- **EN after:** Gene editing of embryos to increase intelligence should be prohibited.
- **Rationale:** Isolate intelligence enhancement from appearance selection and therapeutic editing (tecnologia_09). Appearance selection is retired; this item retains the restrictive agreement pole.

### `tecnologia_15` — agree → LEFT

- **PT before:** Implantes cerebrais para ampliar as capacidades humanas são um caminho legítimo.
- **PT after:** O uso de implantes cerebrais para ampliar as capacidades mentais humanas deve ser permitido.
- **EN before:** Brain implants are a legitimate way to expand human abilities.
- **EN after:** The use of brain implants to enhance human mental abilities should be allowed.
- **Rationale:** Ask directly whether to allow mental enhancement, independently from the reproductive and bodily restrictions in tecnologia_04 and tecnologia_20.

### `tecnologia_19` — agree → LEFT

- **PT before:** Contra o aquecimento global, apostar em tecnologia faz mais sentido do que reduzir o consumo.
- **PT after:** No combate ao aquecimento global, prefiro priorizar soluções tecnológicas à redução do consumo.
- **EN before:** Against global warming, relying on technology makes more sense than cutting consumption.
- **EN after:** In tackling global warming, I prefer prioritizing technological solutions over reducing consumption.
- **Rationale:** Ask for a policy priority rather than which approach appears more effective or sensible.

### `tecnologia_20` — agree → RIGHT

- **PT before:** O corpo humano não deveria ser melhorado com chips e modificações artificiais.
- **PT after:** O uso de tecnologias para ampliar as capacidades físicas humanas deveria ser proibido.
- **EN before:** The human body should not be enhanced with chips and artificial modifications.
- **EN after:** The use of technology to enhance human physical abilities should be prohibited.
- **Rationale:** Isolate bodily enhancement from the named chips/modifications bundle; mental enhancement is asked separately in tecnologia_15.

## Validation

Validated on 2026-09-30:

- `python3 scripts/check_i18n.py`: all catalog locale overlays cover the source data.
- `mvn --batch-mode --no-transfer-progress test` in `backend`: 121 tests passed, no failures/errors/skips.
- `npm ci --no-audit --no-fund`, `npm test`, and `npm run build` in `frontend`: 21 tests passed; TypeScript checking, production build and 1,548 static pages completed. The test runner emitted dependency deprecation warnings for Vite's esbuild options.
- Compared against the baseline: exactly 76 question IDs changed in each language; only `text` changed in the JSON records. All IDs, order, axis IDs, agreement poles and weights are unchanged; every axis retains 10 LEFT and 10 RIGHT items.
- Extracted all 240 `[id=...]` entries from `profile-audit/questions-template.txt` and verified exact text equality with the Portuguese pool. Verified one rationale entry for every changed ID.
- `git diff --check`: passed.

These checks establish data integrity and application compatibility. They do not establish psychometric validity, equivalence of old and new answers, or recalibrated profile matches.
