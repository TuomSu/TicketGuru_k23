# Muokkaa tapahtumaa

Yksittäisen tapahtuman muokkaaminen

**URL** : `/event/{id}`

**URL Parametrit** : `{id}` jossa id on tapahtuman yksilöivä tunnus

**Metodi** : `PUT`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla oikeus muokata tapahtumia

**Esimerkkipyyntö**

Kaikki kentät vaaditaan ja niiden tulee olla oikean muotoisia

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

## Vastauskoodit

**Ehdot** : Muokkauksen voi tehdä vain käyttäjä, jolla on siihen vaaditut oikeudet.

**Koodi** : `200 OK`

**Content example** : Kun tapahtuman nimeä ja kuvausta on muokattu ja tiedot lähetetty POST - metodia käyttäen osoitteeseen `/events/2`...

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

## Virhekoodi

**Condition** : Kutsussa annetulla id:llä ei löydy tapahtuma

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Tapahtumaa ei löytynyt annetulla id:llä"
}
```