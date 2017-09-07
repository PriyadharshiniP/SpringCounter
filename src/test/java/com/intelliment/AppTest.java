package com.intelliment;


import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
 

/**
 * This is an Unit testing program using REST Assured framework to validate the 2 Spring Services
 * Note - ALL the other Test cases are tested using  the tools
 * Advanced REST Client and CURL externally.
 * 
 * @author priya
 * v 1.1
 *
 */
public class AppTest{

    @Before
    public void setUp(){
        RestAssured.basePath = "http://localhost:8080/SpringServices";
    }

    @Test
    public void testGetTopSearch(){
    	
    	//Test POST Service
    	given().header("Authorization", "Basic dXNlcjpwYXNzd29yZA==").contentType("application/json").
    	body("{\"searchText\":[\"Duis\", \"Sed\", \"Done\", \"Augue\", \"Pellentesque\", \"123\"]}").expect().statusCode(200).when().post("http://localhost:8080/SpringServices/counter-api/search");
    	
    	//Test GET Service
    	given().auth().basic("user", "password").expect().statusCode(200).when().get("http://localhost:8080/SpringServices/top/3");
    }

}
	


