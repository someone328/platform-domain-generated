
package io.vertx.cluster.platform.domain;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "users",
    "groupType"
})
public class UserGroup {

    @JsonProperty("id")
    private String id;
    @JsonProperty("users")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @Valid
    private Set<User> users = new LinkedHashSet<User>();
    @JsonProperty("groupType")
    private UserGroup.GroupType groupType;

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

    @JsonProperty("groupType")
    public UserGroup.GroupType getGroupType() {
        return groupType;
    }

    @JsonProperty("groupType")
    public void setGroupType(UserGroup.GroupType groupType) {
        this.groupType = groupType;
    }

    public UserGroup withGroupType(UserGroup.GroupType groupType) {
        this.groupType = groupType;
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
        sb.append("groupType");
        sb.append('=');
        sb.append(((this.groupType == null)?"<null>":this.groupType));
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
        result = ((result* 31)+((this.groupType == null)? 0 :this.groupType.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.users == null)? 0 :this.users.hashCode()));
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
        return ((((this.groupType == rhs.groupType)||((this.groupType!= null)&&this.groupType.equals(rhs.groupType)))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.users == rhs.users)||((this.users!= null)&&this.users.equals(rhs.users))));
    }

    public enum GroupType {

        ONE("one"),
        SECOND_ONE("secondOne"),
        _3_RD_ONE("3rd one");
        private final String value;
        private final static Map<String, UserGroup.GroupType> CONSTANTS = new HashMap<String, UserGroup.GroupType>();

        static {
            for (UserGroup.GroupType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private GroupType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static UserGroup.GroupType fromValue(String value) {
            UserGroup.GroupType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
