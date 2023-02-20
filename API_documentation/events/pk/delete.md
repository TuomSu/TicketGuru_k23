# Tapahtuman poistaminen

Yksittäisen tapahtuman poistaminen sovelluksesta

**URL** : `/events/{id}`

**URL Parametrit** : `{id}` jossa id on tapahtuman yksilöivä tunnus

**Metodi** : `DELETE`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla oikeus poistaa tapahtumia

**Data** : `{}`

## Success Response

**Ehdot** : Annetun parametrin mukainen tapahtuma on olemassa

**Koodi** : `204 NO CONTENT`

**Sisältö** : `{}`

## Virhekoodit

**Ehdot** : Jos annetulla parametrilla ei löytynyt tapahtumaa, jonka voisi poistaa

**Koodi** : `404 NOT FOUND`

**Content** : `{}`

### Tai

**Ehdot** : Käyttäjällä ei ole oikeuksia poistaa tapahtumia

**Code** : `403 FORBIDDEN`

**Content** : 
```json
{"detail": "Sinulla ei ole oikeuksia suorittaa tätä toimenpidettä."}
```
