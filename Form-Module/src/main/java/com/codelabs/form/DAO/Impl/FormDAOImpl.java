/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.form.DAO.Impl;

import com.codelabs.entity.Form;
import com.codelabs.form.DAO.FormDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kamal
 */
@Repository(value = "FormDAO")
public class FormDAOImpl implements FormDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Form> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_forms";
        return jdbcTemplate.query(sql, new FormMapper());
    }

    @Override
    public Form getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_forms WHERE form_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new FormMapper());
    }

    @Override
    public int insert(Form f) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_forms(form_name,description,status)"
                + "VALUES(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{f.getName(), f.getDescription(), f.isStatus()});
    }

    @Override
    public int update(Form f) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE INTO tbl_forms SET form_name=?,description=?,status=?"
                + "WHERE form_id=?";
        return jdbcTemplate.update(sql, new Object[]{f.getName(), f.getDescription(), f.isStatus(), f.getId()});
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM tbl_forms WHERE form_id=?";
        return jdbcTemplate.update(sql, new Object[]{id});

    }

    public class FormMapper implements RowMapper<Form> {

        @Override
        public Form mapRow(ResultSet rs, int i) throws SQLException {
            Form fm = new Form();
            fm.setId(rs.getInt("form_id"));
            fm.setName(rs.getString("form_name"));
            fm.setDescription(rs.getString("description"));
            fm.setAddedDate(rs.getDate("addedDate"));
            fm.setStatus(rs.getBoolean("status"));
            return fm;
        }

    }
}
