# Muokkaa postinumeroa

Yksittäisen postinumeron muokkaaminen

**URL** : `/{areaCode}`

**URL Parametrit** : `{areaCode}` jossa areaCode on postinumero

**Metodi** : `PUT`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

**Rajoitukset**

Postinumerolle tulee antaa kaupunki. Vain kaupunkia voi muokata.

```json
{
        "city": "Helsinki"
}
```

## Vastauskoodit

**Ehdot** : Muokkauksen voi tehdä vain käyttäjä, jolla on siihen vaaditut oikeudet.

**Koodi** : `200 OK`

**Esimerkki sisällöstä** : 

```json
{
    "areaCode": "00000",
    "city": "Helsinki"
}
```

## Virhekoodi

**Ehto** : Kutsussa annettua postinumeroa ei löydy

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Annettua postinumeroa ei löytynyt"
}
```

