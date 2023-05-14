# Näytä yksittäinen tapahtumapaikka

Hakee yksittäisen tapahtumapaikan id:n perusteella

**URL** : `/venue/{id}`

**URL Parametrit** : `{id}` jossa id on tapahtumapaikan yksilöivä tunnus

**Method** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on admin tai basic oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Jos tapahtumapaikka on olemassa ja käyttäjällä on oikeudet tarkastella tapahtumapaikkoja

**Koodi** : `200 OK`

**Esimerkki sisällöstä**

```json
{
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

**Ehdot** : Jos tapahtumapaikka ei löydy annetulla id - paramterilla

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Tapahtumapaikkaa ei löytynyt annetulla id:llä"
}
```