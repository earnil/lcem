package org.lcem.web.shared.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Emission implements Serializable {

	private static final long serialVersionUID = -3468529378799359329L;
	
	private String name;
	private Date date;
	private String link;
	private List<Track> tracks;
	private List<Film> films;

	public Emission() {
		this.name = null;
		this.date = null;
		this.link = null;
		this.tracks = new ArrayList<Track>();
		this.films = new ArrayList<Film>();
	}

	public Emission(String name, Date date) {
		this.name = name;
		this.date = date;
		this.link = null;
		this.tracks = new ArrayList<Track>();
		this.films = new ArrayList<Film>();
	}

	public Emission(String name, Date date, String link) {
		this.name = name;
		this.date = date;
		this.link = link;
		this.tracks = new ArrayList<Track>();
		this.films = new ArrayList<Film>();
	}
	
	public Emission(String name, Date date, String link, List<Track> tracks, List<Film> films) {
		this.name = name;
		this.date = date;
		this.link = link;
		this.tracks = tracks;
		this.films = films;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * @return the tracks
	 */
	public List<Track> getTracks() {
		return tracks;
	}
	
	/**
	 * @param tracks the tracks to set
	 */
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	/**
	 * @return the films
	 */
	public List<Film> getFilms() {
		return films;
	}
	
	/**
	 * @param films the films to set
	 */
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
}
