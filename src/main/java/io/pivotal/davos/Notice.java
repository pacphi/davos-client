
package io.pivotal.davos;

import java.time.LocalDate;
import java.util.List;

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
    "id",
    "type",
    "sourceId",
    "title",
    "details",
    "vendor",
    "cvssVector",
    "severity",
    "reporterAcknowledgement",
    "status",
    "urls",
    "cwe",
    "pendingDerivation",
    "discoveredDate",
    "publishedDate",
    "receivedDate"
})
@ToString
public class Notice {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("sourceId")
    private String sourceId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("details")
    private String details;
    @JsonProperty("vendor")
    private String vendor;
    @JsonProperty("cvssVector")
    private String cvssVector;
    @JsonProperty("severity")
    private String severity;
    @JsonProperty("reporterAcknowledgement")
    private String reporterAcknowledgement;
    @JsonProperty("status")
    private String status;
    @JsonProperty("urls")
    private List<Url> urls;
    @JsonProperty("cwe")
    private String cwe;
    @JsonProperty("pendingDerivation")
    private boolean pendingDerivation;
    @JsonProperty("discoveredDate")
    private LocalDate discoveredDate;
    @JsonProperty("publishedDate")
    private LocalDate publishedDate;
    @JsonProperty("receivedDate")
    private LocalDate receivedDate;


    public Notice(
        @JsonProperty("id") Integer id,
        @JsonProperty("type") String type,
        @JsonProperty("sourceId")String sourceId,
        @JsonProperty("title") String title,
        @JsonProperty("details") String details,
        @JsonProperty("vendor") String vendor,
        @JsonProperty("cvssVector") String cvssVector,
        @JsonProperty("severity") String severity,
        @JsonProperty("reporterAcknowledgement") String reporterAcknowledgement,
        @JsonProperty("status") String status,
        @JsonProperty("urls") List<Url> urls,
        @JsonProperty("cwe") String cwe,
        @JsonProperty("pendingDerivation") boolean pendingDerivation,
        @JsonProperty("discoveredDate") LocalDate discoveredDate,
        @JsonProperty("publishedDate") LocalDate publishedDate,
        @JsonProperty("receivedDate") LocalDate receivedDate) {
        this.id = id;
        this.type = type;
        this.sourceId = sourceId;
        this.title = title;
        this.details = details;
        this.vendor = vendor;
        this.cvssVector = cvssVector;
        this.severity = severity;
        this.reporterAcknowledgement = reporterAcknowledgement;
        this.status = status;
        this.urls = urls;
        this.cwe = cwe;
        this.pendingDerivation = pendingDerivation;
        this.discoveredDate = discoveredDate;
        this.publishedDate = publishedDate;
        this.receivedDate = receivedDate;
    }

}
