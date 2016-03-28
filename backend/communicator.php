<?php 
require "config.php";
require "users.php";
require "feel.php";

//Establish connection 
$conn = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);

//Check if connection works
if($conn->connect_error){
        echo $conn->connect_error;
}

//Work done by this script




//Close connection 
$conn->close();
