package com.vam.persistance;
import java.sql.*;
import org.junit.jupiter.api.Test;

public class JDBCTest {
	
	@Test
	public void testConnection() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String url = "jdbc:oracle:thin:@DB202203091416_high?TNS_ADMIN=C://Wallet_DB202203091416";
            String id = "admin";
            String pwd = "Cloudoracle123";

            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url,id,pwd);

            String sql="insert into user1 (id,name) values(150,'1')";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
