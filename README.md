# TODO App - REST API Documentation
RESTful API Designed in Kotlin and Spring for a very simple TODO application.

## Index
* [Requirements](#requirements)
* [Installation](#installation)
* [Schema](#schema)
* [Authentication](#authentication)
* [Root End-Point](#root-end-point)
* [Core Resources](#core-resources)
* [Documentation](#documentation)
* [Request & Response Examples](#request--response-examples)

## Requirements

- [kotlin & spring](https://spring.io/projects/spring-framework)
- [Postgresql](https://www.postgresql.org/): Make sure you have your own local db ( you can use docker )
- [PostMan](https://www.getpostman.com/): for testing the api

## Installation

1. Clone the repository
2. Install the application
3. Place your own Postgresql URI in `aplicattion-local.yml`
3. Start the server: `gradel bootRunLocal`
4. Open PostMan and make a `GET` request to `http://127.0.0.1:3000/api/v1/todo`

## Schema

1. All API access is over HTTP, and accessed from `http://localhost:3000/api/v1`.
2. All data is sent and received as JSON.
3. Blank fields are included as `null` instead of being omitted.
4. All timestamps return in ISO 8601 format: `YYYY-MM-DDTHH:MM:SSZ`

## Authentication
There are no authentication implemented yet. So, all the end-points are open.

## Root End-Point
`http://localhost:3000/api/v1`

## Core Resources
### Todo
`Todo` object represents snapshot of a specific Todo with a unique Id. You can retrieve it to see details about the Todo.

#### Schema
```javascript
{
    title: {
        type: String,
        required: true
    },
    description: {
        type: String,
        required: true,
        default: 'N/A'
    },
    onDate: {
        type: Date,
        required: true,
        default: Date.now
    },
    isCompleted: {
        type: Boolean,
        required: true,
        default: false
    }
}
```
#### End-Points
| Method | End-Point | Description |
| --- | --- | --- |
| `GET` | `/todo` | List all *todos* |
| `POST` | `/todo` | Create a new *todo* |
| `GET` | `/todo/:id` | Fetch a specific *todo* |
| `PUT` | `/todo/:id` | Edit existing *todo* |
| `PATCH` | `/todo/:id` | Mark an existing *todo* as complete |
| `DELETE` | `/todo/:id` | Delete existing *todo* |

## Documentation
https://documenter.getpostman.com/view/8474302/SVfGyBSu

## Request & Response Examples

### API Resources
- [GET /todo](#get-todo)
- [GET /todo/:todoId](#get-todotodoId)
- [POST /todo](#post-todo)
- [PUT /todo/:todoId](#put-todotodoId)
- [PATCH /todo/:todoId](#patch-todotodoId)
- [DELETE /todo/:todoId](#delete-todotodoId)

### GET /todo
To get the list of all *todos*
#### Resourse Url
`http://localhost:3000/api/v1/todo`
#### Request Params
`N/A`
#### Request Body
`N/A`
#### Response
```javascript
{
    "items": [
        {
            "description": "Write documentation for Todo API",
            "isCompleted": false,
            "id": "5d56e2bbc2a36326a0a57c19",
            "title": "Write Documentation",
            "onDate": "2019-08-16T15:47:30.889Z",
        },
        {
           
            "description": "Write Test-Cases for Todo API",
            "isCompleted": false,
            "id": "5d56e320c2a36326a0a57c1a",
            "title": "Write Test-Cases",
            "onDate": "2019-08-16T15:47:30.889Z",
        }
    ],
    "total": 2
}
```

### GET /todo/:todoId
To get a specific *todo*
#### Resourse Url
`http://localhost:3000/api/v1/todo/{{TODO_ID}}`
#### Request Params
`{{TODO_ID}}`
#### Request Body
`N/A`
#### Response
```javascript
{
    "data": {
        "description": "Write documentation for Todo API",
        "isCompleted": false,
        "id": "5d56e2bbc2a36326a0a57c19",
        "title": "Write Documentation",
        "onDate": "2019-08-16T15:47:30.889Z"
    }
}
```

### POST /todo
To create a new *todo*
#### Resourse Url
`http://localhost:3000/api/v1/todo`
#### Request Params
`N/A`
#### Request Body
```javascript
{
    "title": "Write Test-Cases",
    "description": "Write Test-Cases for Todo API",
    "onDate": "2019-08-16T15:47:30.889Z",
}
```
#### Response
```javascript
{
    "data": {
        "description": "Write Test-Cases for Todo API",
        "isCompleted": false,
        "id": "5d56e320c2a36326a0a57c1a",
        "title": "Write Test-Cases",
        "onDate": "2019-08-16T15:47:30.889Z",
    }
}
```

### PUT /todo/:todoId
To edit an existing *todo*
#### Resourse Url
`http://localhost:3000/api/v1/todo/{{TODO_ID}}`
#### Request Params
`{{TODO_ID}}`
#### Request Body
```javascript
{
    "title": "UPDATED: Write Documentation",
    "description": "UPDATED: Write documentation for Todo API"
}
```
#### Response
```javascript
{
    "data": {
        "description": "UPDATED: Write documentation for Todo API",
        "isCompleted": true,
        "id": "5d56e2bbc2a36326a0a57c19",
        "title": "UPDATED: Write Documentation",
        "onDate": "2019-08-16T15:47:30.889Z",
    }
}
```
### PATCH /todo/:todoId
To mark a *todo* as Complete
#### Resourse Url
`http://localhost:3000/api/v1/todo/{{TODO_ID}}`
#### Request Params
`{{TODO_ID}}`
#### Request Body
`N/A`
#### Response
```javascript
{
    "data": {
        "description": "Write documentation for Todo API",
        "isCompleted": true,
        "id": "5d56e2bbc2a36326a0a57c19",
        "title": "Write Documentation",
        "onDate": "2019-08-16T15:47:30.889Z",
    }
}
```

### DELETE /todo/:todoId
To delete an existing *todo*
#### Resourse Url
`http://localhost:3000/api/v1/todo/{{TODO_ID}}`
#### Request Params
`{{TODO_ID}}`
#### Request Body
`N/A`
#### Response
```javascript
no content ( status 201 )
```