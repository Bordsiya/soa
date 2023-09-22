package com.example.firstservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * InlineResponse404
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-21T11:23:02.120621100+03:00[Europe/Moscow]")


public class InlineResponse404 extends Error {
    @JsonProperty("code")
    private Object inlineResponse404Code = null;

    @JsonProperty("message")
    private Object inlineResponse404Message = null;

    public InlineResponse404 inlineResponse404Code(Object inlineResponse404Code) {
        this.inlineResponse404Code = inlineResponse404Code;
        return this;
    }

    /**
     * Get inlineResponse404Code
     *
     * @return inlineResponse404Code
     **/
    @Schema(description = "")

    public Object getInlineResponse404Code() {
        return inlineResponse404Code;
    }

    public void setInlineResponse404Code(Object inlineResponse404Code) {
        this.inlineResponse404Code = inlineResponse404Code;
    }

    public InlineResponse404 inlineResponse404Message(Object inlineResponse404Message) {
        this.inlineResponse404Message = inlineResponse404Message;
        return this;
    }

    /**
     * Get inlineResponse404Message
     *
     * @return inlineResponse404Message
     **/
    @Schema(description = "")

    public Object getInlineResponse404Message() {
        return inlineResponse404Message;
    }

    public void setInlineResponse404Message(Object inlineResponse404Message) {
        this.inlineResponse404Message = inlineResponse404Message;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InlineResponse404 inlineResponse404 = (InlineResponse404) o;
        return Objects.equals(this.inlineResponse404Code, inlineResponse404.inlineResponse404Code) &&
                Objects.equals(this.inlineResponse404Message, inlineResponse404.inlineResponse404Message) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inlineResponse404Code, inlineResponse404Message, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InlineResponse404 {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    inlineResponse404Code: ").append(toIndentedString(inlineResponse404Code)).append("\n");
        sb.append("    inlineResponse404Message: ").append(toIndentedString(inlineResponse404Message)).append("\n");
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
