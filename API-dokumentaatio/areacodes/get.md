# Näytä postinumerot

Näyttää kaikki sovellukseen lisätyt postinumerot

**URL** : `/acodes/`

**Metodi** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut käyttöoikeudet** : Admin - käyttöoikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Sovellukseen ei ole lisätty postinumeroita

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### Tai

**Ehdot** : Sovellukseen on lisätty yksi tai useampi postinumero

**Koodi** : `200 OK`

**Sisältö** : 

```json
[
    {
        "areaCode": "00000",
        "city": "Testikaupunki"
    }
]
```