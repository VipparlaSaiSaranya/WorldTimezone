# Timezone API

## Problme Statement
```
Below are the coding exercise instructions:

1. Create a spring boot microservice the exposes an API

2. The API will expose a single “GET” “time” API that takes a parameter “timezone”

3. The API will validate that the timezone parameter is within the US timezones

4. It will throw an error if the parameter is not a valid timezone

5. It will return an error if it is not a US timezone

6. The microservice will make a call to the public API at worldtimeapi.org

7. The API will return only the abbreviation, timezone, and datetime fields in json format

```

## Getting Started

This application was developed using Spring Boot.

## Requirements

Java - 11

Maven - 4.x.x

Spring Boot - 2.7.10-SNAPSHOT

## Steps to Setup

- In Eclipse/Spring STS import WorldTimezone Project

### How to import : 
	- Click on File menu
	- Click on Import sub menu
	- Search for 'Existing projects into Workspace' option and click next
	- Browse folder and click on finish

### Build and run the app using maven

	- Right click on project and click on Run As.. and then click on Maven Test
	- Once build is successful then right click and Run as Spring Boot Application
	
The app can be accessed at <http://localhost:8080> from any modern browser.

## Explore Rest APIs

The App defines following CRUD APIs.

APIs:

- GET - /time?timezone="timezonename" - Get Timezone details

### Sample API and Response details
```
Request:

http://localhost:8080/time?timezone=America/Los_Angeles

Response : 

{
    "abbreviation": "PDT",
    "timezone": "America/Los_Angeles",
    "datetime": "2023-03-21T06:08:08.106535-07:00"
}
```

You can test them using postman or any other rest client.