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
# Parents
# Required Fields
title - not null or empty, mr mrs miss master dr

firstname - not null or empty

lastname - not null or empty

emailaddress - a valid email

dateOfBirth - a date in the past

gender - male or female

# Children
# Required Fields
firstname - not null or empty

lastname - not null or empty

emailaddress - a valid email

dateOfBirth - a date in the past

gender - male or female




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

If the rules are met, then the caller will receive a __201 Created__ response, with a link to the newly created parent

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

## Swagger
to generate swagger on the fly go to URL
```
http:\\localhost:8080\v2\api-docs
```

### output
```json
{
   "swagger":"2.0",
   "info":{
      "description":"Api Documentation",
      "version":"1.0",
      "title":"Api Documentation",
      "termsOfService":"urn:tos",
      "contact":{

      },
      "license":{
         "name":"Apache 2.0",
         "url":"http://www.apache.org/licenses/LICENSE-2.0"
      }
   },
   "host":"localhost:8080",
   "basePath":"/",
   "tags":[
      {
         "name":"parent-endpoint",
         "description":"Parent Endpoint"
      }
   ],
   "paths":{
      "/parents":{
         "post":{
            "tags":[
               "parent-endpoint"
            ],
            "summary":"createParent",
            "operationId":"createParentUsingPOST",
            "consumes":[
               "application/json"
            ],
            "produces":[
               "*/*"
            ],
            "parameters":[
               {
                  "in":"body",
                  "name":"parent",
                  "description":"parent",
                  "required":true,
                  "schema":{
                     "$ref":"#/definitions/ParentDTO"
                  }
               }
            ],
            "responses":{
               "200":{
                  "description":"OK",
                  "schema":{
                     "$ref":"#/definitions/ResponseEntity"
                  }
               },
               "201":{
                  "description":"Created"
               },
               "401":{
                  "description":"Unauthorized"
               },
               "403":{
                  "description":"Forbidden"
               },
               "404":{
                  "description":"Not Found"
               }
            }
         }
      },
      "/parents/{parent_id}":{
         "get":{
            "tags":[
               "parent-endpoint"
            ],
            "summary":"getParentWithChildren",
            "operationId":"getParentWithChildrenUsingGET",
            "consumes":[
               "application/json"
            ],
            "produces":[
               "application/json"
            ],
            "parameters":[
               {
                  "name":"parent_id",
                  "in":"path",
                  "description":"parent_id",
                  "required":true,
                  "type":"integer",
                  "format":"int64"
               }
            ],
            "responses":{
               "200":{
                  "description":"OK",
                  "schema":{
                     "$ref":"#/definitions/ResponseEntity"
                  }
               },
               "401":{
                  "description":"Unauthorized"
               },
               "403":{
                  "description":"Forbidden"
               },
               "404":{
                  "description":"Not Found"
               }
            }
         }
      }
   },
   "definitions":{
      "ResponseEntity":{
         "type":"object",
         "properties":{
            "body":{
               "type":"object"
            },
            "statusCode":{
               "type":"string",
               "enum":[
                  "100",
                  "101",
                  "102",
                  "103",
                  "200",
                  "201",
                  "202",
                  "203",
                  "204",
                  "205",
                  "206",
                  "207",
                  "208",
                  "226",
                  "300",
                  "301",
                  "302",
                  "303",
                  "304",
                  "305",
                  "307",
                  "308",
                  "400",
                  "401",
                  "402",
                  "403",
                  "404",
                  "405",
                  "406",
                  "407",
                  "408",
                  "409",
                  "410",
                  "411",
                  "412",
                  "413",
                  "414",
                  "415",
                  "416",
                  "417",
                  "418",
                  "419",
                  "420",
                  "421",
                  "422",
                  "423",
                  "424",
                  "426",
                  "428",
                  "429",
                  "431",
                  "451",
                  "500",
                  "501",
                  "502",
                  "503",
                  "504",
                  "505",
                  "506",
                  "507",
                  "508",
                  "509",
                  "510",
                  "511"
               ]
            },
            "statusCodeValue":{
               "type":"integer",
               "format":"int32"
            }
         }
      },
      "ChildDTO":{
         "type":"object",
         "required":[
            "dateOfBirth",
            "emailAddress",
            "firstName",
            "gender",
            "id",
            "lastName",
            "secondName"
         ],
         "properties":{
            "dateofBirth":{
               "type":"string",
               "format":"date"
            },
            "id":{
               "type":"integer",
               "format":"int64"
            },
            "firstName":{
               "type":"string"
            },
            "lastName":{
               "type":"string"
            },
            "secondName":{
               "type":"string"
            },
            "emailAddress":{
               "type":"string"
            },
            "dateOfBirth":{
               "type":"string",
               "format":"date"
            },
            "gender":{
               "type":"string"
            }
         }
      },
      "ParentDTO":{
         "type":"object",
         "required":[
            "children",
            "dateOfBirth",
            "emailAddress",
            "firstName",
            "gender",
            "id",
            "lastName",
            "secondName",
            "title"
         ],
         "properties":{
            "id":{
               "type":"integer",
               "format":"int64"
            },
            "title":{
               "type":"string"
            },
            "firstName":{
               "type":"string"
            },
            "secondName":{
               "type":"string"
            },
            "lastName":{
               "type":"string"
            },
            "emailAddress":{
               "type":"string"
            },
            "dateOfBirth":{
               "type":"string",
               "format":"date"
            },
            "gender":{
               "type":"string"
            },
            "children":{
               "type":"array",
               "items":{
                  "$ref":"#/definitions/ChildDTO"
               }
            }
         }
      }
   }
}
```
