package br.com.search.indexer;

import java.util.List;
import java.util.Map;

import br.com.search.exception.InvalidParameterException;
import br.com.search.utils.ParameterUtil;
import br.com.search.utils.ParametersMapUtils;

public class Indexer {

	public static void main(String[] args) throws InvalidParameterException, Exception {
		if (args.length < 1) {
			System.out.println(
					"Usage: indexer.jar -indexPath <PATH> \n" + "	-indexPath	Path of files to be indexed.\n");

			System.exit(-1);
		}

		Map<String, List<String>> params = ParametersMapUtils.buildParamMap(args);
		String indexPath = ParameterUtil.getParameter("indexPath", params, true);

		FileIndexer fileIndexer = new FileIndexer();
		fileIndexer.indexPath(indexPath);
	}
}
