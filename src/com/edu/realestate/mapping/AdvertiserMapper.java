package com.edu.realestate.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.edu.realestate.model.*;
import com.edu.realestate.model.Advertiser;
import com.edu.realestate.model.RealEstate;
import com.edu.realestate.model.TransactionType;

public class AdvertiserMapper {

	//Lecture DB vers OO
	public static Advertisement resultToAdv(ResultSet rs, Advertiser ad, RealEstate re) throws SQLException {
		
		Advertisement adv = new Advertisement();
		adv.setId(rs.getInt("id"));
		adv.setTitle(rs.getString("title"));
		adv.setAdvertiser(ad);
		adv.setRealEstate(re);
		
		TransactionType tt = TransactionType.valueOf(rs.getString("transaction_type"));
		adv.setTransactionType(tt);
		
		AdStatus as = AdStatus.valueOf(rs.getString("status"));
		adv.setStatus(as);
		
		//adv.setStatus(rs.getDouble("latitudes"));
		//adv.setTransactionType(rs.getDouble("latitude"));
		adv.setDescription(rs.getString("description"));
		adv.setAdNumber(rs.getString("ad_number"));
		adv.setRefusedComment(rs.getString("refused_comment"));
		
		return adv;
	}
	
	//Ecriture OO vers DB
	public static Statement advStatement(Advertisement adv) throws Exception{
		return null;
	}
	

}
