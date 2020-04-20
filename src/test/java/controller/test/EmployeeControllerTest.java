package controller.test;

import com.ssm.maven.core.entity.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath*:/spring-context.xml",
                                             "classpath*:/spring-context-mvc.xml",
                                             "classpath*:/mybatis-config.xml"})
public class EmployeeControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employee/list"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testSearch() throws Exception{
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                MockMvcRequestBuilders.get("/employee/find")
                        .param("id","1");
        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void testCount() throws Exception{
         MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                     .get("/employee/total")
                     .param("isPartyMember","1"))
                 .andExpect(status().isOk())
                 .andDo(print())
                 .andReturn();
    }
    @Test
    public void testAdd() throws Exception{
        Employee employee = new Employee();
        employee.setName("Guest");
        employee.setMobile("15812071547");
        employee.setIsPartyMember(0);
        employee.setIsMarried(0);
        employee.setRemarks("hahahaha");
        mockMvc.perform(MockMvcRequestBuilders
                    .get("/employee/add")
                    .requestAttr("employee",employee))
                .andExpect(status().isOk())
                .andDo(print());
    }


    public void testUpdate() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                    .get("/employee/update")
                    .param("employee"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
