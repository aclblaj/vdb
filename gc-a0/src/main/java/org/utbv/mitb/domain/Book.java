package org.utbv.mitb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//User is a keyword in some SQL dialects!
@Table(name="Books")
public class Book {

	@Id
    @GeneratedValue
    private Long id;
	
    @Column(unique = true)
    private String title;
    
    private Long publishYear;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Long publishYear) {
		this.publishYear = publishYear;
	}
    
}
