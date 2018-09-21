///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.codelabs.core.DAO.Impl;
//
//import com.codelabs.core.DAO.GenericDAO;
//import java.lang.reflect.ParameterizedType;
//import java.util.List;
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// *
// * @author kamal
// */
//public class GenericDAOImpl<T> implements GenericDAO<T> {
////
////    @Autowired
////    protected SessionFactory sessionFactory;
////    protected Session session;
////    protected Transaction transaction;
////    private Class<T> paramClass;
////
////    public GenericDAOImpl() {
////        paramClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
////    }
////
////    @Override
////
////    public T insert(T t) {
////
////        session = sessionFactory.openSession();
////        transaction = session.beginTransaction();
////        session.save(t);
////        transaction.commit();
////        session.close();
////        return t;
////    }
////
////    @Override
////    public void update(T t) {
////        session = sessionFactory.openSession();
////        transaction = session.beginTransaction();
////        session.update(t);
////        transaction.commit();
////        session.close();
////    }
////
////    @Override
////    public T getById(int id) {
////        session = sessionFactory.openSession();
////        T t = (T) session.get(paramClass, id);
////        session.close();
////        return t;
////
////    }
////
////    @Override
////    public boolean delete(int id) {
////        boolean success = false;
////        session = sessionFactory.openSession();
////        T t = (T) session.get(paramClass, id);
////        if (t != null) {
////            transaction = session.beginTransaction();
////            session.delete(t);
////            transaction.commit();
////            success = true;
////        }
////        return success;
////    }
////
////    @Override
////    public List<T> getAll() {
////        session = sessionFactory.openSession();
////        Criteria criteria = session.createCriteria(paramClass).setMaxResults(10);
////        List<T> list = criteria.list();
////        session.close();
////        return list;
////    }
//
//}
