package main.projetobd_demo_dao_jdbc.model.dao;

/*
 * Factory class responsible for instantiating DAO implementations.
 *
 * Objective:
 * Centralize the creation of DAO objects, hiding the implementation details
 * from the rest of the application. This makes the code easier to maintain,
 * reduces coupling, and allows DAO implementations to be changed without
 * affecting the classes that use them.
 */

import main.projetobd_demo_dao_jdbc.model.dao.impl.DepartmentDaoJDBC;
import main.projetobd_demo_dao_jdbc.model.dao.impl.SellerDaoJDBC;
import mysql.DB;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
