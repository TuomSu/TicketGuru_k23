# Näytä tapahtumat

Näyttää kaikki sovellukseen lisätyt tapahtumat

**URL** : `/events/`

**Metodi** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Permissions required** : None

**Data constraints** : `{}`

## Success Responses

**Ehdot** : Sovellukseen ei ole lisätty tapahtumia

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### Tai

**Ehdot** : Sovellukseen on lisätty yksi tai useampia tapahtumia

**Code** : `200 OK`

**Content** : Tässä esimerkissä sovellukseen on lisätty kaksi tapahtumaa, jotka listataan käyttäjälle

```json
[
    "event": {
        "id": 1,
        "eventName": "HEDBERG ON THE ROAD - STAND UP KIERTUE 2023",
        "eventStartDate": 2023-03-16,
        "eventEndDate": 2023-03-16,
        "ticketAmount": 500,
        "ticketPrice": 35,
        "description": "Hedberg On the Road starttaa torstaina 16.3.2023. Kevään hauskimmalla kiertueella nautitaan Samin käsikirjoittamista nauruhermoja kutkuttavista tarinoista, mielikuvituksen synnyttämistä hahmoista sekä improvisaatiosta.",
        "presaleStarts": 2023-01-01,
        "presaleEnds": 2023-03-15,
        "venue": "Apollo Live Club"
    },
    "event": {
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
    },
]
```