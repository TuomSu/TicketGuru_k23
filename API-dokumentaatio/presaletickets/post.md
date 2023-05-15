# Luo ennakkolippu

Luo ennakkolippu

**URL** : `/presaletickets/{id}`

**Metodi** : `POST`

**URL Parametrit** : `{id}` sen tapahtuman id, johon ennakkolippu halutaan lisätä

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä täytyy olla admin tai basic oikeudet

**Esimerkkipyyntö**

```json
{
    "used": false,
    "tickettype": {
        "type_id": 1,
}
```

## Onnistuneen pyynnön vastauskoodi

**Ehdot** : Kaikki tarvittavat kentät on täytetty ja data on oikean muotoista. Käyttäjällä on oikeus luoda ennakkolippuja. Ennakkolipulle määritetyt sale_id, event_id ja type_id löytyvät tietokannasta.

**Koodi** : `201 CREATED`

**Esimerkki sisällöstä**

```json
{

}
```

## Virhekoodii

**Ehdot** : Jos kaikkia tarvittavia kenttiä ei ole täytetty

**Koodi** : `400 BAD REQUEST`
