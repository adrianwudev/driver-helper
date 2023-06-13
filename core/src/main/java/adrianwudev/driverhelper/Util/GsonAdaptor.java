package adrianwudev.driverhelper.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

public class GsonAdaptor<T> {
    public String getJsonWithGsonAdaptor(T object){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter()).create();
        return gson.toJson(object);
    }
}
