package bit.turing.screenmatch.main;

import java.util.ArrayList;
import java.util.Scanner;

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

		for(int season = 1; season <= serieConvert.totalSeasons(); season++){
			String seasonData = apiService.fetchData(URL + "&season=" + season);
			SeasonModel seasonConvert = convert.getData(seasonData, SeasonModel.class);
			//System.out.println(seasonConvert);

			seasons.add(seasonConvert);
		}

		seasons.forEach(System.out::println);
    }

}
