# SPL: *Itsasontzigudua* jokoa (*Battleship*)

**Ikasgaia**: Softwarearen Garapen Industriala

**Helburua**: emandako software (programa) batetik abiatuz, software produktu-lerro bat eraiki. 

Lanean  hasteko  erabiliko  den  aplikazioa  ***Battleship***  da,  oso  hedatua  den  jokoa,  hainbat  sistema eragilerekin batera doana. Bi jokalariren artean jokatzen da eta helburua beste jokalariaren itsasontzi flota  hondoratzea  da,  berak  gurea  urperatu  baino  lehen.  Partida  aurkariaren  azken  itsasontzia hondoratzean amaitzen da. Programa aldatu behar da hainbat produktu desberdin emango dituen SPL bat sortzeko. SPL honek jokoaren aldaki erraz batzuk sorrarazi behar ditu. 

**Lan-ataza**: *Battleship* SPL-aren kodean, behar diren aldaketak burutu: 

1) FeatureIDE proiektu bat sortu, identifikatzeko zure abizena erabiliz. 
1) Proiektuan, aurrerago ematen den aldakortasun eredua (hots, ezaugarri diagrama) sortu. 
1) Emandako  kodea  banatu  eta  aurreko  ezaugarrietan  barreiatu,  enuntziatuan  adierazitakoa jarraituz.  Zenbait  ezaugarri  ez  dago  inplementatuta,  eta  hortaz  gehitu  egin  behako  dira. Kasuren batean metodo gehigarriren bat sartzea beharrezkoa izatea gerta daiteke (edo kodea hainbat metodotan banatzea), SPL-ko kide desberdinen konposaketa egokia egin ahal izateko. Lana ezaugarriz ezaugarri egitea gomendatzen da, denek ez baitute zailtasun maila berdina. 
1) Proiektu osoa esportatu eta zip fitxategi batean trinkotu. eGela plataformara igo. 

Honako  URLetan  hainbat  Java  programa  daude,  aplikazio  horiek  inplementatzen  dituztenak. Praktikaren helburua ez da kodea hobetzea, analizatzea baizik, eta kodea kontuan hartu nahi ditugun ezaugarrietara lotzea, kodea behar ez denean errepika ez dadin. Helburua produktu-lerroko aplikazio desberdinak eraiki ahal izatea da. Lanean hasteko kode hauetako bat izan daiteke: 

- https://github.com/ymarcus93/Java-Battleship (kontsola bitartez) 
- https://pastebin.com/PXu9zzm0 (kontsola bitartez; azalpenak: https://youtu.be/-K4XvwySUAA) 

Aplikazioak  **About**  funtzionalitatea  eduki  behar  du,  eta  honek  ematen  den  kodearen  egilearen inguruko informazioa erakutsi behar du. Jatorrizko egilearen informazioa zurearekin batera sartzea ez ahaztu. Atal honetan, aplikaziorako hautatua izan den ezaugarri bakoitzeko lerro bat adieraziko da. Adibideko  irudiak  adierazten  du  erabilitako  aplikazioa  *Yuval  Marcus*-ena  dela  eta  *challenge* ezaugarria izan ezik beste guztiak hautatuak dituela (modu grafikoan aurkeztea ez da beharrezkoa).  

![](EzaugarriDiagrama.png)  ![](About.png)

SPL-ak  hiru  **zailtasun**-maila  aurreikusten  ditu  (*Difficulty*):  ***Beginner***  (8x8  eta  3  itsasontzi  mota); ***Intermediate*** (10x10 eta 4 itsasontzi mota); ***Advanced*** (20x20 eta 7 itsasontzi mota).** 

**Statistics** ezaugarriak, tiro bakoitzaren ondoren, sistemak guztira bota diren tiroen laburpen estatistiko bat erakustea ahalbidetzen du. Horrela zehaztuko da unera arte jokalariak zenbat tiro bota dituen, zenbat itsasontzi ukitu diren (baina oraindik erabat urperatu gabe – *hit*), kopuru hori itsasontzi kopuru osoarekin alderatuz zein portzentaje den adieraziz, eta informazio bera urperatutako itsasontziekin (*sunk*) eta aurkitu ez diren itsasontziekin (*locate*). 

```
Until this moment you have made 5 shots.  
You have hit 0 aircraft carriers (0%), 0 destroyers (0%), 1 submarines (33%), and 0 patrols (0%).  
You have sunk 0 aircraft carriers (0%), 0 destroyers (0%), 0 submarines (0%), and 1 patrols (25%). 
You have to locate 1 aircraft carriers (100%), 2 destroyers (100%), 2 submarinos (66%), and 3 patrols (75%).
```

