package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.*;
import util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public List<Department> getDepartment() {
		List<Department> d = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM DEPARTMENT";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("DEPARTMENT_ID");
				String name = rs.getString("DEPARTMENT_NAME");
				Department newD = new Department(id,name);
				d.add(newD);
			}
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return d;
	}

	@Override
	public Department getDepartmentById(int id) {
		PreparedStatement pstmt = null;
		Department department = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				String name = rs.getString("DEPARTMENT_NAME");
				department = new Department(id,name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return department;
	}

}
