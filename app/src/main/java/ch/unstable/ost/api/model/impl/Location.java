package ch.unstable.ost.api.model.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Arrays;

import ch.unstable.ost.utils.ParcelUtils;

import static ch.unstable.ost.utils.ObjectsCompat.requireNonNull;


public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
    private final String name;
    private final StationType type;
    @Nullable
    private final String id;

    public Location(String name, StationType type, @Nullable String id) {
        this.name = requireNonNull(name, "name");
        this.type = requireNonNull(type, "type");
        this.id = id;
    }

    protected Location(Parcel in) {
        name = in.readString();
        id = in.readString();
        type = ParcelUtils.readEnum(StationType.values(), in);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
        ParcelUtils.writeEnum(dest, type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getId() {
        if (id == null) {
            return name;
        } else {
            return id;
        }
    }

    @NonNull
    public StationType getType() {
        return type;
    }

    public enum StationType {
        TRAIN(1),
        BUS(2),
        TRAM(4),
        SHIP(8),
        METRO(16),
        CABLEWAY(32),
        COG_RAILWAY(64),
        /// German: Standseilbahn
        FUNICULAR(128),
        ELEVATOR(256),
        POI(512),
        ADDRESS(1024),
        UNKNOWN(2048);

        public final int bit;

        StationType(int i) {
            this.bit = i;
        }

        public static int getMask(StationType... types) {
            int mask = 0;
            for (StationType type : types) {
                mask |= type.bit;
            }
            return mask;
        }

        public static StationType[] fromMask(int mask) {
            StationType[] types = new StationType[values().length];
            int length = 0;
            for (StationType type : values()) {
                if ((mask & type.bit) > 0) {
                    types[length] = type;
                    ++length;
                }
            }
            return Arrays.copyOf(types, length);
        }
    }
}
