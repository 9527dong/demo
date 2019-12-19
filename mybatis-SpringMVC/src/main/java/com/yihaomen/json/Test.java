package com.yihaomen.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Item.class, new ItemDeserializer());
        mapper.registerModule(module);

        String json = "{\n"
            + "    \"id\": 1,\n"
            + "    \"itemName\": \"theItem\",\n"
            + "    \"createdBy\": 2\n"
            + "}";
        try {
            Item readValue = mapper.readValue(json, Item.class);
            System.out.println(readValue);
        } catch (IOException e) {

        }
    }
}
