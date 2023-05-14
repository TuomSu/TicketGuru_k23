# Muokkaa myyntitapahtumaa

Yksittäisen myyntitapahtuman muokkaaminen

**URL** : `/saleEvent/{id}`

**URL Parametrit** : `{id}` jossa id on myyntitapahtuman yksilöivä tunnus

**Metodi** : `PUT`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

**Rajoitukset**

Myyntitapahtumalle tulee määritellä myyntipäivä ja käyttäjä. Ilman niitä tiedon tallentaminen ei onnistu.

```json
{
    "saledate": "2023-03-13T16:05:00",
    "user": {
        "userid": 1,
        "role": {
            "roleid": 1,
            "role": "admin",
            "rights": "all rights"
        },
        "firstName": "Anna",
        "lastName": "Anttonen",
        "username": "usernameAnna",
        "password": "password"
    }
}
```

## Vastauskoodit

**Ehdot** : Muokkauksen voi tehdä vain käyttäjä, jolla on siihen vaaditut oikeudet.

**Koodi** : `200 OK`

**Esimerkki sisällöstä** : 

```json
{
    "saleid": 2,
    "saledate": "2023-03-13T16:05:00",
    "totalprice": 350,
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
```

## Virhekoodi

**Ehto** : Kutsussa annetulla id:llä ei löydy myyntitapahtumaa

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Myyntitapahtumaa ei löytynyt annetulla id:llä"
}
```

