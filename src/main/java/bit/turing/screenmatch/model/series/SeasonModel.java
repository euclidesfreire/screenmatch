package bit.turing.screenmatch.model.series;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record SeasonModel(
        @JsonAlias("number") Integer number,
        @JsonAlias("totalSeasons") Integer totalSeasons,
        List<episodeModel> episodes
) {}
