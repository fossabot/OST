package ch.unstable.ost.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Objects;

import java.util.Date;

import static ch.unstable.ost.utils.ParcelUtils.readNonNulTypedObject;
import static ch.unstable.ost.utils.ParcelUtils.writeNonNullTypedObject;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * TODO: check if the stops contain the arrival and departure
 */
public class Section implements Parcelable {

    public static final Creator<Section> CREATOR = new Creator<Section>() {
        @Override
        public Section createFromParcel(Parcel in) {
            return new Section(in);
        }

        @Override
        public Section[] newArray(int size) {
            return new Section[size];
        }
    };
    @NonNull
    private final DepartureCheckpoint departure;
    @NonNull
    private final ArrivalCheckpoint arrival;
    @NonNull
    private final String headsign;
    private final long walkTime;
    @NonNull
    private final Route route;

    public Section(Route route, DepartureCheckpoint departure, ArrivalCheckpoint arrival, String headsign, long walkTime) {
        this.route = checkNotNull(route, "route");
        this.departure = checkNotNull(departure, "departure");
        this.arrival = checkNotNull(arrival, "arrival");
        this.headsign = checkNotNull(headsign, "headsign");
        this.walkTime = walkTime;
    }

    private Section(Parcel in) {
        route = readNonNulTypedObject(in, Route.CREATOR);
        departure = readNonNulTypedObject(in, DepartureCheckpoint.CREATOR);
        arrival = readNonNulTypedObject(in, ArrivalCheckpoint.CREATOR);
        headsign = in.readString();
        walkTime = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        writeNonNullTypedObject(dest, route, flags);
        writeNonNullTypedObject(dest, departure, flags);
        writeNonNullTypedObject(dest, arrival, flags);
        dest.writeString(headsign);
        dest.writeLong(walkTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getLineShortName() {
        return route.getShortName();
    }

    public Date getDepartureDate() {
        return departure.getDepartureTime();
    }

    public Date getArrivalDate() {
        return arrival.getArrivalTime();
    }

    public Location getArrivalLocation() {
        return arrival.getLocation();
    }

    public Location getDepartureLocation() {
        return departure.getLocation();
    }

    @NonNull
    public String getHeadsign() {
        return headsign;
    }

    public String getDeparturePlatform() {
        return departure.getPlatform();
    }

    public String getArrivalPlatform() {
        return arrival.getPlatform();
    }

    public PassingCheckpoint[] getStops() {
        return route.getStops();
    }

    @NonNull
    public String getRouteLongName() {
        return route.getLongName();
    }

    @NonNull
    public ArrivalCheckpoint getArrival() {
        return arrival;
    }

    @NonNull
    public DepartureCheckpoint getDeparture() {
        return departure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return walkTime == section.walkTime &&
                Objects.equal(departure, section.departure) &&
                Objects.equal(arrival, section.arrival) &&
                Objects.equal(headsign, section.headsign) &&
                Objects.equal(route, section.route);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(departure, arrival, headsign, walkTime, route);
    }
}
