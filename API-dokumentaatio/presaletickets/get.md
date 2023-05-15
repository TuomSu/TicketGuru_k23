# Näytä kaikki ennakkoliput

Näyttää kaikki sovellukseen lisätyt tapahtumat

**URL** : `/presaletickets/`

**Metodi** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Permissions required** : Admin tai peruskäyttäjän oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Sovellukseen ei ole lisätty ennakkolippuja

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### Tai

**Ehdot** : Sovellukseen on lisätty yksi tai useampi ennakkolippu

**Code** : `200 OK`

**Vastauksen sisältö** : Tässä esimerkissä sovellukseen on lisätty kaksi ennakkolippua, jotka listataan käyttäjälle

```json
[
    {
        "presaleticketid": 1,
        "used": false,
        "price": 10,
        "code": "c3c125dd-c862-4c43-94b7-eb97cce56c84",
        "event": {
            "event_id": 1,
            "eventName": "Testitapahtuma",
            "eventStartDate": "11.12.2023 12:00",
            "eventEndDate": "11.12.2023 23:00",
            "ticketAmount": 10,
            "soldTickets": 0,
            "ticketPrice": 15.5,
            "description": "Tapahtuma testaa tapahtuman toimintaa",
            "presaleStarts": "01.10.2023 01:00",
            "presaleEnds": "10.12.2023 23:00",
            "venue": {
                "venue_id": 1,
                "venueName": "Testipaikka",
                "description": "Testi",
                "address": "Testikuja 2",
                "areaCode": {
                    "areaCode": "00000",
                    "city": "Testikaupunki"
                }
            }
        },
        "tickettype": {
            "type_id": 1,
            "price": 120,
            "type": "Student",
            "event": {
                "event_id": 1,
                "eventName": "Testitapahtuma",
                "eventStartDate": "11.12.2023 12:00",
                "eventEndDate": "11.12.2023 23:00",
                "ticketAmount": 10,
                "soldTickets": 0,
                "ticketPrice": 15.5,
                "description": "Tapahtuma testaa tapahtuman toimintaa",
                "presaleStarts": "01.10.2023 01:00",
                "presaleEnds": "10.12.2023 23:00",
                "venue": {
                    "venue_id": 1,
                    "venueName": "Testipaikka",
                    "description": "Testi",
                    "address": "Testikuja 2",
                    "areaCode": {
                        "areaCode": "00000",
                        "city": "Testikaupunki"
                    }
                }
            }
        }
    }
]
```

# Näytä ennakkolippu koodin perusteella

**URL** : `/presaletickets?code={code}`

**Metodi** : `GET`

**URL Parametrit** : `{code}` ennakkolipun koodi

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä täytyy olla adminin, peruskäyttäjän tai lipuntarkastajan oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Parametrinä annetun koodin sisältävä ennakkolippu löytyy tietokannasta.

**Koodi** : `200 OK`

**Vastauksen sisältö**

```json
{
    "presaleticketid": 1,
    "used": false,
    "price": 10,
    "code": "c3c125dd-c862-4c43-94b7-eb97cce56c84",
    "event": {
        "event_id": 1,
        "eventName": "Testitapahtuma",
        "eventStartDate": "11.12.2023 12:00",
        "eventEndDate": "11.12.2023 23:00",
        "ticketAmount": 10,
        "soldTickets": 0,
        "ticketPrice": 15.5,
        "description": "Tapahtuma testaa tapahtuman toimintaa",
        "presaleStarts": "01.10.2023 01:00",
        "presaleEnds": "10.12.2023 23:00",
        "venue": {
            "venue_id": 1,
            "venueName": "Testipaikka",
            "description": "Testi",
            "address": "Testikuja 2",
            "areaCode": {
                "areaCode": "00000",
                "city": "Testikaupunki"
            }
        }
    },
    "tickettype": {
        "type_id": 1,
        "price": 120,
        "type": "Student",
        "event": {
            "event_id": 1,
            "eventName": "Testitapahtuma",
            "eventStartDate": "11.12.2023 12:00",
            "eventEndDate": "11.12.2023 23:00",
            "ticketAmount": 10,
            "soldTickets": 0,
            "ticketPrice": 15.5,
            "description": "Tapahtuma testaa tapahtuman toimintaa",
            "presaleStarts": "01.10.2023 01:00",
            "presaleEnds": "10.12.2023 23:00",
            "venue": {
                "venue_id": 1,
                "venueName": "Testipaikka",
                "description": "Testi",
                "address": "Testikuja 2",
                "areaCode": {
                    "areaCode": "00000",
                    "city": "Testikaupunki"
                }
            }
        }
    }
}

```

## Virhekoodit

**Ehdot** : Jos annetulla koodilla ei löydy tietokannasta lippua

**Koodi** : `404 NOT FOUND`

**Esimerkki sisällöstä**

```json
{
    "message": "Ennakkolippua ei löytynyt annetulla koodilla"
}
```
# Ennakkolipun hakeminen id:n perusteella

**URL** : `/presaleticket/{id}`

**URL Parametrit** : `{id}` jossa id on tapahtuman yksilöivä tunnus

**Method** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on admin tai peruskäyttäjän oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Ennakkolippu on olemassa ja käyttäjällä on oikeudet tarkastella ennakkolippuja

**Koodi** : `200 OK`

**Vastauksen esimerkkisisältö**

```json
{
    "presaleticketid": 1,
    "used": false,
    "price": 10,
    "code": "c3c125dd-c862-4c43-94b7-eb97cce56c84",
    "event": {
        "event_id": 1,
        "eventName": "Testitapahtuma",
        "eventStartDate": "11.12.2023 12:00",
        "eventEndDate": "11.12.2023 23:00",
        "ticketAmount": 10,
        "soldTickets": 0,
        "ticketPrice": 15.5,
        "description": "Tapahtuma testaa tapahtuman toimintaa",
        "presaleStarts": "01.10.2023 01:00",
        "presaleEnds": "10.12.2023 23:00",
        "venue": {
            "venue_id": 1,
            "venueName": "Testipaikka",
            "description": "Testi",
            "address": "Testikuja 2",
            "areaCode": {
                "areaCode": "00000",
                "city": "Testikaupunki"
            }
        }
    },
    "tickettype": {
        "type_id": 1,
        "price": 120,
        "type": "Student",
        "event": {
            "event_id": 1,
            "eventName": "Testitapahtuma",
            "eventStartDate": "11.12.2023 12:00",
            "eventEndDate": "11.12.2023 23:00",
            "ticketAmount": 10,
            "soldTickets": 0,
            "ticketPrice": 15.5,
            "description": "Tapahtuma testaa tapahtuman toimintaa",
            "presaleStarts": "01.10.2023 01:00",
            "presaleEnds": "10.12.2023 23:00",
            "venue": {
                "venue_id": 1,
                "venueName": "Testipaikka",
                "description": "Testi",
                "address": "Testikuja 2",
                "areaCode": {
                    "areaCode": "00000",
                    "city": "Testikaupunki"
                }
            }
        }
    }
}
```

## Virhekoodit

**Ehdot** : Jos ennakkolippua ei löydy annetulla id - paramterilla

**Koodi** : `404 NOT FOUND`

**Sisältö** : 

```json
{
    "message": "Ennakkolippua ei löytynyt annetulla id:llä"
}
```
