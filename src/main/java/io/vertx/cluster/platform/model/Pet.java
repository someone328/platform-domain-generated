package io.vertx.cluster.platform.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
/**
 * Основной класс модели. Все остальные созданы для работы с ним.
 **/

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Pet   {

  private Long id = null;

  private String name = null;

  private String tag = null;

  public Pet () {

  }

  public Pet (Long id, String name, String tag) {
    this.id = id;
    this.name = name;
    this.tag = tag;
  }

    
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public Pet setId(Long id) {
    this.id = id;
    return this;
  }

    
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public Pet setName(String name) {
    this.name = name;
    return this;
  }

    
  @JsonProperty("tag")
  public String getTag() {
    return tag;
  }
  public Pet setTag(String tag) {
    this.tag = tag;
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
    Pet pet = (Pet) o;
    return Objects.equals(id, pet.id) &&
        Objects.equals(name, pet.name) &&
        Objects.equals(tag, pet.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, tag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pet {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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
