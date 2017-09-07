package com.intelliment;


import static com.jayway.restassured.RestAssured.expect;
//import groovyx.net.http.ContentType;


import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
//Note - ALL the Test cases are tested using tools 
// Advanced REST Client and CURL externally.
public class AppTest{

    @Before
    public void setUp(){
        RestAssured.basePath = "http://localhost:8080/SpringCounter";
    }

    @Test
    public void testGetTopSearch(){
        expect().statusCode(200).when()
                .get("/top/3");
    }

}
	


