package org.lcem.web.shared.model;

import java.io.Serializable;

public class Track implements Serializable {

	private static final long serialVersionUID = 1414837357719057878L;
	
	private String name;
	private String songWriter;
	private String performer;
	
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
		
}
