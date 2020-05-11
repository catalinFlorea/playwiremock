package com.playwiremock.customer.webclient;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Controller
public class ProviderWebClient {

	private static final String PROVIDER_BASE_URL = "http://localhost:8080";
	private static final String LOGIN_URI_FUNCTION = "/login";

	private static final Logger logger = LoggerFactory.getLogger(ProviderWebClient.class);

	private ProviderWebClient() {
	}

	public static WebClient builder() {
		TcpClient tcpClient = TcpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30_000)
				.doOnConnected(connection -> connection.addHandlerLast(new ReadTimeoutHandler(30))
						.addHandlerLast(new WriteTimeoutHandler(30)));

		return WebClient.builder().baseUrl(PROVIDER_BASE_URL)
				.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.ALL_VALUE)
				.defaultHeader(HttpHeaders.USER_AGENT, "Aggregation API").build();
	}

	public static AuthorizationToken getAuthToken(String username) {
		return ProviderWebClient.builder().post().uri(LOGIN_URI_FUNCTION).header("username", username).retrieve()
				.bodyToMono(AuthorizationToken.class).block(Duration.ofSeconds(5));
	}
}
