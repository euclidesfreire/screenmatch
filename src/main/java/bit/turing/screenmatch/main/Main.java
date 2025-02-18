package bit.turing.screenmatch.main;

import java.util.Scanner;

import bit.turing.screenmatch.model.series.SeriesModel;
import bit.turing.screenmatch.services.ApiService;
import bit.turing.screenmatch.services.ConvertData;

public class Main {
    private final String API_URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=a08af02c";

    private Scanner serie = new Scanner(System.in);
    private ApiService apiService = new ApiService();
    private ConvertData convert = new ConvertData();

    public void run() {

        System.out.println("Digite sua série favorita.");

        String nameSerie = serie.nextLine();

        String URL = API_URL + nameSerie.replace(" ", "+") + API_KEY;

        String serieData = apiService.fetchData(URL);

        SeriesModel serieConvert = convert.getData(serieData, SeriesModel.class);
    }

}
