# Lipputyypin poistaminen

Yksittäisen lipputyypin poistaminen sovelluksesta

**URL** : `/tickettypes/{id}`

**URL Parametrit** : `{id}` jossa id on lipputyypin yksilöivä tunnus

**Metodi** : `DELETE`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

## Onnistuneen pyynnön vastauskoodi

**Ehdot** : Annetun parametrin mukainen lipputyyppi on olemassa

**Koodi** : `200 OK`

**Sisältö** : 

Onnistuneen poistamisen jälkeen palautetaan listaus kaikista tietokannassa jäljellä olevista lipputyypeistä.

```json
[
    {
        "type_id": 2,
        "price": 100,
        "type": "Child under 7",
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
    },
    {
        "type_id": 3,
        "price": 150,
        "type": "Eläkeläinen",
        "event": {
            "event_id": 2,
            "eventName": "Kokeilutapahtuma",
            "eventStartDate": "11.12.2023 12:00",
            "eventEndDate": "11.12.2023 23:00",
            "ticketAmount": 10,
            "soldTickets": 0,
            "ticketPrice": 15.5,
            "description": "Tapahtuma kokeilee tapahtuman toimintaa",
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
]
```

## Virhekoodit

**Ehdot** : Jos annetulla parametrilla ei löytynyt lipputyyppiä, jonka voisi poistaa

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Lipputyyppiä ei löytynyt annetulla id:llä"
}
```

