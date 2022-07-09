package fr.dieuours.luckyrace.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class ClassSerializer {

    private static final Gson gson;

    static {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

    /**
     * @return gson
     * @see Gson
     */
    public static Gson getGson() {
        return gson;
    }

    /**
     * @param c
     * @param json
     * @return gson.fromJson(String, Class < ? extends ClassSerializer >);
     * @see ClassSerializer
     * @see Class
     */
    public static <T> T deserialize(Class<? extends ClassSerializer> c, String json) {
        return gson.fromJson(json, (Type) c);
    }

    /**
     * @return this.gson.toJson(this);
     */
    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
