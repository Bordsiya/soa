package com.example.firstservice.models;

import com.example.firstservice.exception.UndefinedOrganizationTypeException;
import com.example.firstservice.util.enums.OrganizationTypeType;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import java.time.LocalDate;
import java.util.Objects;

/**
 * OrganizationWithoutId
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationWithoutIdDTO {

  @Schema(example = "OAO Aviasales", required = true, description = "Organization name")
  @NotBlank(message = "Name is required.")
  @Size(min=1)
  @JsonProperty("name")
  private String name;

  @Schema(required = true, description = "")
  @NotNull(message = "Coordinates are required.")
  @JsonProperty("coordinates")
  private CoordinatesDTO coordinatesDTO;

  @Schema(required = true, description = "Organization creation date, generates automatically")
  @NotNull(message = "Creation-date is required.")
  @JsonProperty("creationDate")
  private LocalDate creationDate;

  @Schema(example = "4.5", required = true, description = "Organization annual turnover")
  @NotNull(message = "Double is required.")
  @DecimalMin("0")
  @JsonProperty("annualTurnover")
  private Double annualTurnover;

  @Schema(required = true, description = "")
  @NotNull(message = "Organization-Type is required.")
  @JsonProperty("type")
  private OrganizationTypeType type;

  @Schema(required = true, description = "")
  @NotNull(message = "Official-Address is required.")
  @JsonProperty("officialAddress")
  private AddressDTO officialAddressDTO;

  public void setType(OrganizationTypeType type) {
    if (type == null) throw new UndefinedOrganizationTypeException();
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationWithoutIdDTO organizationWithoutIdDTO = (OrganizationWithoutIdDTO) o;
    return Objects.equals(this.name, organizationWithoutIdDTO.name) &&
        Objects.equals(this.coordinatesDTO, organizationWithoutIdDTO.coordinatesDTO) &&
        Objects.equals(this.creationDate, organizationWithoutIdDTO.creationDate) &&
        Objects.equals(this.annualTurnover, organizationWithoutIdDTO.annualTurnover) &&
        Objects.equals(this.type, organizationWithoutIdDTO.type) &&
        Objects.equals(this.officialAddressDTO, organizationWithoutIdDTO.officialAddressDTO);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, coordinatesDTO, creationDate, annualTurnover, type, officialAddressDTO);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationWithoutId {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinatesDTO)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    annualTurnover: ").append(toIndentedString(annualTurnover)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    officialAddress: ").append(toIndentedString(officialAddressDTO)).append("\n");
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
