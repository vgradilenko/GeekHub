package serializer.json.adapter;

import org.json.JSONArray;
import org.json.JSONException;
import serializer.json.JsonSerializer;

import java.util.Collection;

/**
 * Converts all objects that extends java.util.Collections to JSONArray.
 */
public class CollectionAdapter implements JsonDataAdapter<Collection> {

    @Override
    public Object toJson(Collection c) throws JSONException {
        JSONArray objects = new JSONArray();

        for (Object o : c) {
            objects.put(JsonSerializer.serialize(o));
        }

        return objects;
    }
}
