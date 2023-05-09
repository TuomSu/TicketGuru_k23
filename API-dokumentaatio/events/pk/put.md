# Muokkaa tapahtumaa

Yksittäisen tapahtuman muokkaaminen

**URL** : `/event/{id}`

**URL Parametrit** : `{id}` jossa id on tapahtuman yksilöivä tunnus

**Metodi** : `PUT`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla oikeus muokata tapahtumia

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

## Vastauskoodit

**Ehdot** : Muokkauksen voi tehdä vain käyttäjä, jolla on siihen vaaditut oikeudet.

**Koodi** : `200 OK`

**Content example** : Kun tapahtuman nimeä ja kuvausta on muokattu ja tiedot lähetetty POST - metodia käyttäen osoitteeseen `/events/2`...

```json
{
    "id": 2,
    "eventName": "Patti Smith (USA) and the big band",
    "eventStartDate": 2023-05-15,
    "eventEndDate": 2023-05-15,
    "ticketAmount": 1500,
    "ticketPrice": 58,
    "description": "Patti Smith yhtyeineen saapuu Suomeen legendaariseen Kulttuuritaloon",
    "presaleStarts": 2023-02-01,
    "presaleEnds": 2023-05-01,
    "venue": "Kulttuuritalo"
}
```

## Virhekoodi

**Condition** : Kutsussa annetulla id:llä ei löydy tapahtuma

**Koodi** : `404 NOT FOUND`

**Sisältö** : `{}`

### Tai

**Ehdot** : Käyttäjällä ei ole oikeus muokata tapahtumia

**Koodi** : `403 FORBIDDEN`

**Sisältö** : 
```json
{"detail": "Sinulla ei ole oikeuksia suorittaa tätä toimenpidettä."}
```