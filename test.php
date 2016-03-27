<?php
require_once("classes/connect.php");
$conn = establish();


$sqlUserPid1 = "SELECT * FROM users WHERE PID = 1";
$result = $conn->query($sqlUserPid1);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "id: " . $row["pid"]. " - Name: " . $row["firstname"]. " " . $row["lastname"]. "<br>";
    }
} else {
    echo "0 results";
}
mysqli_close($conn);
?>