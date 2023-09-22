package com.example.firstservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMin;
import java.util.Objects;

/**
 * OnlyAnnualTurnover
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")


public class OnlyAnnualTurnover   {
  @JsonProperty("value")
  private Double value = null;

  public OnlyAnnualTurnover value(Double value) {
    this.value = value;
    return this;
  }

  /**
   * Organization annual turnover
   * minimum: 0
   * @return value
   **/
  @Schema(example = "4.5", description = "Organization annual turnover")
  
  @DecimalMin("0")  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OnlyAnnualTurnover onlyAnnualTurnover = (OnlyAnnualTurnover) o;
    return Objects.equals(this.value, onlyAnnualTurnover.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OnlyAnnualTurnover {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
