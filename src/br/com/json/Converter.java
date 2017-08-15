package br.com.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Converter {

    public static String objectToJson(Object object) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.writeValueAsString(object);
    }

    public static <T> T jsonToObject(String json, Class<T> c) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, c);
    }

    public static <T> T jsonToObject(String json, String c) throws Exception {
        return jsonToObject(json, (Class<T>) Class.forName(c));
    }

    public static <T> List<T> jsonListToObject(String json, String c) throws Exception {
        return jsonListToObject(json, (Class<T>) Class.forName(c));
    }

    public static <T> List<T> jsonListToObject(String json, Class<T> c) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, c));
    }

    public static <T> Set<T> jsonSetToObject(String json, Class<T> c) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(Set.class, c));
    }

    public static <T> T[] jsonArrayToObject(String json, Class<T> c) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, mapper.getTypeFactory().constructArrayType(c));
    }

    public static <K, V> Map<K, V> jsonMapToObject(String json, String keyClass, String valueClass) throws Exception {
        return jsonMapToObject(json, (Class<K>) Class.forName(keyClass), (Class<V>) Class.forName(valueClass));
    }

    public static <K, V> Map<K, V> jsonMapToObject(String json, Class<K> keyClass, Class<V> valueClass) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, keyClass, valueClass));
    }
}
