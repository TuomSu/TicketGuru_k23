# Näytä yksittäinen postinumero

Hakee yksittäisen postinumeron

**URL** : `/{areaCode}`

**URL Parametrit** : `{areaCode}` jossa areaCode on postinumero

**Method** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on admin oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Jos postinumero on olemassa ja käyttäjällä on oikeudet tarkastella postinumeroita

**Koodi** : `200 OK`

**Esimerkki sisällöstä**

```json
{
        "areaCode": "00000",
        "city": "Testikaupunki"
}
```

## Virhekoodit

**Ehdot** : Jos postinumeroa ei löydy annetulla paramterilla

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Annettua postinumeroa ei löytynyt"
}
```