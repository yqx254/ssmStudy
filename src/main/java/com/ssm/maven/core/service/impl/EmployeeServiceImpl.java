package com.ssm.maven.core.service.impl;

import com.ssm.maven.core.dao.EmployeeDao;
import com.ssm.maven.core.entity.Employee;
import com.ssm.maven.core.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 * @date 20200418
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
        private final  static Logger logger =
                Logger.getLogger(EmployeeServiceImpl.class);
        @Resource
        EmployeeDao employeeDao;

        @Override
        public List<Employee> findEmployee(Map<String, Object> map){
            return employeeDao.findEmployee(map);
        }

        @Override
        public Long getTotalEmployee(Map<String, Object> map) {
                return employeeDao.getTotalEmployee(map);
        }

        @Override
        public void addEmployee(Employee employee) {
                employeeDao.addEmployee(employee);
        }

        @Override
        public Employee findEmployeeById(String id) {
                return employeeDao.findEmployeeById(id);
        }

}
