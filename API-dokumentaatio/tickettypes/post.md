# Luo lipputyyppi

Lipputyypin luominen

**URL** : `/tickettypes/`

**Metodi** : `POST`

**Kirjautuminen vaaditaan** : Kyllä

**Vaaditut oikeudet** : Käyttäjällä on admin-käyttöoikeudet

**Rajoitukset**

Lipputyypille tulee määritellä hinta ja nimi. Ilman niitä tiedon tallentaminen ei onnistu.

```json
{
    "price" : "double",
    "name" : "String"
}
```

## Onnistuneen pyynnön vastaus

**Ehdot** : Kaikki tarvittavat tiedot on annettu ja data on oikean muotoista. Käyttäjällä on oikeus luoda lipputyyppejä.

**Koodi** : `201 CREATED`

**Esimerkki sisällöstä**

```json
{
    Tarkista vastauksen sisältö
}
```

## Virhekoodit

**Ehdot** : Jos kaikkia tarvittavia kenttiä ei ole täytetty

**Koodi** : `400 BAD REQUEST`

**Esimerkki sisällöstä**

```json
{
    Mitä tulee vastaukseksi?
}
```