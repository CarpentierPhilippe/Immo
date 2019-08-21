package com.edu.realestate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Picture {
	
	@Id
	private Integer id;
	private Byte[] content;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Byte[] getContent() {
		return content;
	}
	public void setContent(Byte[] content) {
		this.content = content;
	}
	public String toString() {
		return "Picture [id=" + id + "content= "+ content +" ]";
	}
	
}
