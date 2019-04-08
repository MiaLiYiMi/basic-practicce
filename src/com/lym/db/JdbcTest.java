package com.lym.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

		public static void main(String[] args) throws SQLException, ClassNotFoundException {
	        String url = "jdbc:mysql://127.0.0.1:3306/mydb";
	        String username = "root";
	        String password = "redhat";
	        /**
	         * Class.forName(""); 的作用是要求JVM查找并加载指定的类，如果在类中有静态初始化器的话，JVM必然会执行该类的静态代码段。
	         * 	而在JDBC规范中明确要求这个Driver类必须向 DriverManager注册自己
	         * 	既然在静态初始化器的中已经进行了注册，所以我们在使用 JDBC时只需要 Class.forName(XXX.XXX);就可以了
	         */
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(url, username, password);
	        String sql = "SELECT * FROM msg";
	        PreparedStatement prepareStatement = connection.prepareStatement(sql);
	        ResultSet resultSet = prepareStatement.executeQuery();
	        resultSet.next();
	        String address = resultSet.getString("address");
	        System.out.println(address);
	        
	}

}
