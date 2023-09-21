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
 * InlineResponseDefault
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-21T11:53:29.139894400+03:00[Europe/Moscow]")


public class InlineResponseDefault extends Error  {
  @JsonProperty("code")
  private Object inlineResponseDefaultCode = null;

  @JsonProperty("message")
  private Object inlineResponseDefaultMessage = null;

  public InlineResponseDefault inlineResponseDefaultCode(Object inlineResponseDefaultCode) {
    this.inlineResponseDefaultCode = inlineResponseDefaultCode;
    return this;
  }

  /**
   * Get inlineResponseDefaultCode
   * @return inlineResponseDefaultCode
   **/
  @Schema(description = "")
  
    public Object getInlineResponseDefaultCode() {
    return inlineResponseDefaultCode;
  }

  public void setInlineResponseDefaultCode(Object inlineResponseDefaultCode) {
    this.inlineResponseDefaultCode = inlineResponseDefaultCode;
  }

  public InlineResponseDefault inlineResponseDefaultMessage(Object inlineResponseDefaultMessage) {
    this.inlineResponseDefaultMessage = inlineResponseDefaultMessage;
    return this;
  }

  /**
   * Get inlineResponseDefaultMessage
   * @return inlineResponseDefaultMessage
   **/
  @Schema(description = "")
  
    public Object getInlineResponseDefaultMessage() {
    return inlineResponseDefaultMessage;
  }

  public void setInlineResponseDefaultMessage(Object inlineResponseDefaultMessage) {
    this.inlineResponseDefaultMessage = inlineResponseDefaultMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponseDefault inlineResponseDefault = (InlineResponseDefault) o;
    return Objects.equals(this.inlineResponseDefaultCode, inlineResponseDefault.inlineResponseDefaultCode) &&
        Objects.equals(this.inlineResponseDefaultMessage, inlineResponseDefault.inlineResponseDefaultMessage) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inlineResponseDefaultCode, inlineResponseDefaultMessage, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponseDefault {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    inlineResponseDefaultCode: ").append(toIndentedString(inlineResponseDefaultCode)).append("\n");
    sb.append("    inlineResponseDefaultMessage: ").append(toIndentedString(inlineResponseDefaultMessage)).append("\n");
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
