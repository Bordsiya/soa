package com.example.thirdservice.models;

import java.util.Objects;
import com.example.thirdservice.models.Quarter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T22:04:54.480604900+03:00[Europe/Moscow]")


public class InlineResponse200   {
  @JsonProperty("quarter")
  private Quarter quarter = null;

  public InlineResponse200 quarter(Quarter quarter) {
    this.quarter = quarter;
    return this;
  }

  /**
   * Get quarter
   * @return quarter
   **/
  @Schema(description = "")
  
    @Valid
    public Quarter getQuarter() {
    return quarter;
  }

  public void setQuarter(Quarter quarter) {
    this.quarter = quarter;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.quarter, inlineResponse200.quarter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quarter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    quarter: ").append(toIndentedString(quarter)).append("\n");
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
