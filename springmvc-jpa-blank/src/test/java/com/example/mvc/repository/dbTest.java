package com.example.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class dbTest {

private static final String DRIVER = "net.sf.log4jdbc.DriverSpy";
	
	private static final String URL = "jdbc:log4jdbc:h2:mem:example";
	
	private static final String USER = "sa";
	
	private static final String PW = "";
	
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
