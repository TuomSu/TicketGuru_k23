# Projekti: TicketGuru

##### Tiimi: Koodivelhot

##### Projektiryhmän jäsenet:
* Alex Kiippa
* Jaakko Huovelin
* Susanna Tuomi
* Vesa Liukkonen
* Jenny Berg

## Johdanto

Projektin tavoitteena on tuottaa lipputoimiston tilaama lipunmyyntijärjestelmä, jonka avulla lipputoimiston henkilökunta voi myydä lippuja erilaisiin tapahtumiin myyntipisteessä. Asiakas voi määritellä järjestelmään ne tapahtumat, joihin lippuja myydään.  

Järjestelmän avulla lipputoimiston lipunmyynti tehostuu ja heidän on helpompi hallita myytäviä tapahtumia. Lisäksi asiakas saa järjestelmästä liiketoiminnan kehittämisen kannalta hyödyllisiä myyntiraportteja. Järjestelmän alustava nimi on TicketGuru.

Palvelu toteutetaan Javalla Spring Boot -kehystä käyttäen. Käyttöliittymäratkaisut ja -teknologiat tarkentuvat myöhemmin.
___

## Järjestelmän määrittely

3 olennaista tehtävää, jonka järjestelmän pitäisi pystyä tekemään on:
1.	Lipunmyynti
- myynnistä muodostuu myyntitapahtuma, josta päästään tulostamaan asiakkaalle lippu
- lippuja myydään ennakkoon tietty määrä, ja loput, joista ei ole muodostunut myyntitapahtumaa, tulostetaan ja myydään ovella.
- lipputyyppejä on erihintaisia (tässä voitaisiin käyttää kerrointa, esim. lapsen lippu x0,5)
2.	Tapahtumien hallinta
- tapahtumia on pystyttävä luomaan järjestelmässä, mutta tämän lisäksi myös muokkaamaan ja poistamaan
3.	Myyntiraportti
- tapahtumakohtaisten myyntiraporttien näyttäminen, lipputyypeittäin myyntien näyttäminen sekä kronologisessa järjestyksessä tapahtuman myyntitapahtumat näyttämään


### TicketGurussa on kolme käyttäjäroolia: Admin, pääkäyttäjä ja käyttäjä:

**Admin**: pääsääntöisesti lipputoimiston käytössä ja palvelun kehittäjän käytössä, jolla mahdollistetaan kaikkien tietojen muokkaus tietokantaan ja järjestelmään (sis. CRUD toiminnallisuudet)

*Käyttäjätarinoita:*

As an admin user, I want to have all the rights to use the software and database so that I can read, add, edit and delete the events.

As an admin user, I want to be able to add/save, edit and delete different events.

As an admin user, I need to be able to set, start and end pre-selling of tickets.

As an admin user, I want to be able to add/save, edit and delete tickets.

**Pääkäyttäjä**: toimistotyöntekijällä olisi CRUD-oikeudet sekä oikeus ottaa raportteja, 

*Käyttäjätarinoita:*

As the operator at the office, I want to get ticket sales reports from the software so that I can improve my business model.

As the operator at the office, I want to be able to distinguish between used and not used tickets.


**Käyttäjä**: lipunmyyjälle taas riittää oikeudet nähdä tapahtumat ja luoda myyntitapahtuma.

*Käyttäjätarinoita:*

As the ticket salesperson, I want to be able to sell discounted tickets for kids for example.

As the ticket salesperson, I want to be able to see the events and sell tickets and print them to customers so that they can show the ticket before the event.

___


## Linkki projektin työjonoon ja Scrum-tauluun

[Työjono ja Scrum-taulu](./tyojono_Scrumtaulu.md)

