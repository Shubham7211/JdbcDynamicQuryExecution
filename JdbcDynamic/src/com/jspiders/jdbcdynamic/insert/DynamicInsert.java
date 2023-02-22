package com.jspiders.jdbcdynamic.insert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;

public class DynamicInsert {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static FileReader fileReader;
	private static Properties properties;
	private static int result;
	private static String query;
	private static String filePath="E:\\Eclipse_Workspace\\JdbcDynamic\\resources\\db_info.properties";
	
	//main method started from here
	public static void main(String[] args) {

		try {
			fileReader=new FileReader(filePath);
			properties=new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			query="insert into"
					+" student values "
					+"(?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, 6);
			preparedStatement.setString(2,"Babita");
			preparedStatement.setString(3, "rajjay6672@gmail.com ");
			preparedStatement.setLong(4, 8788841192L);
			result=preparedStatement.executeUpdate();
			System.out.println("query ok,"+result+"rows(s) affected");
			
		} catch (IOException |ClassNotFoundException|SQLException e) {
					e.printStackTrace();
		}
		finally {
			try {
				if (connection!=null) {
					connection.close();
				}
				if (preparedStatement!=null) {
					preparedStatement.close();
				}
				if (fileReader!=null) {
					connection.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}//catch block end here
		}//finally block end here
	}//main method ended here

}//class end here
