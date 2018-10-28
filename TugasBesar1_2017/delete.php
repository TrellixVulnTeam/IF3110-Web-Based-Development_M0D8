<?php
	$loc = $_GET['loc'];
	$id = $_GET['id_active'];
	require 'connection.php';
	$sql = "DELETE FROM preferredlocation WHERE location='$loc'";
	if (mysqli_query($mysqli, $sql)) {
    	mysqli_close($sql);
    	header('Location: editlocation.php?id_active='.$id.'');
	} else {
    	echo "Error deleting record";
	}	
?>