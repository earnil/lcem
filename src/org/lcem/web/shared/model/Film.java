package org.lcem.web.shared.model;

import java.io.Serializable;

public class Film implements Serializable {

	private static final long serialVersionUID = 4883315430579454193L;
	
	private String name;
	private String director;
	
	public Film(String name, String director) {
		this.name = name;
		this.director = director;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	
}
