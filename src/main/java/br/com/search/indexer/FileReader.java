package br.com.search.indexer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.search.indexer.processor.Normalizer;
import br.com.search.model.Movie;

public class FileReader {

	private Normalizer normalizer;

	public FileReader(Normalizer normalizer) {
		this.normalizer = normalizer;
	}

	public Movie readMovieFile(File file) throws IOException {

		InputStream is = new FileInputStream(file);
		BufferedReader buf = new BufferedReader(new InputStreamReader(is));

		String line = buf.readLine();

		is.close();
		buf.close();

		return new Movie(this.normalizer.normalize(line), file.getName().trim());
	}
}
