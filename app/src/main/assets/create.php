<?php
require("connection.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $name = $_POST["name"];
    $address = $_POST["address"];
    $contact = $_POST["contact"];

    $command = "INSERT INTO tbl_laundry (name, address, contact,) VALUES ('$name','$address','$contact')";
    $execute = mysqli_query($connect, $command);
    $check = mysqli_affected_rows($connect);

    if($check > 0){
        $response["code"] = 1;
        $response["message"] = "Successfully Saved";
    }else{
        $response["code"] = 0;
        $response["message"] = "Failed To Save Data";
    }
}
else{
    $response["code"] = 0;
    $response["message"] = "Data Not Available";
}

echo json_encode($response);
mysqli_close($connect);