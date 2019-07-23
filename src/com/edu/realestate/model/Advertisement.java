package com.edu.realestate.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class Advertisement {

	static DateFormat df = new SimpleDateFormat("yy");
		
	private int id;
	private String title;
	private AdStatus status;
	private TransactionType transactionType;
	private LocalDate releaseDate;
	private String description;
	private String adNumber;
	private String refusedComment;
	private Advertiser advertiser;
	private RealEstate realEstate;
		
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

	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", title=" + title + ", status=" + status + ", transactionType="
				+ transactionType + ", releaseDate=" + releaseDate + ", description=" + description + ", adNumber="
				+ adNumber + ", refusedComment=" + refusedComment + ", advertiser=" + advertiser + ", realEstate="
				+ realEstate + ", pictures=" + pictures + "]";
	}
	

}
