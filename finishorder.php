<?php
	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        require 'connection.php';
        echo $_POST['dest'];
    }
?>