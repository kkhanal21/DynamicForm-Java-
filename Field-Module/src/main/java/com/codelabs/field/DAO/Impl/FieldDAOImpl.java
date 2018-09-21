/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.field.DAO.Impl;

import com.codelabs.entity.Field;
import com.codelabs.field.DAO.FieldDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author koirala
 */
public class FieldDAOImpl implements FieldDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Field> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_form_fields";
        return jdbcTemplate.query(sql, new FieldMapper());
    }

    @Override
    public Field getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_form_fields WHERE field_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new FieldMapper());
    }

    @Override
    public int insert(Field f) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_form_fields(field_name)"
                + "VALUES(?)";
        return jdbcTemplate.update(sql, new Object[]{f.getName()});
    }

    @Override
    public int update(Field f) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_form_fields field_name=?"
                + "WHERE field_id=?";
        return jdbcTemplate.update(sql, new Object[]{f.getName()});
    }

    @Override
    public int delete(Field t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class FieldMapper implements RowMapper<Field> {

        @Override
        public Field mapRow(ResultSet rs, int i) throws SQLException {
            Field f = new Field();
            f.setId(rs.getInt("field_id"));
            f.setName(rs.getString("field_name"));
            
            return f;
        }
    }    
}
