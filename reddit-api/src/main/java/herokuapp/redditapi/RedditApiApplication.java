package herokuapp.redditapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"herokuapp.redditapi"})
public class RedditApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedditApiApplication.class, args);
    }

}
