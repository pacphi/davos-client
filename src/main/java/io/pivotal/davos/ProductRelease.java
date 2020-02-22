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
    "releaseVersion",
    "releaseLineName",
    "releaseLineId",
    "releaseId",
    "releaseDate",
    "createdAt",
    "productName",
    "productId"
})
public class ProductRelease {

    @JsonProperty("releaseVersion")
    private String releaseVersion;
    @JsonProperty("releaseLineName")
    private String releaseLineName;
    @JsonProperty("releaseLineId")
    private Integer releaseLineId;
    @JsonProperty("releaseId")
    private Integer releaseId;
    @JsonProperty("releaseDate")
    private LocalDate releaseDate;
    @JsonProperty("createdAt")
    private LocalDate createdAt;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("productId")
    private Integer productId;

    @JsonCreator
    public ProductRelease(
        @JsonProperty("releaseVersion") String releaseVersion,
        @JsonProperty("releaseLineName") String releaseLineName,
        @JsonProperty("releaseLineId") Integer releaseLineId,
        @JsonProperty("releaseId") Integer releaseId,
        @JsonProperty("releaseDate") LocalDate releaseDate,
        @JsonProperty("createdAt") LocalDate createdAt,
        @JsonProperty("productName") String productName,
        @JsonProperty("productId") Integer productId) {
        this.releaseVersion = releaseVersion;
        this.releaseLineName = releaseLineName;
        this.releaseLineId = releaseLineId;
        this.releaseId = releaseId;
        this.releaseDate = releaseDate;
        this.createdAt = createdAt;
        this.productName = productName;
        this.productId = productId;
    }

}