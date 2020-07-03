package com.gravity.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import com.gravity.beam.Employee;
import com.gravity.dao.EmpDao;
import com.gravity.tools.JdbcUtils;


public class EmpDaoImpl implements EmpDao{

	@Override
	public void addEmpWith(Employee emp) throws SQLException {//实现接口中添加雇员信息的方法
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {			
			conn = JdbcUtils.getConnection();//  获取连接
			String sql = "insert into Employee values(?,?,?,?,?,?,?,?);"; //插入雇员信息的sql语句
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setInt(3, emp.getTel());
			ps.setString(4, emp.getSex());
			ps.setString(5, emp.getCarType());
			ps.setString(6, emp.getCarnum());
			ps.setString(7, emp.getnowstate());
			// 将java的date转换为sql的date
			ps.setDate(8, new Date(emp.getJoinTime().getTime()));
			
			ps.executeUpdate();// 执行插入语句
		
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtils.closeDB(conn, ps, null);
		}	
	}

	@Override
	public List<Employee> queryAllEmp(int page, int limit) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {			
			conn = JdbcUtils.getConnection();
			String sql = "select * from Employee limit ?,?"; // (page-1)*limit分页显示
			ps = conn.prepareStatement(sql);
			// 设置分页参数
			ps.setInt(1, (page-1)*limit);
			ps.setInt(2, limit);
			// 执行查询语句
			rs = ps.executeQuery();
			// 创建一个集合用来保存对象
			List<Employee> emps = new ArrayList<>();
			// 遍历获取每一条数据
			while (rs.next()) {
				// 创建对象保存对应的信息
				emps.add(new Employee(rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("tel"),
						rs.getString("sex"),
						rs.getString("carType"),
						rs.getString("carnum"),
						rs.getString("nowstate"),
						rs.getDate("joinTime"))
						);
			}
			return emps;
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtils.closeDB(conn, ps, rs);
		}
	}

	@Override
	public int getAllEmpCount() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {			
			conn = JdbcUtils.getConnection();
			String sql = "select count(*) from Employee;";//计算总雇员信息条数
			ps = conn.prepareStatement(sql);
			// 执行查询语句
			rs = ps.executeQuery();
			
		    rs=ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtils.closeDB(conn, ps, rs);
		}
	}

	@Override
	public List<Employee> queryAllEmp(Map<String, String> parms) throws SQLException {//模糊查询
		// 准备参数
				String pages = parms.get("page");
				String limits = parms.get("limit");
				String sex = parms.get("sex");
				String carType = parms.get("carType");
				String name = parms.get("name");
				
				int page = Integer.parseInt(pages == null?"1":pages);
				int limit = Integer.parseInt(limits == null?"10":limits);
				
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try {			
					conn = JdbcUtils.getConnection();
					String sql = "select * from Employee where 1=1 "; 
					
					if (carType != null && !carType.isEmpty()) {
						// 设置车型的查询
						sql = sql + " and carType = '"+carType+"'";
					}
					//设置性别的查询
					if (sex != null && !sex.isEmpty()) {
						sql = sql + " and sex='"+sex+"' ";
					}
					//设置名字的模糊查询
					if (name != null && !name.isEmpty()) {
						sql = sql + " and name like '%"+name+"%'";
					}
					
					sql = sql + " limit ?,?;";
					
					System.out.println(sql);
					ps = conn.prepareStatement(sql);
					// 设置分页参数
					ps.setInt(1, (page-1)*limit);
					ps.setInt(2, limit);
					// 执行查询语句
					rs = ps.executeQuery();
					// 创建一个集合用来保存对象
					List<Employee> emps = new ArrayList<>();
					// 遍历获取每一条数据
					while (rs.next()) {
						// 创建对象保存对应的信息
						emps.add(new Employee(rs.getInt("id"),
								rs.getString("name"),
								rs.getInt("tel"),
								rs.getString("sex"),
								rs.getString("carType"),
								rs.getString("carnum"),
								rs.getString("nowstate"),
								rs.getDate("joinTime"))
								);
					}
					return emps;
				} catch (SQLException e) {
					throw e;
				}finally {
					JdbcUtils.closeDB(conn, ps, rs);
				}
	}

	@Override
	public int getAllEmpCount(Map<String, String> parms) throws SQLException {//根据条件查询，得到的数据条数
		// 准备参数
		String sexS = parms.get("sex");
		String carTypeS = parms.get("carType");
		String nameS = parms.get("name");
				
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {			
			conn = JdbcUtils.getConnection();
			String sql = "select count(*) from Employee where 1=1 "; 
			
			if (sexS != null && !sexS.isEmpty()) {
				sql = sql + " and sex='"+sexS+"' ";
			}
			
			if (carTypeS != null && !carTypeS.isEmpty()) {

				sql = sql + " and carType = '"+carTypeS+"' ";
			}

			if (nameS != null && !nameS.isEmpty()) {
				sql = sql + " and name like '%"+nameS+"%' ";
			}

			ps = conn.prepareStatement(sql);
			// 执行查询语句
			rs = ps.executeQuery();

			rs.next();
						
			return rs.getInt(1);
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtils.closeDB(conn, ps, rs);
		}
		
	}


	public void deleteEmp(int id)throws Exception{//通过id来删除数据
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {			
			conn = JdbcUtils.getConnection();
			String sql = "delete from Employee where id=?"; 
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			 ps.executeUpdate();
			
		
		} catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtils.closeDB(conn, ps, rs);
		}
		
	}

}
