# Näytä kaikki ennakkoliput

Näyttää kaikki sovellukseen lisätyt tapahtumat

**URL** : `/presaletickets/`

**Metodi** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Permissions required** : Admin tai peruskäyttäjän oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Sovellukseen ei ole lisätty ennakkolippuja

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### Tai

**Ehdot** : Sovellukseen on lisätty yksi tai useampi ennakkolippu

**Code** : `200 OK`

**Vastauksen sisältö** : Tässä esimerkissä sovellukseen on lisätty kaksi ennakkolippua, jotka listataan käyttäjälle

```json
[
    sisältö
]
```

# Näytä ennakkolippu koodin perusteella

**URL** : `/presaletickets?code={code}`

**Metodi** : `GET`

**URL Parametrit** : `{code}` ennakkolipun koodi

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä täytyy olla adminin, peruskäyttäjän tai lipuntarkastajan oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Parametrinä annetun koodin sisältävä ennakkolippu löytyy tietokannasta.

**Koodi** : `200 OK`

**Vastauksen sisältö**

```json
{
    sisältö
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
# Ennakkolipun hakeminen id:n perusteella

**URL** : `/presaletickets/{id}`

**URL Parametrit** : `{id}` jossa id on tapahtuman yksilöivä tunnus

**Method** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on admin tai peruskäyttäjän oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Ennakkolippu on olemassa ja käyttäjällä on oikeudet tarkastella ennakkolippuja

**Koodi** : `200 OK`

**Vastauksen esimerkkisisältö**

```json
{
    sisältö
}
```

## Virhekoodit

**Ehdot** : Jos ennakkolippua ei löydy annetulla id - paramterilla

**Koodi** : `404 NOT FOUND`

**Sisältö** : 

```json
{
    "message": "Ennakkolippua ei löytynyt annetulla id:llä"
}
```
