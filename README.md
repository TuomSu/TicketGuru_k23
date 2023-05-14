# Projekti: TicketGuru

##### Tiimi: Koodivelhot

##### Projektiryhmän jäsenet:
* Alex Kiippa
* Jaakko Huovelin
* Susanna Tuomi
* Vesa Liukkonen
* Jenny Berg

## Johdanto

Projektin tavoitteena on tuottaa lipputoimiston tilaama lipunmyyntijärjestelmä, jonka avulla lipputoimiston henkilökunta voi myydä lippuja erilaisiin tapahtumiin myyntipisteessä. Lipputoimiston henkilökunta voi määritellä järjestelmään ne tapahtumat, joihin lippuja myydään.  

Järjestelmän avulla lipputoimiston lipunmyynti tehostuu ja heidän on helpompi hallita myytäviä tapahtumia. Lisäksi asiakas saa järjestelmästä liiketoiminnan kehittämisen kannalta hyödyllisiä myyntiraportteja. Järjestelmän alustava nimi on TicketGuru.

Palvelu toteutetaan Javalla Spring Boot -kehystä käyttäen. Yksinkertainen käyttöliittymäratkaisu on toteutettu Thymeleaf template enginen avulla. 
___

## Järjestelmän määrittely

3 olennaista tehtävää, jonka järjestelmän pitäisi pystyä tekemään on:
1.	Lipunmyynti
- myynnistä muodostuu myyntitapahtuma, josta päästään tulostamaan asiakkaalle lippu
- lippuja myydään ennakkoon tietty määrä, ja loput, joista ei ole muodostunut myyntitapahtumaa, tulostetaan ja myydään ovella.
- lipputyyppejä on erihintaisia
2.	Tapahtumien hallinta
- tapahtumia on pystyttävä luomaan järjestelmässä, mutta tämän lisäksi myös muokkaamaan ja poistamaan
3.	Myyntiraportti
- tapahtumakohtaisten myyntiraporttien näyttäminen, lipputyypeittäin myyntien näyttäminen sekä kronologisessa järjestyksessä tapahtuman myyntitapahtumat näyttämään


### TicketGurussa on kolme käyttäjäroolia: Admin, pääkäyttäjä, käyttäjä + lipuntarkastaja:

**Admin**: pääsääntöisesti lipputoimiston käytössä ja palvelun kehittäjän käytössä, jolla mahdollistetaan kaikkien tietojen muokkaus tietokantaan ja järjestelmään (sis. CRUD toiminnallisuudet)

*Käyttäjätarinoita:*

As an admin user, I want to have all the rights to use the software and database so that I can read, add, edit and delete the events.

As an admin user, I want to be able to add/save, edit and delete different events.

As an admin user, I need to be able to set, start and end pre-selling of tickets.

As an admin user, I want to be able to add/save, edit and delete tickets.

**Lisätty 3.4.23**
- As an admin user I want to be able to add/save, edit and delete different ticket types.

- As ad admin user I want to be able to add acceptable ticket types to each event.

**Pääkäyttäjä**: toimistotyöntekijällä olisi CRUD-oikeudet sekä oikeus ottaa raportteja, 

*Käyttäjätarinoita:*

As the operator at the office, I want to get ticket sales reports from the software so that I can improve my business model.

As the operator at the office, I want to be able to distinguish between used and not used tickets.


**Käyttäjä**: lipunmyyjälle taas riittää oikeudet nähdä tapahtumat ja luoda myyntitapahtuma.

*Käyttäjätarinoita:*

~~Poistetaan: As the ticket salesperson, I want to be able to sell discounted tickets for kids for example.~~

As the ticket salesperson, I want to be able to see the events and sell tickets and print them to customers so that they can show the ticket before the event.

**Lipuntarkastaja: (lisätty 3.4.23)**

Lipuntarkastajana haluan tarkistaa lipun kelvollisuuden, sekä merkitä lipun käytetyksi, jottei samaa lippua voi käyttää uudelleen.

___


## Linkki projektin työjonoon ja Scrum-tauluun

[Työjono ja Scrum-taulu](./tyojono_Scrumtaulu.md)

