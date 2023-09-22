package com.example.thirdservice.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Prediction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T22:04:54.480604900+03:00[Europe/Moscow]")


public class Prediction   {
  @JsonProperty("increaseProbability")
  private Double increaseProbability = null;

  @JsonProperty("decreaseProbability")
  private Double decreaseProbability = null;

  @JsonProperty("remainProbability")
  private Double remainProbability = null;

  public Prediction increaseProbability(Double increaseProbability) {
    this.increaseProbability = increaseProbability;
    return this;
  }

  /**
   * Probability to increase
   * @return increaseProbability
   **/
  @Schema(example = "0.444", required = true, description = "Probability to increase")
      @NotNull

    public Double getIncreaseProbability() {
    return increaseProbability;
  }

  public void setIncreaseProbability(Double increaseProbability) {
    this.increaseProbability = increaseProbability;
  }

  public Prediction decreaseProbability(Double decreaseProbability) {
    this.decreaseProbability = decreaseProbability;
    return this;
  }

  /**
   * Probability to decrease
   * @return decreaseProbability
   **/
  @Schema(example = "0.056", required = true, description = "Probability to decrease")
      @NotNull

    public Double getDecreaseProbability() {
    return decreaseProbability;
  }

  public void setDecreaseProbability(Double decreaseProbability) {
    this.decreaseProbability = decreaseProbability;
  }

  public Prediction remainProbability(Double remainProbability) {
    this.remainProbability = remainProbability;
    return this;
  }

  /**
   * Probability to remain
   * @return remainProbability
   **/
  @Schema(example = "0.5", required = true, description = "Probability to remain")
      @NotNull

    public Double getRemainProbability() {
    return remainProbability;
  }

  public void setRemainProbability(Double remainProbability) {
    this.remainProbability = remainProbability;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Prediction prediction = (Prediction) o;
    return Objects.equals(this.increaseProbability, prediction.increaseProbability) &&
        Objects.equals(this.decreaseProbability, prediction.decreaseProbability) &&
        Objects.equals(this.remainProbability, prediction.remainProbability);
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
