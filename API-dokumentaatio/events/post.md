# Luo tapahtuma

Luo tapahtuma

**URL** : `/events/`

**Metodi** : `POST`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on oikeus luoda tapahtumia

**Rajoitukset**

Kaikki kentät vaaditaan ja niiden tulee olla oikean muotoisia

```json
{
    "eventName": String,
    "eventStartDate": DATE,
    "eventEndDate": DATE,
    "ticketAmount": int,
    "ticketPrice": double,
    "description": String,
    "presaleStarts": DATE,
    "presaleEnds": DATE,
    "venue": String
}
```

## Success Response

**Ehdot** : Kaikki tarvittavat kentät on täytetty ja data on oikean muotoista. Käyttäjällä on oikeus luoda tapahtumia.

**Koodi** : `201 CREATED`

**Esimerkki sisällöstä**

```json
{
    "id": 2,
    "eventName": "Patti Smith (USA) and band",
    "eventStartDate": 2023-05-15,
    "eventEndDate": 2023-05-15,
    "ticketAmount": 1500,
    "ticketPrice": 58,
    "description": "Patti Smith yhtyeineen saapuu Suomeen",
    "presaleStarts": 2023-02-01,
    "presaleEnds": 2023-05-01,
    "venue": "Kulttuuritalo"
}
```

## Virhekoodit

**Ehdot** : Jos kaikkia tarvittavia kenttiä ei ole täytetty

**Koodi** : `400 BAD REQUEST`
