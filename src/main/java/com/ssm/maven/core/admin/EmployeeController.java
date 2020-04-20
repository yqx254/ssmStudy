package com.ssm.maven.core.admin;

import com.ssm.maven.core.entity.Employee;
import com.ssm.maven.core.entity.PageBean;
import com.ssm.maven.core.service.EmployeeService;
import com.ssm.maven.core.util.ResponseUtil;
import com.ssm.maven.core.util.StringUtil;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Administrator
 * @date 20200418
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
        private static final Logger log = Logger.getLogger(EmployeeController.class);
        @Resource
        private EmployeeService employeeService;
        @RequestMapping("/list")
        public String getList(
                @RequestParam(value = "page", required = false)String page,
                @RequestParam(value ="size", required = false)String size,
                Employee employee,
                HttpServletResponse response)throws  Exception{
                Map<String, Object> queryMap = new HashMap<>(64);
                if(page != null && size != null){
                        PageBean pageBean = new PageBean(Integer.parseInt(page),
                                Integer.parseInt(size));
                        queryMap.put("page", pageBean.getPage());
                        queryMap.put("size", pageBean.getPageSize());
                }
                if(employee.getName() != null &&
                        !"".equals(employee.getName())){
                        queryMap.put("name",
                                StringUtil.formatLike(employee.getName()));
                }
                if(employee.getIsPartyMember() != -1){
                        queryMap.put("isPartyMember",
                                employee.getIsPartyMember());
                }
                if(employee.getPosition() != null &&
                        !"".equals(employee.getPosition())){
                        queryMap.put("position",
                                StringUtil.formatLike(employee.getPosition()));
                }
                if(employee.getProfession() != null &&
                        !"".equals(employee.getProfession())){
                        queryMap.put("profession",
                                StringUtil.formatLike(employee.getProfession()));
                }
                List<Employee> employeeList = employeeService.findEmployee(queryMap);
                Long total = employeeService.getTotalEmployee(queryMap);
                JSONObject result = new JSONObject();
                JSONArray jsonArray = JSONArray.fromObject(employeeList);
                result.put("result", jsonArray);
                result.put("total", total);
                ResponseUtil.write(response,result);
                log.info("employee/list query: " + queryMap.toString());
                return null;
        }
        @RequestMapping("/total")
        public String getTotal(
                @RequestParam(value="page", required = false)String page,
                @RequestParam(value="size", required =  false)String size,
                Employee employee,
                HttpServletResponse response
        )throws  Exception{
                Map <String, Object>query = new HashMap<>(64);
                if(page != null && size != null){
                        PageBean pageBean = new PageBean(Integer.parseInt(page),
                                Integer.parseInt(size));
                        query.put("page",pageBean.getPage());
                        query.put("size",pageBean.getPageSize());
                }
               if(employee.getName() != null &&
                       !"".equals(employee.getName())){
                        query.put("name", StringUtil.formatLike(employee.getName()));
               }
               if(employee.getIsPartyMember() != -1){
                       query.put("isPartyMember",employee.getIsPartyMember());
               }
               if(employee.getProfession() != null &&
                 !"".equals(employee.getProfession())){
                       query.put("profession",StringUtil.formatLike(employee.getProfession()));
               }
               if(employee.getPosition() != null &&
                        !"".equals(employee.getPosition())){
                       query.put("position", StringUtil.formatLike(employee.getPosition()));
               }
               Long total = employeeService.getTotalEmployee(query);
               JSONObject result = new JSONObject();
              result.put("total",total);
              ResponseUtil.write(response,result);
              return  null;
        }

        @RequestMapping("/find")
        public String search(
                @RequestParam(value="id")int id,
                HttpServletResponse response
        )throws  Exception{
                Employee employee = employeeService.findEmployeeById(String.valueOf(id));
                ResponseUtil.write(response, JSONObject.fromObject(employee));
                return null;
        }
}
