
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
    "type",
    "upstreamImpactRecordIds",
    "unfixedUpstreamImpactRecordIds",
    "depth",
    "id",
    "status",
    "releaseLine",
    "fixedVersion"
})
public class ImpactRecord {

    @JsonProperty("type")
    private String type;
    @JsonProperty("upstreamImpactRecordIds")
    private List<String> upstreamImpactRecordIds;
    @JsonProperty("unfixedUpstreamImpactRecordIds")
    private List<String> unfixedUpstreamImpactRecordIds;
    @JsonProperty("depth")
    private Integer depth;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("status")
    private String status;
    @JsonProperty("releaseLine")
    private ReleaseLineRef releaseLine;
    @JsonProperty("fixedVersion")
    private FixedVersion fixedVersion;

    @JsonCreator
    public ImpactRecord(
        @JsonProperty("type") String type,
        @JsonProperty("upstreamImpactRecordIds") List<String> upstreamImpactRecordIds,
        @JsonProperty("unfixedUpstreamImpactRecordIds") List<String> unfixedUpstreamImpactRecordIds,
        @JsonProperty("depth") Integer depth,
        @JsonProperty("id") Integer id,
        @JsonProperty("status") String status,
        @JsonProperty("releaseLine") ReleaseLineRef releaseLine,
        @JsonProperty("fixedVersion") FixedVersion fixedVersion) {
        this.type = type;
        this.upstreamImpactRecordIds = upstreamImpactRecordIds;
        this.unfixedUpstreamImpactRecordIds = unfixedUpstreamImpactRecordIds;
        this.depth = depth;
        this.id = id;
        this.status = status;
        this.releaseLine = releaseLine;
        this.fixedVersion = fixedVersion;
    }


}