[Projects-työkalu](https://github.com/users/VesaLiukkonen/projects/1)

## Käyttöliittymä

Käyttöliittymän tärkeimpiä näkymiä ovat lipunmyyntinäkymä, yksittäisen myyntitapahtuman näkymä, tapahtumien hallinnan näkymä sekä myyntiraporttinäkymä. Lisäksi käyttöliittymästä löytyy näkymä, jossa voidaan tarkastaa lippuja.

Lipunmyyntinäkymässä on listaus myytävissä olevissa tapahtumista. Listauksessa näytetään tapahtumista perustiedot kuten aika ja nimi. Klikkaamalla tapahtumariviä päästään valitsemaan, kuinka monta lippua kyseiseen tapahtumaan halutaan myydä. Myynnin jälkeen avautuu yksittäisen myyntitapahtuman näkymä, jossa näkyy myyntitapahtuman maksutiedot sekä ostetut liput. Sivulta löytyy linkki, josta liput voidaan tulostaa.

Tapahtumien hallinnan näkymässä on listaus järjestelmään tallennetuista tapahtumista, joista näytetään listauksessa perustiedot kuten aika, paikka ja nimi. Näkymän kautta jo lisättyjä tapahtumia ja niiden lipputyyppejä on mahdollista päästä muokkaamaan. Lisäksi tapahtumista voi tulostaa myyntiraportin. Näkymästä löytyy myös linkki uuden tapahtuman lisäämiseen. Myyntiraporttinäkymässä näytetään, kuinka paljon kyseiseen tapahtumaan on myyty lippuja.

Alustavat käyttöliittymän näkymät ja niiden väliset suhteet on esitetty kuvassa 1.

![alt text](https://user-images.githubusercontent.com/83058532/216845243-17b119ea-4f5a-4708-978e-59869c8ee71d.png)
Kuva 1. Alustava käyttöliittymäkaavio.

___


## Tietokanta

Kuvassa 2 on esitetty sovelluksen tietokantakaavio, josta eri taulujen väliset suhteet käyvät ilmi. Sen jälkeen käydään läpi kunkin taulun sisältö.

![Tietokantakaavio](https://github.com/VesaLiukkonen/ElokuvalippusovellusKoodivelhot/blob/develop/tietokantakaavio_TicketGuru.png)
Kuva 2. Tietokantakaavio

### Myyntitapahtumat
*Myyntitapahtumat-taulu sisältää ennakkolippujen myyntitapahtumat. Sama myyntitapahtuma voi kuulua usealle ennakkolipulle. Ennakkolipulla on aina vain yksi myyntitapahtuma*


| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| saleid      | int PK | Myyntitapahtuman id |
| sale_date    | LocalDateTime     |   Myyntitapahtuman päivämäärä & kellonaika |
| totelprice      | double      |   myyntitapahtuman kokonaishinta |
| user_id      | int FK      |   Viittaus myyntitapahtuman myyjään käyttäjä-taulussa |

### Ennakkoliput
*Ennakkoliput-taulu sisältää tapahtumaan ennakkomyyntiaikana myydyt liput. Ennakkolippu kuuluu aina vain yhteen tapahtumaan ja myyntitapahtumaan. Sama tapahtuma ja myyntitapahtuma voivat kuulua usealle eri ennakkolipulle. Ennakkolipulla on vain yksi lipputyyppi. Sama lipputyyppi voi kuulua useaan ennakkolippuun*


| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| presaleticketid      | int PK | Ennakkolipun id |
| tickettypeid    | int FK     |   Viittaus lipputyyppiin lipputyypit - taulussa |
| saleid | intFK      |    Viittaus lipun myyntitapahtumaan myyntitapahtumat - taulussa |
| eventid      | int FK      |   Viittaus tapahtumaan tapahtumat-taulussa |
| used      | BOOLEAN      |   Arvo, joka kertoo, onko lippu käytetty |
| price      | double      |   lipun hinta |
| code      | varchar      |   Lipun yksilöivä koodi, jolla voidaan merkitä lippu käytetyksi. |
| qrcodeImage      | byte[]      |   Lipulle luotava qr-koodi |

### Tulostettulippu
Tulostettulippu-taulu sisältää tapahtumaan myydyt tulostetutliput. Tulostetut liput kuuluuvat tapahtumaan. Tulostetulla lipulla ei ole lipputyyppiä, vaan toimii itsenäisesti, ja se sisältää hinnan ja myyntiajankohdan. 

*Huom.16.5.2023 demottavassa versiossa emme esittele toimintaa ennakkomyynnin jälkeisten lippujen tulostukseen liittyen. Tämä toiminto huomioidaan sovelluksen jatkokehittelyssä.*

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
| type_id      | int PK | Lipputyypin id |
| price    | Double     |  Lipputyypin hinta |
| type    | varchar    | Lipputyyppi |

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
| description | varchar FK     |    Tapahtumapaikan kuvaus |
| address | varchar     |    Tapahtumapaikan osoite |

### Tapahtumat
*Tapahtumat-taulu sisältää tapahtumat*


| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| event_id     | int PK | Tapahtuma ID |
| eventName    | varchar     |   Tapahtuman nimi |
| eventStartDate | Date    |    Tapahtuman aloitus päivämärää ja aika |
| eventEndDate | Date    |    Tapahtuman lopetus päivämärää ja aika |
| ticketAmount | int    |    Kuinka monta lippua tapahtumaan on myynnissä |
| soldTickets | int    |    Kuinka monta lippua tapahtumaan on myyty |
| ticketPrice | Double    |    Kuinka paljon tapahtuman lippu maksaa, tosin hinta muodostuu myyntitapahtumaan lipputyypin mukaan |
| description | varchar    |    Tapahtuman kuvaus |
| presaleStarts | Date    |    Lippujen ennakkomyynti alkaa |
| presaleEnds | Date    |    Lippujen ennakkomyynti päättyy |
| venue | int FK    |    Tapahtumapaikka |

### Käyttäjät ja Käyttäjäroolit

*Käyttäjät ovat yksittäiset henkilöt ja käyttäjäroolit määrittelevät mitkä käyttöoikeudet henkilölle annetaan.*

| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| userid      | int PK | käyttäjän id |
| role      | int FK      |   käyttäjärooli id, viittaus käyttäjäroolitauluun |
| first name | varchar      |    etunimi |
| last name      | varchar      |   sukunimi |
| username      |    varchar |käyttäjätunnus|
| passwordHash      | varchar      |   salasana|

| Kenttä        | Tyyppi           | Kuvaus  |
| ------------- |:-------------:| -----:|
| roleid      | int PK | käyttäjärooli id |
| role      | varchar      |   roolin kuvaus |
| rights | varchar      |    kuvaus oikeuksista |

## Tekninen kuvaus

### Toteutuksen yleiskuvaus

Järjestelmän back end eli palveinpuoli on toteutettu Java Spring Boot sovelluskehystä käyttäen Maven-projektina. Ohjelmointiympäristönä on toiminut Eclipse IDE for Java EE, joka soveltuu hyvin Javan kehitysympäristöksi. Järjestelmän tietokanta on toteutettu MariaDB:n avulla, mutta järjestelmää voi käyttää myös H2-tietokannan avulla. Sovellus on julkaista Azuren pilvipalvelussa. Käyttäliittymä on tehty Thymeleafilla.

### REST API -rajapinta

Alla on esitetty sovelluksen REST API -rajapinnan endpointtien toiminta.

**Tapahtumat** 

Tapahtumien käsittelyyn liittyvät endpointit

* [**Näytä kaikki tapahtumat**](API-dokumentaatio/events/get.md) : `GET /events`
* [**Näytä tapahtuma ID:n perusteella**](API-dokumentaatio/events/pk/get.md) : `GET /event/{id}`
* [**Lisää uusi tapahtuma**](API-dokumentaatio/events/post.md) : `POST /events`
* [**Muokkaa tapahtumaa ID:n perusteella**](API-dokumentaatio/events/pk/put.md) : `PUT /event/{id}`
* [**Poista tapahtuma ID:n perusteella**](API-dokumentaatio/events/pk/delete.md) : `DELETE /event/{id}`

**Lipputyypit**

* [**Näytä kaikki lipputyypit**](API-dokumentaatio/tickettypes/get.md) : `GET /tickettypes`
* [**Näytä lipputyyppi ID:n perusteella**](API-dokumentaatio/tickettypes/pk/get.md) : `GET /tickettype/{id}`
* [**Lisää uusi lipputyyppi**](API-dokumentaatio/tickettypes/post.md) : `POST /tickettypes`
* [**Muokkaa lipputyyppiä ID:n perusteella**](API-dokumentaatio/tickettypes/pk/put.md) : `PUT /tickettype/{id}`
* [**Poista lipputyyppi ID:n perusteella**](API-dokumentaatio/tickettypes/pk/delete.md) : `DELETE /tickettype/{id}`

**Tapahtumapaikat**

* [**Näytä kaikki tapahtumapaikat**](API-dokumentaatio/venues/get.md) : `GET /venues`
* [**Näytä tapahtumapaikka ID:n perusteella**](API-dokumentaatio/venues/pk/get.md) : `GET /venue/{id}`
* [**Lisää uusi tapahtumapaikka**](API-dokumentaatio/venues/post.md) : `POST /venues`
* [**Muokkaa tapahtumapaikkaa ID:n perusteella**](API-dokumentaatio/venues/pk/put.md) : `PUT /venues/{id}`
* [**Poista tapahtumapaikka ID:n perusteella**](API-dokumentaatio/venues/pk/delete.md) : `DELETE /venue/{id}`

**Postinumerot**

* [**Näytä kaikki postinumerot**](API-dokumentaatio/areacodes/get.md) : `GET /areacodes`
* [**Näytä postinumero ID:n perusteella**](API-dokumentaatio/areacodes/pk/get.md) : `GET /areacode/{id}`
* [**Lisää uusi postinumero**](API-dokumentaatio/areacodes/post.md) : `POST /areacodes`
* [**Muokkaa postinumeroa ID:n perusteella**](API-dokumentaatio/areacodes/pk/put.md) : `PUT /areacode/{id}`
* [**Poista postinumero ID:n perusteella**](API-dokumentaatio/areacodes/pk/delete.md) : `DELETE /areacode/{id}`

**Ennakkoliput**

* [**Näytä kaikki ennakkoliput**](API-dokumentaatio/presaletickets/get.md) : `GET /presaletickets`
* [**Näytä ennakkolippu id:n perusteella**](API-dokumentaatio/presaletickets/get.md) : `GET /presaletickets/{id}`
* [**Lisää uusi ennakkolippu**](API-dokumentaatio/presaletickets/get.md) : `POST /presaletickets`
* [**Merkitse ennakkolippu käytetyksi koodin perusteella**](API-dokumentaatio/presaletickets/get.md) : `PATCH /presaletickets?code={code}`

**Myyntitapahtumat**

* [**Näytä kaikki myyntitapahtumat**](API-dokumentaatio/saleevents/get.md) : `GET /saleEvents`
* [**Näytä myyntitapahtuma ID:n perusteella**](API-dokumentaatio/saleevents/pk/get.md) : `GET /saleEvent/{id}`
* [**Lisää uusi myyntitapahtuma**](API-dokumentaatio/saleevents/post.md) : `POST /saleEvents`
* [**Muokkaa myyntitapahtumaa ID:n perusteella**](API-dokumentaatio/saleevents/pk/put.md) : `PUT /saleEvent/{id}`
* [**Poista myyntitapahtuma ID:n perusteella**](API-dokumentaatio/saleevents/pk/delete.md) : `DELETE /saleEvent/{id}`

**Käyttäjät**

Käyttäjien käsittelyyn tarvittavien endpointtien kuvaus löytyy [**täältä**](API-dokumentaatio/users/CRUD.md).

## Testaus
*Ohjelmiston oikea toiminta on varmistettu testaamalla projektin aikana eri tasoisilla testeillä: JUnit-yksikkötestejä käytetty luokkien testaukseen, palvelun ohjelmointirajapintojen kautta on testattu palvelun osien yhteistoimintaa (API-testaus) sekä käyttöliittymän testausta (UI-testaus). Testauksen tarkempia sisältöjä ja testisuoritusten tuloksia:*
- repository testauksissa varmistuttiin siitä, että tieto kulkeutuu halutulla tavalla luokkien ja repositorien välillä ja että tieto on repositoreista saatavilla toivotuilla hakukriteereillä. 
- application testeillä myös tarkistettiin, että tieto luokista tallentuu repositoreihin
- weblayer testeillä varmistetiin sisäänkirjautumisen toiminto clientin puolella. 

*Järjestelmän tunnetut ongelmat, joita ei ole korjattu:*
- Ennakkomyynnin jälkeen tulostettavien lippujen tulostustoimintoa ei ole testattu vielä tässä versiossa. 

## Asennustiedot

### Järjestelmän kehitysympäristön asentaminen

1. Tietokoneelle tulee asentaa Eclipse tai muu ohjelmistokehitykseen soveltuva ohjelma (IDE)
2. Projektin repositorio kloonataan tietokoneelle osoitteesta https://github.com/VesaLiukkonen/ElokuvalippusovellusKoodivelhot.git
3. Asennetaan tietokoneelle MariaDB ja HeidiSQL
4. HeidiSQL:stä luodaan yhteys MariaDB-palvelimeen
5. Yhteyden muodostamisen jälkeen luodaan HeidiSQL:ssä uusi tietokanta
6. Application.properties tiedostoon lisätään tietokantaa koskevat tiedot: sijainti ja nimi sekä tunnus ja salasana
7. Kun ongelma on käynnistetty, HeidiSQL:n puolella päivitetään kohdassa 5 luotu tietokanta, jolloin saadaan tietokantaan tarvittavat taulut näkyviin

Kehitysympäristön käyttäminen H2-tietokannalla:

* Application.properties tiedostosta kommentoidaan pois MariaDB:tä koskevat tiedot ja kommentoidaan H2:sta koskevat rivit aktiivisiksi
* Pom.xml -tiedostosta palautetaan H2:sen dependency aktiiviseksi

### Järjestelmän tuotantoympäristön asentaminen

* järjestelmän asentaminen tuotantoympäristöön: miten järjestelmän saisi asennettua johonkin uuteen ympäristöön.

*Asennusohjeesta tulisi ainakin käydä ilmi, miten käytettävä tietokanta ja käyttäjät tulee ohjelmistoa asentaessa määritellä (käytettävä tietokanta, käyttäjätunnus, salasana, tietokannan luonti yms.).*

## Käynnistys- ja käyttöohje
Ohjelman käynnistykseen tarvittava URL sekä kirjautumiseen tarvittava tunnus ja salasana:

**vra-vraro2.azurewebsites.net**

ADMIN
- Username: usernameAnna
- Password: password
