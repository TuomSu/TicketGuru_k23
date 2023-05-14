# Luo myyntitapahtuma

Myyntitapahtuman luominen

**URL** : `/saleEvents/`

**Metodi** : `POST`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on admin- tai basic käyttöoikeudet

**Rajoitukset**

Myyntiapahtumalle tulee määritellä myyntipäivä ja myynnin tehnyt käyttäjä. Ilman niitä tiedon tallentaminen ei onnistu.

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

## Onnistuneen pyynnön vastaus

**Ehdot** : Kaikki tarvittavat tiedot on annettu ja data on oikean muotoista. Käyttäjällä on oikeus luoda myyntitapahtumia.

**Koodi** : `201 CREATED`

**Esimerkki sisällöstä**

```json
{
    "message": "Myyntitapahtuma luotu",
}
```

## Virhekoodit

**Ehdot** : Jos kaikkia tarvittavia kenttiä ei ole täytetty

**Koodi** : `400 BAD REQUEST`
