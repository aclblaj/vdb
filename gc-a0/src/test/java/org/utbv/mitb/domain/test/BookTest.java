package org.utbv.mitb.domain.test;


import org.junit.Assert;
import org.junit.Test;
import org.utbv.mitb.domain.Book;


public class BookTest {

	private final String TITLE = "Poezii";
	
	@Test
	public void instatiateBook() {
		Book book = new Book();
		book.setTitle(TITLE);
		book.setPublishYear(2015L);
		Assert.assertTrue(book!=null && book.getTitle().equals(TITLE));
	}
}
