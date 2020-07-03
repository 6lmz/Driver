package com.gravity.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSONObject;
import com.gravity.beam.Employee;
import com.gravity.dao.EmpDao;
import com.gravity.impl.EmpDaoImpl;

public class EmpService {
	private EmpDao ed = new EmpDaoImpl();

	/**
	 * 添加学生
	 * @param stu
	 * @throws Exception
	 */
	public void addEmpdent(String empJson) throws Exception {
		
		//  将json数据转换为对象
		Employee emp = JSONObject.parseObject(empJson, Employee.class);
		ed.addEmpWith(emp);
	}
	
public String queryAllEmp(int page,int limit) throws Exception {
		
		// 获取到当前分页要显示的内容
		List<Employee> emp = ed.queryAllEmp(page,limit);
		// 还有使用方法获取当前条件下所有分页的总数据条数
		int count = ed.getAllEmpCount();
		// 网页要求的数据格式为json
		// 数据头必须是 "code": 0,"msg": "","count": 44,"data":emp
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("code", 0);
		jsonMap.put("msg", "");
		jsonMap.put("count", count);
		jsonMap.put("data", emp);
		
		// 使用fastjson工具对map进行数据转换
		String json = JSONObject.toJSONString(jsonMap);
		
		return json;
		
	}


/**
 * 模糊学生信息
 * @throws Exception
 */
public String queryAllEmp(Map<String, String> parms) throws Exception{

	List<Employee> emps = ed.queryAllEmp(parms);
	
	// 还有使用方法获取当前条件下所有分页的总数据条数
	int count = ed.getAllEmpCount(parms);
	
	System.out.println(count);
	
	Map<String, Object> jsonMap = new HashMap<>();
	jsonMap.put("code", 0);
	jsonMap.put("msg", "");
	jsonMap.put("count", count);
	jsonMap.put("data", emps);
	
	// 使用fastjson工具对map进行数据转换
	String json = JSONObject.toJSONString(jsonMap);
	
	return json;
}
	public int deleteEmp(int id)throws Exception{
		ed.deleteEmp(id);
		return 0;
	}

}
