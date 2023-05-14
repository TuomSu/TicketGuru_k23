# Näytä tapahtumapaikat

Näyttää kaikki sovellukseen lisätyt lipputyypit

**URL** : `/venues/`

**Metodi** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut käyttöoikeudet** : Admin - käyttöoikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Sovellukseen ei ole lisätty tapahtumapaikkoja

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### Tai

**Ehdot** : Sovellukseen on lisätty yksi tai useampi tapahtumapaikka

**Koodi** : `200 OK`

**Sisältö** : 

```json
[
    {
        "venue_id": 1,
        "venueName": "Testipaikka",
        "description": "Testi",
        "address": "Testikuja 2",
        "areaCode": {
            "areaCode": "00000",
            "city": "Testikaupunki"
        }
    },
    {
        "venue_id": 2,
        "venueName": "Tapahtumapaikka",
        "description": "Testi",
        "address": "Testitie 5",
        "areaCode": {
            "areaCode": "00000",
            "city": "Testikaupunki"
        }
    },
]
```