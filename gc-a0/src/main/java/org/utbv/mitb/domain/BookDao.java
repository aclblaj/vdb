package org.utbv.mitb.domain;

public interface BookDao {
	Book getForTitle(String title);

	void createBook(Book book);
}