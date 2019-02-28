package io.vertx.cluster.platform.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Error   {
  private Integer code = null;  private String message = null;

  public Error () {

  }

  public Error (Integer code, String message) {
    this.code = code;
    this.message = message;
  }

    
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }
  public Error setCode(Integer code) {
    this.code = code;
    return this;
  }

    
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public Error setMessage(String message) {
    this.message = message;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(code, error.code) &&
        Objects.equals(message, error.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
