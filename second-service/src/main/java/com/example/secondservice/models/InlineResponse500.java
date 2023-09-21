package com.example.secondservice.models;

import java.util.Objects;
import com.example.secondservice.models.Error;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse500
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-21T11:53:29.139894400+03:00[Europe/Moscow]")


public class InlineResponse500 extends Error  {
  @JsonProperty("code")
  private Object inlineResponse500Code = null;

  @JsonProperty("message")
  private Object inlineResponse500Message = null;

  public InlineResponse500 inlineResponse500Code(Object inlineResponse500Code) {
    this.inlineResponse500Code = inlineResponse500Code;
    return this;
  }

  /**
   * Get inlineResponse500Code
   * @return inlineResponse500Code
   **/
  @Schema(description = "")
  
    public Object getInlineResponse500Code() {
    return inlineResponse500Code;
  }

  public void setInlineResponse500Code(Object inlineResponse500Code) {
    this.inlineResponse500Code = inlineResponse500Code;
  }

  public InlineResponse500 inlineResponse500Message(Object inlineResponse500Message) {
    this.inlineResponse500Message = inlineResponse500Message;
    return this;
  }

  /**
   * Get inlineResponse500Message
   * @return inlineResponse500Message
   **/
  @Schema(description = "")
  
    public Object getInlineResponse500Message() {
    return inlineResponse500Message;
  }

  public void setInlineResponse500Message(Object inlineResponse500Message) {
    this.inlineResponse500Message = inlineResponse500Message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse500 inlineResponse500 = (InlineResponse500) o;
    return Objects.equals(this.inlineResponse500Code, inlineResponse500.inlineResponse500Code) &&
        Objects.equals(this.inlineResponse500Message, inlineResponse500.inlineResponse500Message) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inlineResponse500Code, inlineResponse500Message, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse500 {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    inlineResponse500Code: ").append(toIndentedString(inlineResponse500Code)).append("\n");
    sb.append("    inlineResponse500Message: ").append(toIndentedString(inlineResponse500Message)).append("\n");
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
