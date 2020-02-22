
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
    "supported",
    "prefix",
    "ubuntuDistribution",
    "defaultReleaseLine",
    "releases"
})
public class ReleaseLine {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("supported")
    private boolean supported;
    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("ubuntuDistribution")
    private String ubuntuDistribution;
    @JsonProperty("defaultReleaseLine")
    private boolean defaultReleaseLine;
    @JsonProperty("releases")
    private List<Release> releases;

    @JsonCreator
    public ReleaseLine(
        @JsonProperty("id") Integer id,
        @JsonProperty("name") String name,
        @JsonProperty("supported") boolean supported,
        @JsonProperty("prefix") String prefix,
        @JsonProperty("ubuntuDistribution") String ubuntuDistribution,
        @JsonProperty("defaultReleaseLine") boolean defaultReleaseLine,
        @JsonProperty("releases") List<Release> releases) {
        this.id = id;
        this.name = name;
        this.supported = supported;
        this.prefix = prefix;
        this.ubuntuDistribution = ubuntuDistribution;
        this.defaultReleaseLine = defaultReleaseLine;
        this.releases = releases;
    }


}
