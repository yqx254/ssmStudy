package com.ssm.maven.core.admin;

import com.ssm.maven.core.entity.Customer;
import com.ssm.maven.core.entity.PageBean;
import com.ssm.maven.core.service.CustomerService;
import com.ssm.maven.core.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fstar
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;
    private static  final Logger log = Logger.getLogger(CustomerController.class);

    @RequestMapping("/list")
    public String customerList(
            @RequestParam(value = "page", required = false)String page,
            @RequestParam(value = "rows", required = false)String rows,
            Customer customer, HttpServletResponse response) throws Exception {
        Map<String,Object> queryMap = new HashMap<>();
        if(page != null && rows != null){
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            queryMap.put("start",pageBean.getStart());
            queryMap.put("size", pageBean.getPageSize());
        }
        if(customer.getKeyword() != null && !"".equals(customer.getKeyword())){
            queryMap.put("keyword",customer.getKeyword());
        }
        List<Customer> customerList = customerService.customerList(queryMap);
        Long total = customerService.customerTotal(queryMap);
        JSONObject result = new JSONObject();
        JSONArray array = JSONArray.fromObject(customerList);
        result.put("rows",array);
        result.put("total",total);
        ResponseUtil.write(response,result);
        return null;
    }
    @RequestMapping("find")
    public String findCustomer(@RequestParam(value="id", required=true) String id,
                               HttpServletResponse response) throws Exception{
        return null;
    }
}
