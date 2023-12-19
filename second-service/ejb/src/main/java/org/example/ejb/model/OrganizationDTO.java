package org.example.ejb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Organization
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationDTO extends OrganizationWithoutIdDTO implements Serializable {
  @JsonProperty("id")
  private Integer id;

  public OrganizationDTO(
          Integer id,
          String name,
          CoordinatesDTO coordinatesDTO,
          LocalDate creationDate,
          Double annualTurnover,
          OrganizationTypeDto type,
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
