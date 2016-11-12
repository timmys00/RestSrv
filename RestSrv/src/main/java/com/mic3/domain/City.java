package com.mic3.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cities")
public class City {
	
	protected City(){}
	
	public City(String country, String city, String accent, String region, double population, double lon, double lat){
		this.setCountry(country);
		this.setCity(city);
		this.setAccent(accent);
		this.setRegion(region);
		this.setPopulation(population);
		this.setLongitude(lon);
		this.setLatitude(lat);
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAccent() {
		return accent;
	}
	public void setAccent(String accent) {
		this.accent = accent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public double getPopulation() {
		return population;
	}
	public void setPopulation(double population) {
		this.population = population;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	@NotNull
	@Column(name = "country", nullable = false)
	public String country;

	@Id
	@NotNull
	@Column(name = "city", nullable = false)
	public String city;

	@NotNull
	@Column(name = "accent", nullable = false)
	public String accent;

	@NotNull
	@Column(name = "region", nullable = false)
	public String region;

	@NotNull
	@Column(name = "population", nullable = false)
	public double population;

	@NotNull
	@Column(name = "latitude", nullable = false)
	public double latitude ;

	@NotNull
	@Column(name = "longitude", nullable = false)
	public double longitude;

}
