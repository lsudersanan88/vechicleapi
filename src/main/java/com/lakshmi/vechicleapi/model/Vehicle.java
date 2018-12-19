package com.lakshmi.vechicleapi.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Vehicle {

	private Integer Id;
	private Integer Year;
	private String Make;
	private String Model;

	public Vehicle(){}
	
	public Vehicle(Integer Id, Integer Year, String Make, String Model){
		this.Id = Id;
		this.Year = Year;
		this.Make = Make;
		this.Model = Model;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getYear() {
		return Year;
	}

	public void setYear(Integer year) {
		Year = year;
	}

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	@Override
	public String toString() {
		return "Vehicle{" +
				"Id=" + Id +
				", Year=" + Year +
				", Make='" + Make + '\'' +
				", Model='" + Model + '\'' +
				'}';
	}
}