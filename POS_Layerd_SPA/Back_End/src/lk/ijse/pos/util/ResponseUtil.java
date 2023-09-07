package lk.ijse.pos.util;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class ResponseUtil {
    public static JsonObject getJson(String state, String message, JsonArray...data){
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        jsonObjectBuilder.add("state",state);
        jsonObjectBuilder.add("message", message);

        if (data.length>0){
            jsonObjectBuilder.add("data",data[0]);
        }else {
            jsonObjectBuilder.add("data","");
        }
        return jsonObjectBuilder.build();
    }
}
