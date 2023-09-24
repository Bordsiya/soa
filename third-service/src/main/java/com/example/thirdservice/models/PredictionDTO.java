package com.example.thirdservice.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;

/**
 * Prediction
 */
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T22:04:54.480604900+03:00[Europe/Moscow]")
public class PredictionDTO {
  @Schema(example = "0.444", required = true, description = "Probability to increase")
  @NotNull(message = "Increase-probability is required.")
  @JsonProperty("increaseProbability")
  private Double increaseProbability;

  @Schema(example = "0.056", required = true, description = "Probability to decrease")
  @NotNull(message = "Decrease-probability is required.")
  @JsonProperty("decreaseProbability")
  private Double decreaseProbability;

  @Schema(example = "0.5", required = true, description = "Probability to remain")
  @NotNull(message = "Remain-probability is required.")
  @JsonProperty("remainProbability")
  private Double remainProbability;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PredictionDTO predictionDTO = (PredictionDTO) o;
    return Objects.equals(this.increaseProbability, predictionDTO.increaseProbability) &&
        Objects.equals(this.decreaseProbability, predictionDTO.decreaseProbability) &&
        Objects.equals(this.remainProbability, predictionDTO.remainProbability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(increaseProbability, decreaseProbability, remainProbability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Prediction {\n");
    
    sb.append("    increaseProbability: ").append(toIndentedString(increaseProbability)).append("\n");
    sb.append("    decreaseProbability: ").append(toIndentedString(decreaseProbability)).append("\n");
    sb.append("    remainProbability: ").append(toIndentedString(remainProbability)).append("\n");
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
