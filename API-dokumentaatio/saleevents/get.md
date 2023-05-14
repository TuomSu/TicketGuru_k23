# Näytä myyntitapahtumat

Näyttää kaikki sovellukseen lisätyt myyntitapahtumat

**URL** : `/saleEvents/`

**Metodi** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut käyttöoikeudet** : Admin tai basic -käyttöoikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Sovellukseen ei ole lisätty myyntitapahtumia

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### Tai

**Ehdot** : Sovellukseen on lisätty yksi tai useampi myyntitapahtuma

**Koodi** : `200 OK`

**Sisältö** : 

```json
[
    {
        "saleid": 1,
        "saledate": "2023-03-13T16:02:00",
        "totalprice": 0,
        "user": {
            "userid": 1,
            "role": {
                "roleid": 1,
                "role": "admin",
                "rights": "all rights"
            },
            "firstName": "Anna",
            "lastName": "Anttonen",
            "username": "usernameAnna"
        },
        "presaletickets": [
            {
                "presaleticketid": 1,
                "used": false,
                "price": 10,
                "code": "47a9e728-3f27-4ef3-982b-0e14fa04ebe0",
                "qrCodeImage": null,
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
    }
]
```