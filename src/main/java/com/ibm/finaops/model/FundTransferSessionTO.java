package com.ibm.finaops.model;

public class FundTransferSessionTO {
	
	/**
	 * @return the transactionNumber
	 */
	public String getTransactionNumber() {
		return transactionNumber;
	}
	/**
	 * @param transactionNumber the transactionNumber to set
	 */
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the fromAccount
	 */
	public String getFromAccount() {
		return fromAccount;
	}
	/**
	 * @param fromAccount the fromAccount to set
	 */
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	/**
	 * @return the toAccount
	 */
	public String getToAccount() {
		return toAccount;
	}
	/**
	 * @param toAccount the toAccount to set
	 */
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	/**
	 * @return the toAccountType
	 */
	public String getToAccountType() {
		return toAccountType;
	}
	/**
	 * @param toAccountType the toAccountType to set
	 */
	public void setToAccountType(String toAccountType) {
		this.toAccountType = toAccountType;
	}
	/**
	 * @return the fromAccountType
	 */
	public String getFromAccountType() {
		return fromAccountType;
	}
	/**
	 * @param fromAccountType the fromAccountType to set
	 */
	public void setFromAccountType(String fromAccountType) {
		this.fromAccountType = fromAccountType;
	}
	/**
	 * @return the beneficiaryName
	 */
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	/**
	 * @param beneficiaryName the beneficiaryName to set
	 */
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	/**
	 * @return the transferAmount
	 */
	public String getTransferAmount() {
		return transferAmount;
	}
	/**
	 * @param transferAmount the transferAmount to set
	 */
	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the headerData
	 */
	public String getHeaderData() {
		return headerData;
	}
	/**
	 * @param headerData the headerData to set
	 */
	public void setHeaderData(String headerData) {
		this.headerData = headerData;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	private String transactionNumber;
	private String userId;
	private String fromAccount;
	private String toAccount;
	private String toAccountType;
	private String fromAccountType;
	private String beneficiaryName;
	private String transferAmount;
	private String remarks;
	private String headerData;

}
