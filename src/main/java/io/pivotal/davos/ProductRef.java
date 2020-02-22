
package io.pivotal.davos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "type"
})
public class ProductRef {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;

    @JsonCreator
    public ProductRef(
        @JsonProperty("id") Integer id,
        @JsonProperty("name") String name,
        @JsonProperty("type") String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

}
