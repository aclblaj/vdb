package org.utbv.mitb.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean(name = "wordBean")
@ViewScoped

public class Anagram implements Serializable {

	private static final long serialVersionUID = 4957841870563527390L;

	private String word;

	private String anagram;

	public void generateAnagram() {

		List<Character> characters = new ArrayList<Character>();
		if (word==null || word.length()==0) {
			word = "empty";
		}
		for (char c : word.toCharArray()) {
			characters.add(c);
		}
		StringBuilder output = new StringBuilder(word.length());
		while (characters.size() != 0) {
			int randPicker = (int) (Math.random() * characters.size());
			output.append(characters.remove(randPicker));
		}
		this.anagram = output.toString();

	}

	public String getAnagram() {
		return anagram;
	}

	public void setAnagram(String anagram) {
		this.anagram = anagram;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}