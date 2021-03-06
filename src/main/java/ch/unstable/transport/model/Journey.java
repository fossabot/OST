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

import ch.unstable.transport.model.Capacity1st;
import ch.unstable.transport.model.Capacity2nd;
import ch.unstable.transport.model.Checkpoint;
import java.util.*;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

/**
 * The actual transportation of a section, e.g. a bus or a train between two stations.
 **/
@ApiModel(description = "The actual transportation of a section, e.g. a bus or a train between two stations.")
public class Journey {
  
  @SerializedName("name")
  private String name = null;
  @SerializedName("category")
  private String category = null;
  @SerializedName("categoryCode")
  private String categoryCode = null;
  @SerializedName("number")
  private Integer number = null;
  @SerializedName("passList")
  private List<Checkpoint> passList = null;
  @SerializedName("capacity1st")
  private Capacity1st capacity1st = null;
  @SerializedName("capacity2nd")
  private Capacity2nd capacity2nd = null;

  /**
   * The name of the transportation
   **/
  @ApiModelProperty(value = "The name of the transportation")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Category of the transportation
   **/
  @ApiModelProperty(value = "Category of the transportation")
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * An internal category code of the transportation
   **/
  @ApiModelProperty(value = "An internal category code of the transportation")
  public String getCategoryCode() {
    return categoryCode;
  }
  public void setCategoryCode(String categoryCode) {
    this.categoryCode = categoryCode;
  }

  /**
   * The number of the transportation line
   **/
  @ApiModelProperty(value = "The number of the transportation line")
  public Integer getNumber() {
    return number;
  }
  public void setNumber(Integer number) {
    this.number = number;
  }

  /**
   * Checkpoints the train passed on the journey
   **/
  @ApiModelProperty(value = "Checkpoints the train passed on the journey")
  public List<Checkpoint> getPassList() {
    return passList;
  }
  public void setPassList(List<Checkpoint> passList) {
    this.passList = passList;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Capacity1st getCapacity1st() {
    return capacity1st;
  }
  public void setCapacity1st(Capacity1st capacity1st) {
    this.capacity1st = capacity1st;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Capacity2nd getCapacity2nd() {
    return capacity2nd;
  }
  public void setCapacity2nd(Capacity2nd capacity2nd) {
    this.capacity2nd = capacity2nd;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Journey journey = (Journey) o;
    return (this.name == null ? journey.name == null : this.name.equals(journey.name)) &&
        (this.category == null ? journey.category == null : this.category.equals(journey.category)) &&
        (this.categoryCode == null ? journey.categoryCode == null : this.categoryCode.equals(journey.categoryCode)) &&
        (this.number == null ? journey.number == null : this.number.equals(journey.number)) &&
        (this.passList == null ? journey.passList == null : this.passList.equals(journey.passList)) &&
        (this.capacity1st == null ? journey.capacity1st == null : this.capacity1st.equals(journey.capacity1st)) &&
        (this.capacity2nd == null ? journey.capacity2nd == null : this.capacity2nd.equals(journey.capacity2nd));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.category == null ? 0: this.category.hashCode());
    result = 31 * result + (this.categoryCode == null ? 0: this.categoryCode.hashCode());
    result = 31 * result + (this.number == null ? 0: this.number.hashCode());
    result = 31 * result + (this.passList == null ? 0: this.passList.hashCode());
    result = 31 * result + (this.capacity1st == null ? 0: this.capacity1st.hashCode());
    result = 31 * result + (this.capacity2nd == null ? 0: this.capacity2nd.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Journey {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  category: ").append(category).append("\n");
    sb.append("  categoryCode: ").append(categoryCode).append("\n");
    sb.append("  number: ").append(number).append("\n");
    sb.append("  passList: ").append(passList).append("\n");
    sb.append("  capacity1st: ").append(capacity1st).append("\n");
    sb.append("  capacity2nd: ").append(capacity2nd).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
