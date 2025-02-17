package bit.turing.screenmatch.model.series;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonModel(
        @JsonAlias("Season") Integer number,
        Integer totalEpisodes,
        @JsonAlias("Episodes") List<EpisodeModel> episodes
) {}
