package org.lcem.web.shared.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Film implements Serializable {

	private static final long serialVersionUID = 4883315430579454193L;

	private Long id;
	private String name;
	private String director;
	private Set<Emission> emissions;

	public Film() {
		this.emissions = new HashSet<Emission>();
	}
	
	public Film(String name, String director) {
		this.name = name;
		this.director = director;
		this.emissions = new HashSet<Emission>();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the emissions
	 */
	protected Set<Emission> getEmissions() {
		return emissions;
	}

	/**
	 * @param emissions the emissions to set
	 */
	protected void setEmissions(Set<Emission> emissions) {
		this.emissions = emissions;
	}
	
    public void addToEmission(Emission emission) {
        this.getEmissions().add(emission);
        emission.getFilms().add(this);
    }

	public void removeFromEvent(Emission emission) {
        this.getEmissions().remove(emission);
        emission.getFilms().remove(this);
    }	
	
}
