# Näytä yksittäinen tapahtuma

Näyttää yksittäisen tapahtuman

**URL** : `/events/{id}`

**URL Parametrit** : `{id}` jossa id on tapahtuman yksilöivä tunnus

**Method** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on oikeus tarkastella tapahtumia

**Data**: `{}`

## Success Response

**Ehdot** : Jos tapahtuma on olemassa ja käyttäjällä on oikeudet tarkastella tapahtumia

**Koodi** : `200 OK`

**Content example**

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

**Ehdot** : Jos tapahtumaa ei löydy annetulla id - paramterilla

**Koodi** : `404 NOT FOUND`

**Sisältö** : `{}`

### Tai

**Ehdot** : Jos tapahtuma on olemassa, mutta käyttäjällä ei ole tarvittavia oikeuksia

**Sisältö** : `403 FORBIDDEN`

**Content** :

```json
{"detail": "Sinulla ei ole oikeuksia suorittaa tätä toimenpidettä."}
```