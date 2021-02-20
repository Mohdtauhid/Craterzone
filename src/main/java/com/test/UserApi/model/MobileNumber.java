package com.test.UserApi.model;
    
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table; 
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
  
  public class MobileNumber {
  @NotNull
  private int id;
  private String cc;                                                   // Country Code +91
  private String number;
  
  public MobileNumber() {
	super();
}
	@Autowired
  public MobileNumber( String cc, String number)
  {
	this.cc = cc;
	this.number = number;
  }


	public String getCc() { 
	  return cc; }
@Autowired
  public void setCc(String cc) { 
	  this.cc = cc; }
  
  public String getNumber() { 
	  return number; 
	  }
	@Autowired
  public void setNumber(String number) { 
	  this.number = number; 
	  }

@Override
public String toString() {
	return "MobileNumber [id=" + id + ", cc=" + cc + ", number=" + number + "]";
}


  }
 