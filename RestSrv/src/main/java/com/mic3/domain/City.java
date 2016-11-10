package com.mic3.domain;

public class City {
	
	public City(){}
	
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
	public String country;
	public String city;
	public String accent;
	public String region;
	public double population;
	public double latitude ;
	public double longitude;

}
