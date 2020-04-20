package com.ssm.maven.core.service;

import com.ssm.maven.core.entity.Employee;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 20200418
 */
public interface EmployeeService extends Serializable {
    /**
     *  就是找雇员列表呗
     * @param map 暂不明
     * @return  雇员集合
     */
    public List<Employee> findEmployee(Map<String, Object> map);
    /**
     *  就是查雇员数量呗
     * @param map 暂不明
     * @return  雇员数量
     */
    public Long getTotalEmployee(Map<String, Object> map);

    /**
     *  就是新增雇员呗
     * @param employee 雇员对象
     */
    public void addEmployee(Employee employee);

    /**
     * 就是查找指定雇员呗
     * @param id 雇员ID
     * @return 雇员对象
     */
    public Employee findEmployeeById(String id);
}
