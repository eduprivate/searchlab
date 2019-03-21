package br.com.search.indexer.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.search.model.Movie;

public class TokenizerTest {
	
	public static final String HTML_FILES_PATH = "./src/test/resources/";

	@Test
	public void tokenizeMovieListTest() throws Exception {
		// Given
		Movie movie = new Movie("a cowboy needs a horse 1956  walt disney bill justice dick kinney", "a-cowboy-needs-a-horse.txt");
		List<Movie> movies = new ArrayList<>();
		movies.add(movie);

		// When 
		Tokenizer tokenizer = new Tokenizer();
		Map<String, List<String>> indexMap = tokenizer.tokenize(movies);
		
		// Then 
		Assert.assertTrue(indexMap.size() > 0);
	}
	
	@Test
	public void sameTokeMultipleDocsTest() throws Exception {
		// Given
		Movie movie = new Movie("a cowboy needs a horse 1956  walt disney bill justice dick kinney", "a-cowboy-needs-a-horse.txt");
		List<Movie> movies = new ArrayList<>();
		movies.add(movie);

		// When 
		Tokenizer tokenizer = new Tokenizer();
		Map<String, List<String>> indexMap = tokenizer.tokenize(movies);
		
		// Then 
		Assert.assertTrue(indexMap.size() > 0);
		Assert.assertTrue(indexMap.get("cowboy") != null);
	}
}
