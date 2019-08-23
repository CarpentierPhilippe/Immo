package com.edu.realestate.model;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="user_data")
@DiscriminatorColumn(name = "user_type")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class User {
	
	@Id
	protected String username;
	protected String password;
	@OneToMany (fetch=FetchType.LAZY)
	@JoinColumn(name="owner")
	protected List<Favoris> favoris;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Favoris> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<Favoris> favoris) {
		this.favoris = favoris;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
