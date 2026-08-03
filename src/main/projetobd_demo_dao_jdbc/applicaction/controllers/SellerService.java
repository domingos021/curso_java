package main.projetobd_demo_dao_jdbc.applicaction.controllers;

import java.util.List;

import main.projetobd_demo_dao_jdbc.model.dao.SellerDao;
import main.projetobd_demo_dao_jdbc.model.entities.Department;
import main.projetobd_demo_dao_jdbc.model.entities.Seller;

/**
 * Service class responsible for encapsulating business logic
 * and orchestrating operations on the Seller DAO.
 */
public class SellerService {

    private final SellerDao sellerDao;

    public SellerService(SellerDao sellerDao) {
        this.sellerDao = sellerDao;
    }

    /*
     * Retrieves a Seller by their unique ID.
     */
    public Seller findById(Integer id) {
        return sellerDao.findById(id);
    }

    /*
     * Retrieves all Sellers belonging to a specific Department.
     */
    public List<Seller> findByDepartment(Department department) {
        return sellerDao.findByDepartment(department);
    }

    /*
     * Retrieves all registered Sellers.
     */
    public List<Seller> findAll() {
        return sellerDao.findAll();
    }

    /*
     * Saves a new Seller into the database.
     */
    public void save(Seller seller) {
        sellerDao.insert(seller);
    }

    /*
     * Updates an existing Seller in the database.
     */
    public void update(Seller seller) {
        sellerDao.update(seller);
    }

    /*
     * Removes a Seller from the database by their ID.
     */
    public void deleteById(Integer id) {
        sellerDao.deleteById(id);
    }
}