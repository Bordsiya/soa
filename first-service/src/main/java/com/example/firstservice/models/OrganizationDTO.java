package com.example.firstservice.models;

import com.example.firstservice.util.enums.OrganizationTypeType;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Organization
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationDTO extends OrganizationWithoutIdDTO {
  @Schema(example = "1", required = true, description = "Organization ID")
  @NotNull(message = "Id is required.")
  @Min(1)
  @JsonProperty("id")
  private Integer id;

  public OrganizationDTO(
          Integer id,
          String name,
          CoordinatesDTO coordinatesDTO,
          LocalDate creationDate,
          Double annualTurnover,
          OrganizationTypeType type,
          AddressDTO addressDTO
  ) {
    this.id = id;
    setName(name);
    setCoordinatesDTO(coordinatesDTO);
    setCreationDate(creationDate);
    setAnnualTurnover(annualTurnover);
    setType(type);
    setOfficialAddressDTO(addressDTO);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationDTO organizationDTO = (OrganizationDTO) o;
    return Objects.equals(this.id, organizationDTO.id) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organization {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
