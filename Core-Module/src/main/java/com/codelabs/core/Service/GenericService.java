/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.core.Service;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kamal
 */
public interface GenericService<T> {

//    List<T> getAll();
//
//    T insert(T t);
//
//    void update(int id, T t);
//
//    boolean delete(int id);
//
//    T getById(int id);
    
    List<T> getAll() throws ClassNotFoundException, SQLException;

    T getById(int id) throws ClassNotFoundException, SQLException;

    int insert(T t) throws ClassNotFoundException, SQLException;

    int update(T t) throws ClassNotFoundException, SQLException;

    int delete(T t) throws ClassNotFoundException, SQLException;
}
