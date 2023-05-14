# Postinumeron poistaminen

Yksittäisen postinumeron poistaminen sovelluksesta

**URL** : `/{areaCode}`

**URL Parametrit** : `{areaCode}` jossa areaCode on postinumero

**Metodi** : `DELETE`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

## Onnistuneen pyynnön vastauskoodi

**Ehdot** : Annetun parametrin mukainen postinumeto on olemassa eikä sitä ei ole liitetty mihinkään tapahtumapaikkaan.

**Koodi** : `200 OK`

**Sisältö** : 

Onnistuneen poistamisen jälkeen palautetaan listaus kaikista tietokannassa jäljellä olevista postinumeroista.

```json
[
    {
        "areaCode": "00000",
        "city": "Testikaupunki"
    }
]
```

## Virhekoodit

**Ehdot** : Jos annetulla parametrilla ei löytynyt postinumeroa, jonka voisi poistaa

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Annettua postinumeroa ei löytynyt"
}
```

