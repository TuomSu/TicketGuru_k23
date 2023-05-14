# Luo postinumero

Postinumeron luominen

**URL** : `/acodes/`

**Metodi** : `POST`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on admin-käyttöoikeudet

**Rajoitukset**

Postinumerolle tulee antaa postinumero ja kaupunki.

```json
 {
        "areaCode": "00200",
        "city": "Helsinki"
 }
```

## Onnistuneen pyynnön vastaus

**Ehdot** : Kaikki tarvittavat tiedot on annettu ja data on oikean muotoista. Käyttäjällä on oikeus luoda postinumeroita.

**Koodi** : `201 CREATED`

**Esimerkki sisällöstä**

```json
{
    "message": "Lipputyyppi luotu",
}
```

## Virhekoodit

**Ehdot** : Jos kaikkia tarvittavia kenttiä ei ole täytetty

**Koodi** : `400 BAD REQUEST`
