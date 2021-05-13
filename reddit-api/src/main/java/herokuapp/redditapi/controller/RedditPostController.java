package herokuapp.redditapi.controller;


import herokuapp.redditapi.model.dto.RedditResp;
import herokuapp.redditapi.model.dto.RedditWrapper;
import herokuapp.redditapi.service.RedditPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/query")
@RequiredArgsConstructor
public class RedditPostController {

    private final RedditPostService redditPostService;

    @GetMapping("/top/{subreddit}/{timeframe}")
    public RedditWrapper getTopRedditPost(@PathVariable String subreddit, @PathVariable String timeframe, @RequestParam(required = false) Integer limit){
        final Optional<RedditResp> topRedditPost = redditPostService.getTopRedditPost(subreddit, timeframe ,limit == null ? 10 : limit);
        if(topRedditPost.isPresent()){
            return new RedditWrapper(topRedditPost.get().getData(), 200);
        }
        return new RedditWrapper(Collections.EMPTY_LIST, 400);
    }
}
