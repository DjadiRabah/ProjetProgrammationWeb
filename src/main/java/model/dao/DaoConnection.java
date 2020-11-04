package model.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnection 
{
	private static Connection connection;

	private DaoConnection() 
	{
		try 
		{
			Class c = Class.forName("com.mysql.cj.jdbc.Driver");
			Driver pilote = (Driver) c.newInstance() ;
	        DriverManager.registerDriver(pilote);

	        String protocole =  "jdbc:mysql:";
	        String ip =  "localhost";
	        String port =  "3306";  
	        String dataBaseName =  "projetweb" + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	        

	        String conString = protocole +  "//" + ip +  ":" + port +  "/" + dataBaseName ;
	        String user =  "root";
	        String password =  "" ;
	        
	        connection = DriverManager.getConnection(conString, user, password);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (InstantiationException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static Connection getInstance()
	{
		if (connection == null)
			new DaoConnection();
		return connection;
	}
	
	public void close()
	{
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
