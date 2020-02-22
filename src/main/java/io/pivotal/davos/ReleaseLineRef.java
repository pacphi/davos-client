
package io.pivotal.davos;

import java.util.List;

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
    "product",
    "releases"
})
public class ReleaseLineRef {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("product")
    private ProductRef product;
    @JsonProperty("releases")
    private List<ReleaseRef> releases;

    @JsonCreator
    public ReleaseLineRef(
        @JsonProperty("id") Integer id,
        @JsonProperty("name") String name,
        @JsonProperty("product") ProductRef product,
        @JsonProperty("releases") List<ReleaseRef> releases) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.releases = releases;
    }

}
