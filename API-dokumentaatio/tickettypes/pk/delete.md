# Lipputyypin poistaminen

Yksittäisen lipputyypin poistaminen sovelluksesta

**URL** : `/tickettypes/{id}`

**URL Parametrit** : `{id}` jossa id on lipputyypin yksilöivä tunnus

**Metodi** : `DELETE`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

## Onnistuneen pyynnön vastauskoodi

**Ehdot** : Annetun parametrin mukainen lipputyyppi on olemassa

**Koodi** : `204 NO CONTENT` // mikä on oikea koodi?

**Sisältö** : 

Onnistuneen poistamisen jälkeen palautetaan listaus kaikista tietokannassa jäljellä olevista lipputyypeistä.

```json
{
    Palauttaa listan kaikista lipputyypeistä
}
```

## Virhekoodit

**Ehdot** : Jos annetulla parametrilla ei löytynyt lipputyyppiä, jonka voisi poistaa

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Lipputyyppiä ei löytynyt annetulla id:llä"
}
```

