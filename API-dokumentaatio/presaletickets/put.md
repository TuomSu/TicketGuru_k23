# Muokkaa ennakkolippua

Yksittäisen ennakkolipun muokkaaminen

**URL** : `/presaleticket/{id}`

**URL Parametrit** : `{id}` jossa id on ennakkolipun yksilöivä tunnus

**Metodi** : `PUT`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

**Esimerkkipyyntö**

```json
{
    "used": false,
    "tickettype": {
        "type_id": 3,
}
```

## Vastauskoodit

**Ehdot** : Muokkauksen voi tehdä vain käyttäjä, jolla on siihen vaaditut oikeudet.

**Koodi** : `200 OK`

**Esimerkki sisällöstä** : 

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

## Virhekoodi

**Ehto** : Kutsussa annetulla id:llä ei löydy ennakkolippua

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Ennakkolippua ei löytynyt annetulla id:llä"
}
```

