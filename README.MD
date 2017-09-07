# Project Title

Inteliment Screening Test - Implement RESTful Services, which provide the solution of the following tasks, given the sample paragraphs. Also protect the services with Spring Security

Task 1: Search the following texts, which will return the counts respectively.

User should be able to execute the following curl command and returning results in the json format:

Sample Request
> curl http://host/counter-api/search -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" - d’{“searchText”:[“Duis”, “Sed”, “Donec”, “Augue”, “Pellentesque”, “123”]}’ -H"Content- Type: application/json" –X POST

Result in JSON:
> {"counts": [{"Duis": 11}, {"Sed": 16}, {"Donec": 8}, {"Augue": 7}, {"Pellentesque": 6},
{"123": 0}]}

Task 2: Provide the top 20 (as Path Variable) Texts, which has the highest counts in the Sample Paragraphs provided.

As a user, I will be able to execute the following curl command and expecting result in csv format. I will be able to put 10, 20, 30 or 5 as the top listing.

Sample Request
> curl http://host/counter-api/top/20 -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" - H”Accept: text/csv”

As an example of the result if I put /top/5: text1|100
text2|91 text3|80 text4|70 text5|60

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software 

Eclipse - IDE - http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/indigosr2

JAVA JDK 1.8 -
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Spring Dev Jars -
https://mvnrepository.com/tags/spring

Tomcat Application server 7-
https://tomcat.apache.org/

Curl -
https://curl.haxx.se/download.html

### Installing

1.Download the code from Github. Set the Environmental PATH, JAVA_HOME, MAVEN_HOME, CURL Path in the System.
2.The input Paragraph is in the resources folder.
3. Run the following command to see the desired results:
Task 1:
Run the following:

curl http://localhost:8080/SpringCounter-1.0-SNAPSHOT/counter-api/search -H"Authorization: Basic dXNlcjpwYXNzd29yZA==" - d"{\"searchText\":[\"Duis\", \"Sed\", \"Donec\", \"Augue\", \"Pellentesque\", \"123\"]}"  -H "Content-Type:application/json" –X POST

The result is:
Note: Unnecessary use of -X or --request, POST is already inferred.
*   Trying ::1...
* TCP_NODELAY set
* connect to ::1 port 8080 failed: Connection refused
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /SpringCounter/counter-api/search HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.55.1
> Accept: */*
> Authorization:Basic dXNlcjpwYXNzd29yZA==
> Content-Type:application/json
> Content-Length: 70
>
* upload completely sent off: 70 out of 70 bytes
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: DENY
< X-Content-Type-Options: nosniff
< Set-Cookie: JSESSIONID=9B3097537F5A4812A43ACD0DA213577C; Path=/SpringCounter; HttpOnly
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Thu, 07 Sep 2017 07:37:44 GMT
<
{"searchText":[{"Duis":11},{"Sed":16},{"Done":0},{"Augue":7},{"Pellentesque":6},{"123":0}]}* Connection #0 to host localhost left intact

Task 2:
Run the following:

curl http://localhost:8080/SpringCounter/top/5 -H "Authorization: Basic  dXNlcjpwYXNzd29yZA==" -H "Accept: text/csv"

The result is :
*   Trying ::1...
* TCP_NODELAY set
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /SpringCounter/top/5 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.55.1
> Accept: */*
> Authorization: Basic  dXNlcjpwYXNzd29yZA==
> Accept-CharSet:text/csv
>
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: DENY
< X-Content-Type-Options: nosniff
< Set-Cookie: JSESSIONID=0C54D8BA9C9F86668ADE9988C061327C; Path=/SpringCounter; HttpOnly
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Thu, 07 Sep 2017 06:35:20 GMT
<
{"searchText":["eget,17","\n","vel,17","\n","sed,16","\n","in,15","\n","et,14","\n"]}* Connection #0 to host localhost left intact

## Built With


* [Maven](https://maven.apache.org/) - Dependency Management


## Author

* **Priya** - *Initial work*

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
