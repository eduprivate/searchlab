package br.com.search.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.search.indexer.processor.Normalizer;
import br.com.search.indexer.processor.ProcessIndexFile;
import br.com.search.indexer.processor.Tokenizer;
import br.com.search.model.Movie;

public class SearchService {

	private ProcessIndexFile indexFile;

	public SearchService() {
		this.indexFile = new ProcessIndexFile();
	}
	
	public SearchService(String indexFile) {
		this.indexFile = new ProcessIndexFile(indexFile);
	}

	public void index(List<Movie> movies) throws IOException, Exception {
		Tokenizer tokenizer = new Tokenizer();
		Map<String, List<String>> indexMap = tokenizer.tokenize(movies);
		this.indexFile.writeIndex(indexMap);
	}

	public Set<String> search(String queryTerm) throws Exception {
		Set<String> resultSet = new HashSet<>();
		Map<String, List<String>> processIndexFile = indexFile.processIndexFile();
		Normalizer normalizer = new Normalizer();
		String[] queryTokens = queryTerm.split(" ");

		for (int i = 0; i < queryTokens.length; i++) {
			resultSet
					.addAll(processIndexFile.get(normalizer.normalize(queryTokens[i]).trim()).stream()
							.collect(Collectors.toSet()));
		}

		return resultSet;
	}
}
