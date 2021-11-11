package ee.taltech.jdbc.test;

import ee.taltech.java.dbconfig.BasicDBAccessCloud;

public class Test {

	public static void main(String[] args) {
		BasicDBAccessCloud q1 = new BasicDBAccessCloud("Select * from 	projects");
		q1.executeQuery();

	}

}
