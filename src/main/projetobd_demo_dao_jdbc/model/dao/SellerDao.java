package main.projetobd_demo_dao_jdbc.model.dao;

import main.projetobd_demo_dao_jdbc.model.entities.Department;
import main.projetobd_demo_dao_jdbc.model.entities.Seller;

import java.util.List;

public interface SellerDao {

    /**
     * Inserts a new seller into the database.
     *
     * @param obj the seller to be inserted
     */
    void insert(Seller obj);

    /**
     * Updates an existing seller in the database.
     *
     * @param obj the seller with the updated information
     */
    void update(Seller obj);

    /**
     * Deletes the seller with the specified ID.
     *
     * @param id the seller ID
     */
    void deleteById(Integer id);

    /**
     * Returns the seller with the specified ID.
     *
     * @param id the seller ID
     * @return the matching seller, or {@code null} if no seller is found
     */
    Seller findById(Integer id);

    /**
     * Returns a list containing all sellers.
     *
     * @return a list of all sellers
     */
    List<Seller> findAll();

    /**
     * Returns all sellers that belong to the specified department.
     *
     * @param department the department used as the search criterion
     * @return a list of sellers in the specified department
     */
    List<Seller> findByDepartment(Department department);
}