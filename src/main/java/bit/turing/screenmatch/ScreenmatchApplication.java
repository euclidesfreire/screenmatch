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

	}
}
