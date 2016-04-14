package com.feel.backend.controller;

import com.feel.backend.api.UserApi;
import com.feel.backend.db.HibernateUtil;
import com.feel.backend.model.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.hibernate.internal.util.type.PrimitiveWrapperHelper;

/**
 * Created by S on 09.04.2016.
 */
public class UserController {

    private static volatile UserController instance = null;


    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public void saveOrUpdate(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.saveOrUpdate(user);
        session.flush();
        session.close();
    }

    public void deleteAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.createQuery("DELETE FROM User").executeUpdate();
        session.close();
    }


    public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = (List<User>) session.createQuery("from User").list();
        session.close();
        return users;

    }

    public User getUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    public User getUser(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //User user = (User) session.get(User.class, username);
        User user = (User) session.createQuery("from User WHERE username = '" + username + "'").uniqueResult();
        session.close();
        return user;
    }

    public void deleteUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = getUser(id);
        if(user != null) {
            session.delete(user);
            session.flush();
        }
        session.close();
    }

    public void deleteUser(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = getUser(username);
        if(user != null) {
            session.delete(user);
            session.flush();
        }
        session.close();
    }
}

