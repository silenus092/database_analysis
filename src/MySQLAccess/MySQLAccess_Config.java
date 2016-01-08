package MySQLAccess;

public class  MySQLAccess_Config {
	public static String database_driver = "com.mysql.jdbc.Driver";
	public static String table_gene = "hgnc_complete_set";
	public static String select_all_gene = "select * from hgnc_complete_set";
	public static String column_brief_title = "brief_title" ;
	public static String column_brief_summary = "brief_summary";
	public static String column_criteria = "criteria";
	
	public static String select_all_clinicalstudy_rows = "SELECT nct_id , brief_title ,brief_summary ,"
								+ "detailed_description , criteria FROM clinical_study ";
	
	
	/**********************************************************************************************************/
	public static String brief_title_query1_LIKE_BINARY_SYMBOL = " SELECT c.nct_id , c.brief_title  "+
			" FROM clinical_study c  " +
			" WHERE c.brief_title LIKE BINARY ";
	
	public static String brief_title_query1_LIKE_SYMBOL  = " SELECT c.nct_id  , c.brief_title "+
			" FROM clinical_study c " +
			" WHERE c.brief_title LIKE ";
	
	public static String brief_title_query2_LIKE_BINARY_NAME   = "SELECT c.nct_id  , c.brief_title "+
			" FROM clinical_study c " +
			" WHERE c.brief_title LIKE BINARY ?";
	
	public static String brief_title_query2_LIKE_NAME  = "SELECT c.nct_id  , c.brief_title  "+
			" FROM clinical_study c " +
			" WHERE c.brief_title LIKE ?";
	
	public static String brief_title_query3_LIKE_BINARY_SYMBOL_NAME  = " SELECT c.nct_id , c.brief_title  "+
			" FROM clinical_study c  " +
			" WHERE c.brief_title LIKE BINARY ?";
	
	public static String brief_title_query3_LIKE_SYMBOL_NAME = " SELECT c.nct_id , c.brief_title  "+
			" FROM clinical_study c  " +
			" WHERE c.brief_title LIKE BINARY ?";

	public static String brief_title_query1_FULLTEXT_SYMBOL= " SELECT c.nct_id , c.brief_title  "+
			" FROM clinical_study c  " +
			" WHERE MATCH (c.brief_title) AGAINST ";
	
	public static String brief_title_query2_FULLTEXT_NAME= " SELECT c.nct_id , c.brief_title  "+
			" FROM clinical_study c  " +
			" WHERE MATCH (c.brief_title) AGAINST ";
	
	public static String brief_title_query3_FULLTEXT_SYMBOL_NAME = " SELECT c.nct_id , c.brief_title  "+
			" FROM clinical_study c  " +
			" WHERE MATCH (c.brief_title) AGAINST ";
	//**************************************************************************************************************************************
	public static String criteria_query1_LIKE_BINARY_SYMBOL = " SELECT c.nct_id , c.criteria  "+
			" FROM clinical_study c  " +
			" WHERE c.criteria LIKE BINARY ";
	
	public static String criteria_query1_LIKE_SYMBOL  = " SELECT c.nct_id  , c.criteria "+
			" FROM clinical_study c " +
			" WHERE c.criteria LIKE ";
	
	public static String criteria_query2_LIKE_BINARY_NAME   = "SELECT c.nct_id  , c.criteria "+
			" FROM clinical_study c " +
			" WHERE c.criteria LIKE BINARY ?";
	
	public static String criteria_query2_LIKE_NAME  = "SELECT c.nct_id  , c.criteria  "+
			" FROM clinical_study c " +
			" WHERE c.criteria LIKE ?";
	
	public static String criteria_query3_LIKE_BINARY_SYMBOL_NAME  = " SELECT c.nct_id , c.criteria  "+
			" FROM clinical_study c  " +
			" WHERE c.criteria LIKE BINARY ?";
	
	public static String criteria_query3_LIKE_SYMBOL_NAME = " SELECT c.nct_id , c.criteria  "+
			" FROM clinical_study c  " +
			" WHERE c.criteria LIKE BINARY ?";

	public static String criteria_query1_FULLTEXT_SYMBOL= " SELECT c.nct_id , c.criteria  "+
			" FROM clinical_study c  " +
			" WHERE MATCH (c.criteria) AGAINST ";
	
	public static String criteria_query2_FULLTEXT_NAME= " SELECT c.nct_id , c.criteria  "+
			" FROM clinical_study c  " +
			" WHERE MATCH (c.criteria) AGAINST ";
	
	public static String  criteria_query3_FULLTEXT_SYMBOL_NAME = " SELECT c.nct_id , c.criteria  "+
			" FROM clinical_study c  " +
			" WHERE MATCH (c.criteria) AGAINST ";
	//**************************************************************************************************************************************
	public static String summary_query1_LIKE_BINARY_SYMBOL = " SELECT c.nct_id , c.brief_summary  "+
			" FROM clinical_study c  " +
			" WHERE c.brief_summary LIKE BINARY ";
	
	public static String summary_query1_LIKE_SYMBOL  = " SELECT c.nct_id  , c.brief_summary "+
			" FROM clinical_study c " +
			" WHERE c.brief_summary LIKE ";
	
	public static String summary_query2_LIKE_BINARY_NAME   = "SELECT c.nct_id  , c.brief_summary "+
			" FROM clinical_study c " +
			" WHERE c.brief_summary LIKE BINARY ?";
	
	public static String summary_query2_LIKE_NAME  = "SELECT c.nct_id  , c.brief_summary  "+
			" FROM clinical_study c " +
			" WHERE c.brief_summary LIKE ?";
	
	public static String summary_query3_LIKE_BINARY_SYMBOL_NAME  = " SELECT c.nct_id , c.brief_summary  "+
			" FROM clinical_study c  " +
			" WHERE c.brief_summary LIKE BINARY ?";
	
	public static String summary_query3_LIKE_SYMBOL_NAME = " SELECT c.nct_id , c.brief_summary  "+
			" FROM clinical_study c  " +
			" WHERE c.brief_summary LIKE BINARY ?";

	public static String summary_query1_FULLTEXT_SYMBOL= " SELECT c.nct_id , c.brief_summary  "+
			" FROM clinical_study c  " +
			" WHERE MATCH (c.brief_summary) AGAINST ";
	
	public static String summary_query2_FULLTEXT_NAME= " SELECT c.nct_id , c.brief_summary  "+
			" FROM clinical_study c  " +
			" WHERE MATCH (c.brief_summary) AGAINST ";
	
	public static String summary_query3_FULLTEXT_SYMBOL_NAME= " SELECT c.nct_id , c.brief_summary  "+
			" FROM clinical_study c  " +
			" WHERE MATCH (c.brief_summary) AGAINST ";
}
