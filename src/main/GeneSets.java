package main;

public class GeneSets {
	private String hgnc_id;
	private String symbol;
	private String name;
	private String contianed_nct_ID= "";
	
	public String getContianed_nct_ID() {
		return contianed_nct_ID;
	}
	public void addContianed_nct_ID(String contianed_nct_ID) {
		this.contianed_nct_ID  = this.contianed_nct_ID+","+contianed_nct_ID;
	}
	public GeneSets(String hgnc_id ,String  symbol,String name ){
		this.hgnc_id = hgnc_id;
		this.symbol = symbol;
		this.name = name;
	}
	public String getHgnc_id() {
		return hgnc_id;
	}

	public void setHgnc_id(String hgnc_id) {
		this.hgnc_id = hgnc_id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


}
