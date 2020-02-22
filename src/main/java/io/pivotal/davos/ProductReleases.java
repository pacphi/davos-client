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
@JsonPropertyOrder( {
    "totalCount",
    "releases"
})
public class ProductReleases {

    @JsonProperty("totalCount")
    private Integer totalCount;
    @JsonProperty("releases")
    private List < Release > releases;

    @JsonCreator
    public ProductReleases(
        @JsonProperty("totalCount") Integer totalCount,
        @JsonProperty("releases") List<Release> releases) {
        this.totalCount = totalCount;
        this.releases = releases;
    }


}