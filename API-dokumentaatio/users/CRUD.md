# Käyttäjät

## GET
Näyttää kaikki sovellukseen lisätyt käyttäjät

**URL** : `/users/`

**Metodi** : `GET`

**Kirjautuminen vaaditaan** : Kyllä

**Permissions required** : None

**Data constraints** : `{}`

## Success Responses

**Ehdot** : Sovellukseen ei ole lisätty käyttäjiä

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### Tai

**Ehdot** : Sovellukseen on lisätty yksi tai useampia käyttäjiä

**Code** : `200 OK`

**Content** : Tässä esimerkissä sovellukseen on lisätty yksi käyttäjä, jotka listataan

```json
[
    {
        "userid": 1,
        "role": {
            "roleid": 1,
            "role": "admin",
            "rights": "all rights"
        },
        "firstName": "Anna",
        "lastName": "Anttonen",
        "username": "usernameAnna",
        "passwordHash": "$2a$10$WDMEAdeX.N/M6oJnNpDyUO5szwepvUl6irlqJ/o5aRcZtth9Yfnom"
    }
]
```

## POST

Lisää käyttäjä

**URL** : `/users/`

**Metodi** : `POST`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on oikeus lisätä käyttäjiä, rooli huomioidaan.

**Rajoitukset**

Kaikki kentät vaaditaan ja niiden tulee olla oikean muotoisia

```json
{
    private UserRole role;
	private String firstName;
	private String lastName;
	private String username;
	private String passwordHash;
	
}
```

## Success Response

**Ehdot** : Kaikki tarvittavat kentät on täytetty ja data on oikean muotoista. Käyttäjällä on oikeus lisätä käyttäjä sekä asettaa rooli.

**Koodi** : `201 CREATED`

**Esimerkki sisällöstä**

```json
{
    "userid": 4,
    "role": {
        "roleid": 3,
        "role": "office",
        "rights": "see, update, delete events and employees"
    },
    "firstName": "Maija",
    "lastName": "Mainio",
    "username": "usernameMaija",
    "passwordHash": "$2a$10$WDMEAdeX.N/M6oJnNpDyUO5szwepvUl6irlqJ/o5aRcZtth9Yfnom"
}
```

## Virhekoodit

**Ehdot** : Jos kaikkia tarvittavia kenttiä ei ole täytetty

**Koodi** : `400 BAD REQUEST`

**Esimerkki sisällöstä**

```json
{
    "role": {
        "Tämä kenttä vaaditaan"
    }
}
```

## PUT

Yksittäisen käyttäjän tietojen muokkaaminen

**URL** : `/user/{id}`

**URL Parametrit** : `{id}` jossa id on käyttäjän yksilöivä tunnus

**Metodi** : `PUT`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla oikeus muokata käyttäjän tietoja

**Rajoitukset**

Kaikki kentät vaaditaan ja niiden tulee olla oikean muotoisia

```json
{
    private UserRole role;
	private String firstName;
	private String lastName;
	private String username;
	private String passwordHash;
}
```

## Vastauskoodit

**Ehdot** : Muokkauksen voi tehdä vain käyttäjä, jolla on siihen vaaditut oikeudet, rooli huomioidaan.

**Koodi** : `200 OK`

**Content example** : Kun henkilön sukunimeä muokattu ja tiedot lähetetty POST - metodia käyttäen osoitteeseen `/user/1`...

```json
{
    "userid": 1,
    "role": {
        "roleid": 1,
        "role": "admin",
        "rights": "all rights"
    },
    "firstName": "Anna",
    "lastName": "Miettinen",
    "username": "usernameAnna",
    "passwordHash": "$2a$10$WDMEAdeX.N/M6oJnNpDyUO5szwepvUl6irlqJ/o5aRcZtth9Yfnom"
}
```

## Virhekoodi

**Condition** : Kutsussa annetulla id:llä ei löydy käyttäjää

**Koodi** : `404 NOT FOUND`

**Sisältö** : `{}`

### Tai

**Ehdot** : Käyttäjällä ei ole oikeus muokata tietoja

**Koodi** : `403 FORBIDDEN`

**Sisältö** : 
```json
{"detail": "Sinulla ei ole oikeuksia suorittaa tätä toimenpidettä."}
```

## Käyttäjän poistaminen

Yksittäisen käyttäjän poistaminen sovelluksesta

**URL** : `/user/{id}`

**URL Parametrit** : `{id}` jossa id on käyttäjän yksilöivä tunnus

**Metodi** : `DELETE`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla oikeus poistaa käyttäjiä

**Data** : `{}`

## Success Response

**Ehdot** : Annetun parametrin mukainen käyttäjä on olemassa

**Koodi** : `204 NO CONTENT`

**Sisältö** : `{}`

## Virhekoodit

**Ehdot** : Jos annetulla parametrilla ei löytynyt käyttäjää, jonka voisi poistaa

**Koodi** : `404 NOT FOUND`

**Content** : `{}`

### Tai

**Ehdot** : Käyttäjällä ei ole oikeuksia poistaa käyttäjää

**Code** : `403 FORBIDDEN`

**Content** : 
```json
{"detail": "Sinulla ei ole oikeuksia suorittaa tätä toimenpidettä."}
```
