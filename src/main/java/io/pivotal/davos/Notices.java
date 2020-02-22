
package io.pivotal.davos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "totalCount",
    "notices"
})
@ToString
public class Notices {

    @JsonProperty("totalCount")
    private Integer totalCount;
    @JsonProperty("notices")
    private List<Notice> notices;

    @JsonCreator
    public Notices(
        @JsonProperty("totalCount") Integer totalCount,
        @JsonProperty("notices") List<Notice> notices) {
        this.totalCount = totalCount;
        this.notices = notices;
    }

}
