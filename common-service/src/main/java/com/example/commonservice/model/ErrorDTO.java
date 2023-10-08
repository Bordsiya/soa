package com.example.commonservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Error
 */
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")
public class ErrorDTO {
  @Schema(example = "400", description = "Error code")
  @JsonProperty("code")
  private String code;

  @Schema(example = "Bad Request", required = true, description = "Error message")
  @NotNull(message = "Message is required.")
  @JsonProperty("message")
  private String message;

  @Schema(example = "2022-09-19T00:00:09Z", required = true, description = "Error time")
  @NotNull(message = "Time is required.")
  @JsonProperty("time")
  private LocalDateTime time;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDTO errorDTO = (ErrorDTO) o;
    return Objects.equals(this.code, errorDTO.code) &&
        Objects.equals(this.message, errorDTO.message) &&
        Objects.equals(this.time, errorDTO.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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
