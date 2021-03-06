/**
 * Trasport API
 * The Transport API allows interested developers to build their own applications using public timetable data, whether they're on the web, the desktop or mobile devices. The aim of this inofficial API is to cover public transport within Switzerland. If you are looking for an officially supported source or need to download all data e.g in GTFS format, please check opendata.swiss. The source code of the Transport API can be found on GitHub, please ask any technical questions there. If you need a direct contact write an email to transport@opendata.ch. In order to be kept update on the future development of this API, please subscribe to our low-traffic Google Group.
 *
 * OpenAPI spec version: 1
 * Contact: transport@opendata.ch
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.unstable.transport.model;

import ch.unstable.transport.model.Journey;
import ch.unstable.transport.model.Location;
import java.util.*;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class StationBoardResponse {
  
  @SerializedName("station")
  private Location station = null;
  @SerializedName("stationboard")
  private List<Journey> stationboard = null;

  /**
   * The first matched location based on the query. The stationboard will be displayed if this is a station.
   **/
  @ApiModelProperty(value = "The first matched location based on the query. The stationboard will be displayed if this is a station.")
  public Location getStation() {
    return station;
  }
  public void setStation(Location station) {
    this.station = station;
  }

  /**
   * A list of journeys with the stop of the line leaving from that station.
   **/
  @ApiModelProperty(value = "A list of journeys with the stop of the line leaving from that station.")
  public List<Journey> getStationboard() {
    return stationboard;
  }
  public void setStationboard(List<Journey> stationboard) {
    this.stationboard = stationboard;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StationBoardResponse stationBoardResponse = (StationBoardResponse) o;
    return (this.station == null ? stationBoardResponse.station == null : this.station.equals(stationBoardResponse.station)) &&
        (this.stationboard == null ? stationBoardResponse.stationboard == null : this.stationboard.equals(stationBoardResponse.stationboard));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.station == null ? 0: this.station.hashCode());
    result = 31 * result + (this.stationboard == null ? 0: this.stationboard.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class StationBoardResponse {\n");
    
    sb.append("  station: ").append(station).append("\n");
    sb.append("  stationboard: ").append(stationboard).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
