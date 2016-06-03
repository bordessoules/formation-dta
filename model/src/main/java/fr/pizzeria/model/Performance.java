package fr.pizzeria.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String service;
	private Date dateMesure;
	private long executionTime;
	
	
	
	public Performance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Performance( String service, Date dateMesure, long executionTime) {
		super();
		this.service = service;
		this.dateMesure = dateMesure;
		this.executionTime = executionTime;
	}
	public Performance(Integer id, String service, Date dateMesure, long executionTime) {
		super();
		this.id = id;
		this.service = service;
		this.dateMesure = dateMesure;
		this.executionTime = executionTime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Date getDateMesure() {
		return dateMesure;
	}
	public void setDateMesure(Date dateMesure) {
		this.dateMesure = dateMesure;
	}
	public long getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
}
