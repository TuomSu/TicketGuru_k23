# Muokkaa lipputyyppiä

Yksittäisen lipputyypin muokkaaminen

**URL** : `/tickettypes/{id}`

**URL Parametrit** : `{id}` jossa id on lipputyypin yksilöivä tunnus

**Metodi** : `PUT`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

**Rajoitukset**

Lipputyypille tulee määritellä hinta ja nimi. Ilman niitä tiedon tallentaminen ei onnistu.

```json
{
    "price" : "double",
    "name" : "String"
}
```

## Vastauskoodit

**Ehdot** : Muokkauksen voi tehdä vain käyttäjä, jolla on siihen vaaditut oikeudet.

**Koodi** : `200 OK`

**Content example** : 

```json
{
    Mitä palauttaa?
}
```

## Virhekoodi

**Condition** : Kutsussa annetulla id:llä ei löydy tapahtuma

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Lipputyyppiä ei löytynyt annetulla id:llä"
}
```

