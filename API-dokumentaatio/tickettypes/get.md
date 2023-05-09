# Näytä lipputyypit

Näyttää kaikki sovellukseen lisätyt lipputyypit

**URL** : `/tickettypes/`

**Metodi** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut käyttöoikeudet** : Admin - käyttöoikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Sovellukseen ei ole lisätty lipputyyppejä

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### Tai

**Ehdot** : Sovellukseen on lisätty yksi tai useampi lipputyyppi

**Koodi** : `200 OK`

**Sisältö** : 

```json
[
    "tickettype": {
        Vastauksen tiedot täytyy vielä täydentää
    },

]
```