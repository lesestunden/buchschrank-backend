# Spring Native Bookcase Backend Example

Simple example for bookcase backend. Saves bookcases and list them (simple CRUD). 

set database connection properties in application.yml

* start in ide: ```gradle bootRun```
* build docker image: ```bootBuildImage```
* run docker image: ```docker run --rm -p 8080:8080 buchschrank:0.0.1-SNAPSHOT```

# Endpoints

## GET /

```
GET / HTTP/1.1
User-Agent: PostmanRuntime/7.28.4
Accept: */*
Cache-Control: no-cache
Host: localhost:8080
Accept-Encoding: gzip, deflate, br
Connection: keep-alive

HTTP/1.1 200 OK
Content-Type: text/plain;charset=UTF-8
Content-Length: 3
Date: Tue, 09 Nov 2021 10:20:10 GMT
Keep-Alive: timeout=60
Connection: keep-alive

1.1
```

## GET /v1/bookcase

```
GET /v1/bookcase HTTP/1.1
User-Agent: PostmanRuntime/7.28.4
Accept: */*
Cache-Control: no-cache
Host: localhost:8080
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
 
HTTP/1.1 200 OK
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 09 Nov 2021 10:22:26 GMT
Keep-Alive: timeout=60
Connection: keep-alive
 
[{"id":1,"title":"ÄÖÜ","streethousenumber":"Selbecker Straße","postcode":"32825","place":null,"country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbücherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1625218928.000000000,"lastupdate":1625218928.000000000},{"id":2,"title":"ÄÖÜ","streethousenumber":"Selbecker Straße","postcode":"32825","place":null,"country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbücherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1625219151.000000000,"lastupdate":1625219151.000000000},{"id":3,"title":"ÄÖÜ","streethousenumber":"Selbecker Straße","postcode":"32825","place":null,"country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbücherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1625219178.000000000,"lastupdate":1625219178.000000000},{"id":5,"title":"Olching test","streethousenumber":"Heckenstraße 12","postcode":"82140","place":"Olching","country":"Deutschland","lat":48.2052453864916,"lng":11.32999386638403,"link":"https://www.aditu.de","contact":"silence@aditu.de","opened":"24/7","inserted":1625474024.000000000,"lastupdate":1625476108.000000000},{"id":8,"title":"test","streethousenumber":"Selbecker Straße","postcode":"32825","place":"Blomberg","country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbuecherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1625492932.000000000,"lastupdate":1625492932.000000000},{"id":9,"title":"testß","streethousenumber":"Selbecker Straße","postcode":"32825","place":"Blomberg","country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbuecherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1625500536.000000000,"lastupdate":1625500536.000000000},{"id":10,"title":"testß","streethousenumber":"Selbecker Straße","postcode":"32825","place":"Blomberg","country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbuecherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1625494619.000000000,"lastupdate":1625494619.000000000},{"id":11,"title":"testß","streethousenumber":"Selbecker Straße","postcode":"32825","place":"Blomberg","country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbuecherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1625551634.000000000,"lastupdate":1625551634.000000000},{"id":12,"title":"testß","streethousenumber":"Selbecker Straße","postcode":"32825","place":"Blomberg","country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbuecherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1625551657.000000000,"lastupdate":1625551657.000000000},{"id":13,"title":"testß","streethousenumber":"Selbecker Straße","postcode":"32825","place":"Blomberg","country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbuecherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1625546364.000000000,"lastupdate":1625546364.000000000},{"id":14,"title":"5tröäüß","streethousenumber":"Florianstraße 8","postcode":"82140","place":"Olching","country":"Deutschland","lat":48.22740745480876,"lng":11.342452056705952,"link":"https://www.aditu.de","contact":"oinfoöäü@aditu.de","opened":"24/7","inserted":1625560295.000000000,"lastupdate":1625560374.000000000},{"id":15,"title":"ÄÖÜ","streethousenumber":"Selbecker Straße","postcode":"32825","place":"Blomberg","country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbücherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1632836910.000000000,"lastupdate":1632836910.000000000},{"id":16,"title":"ÄÖÜ","streethousenumber":"Selbecker Straße","postcode":"32825","place":"Blomberg","country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbücherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1636451039.000000000,"lastupdate":1636451039.000000000},{"id":17,"title":"ÄÖÜ","streethousenumber":"Selbecker Straße","postcode":"32825","place":"Blomberg","country":"Deutschland","lat":51.977261,"lng":9.054234,"link":"","contact":"Stadtbücherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach","opened":"24 Stunden","inserted":1636453123.000000000,"lastupdate":1636453123.000000000}]
```

## POST /v1/request

```
POST /v1/request HTTP/1.1
Content-Type: application/json
User-Agent: PostmanRuntime/7.28.4
Accept: */*
Cache-Control: no-cache
Host: localhost:8080
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
Content-Length: 442
 
{
"bookcase": 0,
"title": "ÄÖÜ<script>bla()</script>",
"streethousenumber": "Bernhard-Weiss-Platz 6",
"postcode": "57271",
"place": "Hilchenbach",
"country": "DE",
"lat": 51.977261,
"lng": 9.054234,
"link": "",
"contact": "Stadtbücherei Hilchenbach, Im Burgweiher 1, 57271 Hilchenbach",
"opened": "24 Stunden",
"inserted": "2017-05-23",
"lastupdate": "2017-05-23",
"remove": false
}
 
HTTP/1.1 200 OK
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 09 Nov 2021 10:23:09 GMT
Keep-Alive: timeout=60
Connection: keep-alive
 
{"id":18}
```