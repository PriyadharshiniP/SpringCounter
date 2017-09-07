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

curl -v  -H "Authorization:Basic dXNlcjpwYXNzd29yZA==" -d "{\"searchText\":[\"Duis\", \"Sed\", \"Donec\", \"Augue\", \"Pellentesque\", \"123\"]}" http://localhost:8080/SpringServices/counter-api/search  -H "Content-Type:application/json" -X POST

Note: Unnecessary use of -X or --request, POST is already inferred.
*   Trying ::1...
* TCP_NODELAY set
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /SpringServices/counter-api/search HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.55.1
> Accept: */*
> Authorization:Basic dXNlcjpwYXNzd29yZA==
> Content-Type:application/json
> Content-Length: 71
>
* upload completely sent off: 71 out of 71 bytes
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: DENY
< X-Content-Type-Options: nosniff
< Set-Cookie: JSESSIONID=5958D64987EBA898590D927CDF7306D7; Path=/SpringServices; HttpOnly
< Content-Type: text/plain;charset=ISO-8859-1
< Content-Length: 88
< Date: Thu, 07 Sep 2017 21:32:03 GMT
<
{"counts":[{"Duis":11},{"Sed":16},{"Donec":8},{"Augue":7},{"Pellentesque":6},{"123":0}]}* Connection #0 to host localhost left intact

Task 2:
Run the following:

curl -v http://localhost:8080/SpringServices/top/5 -H "Authorization: Basic  dXNlcjpwYXNzd29yZA==" -H "Accept:text/csv"

*   Trying ::1...
* TCP_NODELAY set
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /SpringServices/top/5 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.55.1
> Authorization: Basic  dXNlcjpwYXNzd29yZA==
> Accept:text/csv
>
< HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: DENY
< X-Content-Type-Options: nosniff
< Set-Cookie: JSESSIONID=5F1FDED6B18C3FE1B07F58256AB1DD4B; Path=/SpringServices; HttpOnly
< Content-Type: text/csv;charset=ISO-8859-1
< Content-Length: 34
< Date: Thu, 07 Sep 2017 22:19:52 GMT
<
eget|17
vel|17
sed|16
in|15
et|14
* Connection #0 to host localhost left intact


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
