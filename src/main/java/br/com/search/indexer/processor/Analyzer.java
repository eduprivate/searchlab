package br.com.search.indexer.processor;

import java.util.List;
import java.util.Map;

import br.com.search.model.Movie;

public class Analyzer {

	public Map<String, List<String>> analyze(List<Movie> movies) {
		Tokenizer tokenizer = new Tokenizer();
		Map<String, List<String>> indexMap = tokenizer.tokenize(movies);
		return indexMap;
	}

}
