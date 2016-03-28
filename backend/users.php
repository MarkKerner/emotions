<?

class user {
    public $userid;                         // Primary key, user ID
    public $username;                       // Users unique username
    public $firstname;                      // Users Firstname
    public $lastname;                       // Users Lastname
    public $email;                          // Users e-mail
    public $passwd;                         // Users Passwd
    public $profilepic = "default.png";     // Users profilepic, generally same as pid, defaults to the default profile pic.
    public $rights = 1;                     // Users right group, 1 = standard user, 2 = Moderator, 3 = Admin

    function __construct($uid, $user, $fname, $lname, $email, $passwd, $profilepic = "default.png", $rights = 1){
        $this->userid = $uid;
        $this->username = $user;
        $this->firstname = $fname;
        $this->lastname = $lname;
        $this->email = $email;
        $this->passwd = $passwd;
        $this->profilepic = $profilepic;
        $this->rights = $rights;
    }
}
function userToDB($connection, $user){
    $query = "INSERT INTO users VALUES ('$user->userid','$user->username', '$user->firstname', '$user->lastname','$user->email', '$user->passwd', '$user->profilepic', '$user->rights')";
    if (mysqli_query($connection, $query)) {
        echo "New record created successfully";
        $connection->query("INSERT INTO subscriptions VALUES('$user->userid','$user->userid')");
    } else {
        echo "Error: " . $query . "<br>" . mysqli_error($connection);
    }
}

function userFromDBUname($conn, $uname){
    $query = "SELECT * FROM users WHERE username = '$uname'";
    $result = $conn->query($query);
    if ($result->num_rows > 0) {
        // output data of each row
        $reformat = $result->fetch_assoc();
        $tempUser = new user($reformat["pid"],$reformat["username"],$reformat["firstname"],$reformat["lastname"],$reformat["email"],$reformat["passwd"],$reformat["profilepic"],$reformat["rights"]);
        return $tempUser;
    } else {
        echo "User not found";
    }
}

function editUserDB($conn,$user){
    $query = "UPDATE users SET username = '$user->username', firstname = '$user->firstname', lastname = '$user->lastname', email = '$user->email', passwd = '$user->passwd', profilepic = '$user->profilepic'  WHERE pid='$user->userid';";
    $conn->query($query);
}

function delUserDB($conn,$user){
    $query = "DELETE FROM users WHERE pid = '$user->userid'";
    $conn->query($query);
}

function userSubscribe($conn, $subscriberName, $targetName){
    $subscriber = userFromDBUname($conn, $subscriberName);
    $target = userFromDBUname($conn, $targetName);
    $query = "INSERT INTO subscriptions VALUES('$subscriber->userid','$target->userid')";
    $conn->query($query);
}

function userDelSubscribe($conn, $subscriberName, $targetName){
    $subscriber = userFromDBUname($conn, $subscriberName);
    $target = userFromDBUname($conn, $targetName);
    $query = "DELETE FROM subscriptions WHERE subscriber = '$subscriber->userid' AND target = '$target-userid'";
    $conn->query($query);
}


