package org.example.ejb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ejb.exception.UndefinedOrganizationTypeException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * OrganizationWithoutId
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationWithoutIdDTO implements Serializable {
  @JsonProperty("name")
  private String name;

  @JsonProperty("coordinates")
  private CoordinatesDTO coordinatesDTO;

  @JsonProperty("creationDate")
  private LocalDate creationDate;

  @JsonProperty("annualTurnover")
  private Double annualTurnover;

  @JsonProperty("type")
  private OrganizationTypeDto type;

  @JsonProperty("officialAddress")
  private AddressDTO officialAddressDTO;

  public void setType(OrganizationTypeDto type) {
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
