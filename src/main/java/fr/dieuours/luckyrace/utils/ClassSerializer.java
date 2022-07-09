package fr.dieuours.luckyrace.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
     * @param c Class<? extends ClassSerializer> c
     * @param json String
     * @return gson.fromJson(String, Class < ? extends ClassSerializer >);
     * @see ClassSerializer
     */
    public static Object deserialize(Class<? extends ClassSerializer> c, String json) {
        return gson.fromJson(json, c);
    }

    /**
     * @return this.gson.toJson(this);
     */
    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
