package com.feel.backend;

import com.feel.backend.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static com.feel.backend.db.HibernateUtil.getSessionFactory;

/**
 * Created by S on 09.04.2016.
 */
public class main {
    public static void main(String[] args) {
        User javaTestUser  = new User(1,"JavaTestUser", "Firstname", "Lastname", "email", "passwd");
        Session session = getSessionFactory().openSession();
    }

}
