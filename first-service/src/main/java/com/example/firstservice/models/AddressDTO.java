package com.example.firstservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import java.util.Objects;

/**
 * Address
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {
  @Schema(example = "Kosovo street", required = true, description = "Address street")
  @NotBlank(message = "Street is required.")
  @JsonProperty("street")
  private String street;

  @Schema(example = "AE84C", required = true, description = "Address zipcode")
  @NotBlank(message = "ZipCode is required.")
  @JsonProperty("zipCode")
  private String zipCode;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressDTO addressDTO = (AddressDTO) o;
    return Objects.equals(this.street, addressDTO.street) &&
        Objects.equals(this.zipCode, addressDTO.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, zipCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
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