[Projects-työkalu](https://github.com/users/VesaLiukkonen/projects/1)

## Käyttöliittymä

Käyttöliittymän tärkeimpiä näkymiä ovat lipunmyyntinäkymä, yksittäisen myyntitapahtuman näkymä, tapahtumien hallinnan näkymä sekä myyntiraporttinäkymä. 

Lipunmyyntinäkymässä on listaus myytävissä olevissa tapahtumista. Listauksessa näytetään tapahtumista perustiedot kuten aika ja nimi. Klikkaamalla tapahtumariviä päästään valitsemaan, kuinka monta lippua kyseiseen tapahtumaan halutaan myydä. Myynnin jälkeen avautuu yksittäisen myyntitapahtuman näkymä, jossa näkyy myyntitapahtuman maksutiedot sekä ostetut liput. Sivulta löytyy linkki, josta liput voidaan tulostaa.

Tapahtumien hallinnan näkymässä on listaus järjestelmään tallennetuista tapahtumista, joista näytetään listauksessa perustiedot kuten aika, paikka ja nimi. Näkymän kautta jo lisättyjä tapahtumia ja niiden lipputyyppejä on mahdollista päästä muokkaamaan. Lisäksi tapahtumista voi tulostaa myyntiraportin. Näkymästä löytyy myös linkki uuden tapahtuman lisäämiseen. Myyntiraporttinäkymässä näytetään, kuinka paljon kyseiseen tapahtumaan on myyty lippuja.

Alustavat käyttöliittymän näkymät ja niiden väliset suhteet on esitetty kuvassa 1.

![alt text](https://user-images.githubusercontent.com/83058532/216845243-17b119ea-4f5a-4708-978e-59869c8ee71d.png)
Kuva 1. Alustava käyttöliittymäkaavio.

___


## Tietokanta

![Tietokantakaavio](https://github.com/VesaLiukkonen/ElokuvalippusovellusKoodivelhot/blob/develop/tietokantakaavio_TicketGuru.png)

### Myyntitapahtumat
*Myyntitapahtumat-taulu sisältää ennakkolippujen myyntitapahtumat. Sama myyntitapahtuma voi kuulua usealle ennakkolipulle. Ennakkolipulla on aina vain yksi myyntitapahtuma*


| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| saleid      | int PK | Myyntitapahtuman id |
| sale_date    | Date     |   Myyntitapahtuman päivämäärä |
| sale_time | Time      |    Myyntitapahtuman kellonaika |
| user_id      | int FK      |   Viittaus myyntitapahtuman myyjään käyttäjä-taulussa |

### Ennakkoliput
*Ennakkoliput-taulu sisältää tapahtumaan ennakkomyyntiaikana myydyt liput. Ennakkolippu kuuluu aina vain yhteen tapahtumaan ja myyntitapahtumaan. Sama tapahtuma ja myyntitapahtuma voivat kuulua usealle eri ennakkolipulle. Ennakkolipulla on vain yksi lipputyyppi. Sama lipputyyppi voi kuulua useaan ennakkolippuun*


| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| preticketid      | int PK | Ennakkolipun id |
| tickettypeid    | int FK     |   Viittaus lipputyyppiin lipputyypit - taulussa |
| saleid | intFK      |    Viittaus lipun myyntitapahtumaan myyntitapahtumat - taulussa |
| eventid      | int FK      |   Viittaus tapahtumaan tapahtumat-taulussa |
| used      | BOOLEAN      |   Arvo, joka kertoo, onko lippu käytetty |

### Tulostettulippu
*Tulostettulippu-taulu sisältää tapahtumaan myydyt tulostetutliput. Tulostetut liput kuuluuvain tapahtumaan. Tulostetulla lipulla ei ole lipputyyppiä, vaan toimii itsenäisesti, ja se sisältää hinnan ja myynti ajankohdan.

| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| printedTicketid      | int PK | Tulostetunlipun id |
| price    | Double     |   Lipun hinta |
| ticketSold | Boolean      |    Lipun myynti status onko myyty tai eikö ole myyty |
| SoldDate      | LocalDate     |   Lipun myyti päivämäärä |
| eventid      | int FK      |   Viittaus tapahtumaan tapahtumat-taulussa |

### Lipputyypit
*Lipputyypit-taulu sisältää lipputyypit(lapsi, eläkeläinen jne.) ja niitä vastaavat hintakertoimet.*


| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| tickettypeid      | int PK | Lipputyypin id |
| multiplier    | Double     |  Lipputyypin hintakerroin |
| tickettype    | varchar    | Lipputyyppi |

### Postinumero
*Postinumerot-taulu sisältää postinumerot, sekä niiden kaupungit*


| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| areaCode      | varchar PK | Postinumero (ilmoitettu varchar, koska int ei salli 0 alkua) |
| city    | varchar     |  Kaupunki johon postinumero kuuluu |

### Tapahtumapaikat
*Tapahtumapaikat-taulu sisältää tapahtumien tapahtumapaikat*


| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| venue_id     | int PK | Tapahtumapaikka ID |
| venueName    | varchar     |   Tapahtumapaikan nimi |
| areaCode | varchar FK     |    Tapahtumapaikan postinumero |

### Tapahtumat
*Tapahtumat-taulu sisältää tapahtumat*


| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| event_id     | int PK | Tapahtuma ID |
| eventName    | varchar     |   Tapahtuman nimi |
| eventStartDate | Date    |    Tapahtuman aloitus päivämärää ja aika |
| eventEndDate | Date    |    Tapahtuman lopetus päivämärää ja aika |
| ticketAmount | int    |    Kuinka monta lippua tapahtumaan on myynnissä |
| ticketPrice | Double    |    Kuinka paljon tapahtuman lippu maksaa |
| description | varchar    |    Tapahtuman kuvaus |
| presaleStarts | Date    |    Lippujen ennakkomyynti alkaa |
| presaleEnds | Date    |    Lippujen ennakkomyynti päättyy |
| venue | int FK    |    Tapahtumapaikka |

### Käyttäjät ja Käyttäjäroolit

*Käyttäjät ovat yksittäiset henkilöt ja käyttäjäroolit määrittelevät mitkä käyttöoikeudet henkilölle annetaan.*

| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| user_id      | int PK | käyttäjän id |
| role_id      | int FK      |   käyttäjärooli id, viittaus käyttäjäroolitauluun |
| first name | varchar      |    etunimi |
| last name      | varchar      |   sukunimi |
| username      |    varchar |käyttäjätunnus|
| password      | varchar      |   salasana|

| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| role_id      | int PK | käyttäjärooli id |
| role      | varchar      |   roolin kuvaus |
| rights | varchar      |    kuvaus oikeuksista |

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