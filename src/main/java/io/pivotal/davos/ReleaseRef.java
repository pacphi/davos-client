
package io.pivotal.davos;

import java.time.LocalDate;

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
    "releaseDate",
    "version",
    "id"
})
public class ReleaseRef {

    @JsonProperty("className")
    private String className;
    @JsonProperty("releaseDate")
    private LocalDate releaseDate;
    @JsonProperty("version")
    private String version;
    @JsonProperty("id")
    private Integer id;

    @JsonCreator
    public ReleaseRef(
        @JsonProperty("className") String className,
        @JsonProperty("releaseDate") LocalDate releaseDate,
        @JsonProperty("version") String version,
        @JsonProperty("id") Integer id) {
        this.className = className;
        this.releaseDate = releaseDate;
        this.version = version;
        this.id = id;
    }

}
