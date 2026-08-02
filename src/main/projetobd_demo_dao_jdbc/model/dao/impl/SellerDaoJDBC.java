package main.projetobd_demo_dao_jdbc.model.dao.impl;
import main.projetobd_demo_dao_jdbc.model.dao.SellerDao;
import main.projetobd_demo_dao_jdbc.model.entities.Department;
import main.projetobd_demo_dao_jdbc.model.entities.Seller;
import mysql.DB;
import mysql.exception.DbException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//implementando as interfaces
//estruturando o dao/ impl-> implementation

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    /*
     * Constructor that receives the database connection.
     */
    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setObject(3, obj.getBirthDate());
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Seller obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
                            + "WHERE Id = ?");

            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setObject(3, obj.getBirthDate());
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());
            st.setInt(6, obj.getId());

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Seller findById(Integer Id) {
        PreparedStatement stm = null;
        ResultSet rst = null;
        try {
            /*
             * conn is the database connection received through the constructor.
             * It is used to create a PreparedStatement that executes the SQL query.
             *
             * SQL explanation:
             * - SELECT seller.*: retrieves all columns from the seller table.
             * - department.Name AS DepName: retrieves the department name and assigns
             *   it the alias "DepName" to avoid ambiguity and simplify access in the ResultSet.
             * - INNER JOIN department: combines rows from the seller and department tables.
             * - ON seller.DepartmentId = department.Id: matches each seller with its
             *   corresponding department using the foreign key relationship.
             * - WHERE seller.Id = ?: filters the result to return only the seller
             *   with the specified ID. The question mark (?) is a placeholder that
             *   will be replaced by the method parameter using PreparedStatement.
             * * statement represents de data's to be consulted
             * *
             * *stm.executeQuery() => here we consult the datas in the bd
             * *the result of this operation we store in the resultset |rst = stm.executeQuery();
             */
            stm = conn.prepareStatement(
                    "SELECT seller.*, department.Name AS DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE seller.Id = ?");
            stm.setInt(1, Id);

            /*
             * stm.executeQuery() sends the SQL query to the database.
             * The database executes the query and returns the matching rows.
             * We store the returned data in a ResultSet object.
             * Moves the cursor to the first row of the ResultSet.
             * If a row exists, the data in that row becomes available for reading.
             */
            rst = stm.executeQuery(); //consult sql, the result is stored in the rst

            // Checks whether rst.next() returned a row.
            if (rst.next()) {

                // If a row exists, creates the Department and Seller objects
                // using the data from the current row.
                /*
                 * executeQuery() has already executed the SQL query and returned
                 * a ResultSet containing the data.
                 *
                 * rst.next() moves the cursor to the first row, making its values
                 * available through methods such as getInt() and getString().
                 *
                 * We then create the domain objects (Department and Seller)
                 * and populate them with the values from the current row
                 * using their setter methods.
                 *
                 */
                /*
                PreparedStatement (stm)
                           │
                           │ executeQuery()
                           ▼
                   Banco de Dados
                           │
                           │ executa o SELECT
                           ▼
                   Resultado da consulta
                           │
                           ▼
                   ResultSet (rst)
                 */

                // -------- Method that Populating the Department object --------
                Department dept = instantiateDepartment(rst);
                // -------- Method Populating the Seller object --------
                Seller obj = instantiateSeller(rst, dept);

                return obj; // 👈 RETORNA O OBJETO CRIADO
            }

            return null; // 👈 Retorna null caso não encontre no banco

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(stm);
            DB.closeResultSet(rst);
        }
    }


    @Override
    public List<Seller> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "ORDER BY Name");

            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {

                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            /*
             * Creates a PreparedStatement to retrieve all sellers
             * that belong to a specific department.
             */
            st = conn.prepareStatement(

                    /*
                     * Selects all columns from the seller table
                     * and the department name as "DepName".
                     */
                    "SELECT seller.*, department.Name AS DepName "

                            /*
                             * Joins the seller and department tables
                             * using the DepartmentId foreign key.
                             */
                            + "FROM seller INNER JOIN department "

                            /*
                             * Matches each seller with its corresponding department.
                             */
                            + "ON seller.DepartmentId = department.Id "

                            /*
                             * Filters the results by the department ID
                             * provided as a parameter (?).
                             */
                            + "WHERE DepartmentId = ? "

                            /*
                             * Sorts the sellers alphabetically by name.
                             */
                            + "ORDER BY Name");
            /*
                * The question mark (?)1, in the SQL query is a placeholder for a parameter.
             */
            st.setInt(1, department.getId());

            rs = st.executeQuery(); //bd execution

            List<Seller> list = new ArrayList<>();

            /*
             * The map acts as a cache for Department objects.
             *
             * The Integer type is used because the map identifies
             * each Department by its ID.
             *
             * The Department type is used because the map stores
             * Department objects as its values.
             */
            Map<Integer, Department> map = new HashMap<>();



            /*
             * Iterates through the ResultSet returned by executeQuery()
             * while there are more rows to process.
             */
            while (rs.next()) {
                /*
                 * The map acts as a doorman ("cache") for Department objects.
                 *
                 * For each row -> (rs.next()) in the ResultSet, it checks the Department ID
                 * to see whether that Department has already entered.
                 *
                 * If it has, there is no need to create a new Department object;
                 * the existing one is reused.
                 *
                 * Otherwise, a new Department object is created and added to the map.
                 *
                 * This avoids creating duplicate Department objects for sellers
                 * that belong to the same department, improving memory usage
                 * and performance.
                 */


                Department dep = map.get(rs.getInt("DepartmentId"));

                /*
                 * If the department is not already in the map,
                 * *
                 * *===
                 * * dep == null -> nothing was found in the map for the given department ID.?
                 * * put the objet in it ->  dep = instantiateDepartment(rs);
                 *  creates a new Department object and stores it  using its ID as the key.
                 *  and stores the new object ==| (map.put(rs.getInt("DepartmentId"), dep);)  |=== in the map
                 * *====

                 * using its ID as the key.
                 * This prevents duplicate Department objects from being created.
                 * * =======================================================
                 * 1ª- ID: rs.getInt("DepartmentId") OR KEY
                 * 2ª- dep = The Department object created by instantiateDepartment(rs) OR VALUE
                 */
                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    /*
                     * Stores the Department object in the map
                     * using the department ID as the key.
                     */
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                /*
                 * Creates the Seller object and links it
                 * to the cached Department object.
                 */
                Seller obj = instantiateSeller(rs, dep);

                /*
                 * Stores the Seller object, already associated
                 * with its Department, in the list.
                 */
                list.add(obj);
            }
            return list;

        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

     //Functions
    private  Department instantiateDepartment(ResultSet rst) throws  SQLException {
       Department dept = new Department();

        // Populate the Department object using the values
        // from the current ResultSet row.
        // Map database columns to the Department object.
        dept.setId(rst.getInt("DepartmentId"));
        dept.setName(rst.getString("DepName"));

        return dept;
    }

    private Seller instantiateSeller(ResultSet rst, Department dept) throws SQLException {
        Seller obj = new Seller();
        // Populate the Seller object using the values
        // from the current ResultSet row.
        // Map database columns to the Seller object.
        obj.setId(rst.getInt("Id"));
        obj.setName(rst.getString("Name"));
        obj.setEmail(rst.getString("Email"));
        obj.setBaseSalary(rst.getDouble("BaseSalary"));

        // Forma moderna: lê como java.time.LocalDate usando getObject
        obj.setBirthDate(rst.getObject("BirthDate", LocalDate.class));

        // Associate the Department object with the Seller object.
        // The Seller class contains a field of type Department.
        // A Seller has a Department object.
        obj.setDepartment(dept);

        return obj; //returns the object seller
    }
}