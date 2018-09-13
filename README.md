# Hotel Service
## Deployment Instructions

### Prerequisites
    Run the project available at https://github.com/NandaBalakrishnan/my-hotel-service.git in the same machine where this project to be deployed or deploy it anywhere and configure the url host in appliction.proprties

1) Replace the credentials of mongoDB in the application.properties file
2) From command prompt navigate to the folder where the pom.xml file located
3) Run the command mvn clean package
4) Run the mvn install will create the jar under ./target/**.jar 
4) Jar will be created in the folder ./target/**.jar
5) Run the jar by the command java -jar target/**.jar
6) In case of IDE, run the project as spring boot app


# Configuration
 * port no : 8086 (configurable in application.properties)
 * MongoDB : This api connects to the onprem DB as well(can be replaced with mongoDB cloud (Atlas). The Connection string is configurable in application.properties). MongoDB should be up and running in the same machine where the service is deployed.
    
 * Basic Authentication: username and password can be configurable.
 * authorization header is Basic (base64encode(username:password)

## This API exposes the following endpoints

## GET /hotels/details

Description : This will respond with the complete set of all hotels available with its hotel information.

Required Headers : Accept = "application/json" Authorization = "Basic(base64encode(username:password)"

## GET  /hotels/details/"hotelId"

Description : This will respond with the details of the hotel with id "hotelId"

Required Headers : Accept = "application/json" Authorization = "Basic(base64encode(username:password)"

## POST  /hotels/details/

Description : This will create a new hotel with its details

Required Headers : Accept = "application/json" Authorization = "Basic(base64encode(username:password)" Content-Type = "application/json"

Request Body :{"id": 999, "name":"IBIS" ,"description": "grt_hotel", "city":"Bangalore","rating":4}

## PUT  /hotels/details/

Description : This will update a existing hotel details

Required Headers : Accept = "application/json" Authorization = "Basic(base64encode(username:password)"  Content-Type = "application/json"

Request Body : Request Body : {"id": 999, "name":"IBIS" ,"description": "grt_hotel", "city":"Bangalore","rating":4}

## DELETE  /hotels/details/"hotelId"

Description : This will delete the details of the hotel with an Id "hotelId"

Required Headers : Accept = "application/json" Authorization = "Basic(base64encode(username:password)"
