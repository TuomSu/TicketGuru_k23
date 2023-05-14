# Tapahtuman poistaminen

Yksittäisen tapahtuman poistaminen sovelluksesta

**URL** : `/event/{id}`

**URL Parametrit** : `{id}` jossa id on tapahtuman yksilöivä tunnus

**Metodi** : `DELETE`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla oikeus poistaa tapahtumia

**Data** : `{}`

## Success Response

**Ehdot** : Annetun parametrin mukainen tapahtuma on olemassa

**Koodi** : `200 OK`

**Sisältö** : `{}`

## Virhekoodit

**Ehdot** : Jos annetulla parametrilla ei löytynyt tapahtumaa, jonka voisi poistaa

**Koodi** : `404 NOT FOUND`

