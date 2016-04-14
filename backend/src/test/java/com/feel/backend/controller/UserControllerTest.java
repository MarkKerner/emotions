package com.feel.backend.controller;

import com.feel.backend.model.User;
import org.hibernate.mapping.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

/**
 * Created by S on 09.04.2016.
 */
public class UserControllerTest {
    UserController userController = new UserController();
    User cTestUser = new User(41, "username", "firstname", "lastname", "email", "passwd");
    User cTestUser2 = new User(42, "username2", "firstname", "lastname", "email", "passwd");
    User cTestUser3 = new User(43, "username3", "firstname", "lastname", "email", "passwd");

    @Before
    public void beforeUserControllerTest(){
        userController.saveOrUpdate(cTestUser);
        userController.saveOrUpdate(cTestUser2);
        userController.saveOrUpdate(cTestUser3);
    }

    @After
    public void afterUserControllerTest(){
        userController.deleteAllUsers();
    }


    @Test
    public void userControllerGetAllUsersShouldGetAllUsers(){
        assertThat(userController.getAllUsers().size(), is(equalTo(3)));
        userController.deleteAllUsers();
        userController.saveOrUpdate(cTestUser);
        assertThat(userController.getAllUsers().size(), is(equalTo(1)));
    }

    @Test
    public void userControllerGetUserByIdShouldSucceed(){
        assertThat(userController.getUser(41).equals(cTestUser), is(equalTo(true)));
        //assertThat(userController.getUser(43).equals(cTestUser3), is(equalTo(true)));
        assertThat(userController.getUser(43).equals(cTestUser), is(equalTo(false)));
    }

    @Test
    public void userControllerGetUserByUsername(){
        assertThat(userController.getUser("username").equals(cTestUser),is(equalTo(true)));
        assertThat(userController.getUser("username2").equals(cTestUser2),is(equalTo(true)));
        assertThat(userController.getUser("username2").equals(cTestUser),is(equalTo(false)));
    }

    @Test
    public void userControllerUpdateSucceed(){
        User temp = userController.getUser(41);
        User temp2 = new User(temp);
        temp2.setUserID(999);
        temp2.setUsername("NotSameUser");
        userController.saveOrUpdate(temp2);
        assertThat(userController.getAllUsers().size(), is(equalTo(4)));

        temp2.setUserID(99);
        temp2.setUsername("ChangedUser");
        userController.saveOrUpdate(temp2);
        assertThat(userController.getUser(99), is(equalTo(temp2)));
        assertThat(userController.getUser("ChangedUser"), is(equalTo(temp2)));

    }

    @Test
    public void userControllerDeleteUserById(){
        userController.deleteUser(41);
        assertThat(userController.getAllUsers().size(), is(equalTo(2)));
        userController.deleteUser(42);
        assertThat(userController.getAllUsers().size(), is(equalTo(1)));

    }

    @Test
    public void userControllerDeleteUserByUsername(){
        userController.deleteUser("username2");
        assertThat(userController.getAllUsers().size(), is(equalTo(2)));
        userController.deleteUser("username3");
        assertThat(userController.getAllUsers().size(), is(equalTo(1)));
    }


}
