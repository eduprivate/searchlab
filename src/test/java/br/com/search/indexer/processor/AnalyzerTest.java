package br.com.search.indexer.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.search.model.Movie;

public class AnalyzerTest {
		
	@Test
	public void testAnalyzerProcessing() throws Exception{
		// Give
		Movie movie = new Movie("a cowboy needs a horse 1956  walt disney bill justice dick kinney", "a-cowboy-needs-a-horse.txt");
		List<Movie> movies = new ArrayList<>();
		movies.add(movie);
		Analyzer analyzer = new Analyzer();
		// When
		Map<String, List<String>> mapIndex = analyzer.analyze(movies);

		// Then
		Assert.assertTrue(mapIndex.size() > 0);
	}
}