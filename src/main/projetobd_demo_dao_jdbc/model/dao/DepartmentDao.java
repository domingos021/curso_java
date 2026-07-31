package main.projetobd_demo_dao_jdbc.model.dao;

import main.projetobd_demo_dao_jdbc.model.entities.Department;

import java.util.List;

public interface DepartmentDao {


    /**
     * Inserts a new department into the database.
     */
    void insert(Department obj);

    /**
     * Updates an existing department in the database.
     */
    void update(Department obj);

    /**
     * Deletes the department with the specified ID.
     */
    void deleteById(Integer id);

    /**
     * Returns the department with the specified ID.
     */
    Department findById(Integer id);

    /**
     * Returns a list containing all departments.
     */
    List<Department> findAll();
}

