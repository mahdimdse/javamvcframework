package ee.taltech.java.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicDBAccessCloud {
	private String query;

	public BasicDBAccessCloud(String query) {
		super();
		this.query = query;
		
	}
	
	public void executeQuery(){
		Connection c = null;
		
		try {
			String url = "jdbc:postgresql://fanny.db.elephantsql.com:5432/szciskhb";
			String username = "szciskhb";
			String password = "lgDSwcV5rc9w1xVzPBYMoSl6H_sAwiRA";
			Class.forName("org.postgresql.Driver");

	        c = DriverManager.getConnection(url, username, password);
	        c.setAutoCommit(false);
	        
	        Statement selectStatement = c.createStatement(
        			ResultSet.TYPE_SCROLL_SENSITIVE,
        			ResultSet.CONCUR_READ_ONLY
            	);
	        
	        // READ DATA
	        
//	        ResultSet resultSet = selectStatement.executeQuery(
//	        		"Select * from 	projects;"
//	    		   );
	        ResultSet resultSet = selectStatement.executeQuery(
	        		this.query
	    		   );
	            resultSet.first();
	            
	            System.out.println(resultSet.getString(2));
	            
	            while (resultSet.next()){
	              System.out.println(resultSet.getString(2));
	            }
		       
	            selectStatement.close();
	            c.commit();
	            c.close();

		} catch (Exception e) {
			e.printStackTrace();
	        System.err.println(e.getClass().getName() +": " + e.getMessage());
	        System.exit(0);
		}
	}
	
}
