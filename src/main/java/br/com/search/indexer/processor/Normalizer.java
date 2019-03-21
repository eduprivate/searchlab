package br.com.search.indexer.processor;

import java.util.ArrayList;
import java.util.List;

import br.com.search.model.Movie;

public class Normalizer {

	public String normalize(String content) {
		return content.toLowerCase().replaceAll("[^\\dA-Za-z ]", "");
	}

	public String normalizeToken(String content) {
		return content.toLowerCase().replaceAll("[\\[\\]]", "");
	}

	public List<String> normalize(List<Movie> movies) {
		List<String> normalizedContent = new ArrayList<String>();

		for (Movie movie : movies) {
			normalizedContent.add(normalize(movie.getContent()));
		}

		return normalizedContent;
	}

}
