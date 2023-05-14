# Näytä yksittäinen lipputyyppi

Hakee yksittäisen lipputyypin id:n perusteella

**URL** : `/tickettypes/{id}`

**URL Parametrit** : `{id}` jossa id on lipputyypin yksilöivä tunnus

**Method** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on admin tai basic oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Jos lipputyyppi on olemassa ja käyttäjällä on oikeudet tarkastella lipputyyppejä

**Koodi** : `200 OK`

**Esimerkki sisällöstä**

```json
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
}
```

## Virhekoodit

**Ehdot** : Jos lipputyyppiä ei löydy annetulla id - paramterilla

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Lipputyyppiä ei löytynyt annetulla id:llä"
}
```