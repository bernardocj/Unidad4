package boot.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="songs")
public class Song implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String name;
	@Column(length=45)
	private String artist;
	@Column(name="date_premier")
	private String datePremier;
	private String format;
	private String album;
		private int cost;
	
	
	public Song(String name, String artist, String datePremier,String format,String album, int cost) {
		super();
		this.name = name;
		this.artist = artist;
		this.datePremier = datePremier;
		this.format=format;
		this.album=album;
		this.cost = cost;
	}
	
	public Song() {
		this("","", "","","",0);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDatePremier() {
		return datePremier;
	}

	public void setDatePremier(String datePremier) {
		this.datePremier = datePremier;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", artist=" + artist + ", datePremier=" + datePremier
				+ ", format=" + format + ", album=" + album +", cost="+cost+ "]";
	}

	
	
}
