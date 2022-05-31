package com.restapiexample.dummy.restapidymmy;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateEmployeeRecord extends TestBase {

    @Test
    public void createUserLoginRecord(){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setEmployee_name("Rhona Davidson");
        employeePojo.setEmployee_salary(50000);
        employeePojo.setEmployee_age(30);
        employeePojo.setProfile_image("");

        Response response = given()
                .header("Content-Type","application/json")
                .pathParam("id",21)
                .body(employeePojo)
                .when()
                .put("/update/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
