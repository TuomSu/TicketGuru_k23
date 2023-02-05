# Projekti: TicketGuru

##### Tiimi: Koodivelhot

##### Projektiryhmän jäsenet:
* Elias Hörkkö
* Alex Kiippa
* Jaakko Huovelin
* Susanna Lehto
* Vesa Liukkonen
* Jenny Berg

## Johdanto

Projektin tavoitteena on tuottaa lipputoimiston tilaama lipunmyyntijärjestelmä, jonka avulla lipputoimiston henkilökunta voi myydä lippuja erilaisiin tapahtumiin myyntipisteessä. Asiakas voi määritellä järjestelmään ne tapahtumat, joihin lippuja myydään.  

Järjestelmän avulla lipputoimiston lipunmyynti tehostuu ja heidän on helpompi hallita myytäviä tapahtumia. Lisäksi asiakas saa järjestelmästä liiketoiminnan kehittämisen kannalta hyödyllisiä myyntiraportteja. Järjestelmän alustava nimi on TicketGuru.

Palvelu toteutetaan Javalla Spring Boot -kehystä käyttäen. Käyttöliittymäratkaisut ja teknologiat tarkentuvat myöhemmin.

___

*Johdantoon kirjoitetaan lyhyt, ytimekäs kuvaus siitä, mikä on projektin aihe, kuka on asiakas (käyttäjä), mitä hän haluaa ja saa järjestelmältä, mitä tekniikoita käytetään ja mitä konkreettisesti on valmiina, kun projekti päättyy.*

* Järjestelmän tarkoitus ja tiivis kuvaus siitä, mistä on kyse ja kenelle järjestelmä on tarkoitettu.
* Toteutus- ja toimintaympäristö lyhyesti:
    * Palvelinpuolen ratkaisut ja teknologiat (esim. palvelinteknologia, mikä tietokantajärjestelmä on käytössä)
    * Käyttöliittymäratkaisut ja teknologiat (esim. päätelaitteet: puhelin, täppäri, desktop)

## Järjestelmän määrittely



TicketGurussa on kolme käyttäjäroolia: Admin, Pääkäyttäjä ja käyttäjä. 

* Admin käyttäjäryhmä on pääsääntöisesti lipputoimiston käytössä ja palvelun kehittäjän käytössä, jolla mahdollistetaan kaikkien tietojen muokkaus.  
* Pääkäyttäjä on lipputoimiston henkilökunnalla. Pääkäyttäjät voivat lisätä ja poistaa tapahtumia palvelusta. Tälle ryhmälle on myös oma sivu johon kerääntyy dataa lippujne myynnistä.
* Käyttäjä on asiakkaiden käyttäjäryhmä, jotka ostavat lippuja palvelusta. Tämä Käyttäjä ryhmä pystyy siis ainoastaan ostamaan lippuja.



___

*Määrittelyssä järjestelmää tarkastellaan käyttäjän näkökulmasta. Järjestelmän toiminnot hahmotellaan käyttötapausten tai käyttäjätarinoiden kautta, ja kuvataan järjestelmän käyttäjäryhmät.*

* Lyhyt kuvaus käyttäjäryhmistä (rooleista)
* Käyttäjäroolit ja roolien tarvitsemat toiminnot, esim. käyttötapauskaaviona (use case diagram) tai käyttäjätarinoina.
* Lyhyt kuvaus käyttötapauksista tai käyttäjätarinat

*Kuvauksissa kannattaa harkita, mikä on toteuttajalle ja asiakkaalle oleellista tietoa ja keskittyä siihen.*

## Linkki projektin työjonoon ja Scrum-tauluun

[Työjono ja Scrum-taulu](./tyojono_Scrumtaulu.md)

## Käyttöliittymä

Tärkeimmät käyttöliittymät ovat: etusivu, hakusivuja,  oma sivu ja myyntisivu.

* Etusivulla näkyy suositeltuja tapahtumia lähellä käyttäjää ja sivun ylälaidassa sijaitsee hakupalkki mistä käyttäjän on mahdollista etsiä mieluisa tapahtuma.
* Hakusivulla on näkymä sitten hakusanalla etsityistä tapahtumista jonne on lippuja. Tällä sivulla on myös mahdollista ostaa tiettyyn tapahtumaan lippu
* Oma sivu. Omallasivulla näkyy sitten käyttäjän ostetut liput tuleviin ja menneisiin tapahtumiin.
* Myyntisivu on pääkäyttäjälle eli tapahtumien listaajalle. Myyntisivulle kerääntyy dataa lippujen myynneistä.

