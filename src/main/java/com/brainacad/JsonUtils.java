package com.brainacad;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;



import java.util.List;

public class JsonUtils {
    /*
     * FOR DEBUG
     *
    static String jsonpathCreatorNamePath = "$['tool']['jsonpath']['creator']['name']";
    static String jsonpathCreatorLocationPath = "$['tool']['jsonpath']['creator']['location'][*]";
    private static String jsonString = "{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/mrmoiree/128.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg\"}]}";

    private static String jsonPathInt = "$.total";

    public static void main(String[] args) {
        int n = intFromJSONByPath(jsonString, jsonPathInt);
        System.out.println(n);
    }
    /*
     * */

    //Extract integer from JSON
    public static int intFromJSONByPath(String jsonString, String jsonPath) {
      return JsonPath.parse(jsonString).read(jsonPath);
    }

    //Extract String from JSON
    public static String stringFromJSONByPath(String jsonString, String jsonPath) {
       return JsonPath.parse(jsonString).read(jsonPath);
     }

    //Extract double from JSON
    public static double doubleFromJSONByPath(String jsonString, String jsonPath){
        return JsonPath.parse(jsonString).read(jsonPath);
     }

    //Extract List<> from JSON
    public static List listFromJSONByPath(String jsonString, String jsonPath) {
        return JsonPath.parse(jsonString).read(jsonPath);
    }

}
