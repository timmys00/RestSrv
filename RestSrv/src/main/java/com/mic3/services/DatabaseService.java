package com.mic3.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Service;

import com.mic3.domain.City;
import com.mic3.repo.CitiesRepository;

//SERVICE USED FOR TESTING
@Service
public class DatabaseService {

	private static final String SQL_SELECT_CITIES = "select * from cities";
	
//	@Value("${dbJdbc}")
//	private String dbJdbc;
//	
//	@Value("${dbPass}")
//	private String dbPassword;
//	
//	@Value("${dbUser}")
//	private String dbUsername;
//	
//	@Value("${dbName}")
//	private String dbName;
	
	private CitiesRepository citiesRepository;
	
	@Autowired
	public DatabaseService(CitiesRepository citiesRepository){
		this.citiesRepository = citiesRepository;
	}
	
	public void initializeCityRepo(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try { Class.forName("org.postgresql.Driver"); } 
		catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
			return;
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mic3_db", "postgres", "admin");
//			conn = DriverManager.getConnection(this.dbJdbc+this.dbName, this.dbUsername, this.dbPassword);
			stmt = conn.prepareStatement(SQL_SELECT_CITIES, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery();

//			this.citiesRepository.FillRepository(rs);			
			
		} catch (SQLException e) {
			System.out.println("BAD BAD");
			e.printStackTrace();
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} 
				catch(SQLException e) {
					System.out.println("RS CLOSE FAILESD");
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} 
				catch(SQLException e) {
					System.out.println("STATEMENT CLOSE FAILESD");
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} 
				catch(SQLException e) {
					System.out.println("CON CLOSE FAILESD");
				}
			}
		}
//		System.out.println("INIT DATABASE QUERY AND FILL REPO !!!!!!!!!!!!!!!!!!! ==== " + this.citiesRepository.findAll().size());

	}
}
