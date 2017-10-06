<?php
	$username = $mysqli->real_escape_string($_POST['username']);
	$result = $mysqli->query("SELECT * FROM user WHERE username='$username'");
	if ($result->num_rows == 0) {
		echo "<script>alert('Akun dengan username tersebut belum ada')</script>";
	} else {
		$user = $result->fetch_assoc();
		$hot = $user['id'];
		if (password_verify($_POST['pass'], $user['pass'])) {
			if ($user['is_driver'] == 1) {
				header("location: profile.php?id_active=$hot");
			} else {
				header("location: order.php?id_active=$hot");
			}
		} else {
			echo "<script>alert('Password salah!')</script>";
		}
	}
?>
