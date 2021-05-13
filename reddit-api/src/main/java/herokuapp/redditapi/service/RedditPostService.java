package herokuapp.redditapi.service;

import herokuapp.redditapi.model.dto.RedditResp;
import java.util.Optional;

public interface RedditPostService {
     Optional<RedditResp> getTopRedditPost(String subreddit, String timeframe, int limit);
}
