package io.pivotal.davos;

import org.assertj.core.api.Assertions;
import org.cloudfoundry.uaa.tokens.GetTokenByPasswordResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import feign.FeignException.Forbidden;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
@SpringBootTest
class DavosClientTests {

	private static final String URI_TEMPLATE = "https://%s";

	private final DavosClient davosClient;
	private final WebClient webClient;
	private final UaaCredentials credentials;

	@Autowired
	DavosClientTests(
		DavosClient davosClient,
		WebClient webClient,
		UaaCredentials credentials
	) {
		this.davosClient = davosClient;
		this.webClient = webClient;
		this.credentials = credentials;
	}

	@Test
	void assertThatUnauthorizedCallToGetNoticesFails() {
		StepVerifier
			.create(
				davosClient.getNotices("foo",null, null, null, null, null)
			)
			.expectErrorMatches(throwable -> throwable instanceof Forbidden)
			.verify();
	}

	// FIXME  This is where we need to focus the effort.  All client requests are being rebuffed.
	// Need to understand how to authenticate and what to pass along either in request header(s) or via cookie

	// As of 2020-02-22 each test below currently fails, and not in way you'd expect

	// @see https://docs.cloudfoundry.org/api/uaa/version/4.35.0/index.html#password-grant
    private Mono<String> obtainAccessToken() {
        String get = String.format(URI_TEMPLATE, credentials.getApiEndpoint());
        LinkedMultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("grant_type", "password");
        request.add("client_id", credentials.getClientId());
        request.add("client_secret", credentials.getClientSecret());
        request.add("username", credentials.getUsername());
        request.add("password", credentials.getPassword());
        return webClient
                .post()
                .uri(get)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(GetTokenByPasswordResponse.class)
                .map(r -> r.getAccessToken());
	}

	@Test
	void assertThatCallToObtainAuthTokenSucceeds() {
		StepVerifier
			.create(
				obtainAccessToken()
			)
			.assertNext(token -> {
				log.info("Token: " + token);
				Assertions.assertThat(token).isNotBlank();
			})
			.verifyComplete();
	}

	@Test
	void assertThatAuthorizedCallToGetNoticesSucceeds() {
		StepVerifier
			.create(
				obtainAccessToken()
					.flatMap(token -> davosClient.getNotices(token, null, null, null, null, null))
			)
			.assertNext(notice -> {
				log.info("Notice: " + notice.toString());
				Assertions.assertThat(notice.getNotices()).isNotEmpty();
			})
			.verifyComplete();
	}
}
