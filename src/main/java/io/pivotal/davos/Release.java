
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
    "className",
    "version",
    "id"
})
public class Release {

    @JsonProperty("className")
    private String className;
    @JsonProperty("version")
    private String version;
    @JsonProperty("id")
    private Integer id;

    @JsonCreator
    public Release(
        @JsonProperty("className") String className,
        @JsonProperty("version") String version,
        @JsonProperty("id") Integer id) {
        this.className = className;
        this.version = version;
        this.id = id;
    }

}
