# Myyntitapahtuman poistaminen

Yksittäisen myyntitapahtuman poistaminen sovelluksesta

**URL** : `/saleEvent/{id}`

**URL Parametrit** : `{id}` jossa id on myyntitapahtuman yksilöivä tunnus

**Metodi** : `DELETE`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

## Onnistuneen pyynnön vastauskoodi

**Ehdot** : Annetun parametrin mukainen myyntitapahtuma on olemassa.

**Koodi** : `200 OK`

**Sisältö** : 

Onnistuneen poistamisen jälkeen palautetaan listaus kaikista tietokannassa jäljellä olevista myyntitapahtumista.

```json
[
    {
        "saleid": 2,
        "saledate": "2023-03-13T16:05:00",
        "totalprice": 300,
        "user": {
            "userid": 1,
            "role": {
                "roleid": 1,
                "role": "admin",
                "rights": "all rights"
            },
            "firstName": "Anna",
            "lastName": "Anttonen",
            "username": "usernameAnna"
        },
        "presaletickets": []
    }
]
```

## Virhekoodit

**Ehdot** : Jos annetulla parametrilla ei löytynyt myyntitapahtumaa, jonka voisi poistaa

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Myyntitapahtumaa ei löytynyt annetulla id:llä"
}
```

