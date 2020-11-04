<?php
require("connection.php");
$command = "SELECT * FROM tbl_laundry";
$execute = mysqli_query($connect, $command);
$check = mysqli_affected_rows($connect);

if($check > 0){

    $response["code"] = 1;
    $response["message"] = "Data Available";
    $response["data"] = array();

    while($fetch = mysqli_fetch_object($execute)){
        $F["id"] = $fetch->id;
        $F["name"] = $fetch->name;
        $F["address"] = $fetch->address;
        $F["contact"] = $fetch->contact;
        
        array_push($response["data"], $F);
    }

}else{

    $response["code"] = 0;
    $response["message"] = "Data Not Available";
}

echo json_encode($response);
mysqli_close($connect);