___

*Esitetään käyttöliittymän tärkeimmät (vain ne!) näkymät sekä niiden väliset siirtymät käyttöliittymäkaaviona.*

*Jos näkymän tarkoitus ei ole itsestään selvä, se pitää kuvata lyhyesti.*

## Tietokanta
*Järjestelmään säilöttävä ja siinä käsiteltävät tiedot ja niiden väliset suhteet kuvataan käsitekaaviolla. Käsitemalliin sisältyy myös taulujen välisten viiteyhteyksien ja avainten määritykset. Tietokanta kuvataan käyttäen jotain kuvausmenetelmää, joko ER-kaaviota ja UML-luokkakaaviota.*

*Lisäksi kukin järjestelmän tietoelementti ja sen attribuutit kuvataan tietohakemistossa. Tietohakemisto tarkoittaa yksinkertaisesti vain jokaisen elementin (taulun) ja niiden attribuuttien (kentät/sarakkeet) listausta ja lyhyttä kuvausta esim. tähän tyyliin:*

### Tilit
*Tilit-taulu sisältää käyttäjätilit. Käyttäjällä voi olla monta tiliä. Tili kuuluu aina vain yhdelle käyttäjälle.*


| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| id      | int PK | Tilin id |
| nimimerkki      | varchar(30)      |   Tilin nimimerkki |
| avatar | int FK      |    Tilin avatar, viittaus avatar-tauluun |
| kayttaja      | int FK      |   Viittaus käyttäjän käyttäjä-taulussa |

## Tekninen kuvaus
*Teknisessä kuvauksessa esitetään järjestelmän toteutuksen suunnittelussa tehdyt tekniset ratkaisut, esim.*

* Missä mikäkin järjestelmän komponentti ajetaan (tietokone, palvelinohjelma) ja komponenttien väliset yhteydet (vaikkapa tähän tyyliin: https://security.ufl.edu/it-workers/risk-assessment/creating-an-information-systemdata-flow-diagram/)
* Palvelintoteutuksen yleiskuvaus: teknologiat, deployment-ratkaisut yms.
* Keskeisten rajapintojen kuvaukset, esimerkit REST-rajapinta. Tarvittaessa voidaan rajapinnan käyttöä täsmentää UML-sekvenssikaavioilla.
* Toteutuksen yleisiä ratkaisuja, esim. turvallisuus.
*Tämän lisäksi*

* ohjelmakoodin tulee olla kommentoitua
* luokkien, metodien ja muuttujien tulee olla kuvaavasti nimettyjä ja noudattaa johdonmukaisia nimeämiskäytäntöjä
* ohjelmiston pitää olla organisoitu komponentteihin niin, että turhalta toistolta vältytään


## Testaus
*Tässä kohdin selvitetään, miten ohjelmiston oikea toiminta varmistetaan testaamalla projektin aikana: millaisia testauksia tehdään ja missä vaiheessa. Testauksen tarkemmat sisällöt ja testisuoritusten tulosten raportit kirjataan erillisiin dokumentteihin.*

*Tänne kirjataan myös lopuksi järjestelmän tunnetut ongelmat, joita ei ole korjattu.*

## Asennustiedot
*Järjestelmän asennus on syytä dokumentoida kahdesta näkökulmasta:*

* järjestelmän kehitysympäristö: miten järjestelmän kehitysympäristön saisi rakennettua johonkin toiseen koneeseen

* järjestelmän asentaminen tuotantoympäristöön: miten järjestelmän saisi asennettua johonkin uuteen ympäristöön.

*Asennusohjeesta tulisi ainakin käydä ilmi, miten käytettävä tietokanta ja käyttäjät tulee ohjelmistoa asentaessa määritellä (käytettävä tietokanta, käyttäjätunnus, salasana, tietokannan luonti yms.).*

## Käynnistys- ja käyttöohje
*Tyypillisesti tässä riittää kertoa ohjelman käynnistykseen tarvittava URL sekä mahdolliset kirjautumiseen tarvittavat tunnukset. Jos järjestelmän käynnistämiseen tai käyttöön liittyy joitain muita toimenpiteitä tai toimintajärjestykseen liittyviä asioita, nekin kerrotaan tässä yhteydessä.*

*Usko tai älä, tulet tarvitsemaan tätä itsekin, kun tauon jälkeen palaat järjestelmän pariin !*