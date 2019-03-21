package br.com.search.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.search.model.Movie;

public class SearchServiceTest {

	public static final String FILES_PATH = "./src/test/java/resources/";

	@Test
	public void testIndex() throws IOException, Exception {
		Movie movie = new Movie("a cowboy needs a horse 1956  walt disney bill justice dick kinney",
				"a-cowboy-needs-a-horse.txt");
		List<Movie> movies = new ArrayList<>();
		movies.add(movie);
		SearchService subject = new SearchService(FILES_PATH + "index3.ix");

		subject.index(movies);

		Assert.assertTrue(subject.search("walt").size() > 0);
	}

	@Test
	public void testSearch() throws IOException, Exception {
		Movie movie = new Movie("a cowboy needs a horse 1956  walt disney bill justice dick kinney",
				"a-cowboy-needs-a-horse.txt");
		List<Movie> movies = new ArrayList<>();
		movies.add(movie);
		SearchService subject = new SearchService(FILES_PATH + "index3.ix");

		subject.index(movies);

		Assert.assertTrue(subject.search("walt disney").size() > 0);
	}

}
