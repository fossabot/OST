package ch.unstable.ost.api.search.types;


import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class SearchCHIconClassDeserializer implements JsonDeserializer<ch.unstable.ost.api.model.impl.Location.StationType> {
    private static final String TAG = SearchCHIconClassDeserializer.class.getSimpleName();

    @Override
    public ch.unstable.ost.api.model.impl.Location.StationType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String iconClass = json.getAsString();
        switch (iconClass) {
            case "sl-icon-type-zug":
                return ch.unstable.ost.api.model.impl.Location.StationType.TRAIN;
            case "sl-icon-type-bus":
                return ch.unstable.ost.api.model.impl.Location.StationType.BUS;
            case "sl-icon-type-tram":
                return ch.unstable.ost.api.model.impl.Location.StationType.TRAM;
            case "sl-icon-type-adr":
                return ch.unstable.ost.api.model.impl.Location.StationType.ADDRESS;
            default:
                Log.w(TAG, "Unknown class: " + iconClass);
                return ch.unstable.ost.api.model.impl.Location.StationType.UNKNOWN;
        }
    }
}
