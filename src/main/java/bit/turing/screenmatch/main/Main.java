package bit.turing.screenmatch.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import bit.turing.screenmatch.model.series.EpisodeModel;
import bit.turing.screenmatch.model.series.SeasonModel;
import bit.turing.screenmatch.model.series.SeriesModel;
import bit.turing.screenmatch.services.ApiService;
import bit.turing.screenmatch.services.ConvertDataService;

public class Main {
    private final String API_URL = "https://www.omdbapi.com/?apikey=a08af02c&t=";

    private Scanner serie = new Scanner(System.in);
    private ApiService apiService = new ApiService();
    private ConvertDataService convert = new ConvertDataService();

    public void run() {

        System.out.println("Digite sua série favorita.");

        String nameSerie = serie.nextLine();

        String URL = API_URL + nameSerie.replace(" ", "+");

        String serieData = apiService.fetchData(URL);

        SeriesModel serieConvert = convert.getData(serieData, SeriesModel.class);
        System.out.println(serieConvert);

        ArrayList<SeasonModel> seasons = new ArrayList<SeasonModel>();

        for (int season = 1; season <= serieConvert.totalSeasons(); season++) {
            String seasonData = apiService.fetchData(URL + "&season=" + season);
            SeasonModel seasonConvert = convert.getData(seasonData, SeasonModel.class);
            // System.out.println(seasonConvert);

            seasons.add(seasonConvert);
        }

        // seasons.forEach(System.out::println);

        // Uso de Lambda
        // seasons.forEach(season -> season.episodes().forEach(episode ->
        // System.out.println(episode.rating())));

        /**
         * O flatMap consegue entrar na lista de uma lista List<List>
         */
        List<EpisodeModel> episodes = seasons.stream()
                .flatMap(season -> season.episodes().stream())
                .collect(Collectors.toList());

        List<EpisodeModel> topEpisodes = episodes.stream()
                .filter(episode -> !episode.rating().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(EpisodeModel::rating).reversed())
                .limit(5)
                .collect(Collectors.toList());

        //topEpisodes.forEach(System.out::println);

         /**
         * O flatMap consegue entrar na lista de uma lista List<List>
         */
        List<Map<EpisodeModel, Integer>> episodesMap = seasons.stream()
                .flatMap(season -> season.episodes().stream()
                    //map(episode -> episode)
                    .map(episode -> Map.of(episode, season.number()))
                )
                .collect(Collectors.toList());

        episodesMap.forEach(System.out::println);

    }

}
