package bit.turing.screenmatch.model.series;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeModel(
        @JsonAlias("Episode") Integer number,
        @JsonAlias("Title") String title,
        @JsonAlias("Plot") String plot,
        @JsonAlias("imdbRating") String rating,
        @JsonAlias("Released") String released
) {}
