package com.example.gascontrol.db;

public class Dados {
	
	private long id;
	private int gasType;
	private double gasValue;
	private double totalValue;
	private double totalKM;
	private String date;
	private long rendimento;
	
	public Dados () {
		// empty Constructor
	}
	
	public Dados (int gasType, double gasValue, double totalValue, double totalKM, String date) {
		this.gasType = gasType;
		this.gasValue = gasValue;
		this.totalValue = totalValue;
		this.totalKM = totalKM;
		this.date = date;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the gasType
	 */
	public int getGasType() {
		return gasType;
	}
	/**
	 * @param gasType the gasType to set
	 */
	public void setGasType(int gasType) {
		this.gasType = gasType;
	}
	/**
	 * @return the gasValue
	 */
	public double getGasValue() {
		return gasValue;
	}
	/**
	 * @param gasValue the gasValue to set
	 */
	public void setGasValue(long gasValue) {
		this.gasValue = gasValue;
	}
	/**
	 * @return the totalValue
	 */
	public double getTotalValue() {
		return totalValue;
	}
	/**
	 * @param totalValue the totalValue to set
	 */
	public void setTotalValue(long totalValue) {
		this.totalValue = totalValue;
	}
	/**
	 * @return the totalKM
	 */
	public double getTotalKM() {
		return totalKM;
	}
	/**
	 * @param totalKM the totalKM to set
	 */
	public void setTotalKM(long totalKM) {
		this.totalKM = totalKM;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the rendimento
	 */
	public long getRendimento() {
		return rendimento;
	}
	/**
	 * @param rendimento the rendimento to set
	 */
	public void setRendimento(long rendimento) {
		this.rendimento = rendimento;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String message = 
				"\n************************************************\n" +
				"\nRec ID: " + this.id +
				"\nGasType: " + this.gasType +
				"\nGas Value: " + this.gasValue + 
				"\nTotal Value: " + this.totalValue + 
				"\nTotal KM: " + this.totalKM +
				"\nDate: " + this.date +
				"\nRendimento: " + this.rendimento +
				"\n************************************************\n";
		return message;
	}
	
	
}
