# Näytä yksittäinen myyntitapahtuma

Hakee yksittäisen myyntitapahtuman id:n perusteella

**URL** : `/saleEvent/{id}`

**URL Parametrit** : `{id}` jossa id on myyntitapahtuman yksilöivä tunnus

**Method** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on admin tai basic oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Jos myyntitapahtuma on olemassa ja käyttäjällä on oikeudet tarkastella myyntitapahtumia

**Koodi** : `200 OK`

**Esimerkki sisällöstä**

```json
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
```

## Virhekoodit

**Ehdot** : Jos myyntitapahtumaa ei löydy annetulla id - paramterilla

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Myyntitapahtumaa ei löytynyt annetulla id:llä"
}
```