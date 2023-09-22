package com.example.firstservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Coordinates
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")


public class Coordinates   {
  @JsonProperty("x")
  private Double x = null;

  @JsonProperty("y")
  private Long y = null;

  public Coordinates x(Double x) {
    this.x = x;
    return this;
  }

  /**
   * x coordinate
   * @return x
   **/
  @Schema(example = "4.9", required = true, description = "x coordinate")
      @NotNull

    public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  public Coordinates y(Long y) {
    this.y = y;
    return this;
  }

  /**
   * y coordinate
   * @return y
   **/
  @Schema(example = "6", required = true, description = "y coordinate")
      @NotNull

    public Long getY() {
    return y;
  }

  public void setY(Long y) {
    this.y = y;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coordinates coordinates = (Coordinates) o;
    return Objects.equals(this.x, coordinates.x) &&
        Objects.equals(this.y, coordinates.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coordinates {\n");
    
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
