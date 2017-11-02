<?php
	$loc = $_GET['loc'];
	$newloc = $_GET['newloc'];;
	$id = $_GET['id_active'];
	require 'connection.php';
	$sql = "UPDATE preferredlocation SET location='$newloc' WHERE location='$loc'";
	if (mysqli_query($mysqli, $sql)) {
    	mysqli_close($sql);
    	header('Location: editlocation.php?id_active='.$id.'');
	} else {
    	echo "Error updating record";
	}
?>