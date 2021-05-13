package herokuapp.redditapi.model.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonRootName("reddit")
@AllArgsConstructor
public class RedditWrapper <T>{
    private T data;
    private int statusCode;
}
