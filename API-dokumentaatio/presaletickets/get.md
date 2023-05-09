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
        "presaleticketid": 2,
        "used": false,
        "price": 10.0,
        "sale": {
            "saleid": 1,
            "saledate": "2023-03-13T16:02:00",
            "user": {
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
        },
        "event": {
            "event_id": 1,
            "eventName": "Testitapahtuma",
            "eventStartDate": "11.12.2023 12:00",
            "eventEndDate": "11.12.2023 23:00",
            "ticketAmount": 10,
            "ticketPrice": 0.0,
            "description": "Tapahtuma testaa tapahtuman toimintaa",
            "presaleStarts": "01.10.2023 01:00",
            "presaleEnds": "10.12.2023 23:00",
            "venue": {
                "venue_id": 1,
                "venueName": "Testipaikka",
                "description": "Testi",
                "areaCode": {
                    "areaCode": "00000",
                    "city": "Testikaupunki"
                }
            },
            "aTicketTypes": [
                {
                    "line_id": 1,
                    "ticketType": {
                        "type_id": 1,
                        "multiplier": 0.5,
                        "type": "Student"
                    }
                },
                {
                    "line_id": 2,
                    "ticketType": {
                        "type_id": 2,
                        "multiplier": 0.0,
                        "type": "Child under 7"
                    }
                }
            ]
        },
        "tickettype": {
            "type_id": 1,
            "multiplier": 0.5,
            "type": "Student"
        }
    }
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
        "presaleticketid": 2,
        "used": false,
        "price": 10.0,
        "sale": {
            "saleid": 1,
            "saledate": "2023-03-13T16:02:00",
            "user": {
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
        },
        "event": {
            "event_id": 1,
            "eventName": "Testitapahtuma",
            "eventStartDate": "11.12.2023 12:00",
            "eventEndDate": "11.12.2023 23:00",
            "ticketAmount": 10,
            "ticketPrice": 0.0,
            "description": "Tapahtuma testaa tapahtuman toimintaa",
            "presaleStarts": "01.10.2023 01:00",
            "presaleEnds": "10.12.2023 23:00",
            "venue": {
                "venue_id": 1,
                "venueName": "Testipaikka",
                "description": "Testi",
                "areaCode": {
                    "areaCode": "00000",
                    "city": "Testikaupunki"
                }
            },
            "aTicketTypes": [
                {
                    "line_id": 1,
                    "ticketType": {
                        "type_id": 1,
                        "multiplier": 0.5,
                        "type": "Student"
                    }
                },
                {
                    "line_id": 2,
                    "ticketType": {
                        "type_id": 2,
                        "multiplier": 0.0,
                        "type": "Child under 7"
                    }
                }
            ]
        },
        "tickettype": {
            "type_id": 1,
            "multiplier": 0.5,
            "type": "Student"
        }
    }
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
