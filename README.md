## REST API에 반응하는 localWebServer 앱 구축
bithumb tech academy second pop homework

#### Spec
- Spring 5+, Java 11+, WebFlux, Functional EndPoint

#### Request
```
GET localhost:8080/hello?name$name
```

#### Response
- aplication/json
```
{
  "to": `${name}`,
  "message": `hello ${name}
}
