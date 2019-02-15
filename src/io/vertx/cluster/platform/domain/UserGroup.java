
package io.vertx.cluster.platform.domain;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "users"
})
public class UserGroup {

    @JsonProperty("id")
    private String id;
    @JsonProperty("users")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @Valid
    private Set<User> users = new LinkedHashSet<User>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public UserGroup withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("users")
    public Set<User> getUsers() {
        return users;
    }

    @JsonProperty("users")
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public UserGroup withUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UserGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("users");
        sb.append('=');
        sb.append(((this.users == null)?"<null>":this.users));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.users == null)? 0 :this.users.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserGroup) == false) {
            return false;
        }
        UserGroup rhs = ((UserGroup) other);
        return (((this.users == rhs.users)||((this.users!= null)&&this.users.equals(rhs.users)))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))));
    }

}
