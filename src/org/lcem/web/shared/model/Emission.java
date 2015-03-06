package org.lcem.web.shared.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Emission implements Serializable {

	private static final long serialVersionUID = -3468529378799359329L;
	
	private Long id;
	private String name;
	private Date date;
	private String link;
	private Set<Track> tracks;
	private Set<Film> films;

	public Emission() {
		this.tracks = new HashSet<Track>();
		this.films = new HashSet<Film>();
	}

	public Emission(String name, Date date) {
		this.name = name;
		this.date = date;
		this.tracks = new HashSet<Track>();
		this.films = new HashSet<Film>();
	}

	public Emission(String name, Date date, String link) {
		this.name = name;
		this.date = date;
		this.link = link;
		this.tracks = new HashSet<Track>();
		this.films = new HashSet<Film>();
	}
	
	public Emission(String name, Date date, String link, Set<Track> tracks, Set<Film> films) {
		this.name = name;
		this.date = date;
		this.link = link;
		this.tracks = tracks;
		this.films = films;
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
	protected Set<Track> getTracks() {
		return tracks;
	}
	
	/**
	 * @param tracks the tracks to set
	 */
	protected void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}
	
    public void addToFilm(Track track) {
        this.getTracks().add(track);
        track.getEmissions().add(this);
    }

	public void removeFromEvent(Track track) {
        this.getTracks().remove(track);
        track.getEmissions().remove(this);
    }	
	
	/**
	 * @return the films
	 */
	protected Set<Film> getFilms() {
		return films;
	}
	
	/**
	 * @param films the films to set
	 */
	protected void setFilms(Set<Film> films) {
		this.films = films;
	}
	
    public void addToFilm(Film film) {
        this.getFilms().add(film);
        film.getEmissions().add(this);
    }

    public void removeFromEvent(Film film) {
        this.getFilms().remove(film);
        film.getEmissions().remove(this);
    }
	
}
