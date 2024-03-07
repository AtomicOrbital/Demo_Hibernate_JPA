package com.example.payload;

import com.example.Entity.Employee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class EmployeeResponse {
    public List<Employee> getEmployees(){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            // Bắt đầu một giao dịch
            transaction = session.beginTransaction();

            // Lấy danh sách nhân viên
            List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
            return employees;
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public boolean addEmployee(Employee employee){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            // Thêm nhân viên mới
            session.save(employee);
            transaction.commit();
            return true;
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateEmployee(Employee employee){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            // cập nhật nhân viên mới
            session.update(employee);
            transaction.commit();
            return true;
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteEmployee(int employeeId){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            // Tìm nhân viên theo ID
            Employee employee = session.get(Employee.class, employeeId);
            if(employee != null){
                // Xóa nhân viên
                session.delete(employee);
                transaction.commit();
                return true;
            }
            return false;
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
