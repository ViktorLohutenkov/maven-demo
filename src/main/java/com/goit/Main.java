package com.goit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.goit.dto.User;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("name.json")) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();
            User fromJson = gson.fromJson(new String(resourceAsStream.readAllBytes()), User.class);
            String toJson = gson.toJson(fromJson);
            System.out.println(toJson);
        }
    }
}