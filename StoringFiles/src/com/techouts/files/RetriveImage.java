package com.techouts.files;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveImage 
{
	public static void main(String[] arg)
	{
		System.out.println("Hello World");
		System.out.println("Hello World");

		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "techouts";
		String qwery="select * from ravindradb.imagetable";
	    try {
			Connection connection=DriverManager.getConnection(url, user, password);
			
			Statement statement=connection.createStatement();
			//statement.executeQuery(qwery);
			ResultSet resultSet=statement.executeQuery(qwery);
			if(resultSet.next())
			{
				String name=resultSet.getString(1);
				Blob blob=resultSet.getBlob(2);
				byte[] b=blob.getBytes(1, (int)blob.length());
				FileOutputStream fileOutputStream=new FileOutputStream("D:\\image.jpg");
				System.out.println("Welcome Mr: "+name);
				fileOutputStream.write(b);
				fileOutputStream.close();
				connection.close();
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
	}

}
