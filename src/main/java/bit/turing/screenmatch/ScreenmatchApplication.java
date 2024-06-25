package bit.turing.screenmatch;

import bit.turing.screenmatch.model.SeriesModel;
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

		String json = apiService.fetchData("https://www.omdbapi.com/?t=supernatural&i=tt3896198&apikey=a08af02c");

		ConvertData convert = new ConvertData();
		SeriesModel data = convert.getData(json, SeriesModel.class);

		System.out.println(data);
	}
}
