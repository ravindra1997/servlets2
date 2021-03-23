package com.techouts.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageUpload {
	public static void main(String[] arg) {
		System.out.println("Hello World");

		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "techouts";
		String qwery = "insert into ravindradb.imagetable values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);

			PreparedStatement preparedStatement = connection.prepareStatement(qwery);
			preparedStatement.setString(1, "vijay");
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\d1\\Downloads\\image1.jpg");
			preparedStatement.setBinaryStream(2, fileInputStream, fileInputStream.available());
			File file=new File("C:\\Users\\d1\\Downloads\\ok.txt");
			FileReader fileReader=new FileReader(file);
			preparedStatement.setCharacterStream(3, fileReader,(int)file.length());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("successsfully updated");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
