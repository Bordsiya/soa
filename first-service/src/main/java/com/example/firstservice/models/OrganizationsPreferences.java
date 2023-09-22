package com.example.firstservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OrganizationsPreferences
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")


public class OrganizationsPreferences   {
  @JsonProperty("filtrationFields")
  @Valid
  private List<FiltrationPair> filtrationFields = new ArrayList<FiltrationPair>();

  @JsonProperty("sortingFields")
  @Valid
  private List<SortingOrFilteringField> sortingFields = new ArrayList<SortingOrFilteringField>();

  public OrganizationsPreferences filtrationFields(List<FiltrationPair> filtrationFields) {
    this.filtrationFields = filtrationFields;
    return this;
  }

  public OrganizationsPreferences addFiltrationFieldsItem(FiltrationPair filtrationFieldsItem) {
    this.filtrationFields.add(filtrationFieldsItem);
    return this;
  }

  /**
   * Get filtrationFields
   * @return filtrationFields
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<FiltrationPair> getFiltrationFields() {
    return filtrationFields;
  }

  public void setFiltrationFields(List<FiltrationPair> filtrationFields) {
    this.filtrationFields = filtrationFields;
  }

  public OrganizationsPreferences sortingFields(List<SortingOrFilteringField> sortingFields) {
    this.sortingFields = sortingFields;
    return this;
  }

  public OrganizationsPreferences addSortingFieldsItem(SortingOrFilteringField sortingFieldsItem) {
    this.sortingFields.add(sortingFieldsItem);
    return this;
  }

  /**
   * Get sortingFields
   * @return sortingFields
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<SortingOrFilteringField> getSortingFields() {
    return sortingFields;
  }

  public void setSortingFields(List<SortingOrFilteringField> sortingFields) {
    this.sortingFields = sortingFields;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationsPreferences organizationsPreferences = (OrganizationsPreferences) o;
    return Objects.equals(this.filtrationFields, organizationsPreferences.filtrationFields) &&
        Objects.equals(this.sortingFields, organizationsPreferences.sortingFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filtrationFields, sortingFields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationsPreferences {\n");
    
    sb.append("    filtrationFields: ").append(toIndentedString(filtrationFields)).append("\n");
    sb.append("    sortingFields: ").append(toIndentedString(sortingFields)).append("\n");
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
