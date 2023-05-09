# Näytä yksittäinen lipputyyppi

Hakee yksittäisen lipputyypin id:n perusteella

**URL** : `/tickettypes/{id}`

**URL Parametrit** : `{id}` jossa id on lipputyypin yksilöivä tunnus

**Method** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on admin tai basic oikeudet

## Onnistuneen pyynnön vastaus

**Ehdot** : Jos tapahtuma on olemassa ja käyttäjällä on oikeudet tarkastella tapahtumia

**Koodi** : `200 OK`

**Esimerkki sisällöstä**

```json
{
    Tarkista pyynnön vastaus
}
```

## Virhekoodit

**Ehdot** : Jos lipputyyppiä ei löydy annetulla id - paramterilla

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Lipputyyppiä ei löytynyt annetulla id:llä"
}
```