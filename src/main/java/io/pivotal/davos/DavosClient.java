package io.pivotal.davos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "davos-client", url = "https://davos.cfapps.io", path = "/api/v1/admin")
public interface DavosClient {

    @GetMapping(path = "/notices")
    Mono<Notices> getNotices(
        @RequestHeader("Authorization") String token,
        @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
        @RequestParam(name = "sort", required = false, defaultValue = "publishedData,desc") String sort,
        @RequestParam(name = "size", required = false, defaultValue = "25") Integer size,
        @RequestParam(name = "severityFilter", required = false, defaultValue = "critical,high,medium,low,unknown") String severityFilter,
        @RequestParam(name = "statusFilter", required = false, defaultValue = "resolved,unaffected,pendingdirect,pendingdependent,canceled,unknown") String statusFilter);

    @GetMapping(path = "/notices/{id}/cves")
    Flux<NoticeVulnerability> getNoticeVulnerability(
        @RequestHeader("Authorization") String token,
        @PathVariable("id") String id);

    @GetMapping(path = "/notices/{id}/impact-records")
    Flux<ImpactRecord> getImpactRecord(
        @RequestHeader("Authorization") String token,
        @PathVariable("id") String id);

    @GetMapping(path = "/products")
    Flux<Product> getProducts(
        @RequestHeader("Authorization") String token);

    @GetMapping(path = "/releases")
    Mono<ProductReleases> getReleases(
        @RequestHeader("Authorization") String token,
        @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
        @RequestParam(name = "size", required = false, defaultValue = "25") Integer size,
        @RequestParam(name = "searchQuery", required = false) String releaseVersion,
        @RequestParam(name = "releaseLines", required = false) Integer productId
    );

    @GetMapping(path = "/releases/{id}/vulnerability-exposures")
    Flux<VulnerabilityExposure> getVulnerabilityExposures(
        @RequestHeader("Authorization") String token,
        @PathVariable("id") String id);

}