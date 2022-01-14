package com.zyx_hunan.baseutil.net.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class JSONFormatter {

    static final JSONFormatter FORMATTER = findJSONFormatter();

    public static String formatJSON(String source) {
        try {
            return FORMATTER.format(source);
        } catch (Exception e) {
            return "";
        }
    }

    String format(String source) {
        return "";
    }

    private static JSONFormatter findJSONFormatter() {
        JSONFormatter gsonFormatter = GsonFormatter.buildIfSupported();
        if (gsonFormatter != null) {
            return gsonFormatter;
        }
        return new JSONFormatter();
    }

    static class GsonFormatter extends JSONFormatter {
        private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        private final JsonParser PARSER = new JsonParser();

        @Override
        String format(String source) {
            return GSON.toJson(PARSER.parse(source));
        }

        static JSONFormatter buildIfSupported() {
            try {
                Class.forName("com.google.gson.Gson");
                return new GsonFormatter();
            } catch (ClassNotFoundException ignore) {
                return null;
            }
        }

    }
}
