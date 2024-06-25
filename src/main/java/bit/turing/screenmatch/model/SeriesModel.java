package bit.turing.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesModel(@JsonAlias("Title") String title,
                          @JsonAlias("Plot") String plot,
                          @JsonAlias("Genre") String genre,
                          @JsonAlias("Year") String year,
                          @JsonAlias("totalSeasons") Integer totalSeasons,
                          @JsonAlias("imdbRating") String rating
) {}
