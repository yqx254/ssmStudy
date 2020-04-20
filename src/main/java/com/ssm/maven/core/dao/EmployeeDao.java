package com.ssm.maven.core.dao;

import com.ssm.maven.core.entity.Employee;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public interface EmployeeDao extends Serializable {
    /**
     *  返回目标数据
     * @param map 暂时不明
     * @return 返回雇员List
     */
    public List<Employee> findEmployee(Map<String,Object> map);

    /**
     *  查询总数
     * @param map 暂时不明
     * @return 返回总数
     */
    public Long getTotalEmployee(Map<String, Object> map);

    /**
     * 新增雇员
     * @param employee 上传的雇员对象
     */
    public void addEmployee(Employee employee);

    /**
     * 查找雇员
     * @param id 前端上传的ID
     * @return 查询结果：雇员对象
     */
    public Employee findEmployeeById(String id);
}
