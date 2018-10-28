<?php
	$id = $_GET['id_active'];
	$idorder = $_GET['id_order'];
	require 'connection.php';
	$sql = "UPDATE orderhistory SET hidden_d=1 WHERE id_order='$idorder'";
	if (mysqli_query($mysqli, $sql)) {
    	mysqli_close($sql);
    	header('Location: driverhistory.php?id_active='.$id.'');
	} else {
    	echo "Error deleting record";
	}
?>
