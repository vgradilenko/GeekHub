package serializer.json.adapter;

import java.time.*;


/**
 * Converts object of type java.time.LocalDate to String by using ISO 8601 format
 */
public class LocalDateAdapter implements JsonDataAdapter<LocalDate> {

    @Override
    public Object toJson(LocalDate date) {
        return date.toString();
    }
}
