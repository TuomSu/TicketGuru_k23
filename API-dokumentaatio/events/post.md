# Luo tapahtuma

Luo tapahtuma

**URL** : `/events/`

**Metodi** : `POST`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä täytyy olla admin-oikeudet

**Esimerkkipyyntö**

```json
{
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
```

## Success Response

**Ehdot** : Kaikki tarvittavat kentät on täytetty ja data on oikean muotoista. Käyttäjällä on oikeus luoda tapahtumia.

**Koodi** : `201 CREATED`

**Esimerkki sisällöstä**

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

**Ehdot** : Jos kaikkia tarvittavia kenttiä ei ole täytetty

**Koodi** : `400 BAD REQUEST`
