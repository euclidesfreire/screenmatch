package bit.turing.screenmatch;

import bit.turing.screenmatch.model.movie.MovieModel;
import bit.turing.screenmatch.model.series.SeriesModel;
import bit.turing.screenmatch.services.ApiService;
import bit.turing.screenmatch.services.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiService apiService = new ApiService();
		ConvertData convert = new ConvertData();

		String movie = apiService.fetchData("https://www.omdbapi.com/?apikey=a08af02c&t=matrix");
		MovieModel movieData = convert.getData(movie, MovieModel.class);
		System.out.println(movieData);
		
		String series = apiService.fetchData("https://www.omdbapi.com/?apikey=a08af02c&t=supernatural");
		SeriesModel seriesData = convert.getData(series, SeriesModel.class);
		System.out.println(seriesData);

		for(int season = 1; season < seriesData.totalSeasons(); season++){
			String seasonData = apiService.fetchData("https://www.omdbapi.com/?apikey=a08af02c&season=" + season + "&t=supernatural");
			//SeriesModel seasonConvert = convert.getData(series, SeModel.class);
			System.out.println(seasonData);
		}
	}
}
