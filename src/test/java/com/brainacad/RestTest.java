package com.brainacad;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RestTest{

    private static final String URL="https://reqres.in";

    @Test//GET метод
    public void checkGetResponseStatusCode() throws IOException {
        String endpoint="/api/users";

        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.get(URL+endpoint,"page=2");

        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
    }

    @Test//GET метод
    public void checkGetResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";

        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.get(URL+endpoint,"?page=2");

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//GET метод LIST USERS
    public void getListUsers() throws IOException {
        String endpoint="/api/users";

        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.get(URL+endpoint,"page=2");

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        int n = JsonUtils.intFromJSONByPath(body, "$.total");
        Assert.assertEquals("Total number of users = 12", 12, n);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//GET метод SINGLE USER
    public void getSingleUser() throws IOException {
        String endpoint="/api/users/2";

        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.get(URL+endpoint,"");
        System.out.println("response is: "+response);

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        String fName = JsonUtils.stringFromJSONByPath(body, "$.data.first_name");
        String lName = JsonUtils.stringFromJSONByPath(body, "$.data.last_name");
            Assert.assertNotEquals("Body shouldn't be null", null, body);
            Assert.assertEquals("First name of user - 'Janet'", "Janet", fName);
            Assert.assertEquals("Last name of user - 'Weaver'", "Weaver", lName);
    }

    @Test//DELETE метод
    //TODO: clarify what to put in headers
    public void deleteMethod() throws IOException {
        String endpoint = "/api/users/2";

        HttpResponse response = HttpClientHelper.delete(URL+endpoint,"");
        System.out.println("response is: " + response);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 204", 204, statusCode);
    }

    @Test//POST метод CREATE
    public void checkPostResponseStatusCode() throws IOException {
        String endpoint="/api/users";

        //создаём тело запроса
        String requestBody="{\"name\": \"morpheus\",\"job\": \"leader\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.post(URL+endpoint, requestBody );

        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        String body=HttpClientHelper.getBodyFromResponse(response);
            Assert.assertEquals("Response status code should be 201", 201, statusCode);
    }

    @Test//POST метод
    public void checkPostResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";

        //создаём тело запроса
        String requestBody="{\"name\": \"morpheus\",\"job\": \"leader\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.post(URL+endpoint,requestBody);

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//POST метод create user
    public void checkPostCreateUser() throws IOException {
        String endpoint="/api/users";

        //создаём тело запроса
        String requestBody="{\"name\": \"den\",\"job\": \"tester\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.post(URL+endpoint, requestBody);

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(body);
        String name = JsonUtils.stringFromJSONByPath(body, "$.name");
            Assert.assertEquals("Response status code should be 201", 201, statusCode);
            Assert.assertEquals("Name of user - 'den'", "den", name);
    }

    @Test//PUT метод UPDATE
    public void checkPutUpdateUser() throws IOException {
        String endpoint = "/api/users";

        //создаём тело запроса
        String requestBody="{\"name\": \"updated_user\",\"job\": \"updated_job\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.put(URL+endpoint, requestBody);
        String body=HttpClientHelper.getBodyFromResponse(response);
        int statusCode = response.getStatusLine().getStatusCode();
        String name = JsonUtils.stringFromJSONByPath(body, "$.name");
            Assert.assertEquals("Response status code should be 200", 200, statusCode);
            Assert.assertEquals("Name of new user - 'updated_user'", "updated_user", name);
    }

    //TODO: напишите по тесткейсу на каждый вариант запроса на сайте https://reqres.in
    //TODO: в тескейсах проверьте Result Code и несколько параметров из JSON ответа (если он есть)

}
