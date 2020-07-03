package com.gravity.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.gravity.beam.Employee;

public interface EmpDao {
	/**
	 * 对员工进行操作的接口
	 * @param emp
	 * @throws SQLException
	 */
	public void addEmpWith(Employee emp) throws SQLException;//添加employee信息
	
	public List<Employee> queryAllEmp(int page,int limit) throws SQLException;//查询所有雇员信息
	
	public int getAllEmpCount() throws SQLException;//计算数据条数
		
	public List<Employee> queryAllEmp(Map<String, String> parms) throws SQLException;//模糊查询方法

	public int getAllEmpCount(Map<String, String> parms) throws SQLException;//根据条件获取数据条数
	
	public void deleteEmp(int id)throws Exception;//删除一条数据
}
