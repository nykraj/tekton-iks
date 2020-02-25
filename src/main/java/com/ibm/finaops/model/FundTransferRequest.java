package com.ibm.finaops.model;

public class FundTransferRequest {
	

	/**
	 * @return the fromAcct
	 */
	public String getFromAcct() {
		return fromAcct;
	}
	/**
	 * @param fromAcct the fromAcct to set
	 */
	public void setFromAcct(String fromAcct) {
		this.fromAcct = fromAcct;
	}
	/**
	 * @return the toAcct
	 */
	public String getToAcct() {
		return toAcct;
	}
	/**
	 * @param toAcct the toAcct to set
	 */
	public void setToAcct(String toAcct) {
		this.toAcct = toAcct;
	}
	/**
	 * @return the trfAmnt
	 */
	public String getTrfAmnt() {
		return trfAmnt;
	}
	/**
	 * @param trfAmnt the trfAmnt to set
	 */
	public void setTrfAmnt(String trfAmnt) {
		this.trfAmnt = trfAmnt;
	}
	private String fromAcct;
	private String toAcct;
	private String trfAmnt;
	
}
