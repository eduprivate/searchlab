package br.com.search;

import java.util.List;
import java.util.Map;

import br.com.search.exception.InvalidParameterException;
import br.com.search.utils.ParameterUtil;
import br.com.search.utils.ParametersMapUtils;

public class Searcher {

	public static void main(String[] args) throws InvalidParameterException, Exception {
		if (args.length < 1) {
			System.out.println("Usage: search.jar -query <PATH> \n" + "	-query	Path of files to be indexed.\n");

			System.exit(-1);
		}

		Map<String, List<String>> params = ParametersMapUtils.buildParamMap(args);
		String query = ParameterUtil.getParameter("query", params, true);

		Search search = new Search();
		search.search(query);
	}
}
