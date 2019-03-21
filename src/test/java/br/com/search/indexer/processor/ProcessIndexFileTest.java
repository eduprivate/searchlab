package br.com.search.indexer.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.search.model.Movie;


public class ProcessIndexFileTest {
	
	public static final String FILES_PATH = "./src/test/java/resources/";

	@Test
	public void testReadFileWithContent() throws Exception {
		// Given 
		ProcessIndexFile processIndexFile = new ProcessIndexFile(FILES_PATH + "index2.ix");

		// When 
		Map<String, List<String>> index = processIndexFile.processIndexFile(); 
		
		// Then 
		Assert.assertTrue(index.size() > 0);
	}
 
	@Test
	public void testWriteIndex() throws Exception {
		// Given 
		Movie movie = new Movie("a cowboy needs a horse 1956  walt disney bill justice dick kinney", "a-cowboy-needs-a-horse.txt");
		List<Movie> movies = new ArrayList<>();
		movies.add(movie);
	    Analyzer analyzer = new Analyzer();
		Map<String, List<String>> indexMap = analyzer.analyze(movies);

		// When
	    ProcessIndexFile processIndexFile = new ProcessIndexFile(FILES_PATH+"index2.ix");
	    processIndexFile.writeIndex(indexMap);
	    Map<String, List<String>> indexMapResult = processIndexFile.processIndexFile();
		
		// Then 
		Assert.assertTrue(indexMapResult.size() > 0);
	}

}