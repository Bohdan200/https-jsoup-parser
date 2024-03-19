package web.methods;

import org.jsoup.Jsoup;
import java.io.IOException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class DataMethods {
    public static String get(String url) throws IOException {
        return Jsoup
                .connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
    }

    public static Type getType(Type className) {
        return TypeToken
                .getParameterized(List.class, className)
                .getType();
    }
}
