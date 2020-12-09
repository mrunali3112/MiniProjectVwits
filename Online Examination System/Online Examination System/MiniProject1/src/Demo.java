import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Provider;
import db.Students;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = Provider.getOracleConnection();
		Students sd = new Students();
		sd.setUsername("mrunali");
		sd.setPassword("mrunali");
		Statement pst;
		try {
			pst = con.createStatement();
			String s = "select * from studenttable where userid='" + sd.getUsername() + "' and password='"+sd.getPassword()+"'";
			System.out.println(s);
			ResultSet rs = pst.executeQuery("select * from studenttable where userid='" + sd.getUsername() + "' and password='"+sd.getPassword()+"'");
			System.out.println(rs.next());
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
