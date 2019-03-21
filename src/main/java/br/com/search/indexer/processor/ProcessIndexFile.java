package br.com.search.indexer.processor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessIndexFile {

	private static final String DEFAULT_INDEX_FILE = "/tmp/index.ix";
	private String indexFile;
	
	public ProcessIndexFile() {
		this.indexFile = DEFAULT_INDEX_FILE;
	}
	
	public ProcessIndexFile(String indexFile) {
		this.indexFile = indexFile;
	}

	public Map<String, List<String>> processIndexFile() throws Exception {
		File fileIndex = new File(this.indexFile);
		Map<String, List<String>> indexMap = new HashMap<String, List<String>>();
		Normalizer normalizer = new Normalizer();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIndex))) {
			StringBuffer tokenBuffer = new StringBuffer();
			String tokenLine;

			while ((tokenLine = bufferedReader.readLine()) != null) {
				tokenBuffer.append(tokenLine);
			}

			if (tokenBuffer.length() == 0) {
				throw new Exception("No index content");
			}

			String fileTokens[] = tokenBuffer.toString().split("\\],");

			for (int i = 0; i < fileTokens.length; i++) {
				if (fileTokens[i].trim().isEmpty())
					continue;
				String[] index = fileTokens[i].split("=");
				String token = index[0];
				String unnormalizedDoc = index[1];

				if (!token.isEmpty() && !unnormalizedDoc.isEmpty()) {
					String[] docs = normalizer.normalizeToken(unnormalizedDoc).split(",");
					List<String> listDocs = Arrays.asList(docs);
					indexMap.put(token.trim(), listDocs);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return indexMap;
	}

	public void writeIndex(Map<String, List<String>> indexMap) throws IOException, Exception {
		File fileIndex = new File(this.indexFile);

		BufferedWriter output = null;

		try {
			Map<String, List<String>> existingIndexMap = null;
			if (fileIndex.exists()) {
				existingIndexMap = processIndexFile();
				indexMap.putAll(existingIndexMap);
			}

			String content = indexMap.toString().replaceAll("[\\{\\}]", "");
			output = new BufferedWriter(new FileWriter(fileIndex));
			output.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null)
				output.close();
		}
	}
}
