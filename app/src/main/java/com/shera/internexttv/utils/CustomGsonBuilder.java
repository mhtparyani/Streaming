package com.shera.internexttv.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by Nishikant on 12/14/2015.
 */
public class CustomGsonBuilder {


    public static GsonBuilder getInstance()
    {
        JsonSerializer<Date> ser = new JsonSerializer<Date>() {
            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext
                    context) {
                return src == null ? null : new JsonPrimitive(src.getTime());
            }
        };

        JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, Type typeOfT,
                                    JsonDeserializationContext context) throws JsonParseException {
                if(json.isJsonObject()){
                    JSONObject jsonObject= null;
                    try {
                        jsonObject = new JSONObject(json.getAsJsonObject().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return json == null ? null : new Date(jsonObject.optLong("millis"));
                }else {
                    return json == null ? null : new Date(json.getAsLong());
                }

            }
        };

        return new GsonBuilder()
                .registerTypeAdapter(Date.class, ser)
                .registerTypeAdapter(Date.class, deser);
    }

}
