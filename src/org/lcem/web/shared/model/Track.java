package org.lcem.web.shared.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Track implements Serializable {

	private static final long serialVersionUID = 1414837357719057878L;
	
	private Long id;
	private String name;
	private String songWriter;
	private String performer;
	private Set<Emission> emissions;

	public Track() {
		this.emissions = new HashSet<Emission>();
	}

	public Track(String name, String songWriter, String performer) {
		this.name = name;
		this.songWriter = songWriter;
		this.performer = performer;
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
	 * @return the songWriter
	 */
	public String getSongWriter() {
		return songWriter;
	}
	
	/**
	 * @param songWriter the songWriter to set
	 */
	public void setSongWriter(String songWriter) {
		this.songWriter = songWriter;
	}
	
	/**
	 * @return the performer
	 */
	public String getPerformer() {
		return performer;
	}
	
	/**
	 * @param performer the performer to set
	 */
	public void setPerformer(String performer) {
		this.performer = performer;
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
        emission.getTracks().add(this);
    }

	public void removeFromEvent(Emission emission) {
        this.getEmissions().remove(emission);
        emission.getTracks().remove(this);
    }	
		
}
