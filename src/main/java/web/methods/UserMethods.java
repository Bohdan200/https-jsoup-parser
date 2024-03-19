package web.methods;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.util.List;
import java.util.Map;
import web.user.User;

public class UserMethods {
    public static String get(String url) throws IOException {
        return Jsoup
                .connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
    }

    public static Type getType() {
        return TypeToken
                .getParameterized(List.class, User.class)
                .getType();
    }

    public static String post(String url, User newUser) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return Jsoup
                .connect(url)
                .requestBody(gson.toJson(newUser))
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .referrer("http://www.google.com")
                .ignoreHttpErrors(true)
                .ignoreContentType(true)
                .post()
                .body()
                .text();
    }

    public static String put(String url) throws IOException {

        return Jsoup
                .connect(url)
                .requestBody(new Gson().toJson(Map.of("id", "7", "name", "Henry Sonvar", "username", "Halk")))
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .referrer("http://www.google.com")
                .ignoreContentType(true)
                .headers(Map.of("Content-Type", "application/json; charset=UTF-8"))
                .method(Connection.Method.PUT)
                .execute()
                .body();
    }

    public static String remove(String url) throws IOException {
        return Jsoup
                .connect(url)
                .ignoreContentType(true)
                .method(Connection.Method.DELETE)
                .execute()
                .body();
    }
}
