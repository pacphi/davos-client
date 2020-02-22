
package io.pivotal.davos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "releaseLines",
    "id",
    "name",
    "organization",
    "releaseSourceType",
    "releaseSourceId",
    "trackerProjectId",
    "manifestIdentifiers",
    "ignoredManifestIdentifiers",
    "bomFetchType",
    "bomSourceIdentifier",
    "preferred",
    "type"
})
public class Product {

    @JsonProperty("releaseLines")
    private List<ReleaseLine> releaseLines;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("organization")
    private String organization;
    @JsonProperty("releaseSourceType")
    private String releaseSourceType;
    @JsonProperty("releaseSourceId")
    private String releaseSourceId;
    @JsonProperty("trackerProjectId")
    private String trackerProjectId;
    @JsonProperty("manifestIdentifiers")
    private List<String> manifestIdentifiers;
    @JsonProperty("ignoredManifestIdentifiers")
    private List<String> ignoredManifestIdentifiers;
    @JsonProperty("bomFetchType")
    private String bomFetchType;
    @JsonProperty("bomSourceIdentifier")
    private String bomSourceIdentifier;
    @JsonProperty("preferred")
    private boolean preferred;
    @JsonProperty("type")
    private String type;

    @JsonCreator
    public Product(
        @JsonProperty("releaseLines") List<ReleaseLine> releaseLines,
        @JsonProperty("id") Integer id,
        @JsonProperty("name") String name,
        @JsonProperty("organization") String organization,
        @JsonProperty("releaseSourceType") String releaseSourceType,
        @JsonProperty("releaseSourceId") String releaseSourceId,
        @JsonProperty("trackerProjectId") String trackerProjectId,
        @JsonProperty("manifestIdentifiers") List<String> manifestIdentifiers,
        @JsonProperty("ignoredManifestIdentifiers") List<String> ignoredManifestIdentifiers,
        @JsonProperty("bomFetchType") String bomFetchType,
        @JsonProperty("bomSourceIdentifier") String bomSourceIdentifier,
        @JsonProperty("preferred") boolean preferred,
        @JsonProperty("type") String type) {
        this.releaseLines = releaseLines;
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.releaseSourceType = releaseSourceType;
        this.releaseSourceId = releaseSourceId;
        this.trackerProjectId = trackerProjectId;
        this.manifestIdentifiers = manifestIdentifiers;
        this.ignoredManifestIdentifiers = ignoredManifestIdentifiers;
        this.bomFetchType = bomFetchType;
        this.bomSourceIdentifier = bomSourceIdentifier;
        this.preferred = preferred;
        this.type = type;
    }

}
