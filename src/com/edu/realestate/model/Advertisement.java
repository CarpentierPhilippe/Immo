package com.edu.realestate.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;


@Entity
public class Advertisement {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd");
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@Enumerated (EnumType.STRING)
	private AdStatus status;
	@Enumerated (EnumType.STRING)
	@Column(name="transaction_type")
	private TransactionType transactionType;
	@Column(name="release_date")
	private LocalDate releaseDate;
	private String description;
	@Column(name="ad_number")
	private String adNumber;
	@Column(name="refused_comment")
	private String refusedComment;
	@ManyToOne @JoinColumn(name="advertiser_id")
	private Advertiser advertiser;
	@OneToOne @JoinColumn(name="real_estate_id")
	private RealEstate realEstate;
	@OneToMany (fetch=FetchType.LAZY)
	@JoinColumn(name="advertisement_id")
	@OrderBy ("id")
	private List<Picture> pictures;

	public Advertisement() {
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

	public Advertisement(int id, String title, RealEstate realEstate, AdStatus status, TransactionType transactionType,
			LocalDate releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.realEstate = realEstate;
		this.status = status;
		this.transactionType = transactionType;
		this.releaseDate = releaseDate;
	}

	public Advertiser getAdvertiser() {
		return advertiser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdNumber() {
		return adNumber;
	}

	public void setAdNumber(String adNumber) {
		this.adNumber = adNumber;
	}

	public String getRefusedComment() {
		return refusedComment;
	}

	public void setRefusedComment(String refusedComment) {
		this.refusedComment = refusedComment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RealEstate getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AdStatus getStatus() {
		return status;
	}

	public void setStatus(AdStatus status) {
		this.status = status;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	@PrePersist
	private void avantDeSauver() {
		if (adNumber == null || adNumber.isEmpty()) {
			Random rnd = new Random();
			int n = 1000+ rnd.nextInt();
			adNumber = "A"+ simpleDateFormat.format(new Date())+n;
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", title=" + title + ", status=" + status + ", transactionType="
				+ transactionType + ", releaseDate=" + releaseDate + ", description=" + description + ", adNumber="
				+ adNumber + ", refusedComment=" + refusedComment + ", advertiser=" + advertiser + ", realEstate="
				+ realEstate + ", pictures=" + pictures + "]";
	}
	

}
