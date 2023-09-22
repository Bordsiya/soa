package com.example.firstservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * AnnualTurnoverOrganizationsCount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-21T11:23:02.120621100+03:00[Europe/Moscow]")


public class AnnualTurnoverOrganizationsCount {
    @JsonProperty("annualTurnover")
    private Double annualTurnover = null;

    @JsonProperty("organizationsCount")
    private Integer organizationsCount = null;

    public AnnualTurnoverOrganizationsCount annualTurnover(Double annualTurnover) {
        this.annualTurnover = annualTurnover;
        return this;
    }

    /**
     * Organization annual turnover
     * minimum: 0
     *
     * @return annualTurnover
     **/
    @Schema(example = "4.5", required = true, description = "Organization annual turnover")
    @NotNull

    @DecimalMin("0")
    public Double getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(Double annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public AnnualTurnoverOrganizationsCount organizationsCount(Integer organizationsCount) {
        this.organizationsCount = organizationsCount;
        return this;
    }

    /**
     * Amount of Organizations with such annual turnover value
     * minimum: 0
     *
     * @return organizationsCount
     **/
    @Schema(example = "5", required = true, description = "Amount of Organizations with such annual turnover value")
    @NotNull

    @Min(0)
    public Integer getOrganizationsCount() {
        return organizationsCount;
    }

    public void setOrganizationsCount(Integer organizationsCount) {
        this.organizationsCount = organizationsCount;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnnualTurnoverOrganizationsCount annualTurnoverOrganizationsCount = (AnnualTurnoverOrganizationsCount) o;
        return Objects.equals(this.annualTurnover, annualTurnoverOrganizationsCount.annualTurnover) &&
                Objects.equals(this.organizationsCount, annualTurnoverOrganizationsCount.organizationsCount);
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
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
