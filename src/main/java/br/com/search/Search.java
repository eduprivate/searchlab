package br.com.search;

import java.util.Set;

import br.com.search.service.SearchService;

public class Search {

	public void search(String query) throws Exception {
		SearchService service = new SearchService();
		Set<String> search = service.search(query);

		System.out.println("Foram encontradas " + search.size() + " ocorrências pelo termo \"" + query + "\".");  
		System.out.println("Os arquivos que possuem \"" + query + "\" são: ");
		for (String results : search) {
			System.out.println(results.trim());
		}
	}
}
