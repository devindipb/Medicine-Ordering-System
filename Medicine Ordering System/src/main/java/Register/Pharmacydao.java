package Register;

import java.util.*;
import java.sql.*;

public class Pharmacydao {
	// Method to establish a database connection
	public static Connection getConnection() {
		Connection con = null;
		try {
			// Load the MySQL JDBC driver and connect to the database
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydata", "root","2611");
		} catch (Exception e) {
			// Handle any exceptions that occur during the connection process
			System.out.println(e);
		}
		return con;
	}

	// Method to save pharmacy staff member's information to the database
	public static int save(pharmacy e) {
		int status = 0;
		try {
			Connection con = Pharmacydao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into pharmacy(fristname,lastname,nic,email,password,repassword,phone,dob,country) values (?,?,?,?,?,?,?,?,?)");
			// Set the values for the prepared statement from the 'pharmacy' object
			ps.setString(1, e.getFristname());
			ps.setString(2, e.getLastname());
			ps.setString(3, e.getNic());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPassword());
			ps.setString(6, e.getRepassword());
			ps.setString(7, e.getPhone());
			ps.setString(8, e.getDob());
			ps.setString(9, e.getCountry());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	// Method to update pharmacy staff member's information in the database
	public static int update(pharmacy e) {
		int status = 0;
		try {
			Connection con = Pharmacydao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update pharmacy set fristname=?,lastname=?,nic=?,email=?,password=?,repassword=?,phone=?,dob=?,country=? where id=?");
			ps.setString(1, e.getFristname());
			ps.setString(2, e.getLastname());
			ps.setString(3, e.getNic());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPassword());
			ps.setString(6, e.getRepassword());
			ps.setString(7, e.getPhone());
			ps.setString(8, e.getDob());
			ps.setString(9, e.getCountry());
			ps.setInt(10, e.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = Pharmacydao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from pharmacy where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static pharmacy getEmployeeById(int id) {
		pharmacy e = new pharmacy();

		try {
			Connection con = Pharmacydao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from pharmacy where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setFristname(rs.getString(2));
				e.setLastname(rs.getString(3));
				e.setNic(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setPassword(rs.getString(6));
				e.setRepassword(rs.getString(7));
				e.setPhone(rs.getString(8));
				e.setDob(rs.getString(9));
				e.setCountry(rs.getString(10));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<pharmacy> getAllEmployees() {
		List<pharmacy> list = new ArrayList<pharmacy>();

		try {
			Connection con = Pharmacydao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from pharmacy");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pharmacy e = new pharmacy();
				e.setId(rs.getInt(1));
				e.setFristname(rs.getString(2));
				e.setLastname(rs.getString(3));
				e.setNic(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setPassword(rs.getString(6));
				e.setRepassword(rs.getString(7));
				e.setPhone(rs.getString(8));
				e.setDob(rs.getString(9));
				e.setCountry(rs.getString(10));

				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
