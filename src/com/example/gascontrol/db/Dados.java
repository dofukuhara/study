package com.example.gascontrol.db;

public class Dados {
	
	private long id;
	private int gasType;
	private long gasValue;
	private long totalValue;
	private long totalKM;
	private String date;
	private long rendimento;
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
	public long getGasValue() {
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
	public long getTotalValue() {
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
	public long getTotalKM() {
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
		return this.date;
	}
	
	
}
