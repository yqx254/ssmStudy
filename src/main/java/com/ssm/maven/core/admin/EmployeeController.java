package com.ssm.maven.core.admin;

import com.ssm.maven.core.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 20200418
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
        private static final Logger log = Logger.getLogger(EmployeeController.class);

        @RequestMapping("/list")
        public String getList(
                @RequestParam(value = "page", required = false)String page,
                @RequestParam(value ="row", required = false)String row,
                Employee employee,
                HttpServletResponse response)throws  Exception{

            return null;
        }

}
