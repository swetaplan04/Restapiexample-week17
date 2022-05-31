package com.restapiexample.dummy.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://dummy.restapiexample.com";
        RestAssured.basePath = "/api/v1/employees";
        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }

    //1. total records are 24
    @Test
    public void test001() {
        int records = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The number of records are : " + records);
        System.out.println("------------------End of Test---------------------------");
    }
    //2. data[23].id = 24
    @Test
    public void test002() {
        int id = response.extract().path("data[23].id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The data[23] id is : " + id);
        System.out.println("------------------End of Test---------------------------");
    }
    //3. data[23].employee_name = “Doris Wilder”
    @Test
    public void test003() {
        String name = response.extract().path("data[23].employee_name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The data[23] employee name is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }
    //4. message = “Successfully! All records has been fetched.”
    @Test
    public void test004() {
        String msg = response.extract().path("message");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The message is : " + msg);
        System.out.println("------------------End of Test---------------------------");
    }

    //5.status = success
    @Test
    public void test005() {
        String status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of status is : " + status);
        System.out.println("------------------End of Test---------------------------");
    }
    //6. id = 3 has employee_salary = 86000
    @Test
    public void test006() {
        int salary=0;
        if((response.extract().path("data[2].id")).equals(3)) {
            salary = response.extract().path("data[2].employee_salary");
        }
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id = 3 has employee_salary : " + salary);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. id = 6 has employee_age = 61
    @Test
    public void test007() {
        int age=0;
        if((response.extract().path("data[5].id")).equals(6)) {
            age = response.extract().path("data[5].employee_age");
        }
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id = 6 has employee_age : " + age);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. id = 11 has employee_name = Jena Gaines
    @Test
    public void test008() {
        String name="";
        if((response.extract().path("data[10].id")).equals(11)) {
            name = response.extract().path("data[10].employee_name");
        }
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id = 11 has employee_name : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

}