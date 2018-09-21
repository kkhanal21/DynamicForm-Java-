/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.formoption.DAO.Impl;

import com.codelabs.entity.FormOption;
import com.codelabs.formoption.DAO.FormOptionDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author kamal
 */
public class FormOptionDAOImpl implements FormOptionDAO {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<FormOption> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_form_options";
        return jdbcTemplate.query(sql, new FormOptionMapper());
    }

    @Override
    public FormOption getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_form_options WHERE form_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new FormOptionMapper());
    }

    @Override
    public int insert(FormOption f) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_form_options(form_name,description,status)"
                + "VALUES(?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{f.getName(), f.getDescription(), f.isStatus()});
    }

    @Override
    public int update(FormOption f) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_form_options form_name=?,description=?,status=?"
                + "WHERE form_id=?";
        return jdbcTemplate.update(sql, new Object[]{f.getName(), f.getDescription(), f.isStatus(), f.getId()});
    }

    @Override
    public int delete(FormOption t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class FormOptionMapper implements RowMapper<FormOption> {

        @Override
        public FormOption mapRow(ResultSet rs, int i) throws SQLException {
            FormOption fm = new FormOption();
            fm.setId(rs.getInt("form_id"));
            fm.setName(rs.getString("form_name"));
            fm.setDescription(rs.getString("description"));
            fm.setAddedDate(rs.getDate("addedDate"));
            fm.setStatus(rs.getBoolean("status"));
            return fm;
        }
    }
}
