package mhl.service;
import mhl.dao.EmployeeDAO;
import mhl.domain.Employee;

/**
 * @author HLxxx
 * @version 1.0
 * 该类完成employee表的各种操作（通过调用EmployeeDAO完成）
 */
public class EmployeeService {
    //定义一个EmployeeDAO属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    //方法，根据empId和pwd返回一个Employee对象,查询不到则返回null
    public Employee getEmployeeByIdAndPwd(String empId, String pwd){
        Employee employee = (Employee) employeeDAO.querySingle
                ("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);
        return employee;
    }
}
