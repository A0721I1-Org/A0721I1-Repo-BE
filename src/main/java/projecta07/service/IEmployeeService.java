package projecta07.service;

import projecta07.exception.EmployeeNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projecta07.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    public List<Employee> getAllEmployee();
    public Optional<Employee> getEmployeeById(Long id);
    public Employee addEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public boolean deleteEmployee(Long id);

    public Employee getByEmail(String email);
    // Hàm này để tìm employee nào có email trùng với tham số sẽ update reset_password_token = token.
    public void updateResetPasswordToken(String token, String email) throws EmployeeNotFoundException;
    // Hàm dùng để trả về 1 employee thông qua reset_password_token
    public Employee getByResetPasswordToken(String token);
    //Hàm để đỏi mật khẩu cá nhân.
    public void updatePassword(Employee employee, String newPassword);
// ------------------------------------------------------
    Employee findEmployeeByIdUser(Long IdUser);

    List<Employee> findAll();

    Page<Employee> findAllPage(Pageable pageable);

    Employee findEmployeeById(long id);

    void deleteEmployee(long id);

    List<Employee> searchEmployee(String username, String name, String phone);

    void saveEmployee(Employee employee);

    Optional<Employee> findByIdEmployee(Long id);

}
