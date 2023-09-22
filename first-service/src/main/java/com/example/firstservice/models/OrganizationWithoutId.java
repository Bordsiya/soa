package com.example.firstservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * OrganizationWithoutId
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")


public class OrganizationWithoutId   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("coordinates")
  private Coordinates coordinates = null;

  @JsonProperty("creationDate")
  private LocalDate creationDate = null;

  @JsonProperty("annualTurnover")
  private Double annualTurnover = null;

  @JsonProperty("type")
  private AllOfOrganizationWithoutIdType type = null;

  @JsonProperty("officialAddress")
  private AllOfOrganizationWithoutIdOfficialAddress officialAddress = null;

  public OrganizationWithoutId name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Organization name
   * @return name
   **/
  @Schema(example = "OAO Aviasales", required = true, description = "Organization name")
      @NotNull

  @Size(min=1)   public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrganizationWithoutId coordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  /**
   * Get coordinates
   * @return coordinates
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public OrganizationWithoutId creationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Organization creation date, generates automatically
   * @return creationDate
   **/
  @Schema(required = true, description = "Organization creation date, generates automatically")
      @NotNull

    @Valid
    public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public OrganizationWithoutId annualTurnover(Double annualTurnover) {
    this.annualTurnover = annualTurnover;
    return this;
  }

  /**
   * Organization annual turnover
   * minimum: 0
   * @return annualTurnover
   **/
  @Schema(example = "4.5", required = true, description = "Organization annual turnover")
      @NotNull

  @DecimalMin("0")  public Double getAnnualTurnover() {
    return annualTurnover;
  }

  public void setAnnualTurnover(Double annualTurnover) {
    this.annualTurnover = annualTurnover;
  }

  public OrganizationWithoutId type(AllOfOrganizationWithoutIdType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(required = true, description = "")
      @NotNull

    public AllOfOrganizationWithoutIdType getType() {
    return type;
  }

  public void setType(AllOfOrganizationWithoutIdType type) {
    this.type = type;
  }

  public OrganizationWithoutId officialAddress(AllOfOrganizationWithoutIdOfficialAddress officialAddress) {
    this.officialAddress = officialAddress;
    return this;
  }

  /**
   * Get officialAddress
   * @return officialAddress
   **/
  @Schema(required = true, description = "")
      @NotNull

    public AllOfOrganizationWithoutIdOfficialAddress getOfficialAddress() {
    return officialAddress;
  }

  public void setOfficialAddress(AllOfOrganizationWithoutIdOfficialAddress officialAddress) {
    this.officialAddress = officialAddress;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationWithoutId organizationWithoutId = (OrganizationWithoutId) o;
    return Objects.equals(this.name, organizationWithoutId.name) &&
        Objects.equals(this.coordinates, organizationWithoutId.coordinates) &&
        Objects.equals(this.creationDate, organizationWithoutId.creationDate) &&
        Objects.equals(this.annualTurnover, organizationWithoutId.annualTurnover) &&
        Objects.equals(this.type, organizationWithoutId.type) &&
        Objects.equals(this.officialAddress, organizationWithoutId.officialAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, coordinates, creationDate, annualTurnover, type, officialAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationWithoutId {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    annualTurnover: ").append(toIndentedString(annualTurnover)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    officialAddress: ").append(toIndentedString(officialAddress)).append("\n");
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
