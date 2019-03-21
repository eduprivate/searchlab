package br.com.search.indexer.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.search.model.Movie;

public class Tokenizer {

	public Map<String, List<String>> tokenize(List<Movie> movies) {
		Map<String, List<String>> indexMap = new HashMap<String, List<String>>();

		for (Movie movie : movies) {
			String tokens[] = movie.getContent().split("\\s");

			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].trim().isEmpty())
					continue;
				if (indexMap.get(tokens[i]) != null) {
					List<String> indexedContent = indexMap.get(tokens[i]);
					addContentToList(movie.getFileName(), indexedContent);
				} else {
					List<String> indexedContent = new ArrayList<String>();
					addContentToList(movie.getFileName(), indexedContent);
					indexMap.put(tokens[i], indexedContent);
				}
			}
		}
		return indexMap;
	}

	private void addContentToList(String normalizedContent, List<String> indexedContent) {
		indexedContent.add(normalizedContent);
	}
}