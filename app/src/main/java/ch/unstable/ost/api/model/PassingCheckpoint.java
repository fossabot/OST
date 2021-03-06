package ch.unstable.ost.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.common.base.Objects;

import java.util.Date;

import ch.unstable.ost.utils.ParcelUtils;

import static com.google.common.base.Preconditions.checkNotNull;

public class PassingCheckpoint extends Checkpoint implements Parcelable {

    public static final Creator<PassingCheckpoint> CREATOR = new Creator<PassingCheckpoint>() {
        @Override
        public PassingCheckpoint createFromParcel(Parcel in) {
            return new PassingCheckpoint(in);
        }

        @Override
        public PassingCheckpoint[] newArray(int size) {
            return new PassingCheckpoint[size];
        }
    };

    @Nullable
    private final Date departureTime;

    @Nullable
    private final Date arrivalTime;

    /**
     * Construct a new passing checkpoint
     *
     * if \param arrivalTime and \param departureTime is null it is considered to be a
     * checkpoint that doesn't stop
     *
     * TODO: 26.09.17  TBD: if arrivalTime or departureTime is null is boarding allowed?
     *
     * @param arrivalTime the arrival time
     * @param departureTime the departure time
     * @param location the location
     * @param platform the platform
     */
    public PassingCheckpoint(@Nullable Date arrivalTime, @Nullable Date departureTime, Location location, @Nullable String platform) {
        super(platform, location);
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    private PassingCheckpoint(Parcel in) {
        super(in);
        departureTime = ParcelUtils.readDate(in);
        arrivalTime = ParcelUtils.readDate(in);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        ParcelUtils.writeDate(dest, departureTime);
        ParcelUtils.writeDate(dest, arrivalTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Date getDepartureTime() {
        return departureTime;
    }

    @Nullable
    public Date getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassingCheckpoint that = (PassingCheckpoint) o;
        return Objects.equal(departureTime, that.departureTime) &&
                Objects.equal(arrivalTime, that.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), departureTime, arrivalTime);
    }
}
