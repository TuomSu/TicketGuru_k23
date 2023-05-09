# Ennakkolipun merkitseminen käytetyksi

**URL** : `/presaletickets?code={code}`

**Metodi** : `Patch`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä täytyy olla adminin, peruskäyttäjän tai lipuntarkastajan oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Parametrinä annetun koodin sisältävä ennakkolippu löytyy tietokannasta ja lipun used-arvo on false.

**Koodi** : `200 OK`

**Vastauksen sisältö**

```json
{
    "message": "Lipun tarkastaminen onnistui"
}
```

## Virhekoodit

**Ehdot** : Jos annetulla koodilla ei löydy tietokannasta lippua

**Koodi** : `404 NOT FOUND`

**Esimerkki sisällöstä**

```json
{
    "message": "Ennakkolippua ei löytynyt annetulla koodilla"
}
```

**Ehdot** : Jos lippu on jo käytetty eli used-arvo on true

**Koodi** : `403 FORBIDDEN`

**Esimerkki sisällöstä**

```json
{
    "message": "Lippu on jo käytetty"
}
```