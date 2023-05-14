# Muokkaa tapahtumapaikkaa

Yksittäisen tapahtumapaikan muokkaaminen

**URL** : `/venue/{id}`

**URL Parametrit** : `{id}` jossa id on tapahtumapaikan yksilöivä tunnus

**Metodi** : `PUT`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

**Rajoitukset**

Tapahtumapaikalle tulee määritellä nimi, osoite ja postikoodi. Ilman niitä tiedon tallentaminen ei onnistu.

```json
{
    "venueName": "Tavastia",
    "description": "Ikoninen keikkapaikka",
    "address": "Testikuja 3",
    "areaCode": {
        "areaCode": "00000",
        "city": "Testikaupunki"
    }
}
```

## Vastauskoodit

**Ehdot** : Muokkauksen voi tehdä vain käyttäjä, jolla on siihen vaaditut oikeudet.

**Koodi** : `200 OK`

**Esimerkki sisällöstä** : 

```json
{
    "venue_id": "2",
    "venueName": "Tavastia",
    "description": "Ikoninen keikkapaikka",
    "address": "Testikuja 5",
    "areaCode": {
        "areaCode": "00000",
        "city": "Testikaupunki"
    }
}
```

## Virhekoodi

**Ehto** : Kutsussa annetulla id:llä ei löydy tapahtumapaikkaa

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Tapahtumapaikkaa ei löytynyt annetulla id:llä"
}
```

