<?php

class user {
    public $userPid;                        // Primary key, user ID
    public $username;                       // Users unique username
    public $firstname;                      // Users Firstname
    public $lastname;                       // Users Lastname
    public $email;                          // Users e-mail
    public $passwd;                         // Users Passwd
    public $profilepic = "default.png";     // Users profilepic, generally same as pid, defaults to the default profile pic.
    public $rights = 1;                     // Users right group, 1 = standard user, 2 = Moderator, 3 = Admin

    function __construct($pid, $user, $fname, $lname, $email, $passwd){
        $this->userPid = $pid;
        $this->username = $user;
        $this->firstname = $fname;
        $this->lastname = $lname;
        $this->email = $email;
        $this->passwd = $passwd;
    }

    function userToDB($connection) {
        $query = "INSERT INTO users VALUES ('$this->userPid','$this->username', '$this->firstname', '$this->lastname','$this->email', '$this->passwd', '$this->profilepic', '$this->rights')";
        if (mysqli_query($connection, $query)) {
            echo "New record created successfully";
        } else {
            echo "Error: " . $query . "<br>" . mysqli_error($connection);
        }
    }

    function userFromDbPID($connection){
        $query = "SELECT * FROM USERS WHERE pid = '$this->userPid'";
        return $connection->query($query);
    }

    function userFromDbUname($connection){
        return $connection->query("SELECT * FROM USERS WHERE username = '$this->username'");
    }

}

?>