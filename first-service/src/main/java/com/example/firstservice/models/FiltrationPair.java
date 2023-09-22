package com.example.firstservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * FiltrationPair
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-21T11:23:02.120621100+03:00[Europe/Moscow]")


public class FiltrationPair {
    @JsonProperty("field")
    private SortingOrFilteringField field = null;

    @JsonProperty("value")
    private OneOfFiltrationPairValue value = null;

    public FiltrationPair field(SortingOrFilteringField field) {
        this.field = field;
        return this;
    }

    /**
     * Get field
     *
     * @return field
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public SortingOrFilteringField getField() {
        return field;
    }

    public void setField(SortingOrFilteringField field) {
        this.field = field;
    }

    public FiltrationPair value(OneOfFiltrationPairValue value) {
        this.value = value;
        return this;
    }

    /**
     * Field value
     *
     * @return value
     **/
    @Schema(example = "1", required = true, description = "Field value")
    @NotNull

    public OneOfFiltrationPairValue getValue() {
        return value;
    }

    public void setValue(OneOfFiltrationPairValue value) {
        this.value = value;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FiltrationPair filtrationPair = (FiltrationPair) o;
        return Objects.equals(this.field, filtrationPair.field) &&
                Objects.equals(this.value, filtrationPair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FiltrationPair {\n");

        sb.append("    field: ").append(toIndentedString(field)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
