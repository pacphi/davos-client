
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
    "name",
    "url",
    "publicDisclosure",
    "id"
})
public class Url {

    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("publicDisclosure")
    private boolean publicDisclosure;
    @JsonProperty("id")
    private Integer id;

    @JsonCreator
    public Url(
        @JsonProperty("name") String name,
        @JsonProperty("url") String url,
        @JsonProperty("publicDisclosure") boolean publicDisclosure,
        @JsonProperty("id") Integer id) {
        this.name = name;
        this.url = url;
        this.publicDisclosure = publicDisclosure;
        this.id = id;
    }

}
