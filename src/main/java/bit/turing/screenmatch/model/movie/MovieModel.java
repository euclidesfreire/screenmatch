package bit.turing.screenmatch.model.movie;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record  MovieModel(
        @JsonAlias("Title") String title,
        @JsonAlias("Plot") String plot,
        @JsonAlias("Genre") String genre,
        @JsonAlias("Year") String year,
        @JsonAlias("imdbRating") String rating,
        @JsonAlias("Poster") String poster
) {}