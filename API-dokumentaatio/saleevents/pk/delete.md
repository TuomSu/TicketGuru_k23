# Tapahtumapaikan poistaminen

Yksittäisen tapahtumapaikan poistaminen sovelluksesta

**URL** : `/venue/{id}`

**URL Parametrit** : `{id}` jossa id on lipputyypin yksilöivä tunnus

**Metodi** : `DELETE`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

## Onnistuneen pyynnön vastauskoodi

**Ehdot** : Annetun parametrin mukainen tapahtumapaikka on olemassa eikä tapahtumapaikkaa ei ole liitetty mihinkään tapahtumaan.

**Koodi** : `200 OK`

**Sisältö** : 

Onnistuneen poistamisen jälkeen palautetaan listaus kaikista tietokannassa jäljellä olevista tapahtumapaikoista.

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
    }
]
```

## Virhekoodit

**Ehdot** : Jos annetulla parametrilla ei löytynyt tapahtumapaikkaa, jonka voisi poistaa

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Tapahtumapaikkaa ei löytynyt annetulla id:llä"
}
```

