package herokuapp.redditapi.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
public class RedditResp {
    private String kind;
    private RedditChildren data;
}

@Data
class RedditChildren {
    private List<RedditInnerChildren> children;
}

@Data
class RedditInnerChildren {
    private RedditData data;
}
