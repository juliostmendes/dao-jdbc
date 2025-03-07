package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    Connection conn = DB.getConnection();
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM department " +
                    "WHERE Id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                Department obj = instantiateDepartment(rs);
                return obj;
            }
           return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM department " +
                    "ORDER BY Name");
            rs = ps.executeQuery();

            List<Department> list = new ArrayList<>();
            while(rs.next()){
                Department obj = instantiateDepartment(rs);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));

        return dep;
    }
}
