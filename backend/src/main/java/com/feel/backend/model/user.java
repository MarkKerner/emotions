package com.feel.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.OverridesAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Created by S on 09.04.2016.
 */

@Entity
@Table(name = "Users")
@XmlRootElement
public class User {
    @Id
    @Column(name="pid")
    private int userID;
    @Column(name="username")
    private String username;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="email")
    private String email;
    @Column(name="passwd")
    private String passwd;
    @Column(name="profilepic")
    private String profilepic = "default.png";
    @Column(name="rights")
    private int rights = 1;

    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User() {}
    public User(User u) {
        this.userID = u.getUserID();
        this.username = u.getUsername();
        this.firstname = u.getFirstname();
        this.lastname = u.getLastname();
        this.email = u.getEmail();
        this.passwd = u.getPasswd();
        this.profilepic = u.getProfilepic();
        this.rights = u.getRights();
    }

    public User(int userID, String username, String firstname, String lastname, String email, String passwd, String profilepic, int rights) {
        this.userID = userID;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.passwd = passwd;
        this.profilepic = profilepic;
        this.rights = rights;
    }

    public User(int userID, String username, String firstname, String lastname, String email, String passwd) {

        this.userID = userID;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.passwd = passwd;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public int getRights() {
        return rights;
    }

    public void setRights(int rights) {
        this.rights = rights;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        User u = (User) o;
        if(this.userID != ((User) o).getUserID()) return false;
        if(!this.username.equals(((User) o).getUsername())) return false;
       return true;
    }

    @Override
    public String toString(){
        return this.userID + ", " + this.username;
    }



    public boolean dataMismatch(User u){
        if(this == u) return false;
        if(u == null) return true;
        if(userID != u.getUserID()) return true;
        if(username != u.getUsername()) return true;
        if(firstname != u.getFirstname()) return true;
        if(lastname != u.getLastname()) return true;
        if(email != u.getEmail()) return true;
        if(passwd != u.getPasswd()) return true;
        if(profilepic != u.getProfilepic()) return true;
        if(rights != u.getRights()) return true;
        return false;
    }
}


