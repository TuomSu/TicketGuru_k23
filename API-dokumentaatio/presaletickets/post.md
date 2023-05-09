# Luo ennakkolippu

Luo ennakkolippu

**URL** : `/presaletickets/`

**Metodi** : `POST`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä täytyy olla admin oikeudet

**Rajoitukset**

Kaikki kentät vaaditaan ja niiden tulee olla oikean muotoisia

```json
{
    "used": Boolean,
    "price": double,
    "sale_id": int,
    "event_id": int,
    "type_id": int
}
```

## Success Response

**Ehdot** : Kaikki tarvittavat kentät on täytetty ja data on oikean muotoista. Käyttäjällä on oikeus luoda ennakkolippuja. Ennakkolipulle määritetyt sale_id, event_id ja type_id löytyvät tietokannasta.

**Koodi** : `201 CREATED`

**Esimerkki sisällöstä**

```json
{
        "presaleticketid": 2,
        "used": false,
        "price": 10.0,
        "sale": {
            "saleid": 1,
            "saledate": "2023-03-13T16:02:00",
            "user": {
                "userid": 1,
                "role": {
                    "roleid": 1,
                    "role": "admin",
                    "rights": "all rights"
                },
                "firstName": "Anna",
                "lastName": "Anttonen",
                "username": "usernameAnna",
                "passwordHash": "$2a$10$WDMEAdeX.N/M6oJnNpDyUO5szwepvUl6irlqJ/o5aRcZtth9Yfnom"
            }
        },
        "event": {
            "event_id": 1,
            "eventName": "Testitapahtuma",
            "eventStartDate": "11.12.2023 12:00",
            "eventEndDate": "11.12.2023 23:00",
            "ticketAmount": 10,
            "ticketPrice": 0.0,
            "description": "Tapahtuma testaa tapahtuman toimintaa",
            "presaleStarts": "01.10.2023 01:00",
            "presaleEnds": "10.12.2023 23:00",
            "venue": {
                "venue_id": 1,
                "venueName": "Testipaikka",
                "description": "Testi",
                "areaCode": {
                    "areaCode": "00000",
                    "city": "Testikaupunki"
                }
            },
            "aTicketTypes": [
                {
                    "line_id": 1,
                    "ticketType": {
                        "type_id": 1,
                        "multiplier": 0.5,
                        "type": "Student"
                    }
                },
                {
                    "line_id": 2,
                    "ticketType": {
                        "type_id": 2,
                        "multiplier": 0.0,
                        "type": "Child under 7"
                    }
                }
            ]
        },
        "tickettype": {
            "type_id": 1,
            "multiplier": 0.5,
            "type": "Student"
        }
    }
}
```

## Virhekoodit

**Ehdot** : Jos kaikkia tarvittavia kenttiä ei ole täytetty

**Koodi** : `400 BAD REQUEST`

**Esimerkki sisällöstä**

```json
{
    "eventName": [
        "Tämä kenttä vaaditaan"
    ]
}
```