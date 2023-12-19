package org.example.models.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Coordinates
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoordinatesDTO {
  @Schema(example = "4.9", required = true, description = "x coordinate")
  @NotNull(message = "X is required.")
  @JsonProperty("x")
  private Double x;

  @Schema(example = "6", required = true, description = "y coordinate")
  @NotNull(message = "Y is required.")
  @JsonProperty("y")
  private Long y;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoordinatesDTO coordinatesDTO = (CoordinatesDTO) o;
    return Objects.equals(this.x, coordinatesDTO.x) &&
        Objects.equals(this.y, coordinatesDTO.y);
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
