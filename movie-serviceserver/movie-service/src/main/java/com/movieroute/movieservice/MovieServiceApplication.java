package com.movieroute.movieservice;

import com.movieroute.movieservice.domain.Movie;
import com.movieroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// @EnableSwagger2
public class MovieServiceApplication/* implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner */{

	/*@Autowired
	MovieRepository movieRepository;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		Movie movie = new Movie("6","movie1",5.4,"facebook.com");
		movieRepository.save(movie);

	} */

	/*@Override

	public void run(String...args) throws Exception {

		movieRepository.findAll();
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);

	}

}
