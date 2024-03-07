package com.example;

import com.example.Entity.Employee;
import com.example.payload.EmployeeResponse;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeResponse employeeResponse = new EmployeeResponse();

        Employee newEmployee = new Employee();
        newEmployee.setName("Nguyễn Văn B ");
        newEmployee.setAddress("Hưng Yên");
        newEmployee.setPhone("0123456789");
        boolean isAdded = employeeResponse.addEmployee(newEmployee);
        System.out.println("Thêm nhân viên mới : " + (isAdded ? "Thành công":"Thất bại"));

        Employee updateEmployee = new Employee();
        updateEmployee.setId(3);
        updateEmployee.setName("Nguyễn Văn C");
        updateEmployee.setAddress("Hà Nội");
        updateEmployee.setPhone("012659872");
        boolean isUpdated = employeeResponse.updateEmployee(updateEmployee);
        System.out.println("Sửa nhân nhân viên : " + (isUpdated ? "Thành công":"Thất bại"));

        boolean isDeleted = employeeResponse.deleteEmployee(4 );
        System.out.println("Xóa nhân viên: " + (isDeleted ? "Thành công " : "Thất bại "));

        List<Employee> employees = employeeResponse.getEmployees();
        if(employees != null){
            for(Employee employee:employees){
                System.out.println(
                        employee.getId() + " "
                                + employee.getName() + " "
                                + employee.getAddress()
                                + " " + employee.getPhone() );
            }
        }

    }
}