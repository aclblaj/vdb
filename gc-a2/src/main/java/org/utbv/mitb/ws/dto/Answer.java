package org.utbv.mitb.ws.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Answer {
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}