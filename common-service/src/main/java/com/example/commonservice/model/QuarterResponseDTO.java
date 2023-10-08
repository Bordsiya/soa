package com.example.commonservice.model;

import com.example.commonservice.enums.Quarter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;


/**
 * InlineResponse200
 */
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T22:04:54.480604900+03:00[Europe/Moscow]")
public class QuarterResponseDTO {

  @NotNull(message = "Quarter is required.")
  @JsonProperty("quarter")
  private Quarter quarter;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuarterResponseDTO quarterResponseDTO = (QuarterResponseDTO) o;
    return Objects.equals(this.quarter, quarterResponseDTO.quarter);
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
