package main.projetobd_demo_dao_jdbc.applicaction.controllers;

import main.projetobd_demo_dao_jdbc.model.dao.DepartmentDao;
import main.projetobd_demo_dao_jdbc.model.entities.Department;

import java.util.List;

public class DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    /*
     * Retrieves a Department by its unique ID.
     */
    public Department findById(Integer id) {
        return departmentDao.findById(id);
    }

    /*
     * Retrieves all registered Departments.
     */
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    /*
     * Saves a new Department into the database.
     */
    public void save(Department department) {
        departmentDao.insert(department);
    }

    /*
     * Updates an existing Department in the database.
     */
    public void update(Department department) {
        departmentDao.update(department);
    }

    /*
     * Removes a Department from the database by its ID.
     */
    public void deleteById(Integer id) {
        departmentDao.deleteById(id);
    }
}