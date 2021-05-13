package herokuapp.redditapi.service;

import herokuapp.redditapi.model.dto.RedditResp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedditPostServiceImpl implements RedditPostService{
    private final RestTemplate restTemplate;
    private final String redditUrl ="https://www.reddit.com/r/{subreddit}/top.json?limit={defaultLimit}&t={timeframe}";

    @Override
    public Optional<RedditResp> getTopRedditPost(String subreddit, String timeframe, int limit) {
        ParameterizedTypeReference<RedditResp> responseType =
                new ParameterizedTypeReference<RedditResp>() {
                };

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, createHttpHeaders());
        final ResponseEntity<RedditResp> exchange = restTemplate.exchange(redditUrl, HttpMethod.GET, request, responseType, subreddit, limit, timeframe);
        if (exchange.getStatusCode() == HttpStatus.OK && exchange.getBody() != null) {
            log.info("resp: {}",exchange.getBody());
            return Optional.of(exchange.getBody());
        }
        return Optional.empty();
    }

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        return headers;
    }
}
