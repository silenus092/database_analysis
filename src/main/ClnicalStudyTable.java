package main;

public  class ClnicalStudyTable{
	private String nct_id="";
	private String brief_title_column = "";
	private String full_summary_column = "";
	private String brief_summary_column = "";
	private String criteria_column = "";
	
	public ClnicalStudyTable(String nct_id, String brief_tiltle_column, String full_summary_column,
			String brief_summary_column, String criteria_column) {
		this.nct_id = nct_id;
		this.brief_title_column = brief_tiltle_column;
		this.full_summary_column = full_summary_column;
		this.brief_summary_column = brief_summary_column;
		this.criteria_column = criteria_column;
	}
	public String getNct_id() {
		return nct_id;
	}
	public void setNct_id(String nct_id) {
		this.nct_id = nct_id;
	}
	public String getBrief_tiltle_column() {
		return brief_title_column;
	}

	public void setBrief_tiltle_column(String brief_tiltle_column) {
		this.brief_title_column = brief_tiltle_column;
	}
	public String getBrief_summary_column() {
		return brief_summary_column;
	}
	public void setBrief_summary_column(String brief_summary_column) {
		this.brief_summary_column = brief_summary_column;
	}
	public String getFull_summary_column() {
		return full_summary_column;
	}
	public void setFull_summary_column(String full_summary_column) {
		this.full_summary_column = full_summary_column;
	}
	public String getCriteria_column() {
		return criteria_column;
	}
	public void setCriteria_column(String criteria_column) {
		this.criteria_column = criteria_column;
	}
	
}
