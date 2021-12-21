# REST API for People Management

![image](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![image](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![image](https://img.shields.io/badge/Heroku-430098?style=for-the-badge&logo=heroku&logoColor=white)

This REST API was developed as a hands-on programming exercise, using Java Spring + H2 SQL Database + Heroku deploy.

Implements the main HTTP methods: <code>GET</code>, <code>POST</code>, <code>PUT</code> and <code>DELETE</code>. Assisting in creating, updating, querying and removing data with CPF validation. 

## Base URL

    http://localhost:8080/api/v1/people

## Heroku URL

    https://myperson-management-api.herokuapp.com/api/v1/people

## Resourse Information

<table>
 <tr>
  <td>
    Response formats
  </td>
  <td>
    JSON
  </td>
 </tr>
 <tr>
  <td>
    Requires authentication?
  </td>
  <td>
    No
  </td>
 </tr>
 <tr>
  <td>
    Available pagination?
  </td>
  <td>
    No
  </td>
 </tr>
</table>

## Examples

### <code>***POST***</code> Request:

    .../api/v1/people

Must provide a valid CPF number.

*Request example:*
```json
{
    "firstName": "Fulano",
    "lastName": "de Tal",
    "cpf": "000.000.000-00",
    "birthDate": "dd-MM-yyyy",
    "phones": [
        {
            "type": "MOBILE",
            "ddd": "00",
            "number": "99999-9999"
        }
    ]
}
```

### <code>***GET***</code> People by Id:

    .../api/v1/people/{id}

*Response example:*
```json
{
    "idPerson": 2,
    "firstName": "Beltrano",
    "lastName": "de Tal",
    "cpf": "111.111.111-11",
    "birthDate": "yyyy-MM-dd",
    "phones": [
      {
        "idPhone": 2,
        "type": "MOBILE",
        "ddd": "00",
        "number": "99999-9999"
      }
    ]
}
```

### <code>***GET***</code> All People:

    .../api/v1/people

*Response example:*
```json
[
  {
    "idPerson": 1,
    "firstName": "Fulano",
    "lastName": "de Tal",
    "cpf": "000.000.000-00",
    "birthDate": "yyyy-MM-dd",
    "phones": [
      {
        "idPhone": 1,
        "type": "MOBILE",
        "ddd": "00",
        "number": "99999-9999"
      }
    ]
  },
  {
    "idPerson": 2,
    "firstName": "Beltrano",
    "lastName": "de Tal",
    "cpf": "111.111.111-11",
    "birthDate": "yyyy-MM-dd",
    "phones": [
      {
        "idPhone": 2,
        "type": "MOBILE",
        "ddd": "00",
        "number": "99999-9999"
      }
    ]
  }
]
```

### <code>***PUT***</code> Request:

    .../api/v1/people/{id}

Must provide a valid *idPerson* and *idPhone*.

*Request example:*
```json
{
    "idPerson": 1,
    "firstName": "Fulano",
    "lastName": "de Tal",
    "cpf": "000.000.000-00",
    "birthDate": "dd-MM-yyyy",
    "phones": [
        {
            "idPhone": 1,
            "type": "MOBILE",
            "ddd": "00",
            "number": "99999-9999"
        }
    ]
}
```

### <code>***DELETE***</code> Request:

    .../api/v1/people/{id}

Must provide a valid *idPerson*.

