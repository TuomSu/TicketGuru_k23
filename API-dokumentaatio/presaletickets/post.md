# Luo ennakkolippu

Luo ennakkolippu

**URL** : `/presaletickets/`

**Metodi** : `POST`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä täytyy olla admin tai basic oikeudet

**Rajoitukset**

Kaikki kentät vaaditaan ja niiden tulee olla oikean muotoisia

```json
{
    "used": Boolean,
    "price": double,
    "sale_id": int,
    "event_id": int,
    "type_id": int
}
```

## Success Response

**Ehdot** : Kaikki tarvittavat kentät on täytetty ja data on oikean muotoista. Käyttäjällä on oikeus luoda ennakkolippuja. Ennakkolipulle määritetyt sale_id, event_id ja type_id löytyvät tietokannasta.

**Koodi** : `201 CREATED`

**Esimerkki sisällöstä**

```json
{

}
```

## Virhekoodit

**Ehdot** : Jos kaikkia tarvittavia kenttiä ei ole täytetty

**Koodi** : `400 BAD REQUEST`
