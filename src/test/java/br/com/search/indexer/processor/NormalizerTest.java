package br.com.search.indexer.processor;

import org.junit.Assert;
import org.junit.Test;

public class NormalizerTest {
	
	@Test
	public void specialCharactersRemovalTest() {
		// Give
		String content = "a cowboy needs a horse 1956  walt disney bill justice dick \"kinney\"";
		String expectedContent = "a cowboy needs a horse 1956  walt disney bill justice dick kinney";
		Normalizer normalizer = new Normalizer();

		// When
		String normalizedContent = normalizer.normalize(content);

		// Then
		Assert.assertEquals(expectedContent, normalizedContent);
	}
	
	@Test
	public void lowerCaseNormalizeTest() {
		// Give
		String content = "A COWBOY NEEDS A HORSE 1956  WALT DISNEY BILL JUSTICE DICK KINNEY";
		String expectedContent = "a cowboy needs a horse 1956  walt disney bill justice dick kinney";
		Normalizer normalizer = new Normalizer();

		// When
		String normalizedContent = normalizer.normalize(content);

		// Then
		Assert.assertEquals(expectedContent, normalizedContent);
	}
	
}