<?php
	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        require 'connection.php';

        $id_customer = $_GET['id_active'];
        $id_driver = $_POST['id_driver'];
        $pickup = $_POST['pickup'];
        $dest = $_POST['dest'];
        $star = $_POST['star'];
        $comment = $_POST['comment'];
        $date = date('Y-m-d');
        
        $countQuery = "SELECT COUNT(*) AS count FROM orderhistory WHERE id_driver='$id_driver'"; 
        $countResult = $mysqli->query($countQuery);
        $countFetch = $countResult->fetch_assoc();
        $count = $countFetch['count'];

        $ratingQuery = "SELECT id, star FROM user WHERE id='$id_driver'"; 
        $ratingResult = $mysqli->query($ratingQuery);
        $rating = $ratingResult->fetch_assoc();
        $oldStar = $rating['star'];
        $newStar = ($oldStar * $count + $star) / ($count + 1);
        
        $insert = "INSERT INTO orderhistory(id_customer, id_driver, rating, feedback, order_date, pickup, dest)" .
        "VALUES ('$id_customer', '$id_driver', '$star', '$comment', '$date', '$pickup', '$dest')";
        $mysqli->query($insert);

        $update = "UPDATE user SET vote=vote+1, star='$newStar' WHERE id='$id_driver'";
        $mysqli->query($update);

        header("location: order.php?id_active=$id_customer");
    }
?>