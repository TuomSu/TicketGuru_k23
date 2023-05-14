# Näytä yksittäinen tapahtuma

Näyttää yksittäisen tapahtuman

**URL** : `/event/{id}`

**URL Parametrit** : `{id}` jossa id on tapahtuman yksilöivä tunnus

**Method** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on basic tai admin käyttöoikeudet

**Data**: `{}`

## Success Response

**Ehdot** : Jos tapahtuma on olemassa ja käyttäjällä on oikeudet tarkastella tapahtumia

**Koodi** : `200 OK`

**Content example**

```json
{
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
```

## Virhekoodit

**Ehdot** : Jos tapahtumaa ei löydy annetulla id - paramterilla

**Koodi** : `404 NOT FOUND`


**Sisältö** :

```json
{
    "message" : "Tapahtumaa ei löytynyt annetulla id:llä"
}
```