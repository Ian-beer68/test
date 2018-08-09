# Go Henry Challenge



## Parents
## Requests
### Creating a Parent
### POST http://localhost:8080/parents
the following is an example Json Payload
```json
{
   "title":"Mrs",
   "firstName":"Jane",
   "lastName":"Doe",
   "emailAddress":"jane.doe@gohenry.co.uk",
   "dateOfBirth":"1990-06-03",
   "gender":"female",
   "secondName":"",
   "children":[
      {
         "firstName":"Janet",
         "lastName":"Doe",
         "emailAddress":"janet.doe@gohenry.co.uk",
         "dateOfBirth":"2010-05-22",
         "gender":"female",
         "secondName":""
      },
      {
         "firstName":"Jason",
         "lastName":"Doe",
         "emailAddress":"jason.doe@gohenry.co.uk",
         "dateOfBirth":"2008-12-05",
         "gender":"male",
         "secondName":""
      }
   ]
}

```
## Validation Rules


## Responses

If the rules are not met, the result will be a __400 Bad Request__ response, with a list of field names that are
incorrect
for example
```json
{
    "dateOfBirth": "not in the past",
    "firstName": "must not be null"
}
```

If the rules are met, then the caller will receive a __201 Accepted__ response, with a link to the newly created parent

```json
{
    "link":"http://localhost:8080/parents/1"
}
```

Other possible responses are:
* __401__ - Unauthorised
* __404__ - Not Found
* __500__ - Internal Server Error

### Retrieving a Parent
### GET http://localhost:8080/parents/{id}
example response
```json
{
   "id":1,
   "title":"Mrs",
   "firstName":"Jane",
   "lastName":"Doe",
   "emailAddress":"jane.doe@gohenry.co.uk",
   "dateOfBirth":"1990-06-03",
   "gender":"female",
   "secondName":"",
   "children":[
      {
         "id":2,
         "firstName":"Janet",
         "lastName":"Doe",
         "emailAddress":"janet.doe@gohenry.co.uk",
         "dateOfBirth":"2010-05-22",
         "gender":"female",
         "secondName":""
      },
      {
         "id":3,
         "firstName":"Jason",
         "lastName":"Doe",
         "emailAddress":"jason.doe@gohenry.co.uk",
         "dateOfBirth":"2008-12-05",
         "gender":"male",
         "secondName":""
      }
   ]
}


```


