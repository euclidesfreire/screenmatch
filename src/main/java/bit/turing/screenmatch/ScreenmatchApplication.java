package bit.turing.screenmatch;

import bit.turing.screenmatch.main.Main;

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

		Main main = new Main();
		
		main.run();
		
		// String movie = apiService.fetchData("https://www.omdbapi.com/?apikey=a08af02c&t=matrix");
		// MovieModel movieData = convert.getData(movie, MovieModel.class);
		// //System.out.println(movieData);

		// ArrayList<SeasonModel> seasons = new ArrayList<SeasonModel>();

		// for(int season = 1; season <= seriesData.totalSeasons(); season++){
		// 	String seasonData = apiService.fetchData("https://www.omdbapi.com/?apikey=a08af02c&season=" + season + "&t=supernatural");
		// 	SeasonModel seasonConvert = convert.getData(seasonData, SeasonModel.class);
		// 	//System.out.println(seasonConvert);

		// 	seasons.add(seasonConvert);
		// }

		// seasons.forEach(System.out::println);

	}
}