**Challenge** ezaugarriak jokalarien artean lehiaketa bat zehazten du, jokalari bakoitzak egin dezakeen tiro kopuru mugatuarekin (25 *beginner* direnentzat, 60 *intermediate* eta 250 *expert* delakoentzat). Egindako tiro guztien ondoren, zein den irabazi duen jokalaria adierazten da. Itsasontzian bete-betean jotzen duen lehen tiroarekin 2 puntu kontatzen dira, itsasontziak posizio bat baino gehiago okupatzen badu, berriz ere itsasontzian asmatzen duten hurrengo tiroekin puntu 1 kontatzen da. Itsasontziaren gainean botatako azken tiroarengatik (hau hondoratzen duena) itsasontziak duen posizio adina puntu emango dira. Adibidez, bi itsasontzi desberdin honako posiziotan badaude: *C5* (posizio bakarreko itsasontzia) eta *B1-B2-B3-B4* (lau posizioko itsasontzia), orduan honako tiro hauek eginda *C5, A1, B2, B3, A5, B4* eta *B1*, honako puntuak lortuko lirateke, hurrenez hurren: 3 puntu (lehen tiroarengatik 2 gehi 1, posizio bakarreko itsasontzia hondoratzeagatik), 2 puntu (bigarren itsasontziaren gaineko lehen tiroa izateagatik), puntu 1 (hurrengo posizioetakoa izateagatik), 0 puntu (kale egiteagatik, helburuan ez emateagatik), puntu 1 (asmatzen jarraitzeagatik, baina hondoratu gabe) eta 4 puntu (itsasontzia hondoratzen duen tiroa izateagatik). Horrela, baten batek 4 posizioko itsasontzian asmatzen badu, hondoratzen  badu,  8  puntu  lortzen  ditu  (2+1+1+4).  Puntu  gehien  egin  duena  irabazlea  da. Berdinketaren  kasuan,  punteria  hoberena  izan  duena  (bete-betean  asmatu  duten  tiro  gehien  egin duena) izango da irabazlea, eta bestela parra egin dutela idatziko da. Jokalarietako batek itsasontzi guztiak urperatzen baditu, beste jokalariari beste horrenbeste tiro botatzen utziko zaio, eta orduan puntuen arabera irabazlea zein den adierazten da. 

**PlayerName**  ezaugarriak  jokatuko  duten  jokalarien  izenak  erabiltzea  onartzen  du.  Ezaugarri  hau aukeratua badago, egikaritzapenarekin hasi baino lehen izenak eskatu egingo dira eta jokoan zehar mezuak pertsonalizatu egingo dira (esaterako, *Irabazi egin duzu, Ane,* edo *Zure txanda da, Ane*). 

**Computer** ezaugarriak bigarren jokalaria ordenagailua bera izatea ahalbidetzen du. Bere itsasontziak taulan kokatzeko posizioak ausaz aukeratzen dira, itsasontzia taularen barnean osorik kokatu dadin eta itsasontziak elkar ukitzen jarri ez daitezen (itsasontzi bakoitzaren inguruan eta norantza guztietan, diagonalekoetan  ere,  gelaxka  huts  bat  egon  behar  da  gutxienez).  Ezaugarri  honetan,  “jokalari bereziaren” helburu edo jomugak erabakitzeko aplikatuko den estrategia aukeratu behar da (hots, tiroak  egiteko  programak  jarraituko  duen  algoritmoa).  Lerroa  aukeratzeko,  aukera  hauen  artean hautatu  behar  da:  (1)  ausaz  (*RandomRow*);  (2)  goitik  behera  (*TopDown*);  edo  behetik  gora (*BottomUp*).  Zutabea  aukeratzeko,  antzera:  ausaz  (*RandomColumn*);  (2)  ezkerretik  eskuinera (*Left2Right*); edo eskuinetik ezkerrera (*Right2Left*). 

Azkenik,  eta  aukera  gehigarri  bezala  (ezaugarri  diagraman  agertzen  ez  dena,  eta  gainontzeko aldakortasuna inplementatuta dutenentzat), partida **jokalari anitz**ekin egin ahal izatea kontuan hartzen da.  SPL-a  oro  har  bi  jokalarirentzat  egongo  da  prestatuta,  eta  aukera  gehigarri  honekin  jokalari gehiago egon daitekeela hartzen da (konputagailua bera ere egon daiteke). Kontuan hartu *PlayerName* ezaugarria ere baldin badago, jokalari guztien izenak eskatu beharko direla. Aukera honekin jokatzeko bi modu desberdin daudela ulertzen da: *Banakako tiraketa* eta *Tiraketa partekatua*. Lehenengoan, jokalari batek (berak nahi duen) beste jokalari baten itsasontzien kontra tiro bat egiten du, eta jarraian honek  gertatutakoarekin  erantzungo  dio;  besteak  jokaldiaren  jakinaren  gainean  egongo  dira  eta egokitzen  zaienean  bere  tiroa  inguruko  posizioren  batera  bota  dezakete  itsasontzia  urperatzeko. Bigarren  aukeran,  tiro  bakarra  egiten  da,  baina  beste  jokalari  guztien  aurka  banan-banan  (denak posizio berarekin), eta denek beren egoeraren berri ematen dute.  
