package br.com.search.indexer;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import br.com.search.indexer.processor.Normalizer;
import br.com.search.model.Movie;
import br.com.search.service.SearchService;

public class FileIndexer {

	public void indexPath(final String path) throws Exception {
		List<Movie> movies = new ArrayList<Movie>();
		if (path == null || path.length() == 0) {
			throw new InvalidParameterException("Invalid path.");
		}

		final File folder = new File(path);
		final Normalizer normalizer = new Normalizer();
		final FileReader fileReader = new FileReader(normalizer);
		final SearchService elService = new SearchService();

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				indexPath(fileEntry.getName());
			} else {
				Movie movie = fileReader.readMovieFile(fileEntry);
				movies.add(movie);
			}
		}
		elService.index(movies);
	}
}