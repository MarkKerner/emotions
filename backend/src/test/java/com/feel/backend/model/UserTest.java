package com.feel.backend.model;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by S on 09.04.2016.
 */
public class UserTest {
    private User uExpect = new User (1, "example", "Example", "User", "example@emotions.net", "TESTPWD123");

    @Test
    public void equalsTestShouldFailIfAllDifferent(){
        User u1 = new User(15,"civil", "Fname", "Lname", "email@email.com", "passwd");
        assertThat(u1, is(not(equalTo(uExpect))));

    }

    @Test
    public void equalsTestShouldFailIfIdDifferent() {
        User u1 = new User (2, "example", "Example", "User", "example@emotions.net", "TESTPWD123");
        assertThat(u1, is(not(equalTo(uExpect))));
    }

    @Test
    public void equalsTestShouldFailIfUsernameDifferent() {
        User u1 = new User (1, "falseUser", "Example", "User", "example@emotions.net", "TESTPWD123");
        assertThat(u1, is(not(equalTo(uExpect))));
    }

    @Test
    public void equalsTestShouldSucceed() {
        User u1 = new User (1, "example", "Example", "User", "example@emotions.net", "TESTPWD123");
        assertThat(u1,equalTo(uExpect));
    }

    @Test
    public void dataMismatchFinderShouldSucceedIfFirstNameDifferent(){
        User u1 = new User(uExpect);
        u1.setFirstname("Different");
        assertEquals(true, uExpect.dataMismatch(u1));
    }



    @Test
    public void dataMismatchFinderShouldSucceedIFLastNameDifferent(){
        User u1 = new User(uExpect);
        u1.setLastname("Different");
        assertEquals(true, uExpect.dataMismatch(u1));
    }

    @Test
    public void dataMismatchFinderShouldSucceedIfEmailDifferent(){
        User u1 = new User(uExpect);
        u1.setEmail("Different");
        assertEquals(true, uExpect.dataMismatch(u1));
    }

    @Test
    public void dataMismatchFinderShouldSucceedIfPasswdDifferent(){
        User u1 = new User(uExpect);
        u1.setPasswd("Different");
        assertEquals(true, uExpect.dataMismatch(u1));
    }

    @Test
    public void dataMismatchFinderShouldSucceedIfPicDifferent(){
        User u1 = new User(uExpect);
        u1.setProfilepic("Different");
        assertEquals(true, uExpect.dataMismatch(u1));
    }

    @Test
    public void dataMismatchFinderShouldSucceedIfRightsDifferent(){
        User u1 = new User(uExpect);
        u1.setRights(100);
        assertEquals(true, uExpect.dataMismatch(u1));
    }

    @Test
    public void dataMismatchFinderShouldFail(){
        User u1 = new User(uExpect);
        assertEquals(false, uExpect.dataMismatch(u1));
    }

    @Test
    public void dataMismatchShouldSucceedIfIdDifferent(){
        User u1 = new User(uExpect);
        u1.setUserID(100);
        assertEquals(true, uExpect.dataMismatch(u1));
    }

    @Test
    public void dataMismatchShouldSucceedIfUsernameDifferent(){
        User u1 = new User(uExpect);
        u1.setUsername("Different");
        assertEquals(true, uExpect.dataMismatch(u1));
    }


}
