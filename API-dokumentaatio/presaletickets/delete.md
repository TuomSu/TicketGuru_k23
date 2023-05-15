# Ennakkolipun poistaminen

Yksittäisen ennakkolipun poistaminen sovelluksesta

**URL** : `/presaleticket/{id}`

**URL Parametrit** : `{id}` jossa id on poistettavan ennakkolipun yksilöivä tunnus

**Metodi** : `DELETE`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä tulee olla admin-käyttöoikeudet

## Onnistuneen pyynnön vastauskoodi

**Ehdot** : Annetun parametrin mukainen myyntitapahtuma on olemassa.

**Koodi** : `200 OK`

**Sisältö** : 

Onnistuneen poistamisen jälkeen palautetaan listaus kaikista tietokannassa jäljellä olevista ennakkolipuista.

```json
[
    {
        "presaleticketid": 2,
        "used": false,
        "price": 0.0,
        "code": "8947daa6-5741-4f9c-8159-bc443f3b4f10",
        "event": null,
        "tickettype": {
            "type_id": 1,
            "price": 120.0,
            "type": "Student",
            "event": {
                "event_id": 1,
                "eventName": "Testitapahtuma",
                "eventStartDate": "11.12.2023 12:00",
                "eventEndDate": "11.12.2023 23:00",
                "ticketAmount": 10,
                "soldTickets": 1,
                "ticketPrice": 15.5,
                "description": "Tapahtuma testaa tapahtuman toimintaa",
                "presaleStarts": "01.10.2023 01:00",
                "presaleEnds": "10.12.2023 23:00",
                "venue": {
                    "venue_id": 1,
                    "venueName": "Testipaikka",
                    "description": "Testi",
                    "address": "Testikuja 2",
                    "areaCode": {
                        "areaCode": "00000",
                        "city": "Testikaupunki"
                    }
                }
            }
        }
    }
]
```

## Virhekoodit

**Ehdot** : Jos annetulla parametrilla ei löytynyt ennakkolippua, jonka voisi poistaa

**Koodi** : `404 NOT FOUND`

**Sisältö** :

```json
{
    "message" : "Ennakkolippua ei löytynyt annetulla id:llä"
}
```

