package com.ibm.finaops.model;

public class CustomerAccountDetails {

	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubtype(String subType) {
		this.subType = subType;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getAccountLastModifyOn() {
		return accountLastModifyOn;
	}
	public void setAccountLastModifyOn(String accountLastModifyOn) {
		this.accountLastModifyOn = accountLastModifyOn;
	}
	public String getFrequent() {
		return frequent;
	}
	public void setFrequent(String frequent) {
		this.frequent = frequent;
	}
	private String _id;
	private String _rev;
	private String userId;
	private String accountNumber;
	private String type;
	private String subType;
	private String bank;
	private String accountOwner;
	private String accountType;
	private String currentBalance;
	private String accountLastModifyOn;
	private String frequent;
	
}
