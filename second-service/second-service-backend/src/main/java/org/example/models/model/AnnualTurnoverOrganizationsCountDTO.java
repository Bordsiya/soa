package org.example.models.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * AnnualTurnoverOrganizationsCount
 */
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")
public class AnnualTurnoverOrganizationsCountDTO {
  @Schema(example = "4.5", required = true, description = "Organization annual turnover")
  @NotNull(message = "Annual-Turnover cannot be null.")
  @JsonProperty("annualTurnover")
  @DecimalMin("0")
  private Double annualTurnover;

  @Schema(example = "5", required = true, description = "Amount of Organizations with such annual turnover value")
  @NotNull(message = "Organization-count cannot be null.")
  @JsonProperty("organizationsCount")
  @Min(0)
  private Long organizationsCount;

  /**
   * Organization annual turnover
   * minimum: 0
   * @return annualTurnover
   **/
  public Double getAnnualTurnover() {
    return annualTurnover;
  }
  public void setAnnualTurnover(Double annualTurnover) {
    this.annualTurnover = annualTurnover;
  }

  /**
   * Amount of Organizations with such annual turnover value
   * minimum: 0
   * @return organizationsCount
   **/
  public Long getOrganizationsCount() {
    return organizationsCount;
  }
  public void setOrganizationsCount(Long organizationsCount) {
    this.organizationsCount = organizationsCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnnualTurnoverOrganizationsCountDTO annualTurnoverOrganizationsCountDTO = (AnnualTurnoverOrganizationsCountDTO) o;
    return Objects.equals(this.annualTurnover, annualTurnoverOrganizationsCountDTO.annualTurnover) &&
        Objects.equals(this.organizationsCount, annualTurnoverOrganizationsCountDTO.organizationsCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(annualTurnover, organizationsCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnnualTurnoverOrganizationsCount {\n");
    
    sb.append("    annualTurnover: ").append(toIndentedString(annualTurnover)).append("\n");
    sb.append("    organizationsCount: ").append(toIndentedString(organizationsCount)).append("\n");
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
