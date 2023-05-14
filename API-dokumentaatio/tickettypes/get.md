# Näytä lipputyypit

Näyttää kaikki sovellukseen lisätyt lipputyypit

**URL** : `/tickettypes/`

**Metodi** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut käyttöoikeudet** : Admin - käyttöoikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Sovellukseen ei ole lisätty lipputyyppejä

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### Tai

**Ehdot** : Sovellukseen on lisätty yksi tai useampi lipputyyppi

**Koodi** : `200 OK`

**Sisältö** : 

```json
[
    {
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
    },
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