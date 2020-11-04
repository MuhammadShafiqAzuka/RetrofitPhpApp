<?php
$host = "localhost";
$user = "root";
$pass = "";
$db = "dblaundry";

$connect = mysqli_connect($host, $user, $pass, $db) or die("MYSQL database not connected");

if($connect){
    echo "Connection Successfull";
}