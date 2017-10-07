<?php
	$fullname = $mysqli->real_escape_string($_POST['fullname']);
	$username = $mysqli->real_escape_string($_POST['username']);
	$email = $mysqli->real_escape_string($_POST['email']);
	$pass = $mysqli->real_escape_string(password_hash($_POST['pass'], PASSWORD_BCRYPT));
	$phone = $mysqli->real_escape_string($_POST['phone']);
	$isdriver = isset($_POST['is-driver']) ? 1 : 0;
	$img_path = "profiles/default.png";
	$result = $mysqli->query("SELECT * FROM user WHERE email='$email' OR username='$username'") or die($mysqli->error());
	if ($result->num_rows > 0) {
		echo "<script>alert('Akun Tersebut Sudah Ada !')</script>";
	} else {
		$sql = "INSERT INTO user (username, fullname, email, pass, phone_num, is_driver, img_path)". "VALUES ('$username', '$fullname', '$email', '$pass', '$phone', '$isdriver', '$img_path')";
		$mysqli->query($sql);
		echo "<script>alert('Registrasi berhasil !')
		</script>";
	}
	$result1 = $mysqli->query("SELECT * FROM user WHERE username='$username'");
	if ($result1->num_rows > 0) {
		$user = $result1->fetch_assoc();
		$hot = $user['id'];
		if ($user['is_driver'] == 1) {
			header("location: profile.php?id_active=$hot");
		} else {
			header("location: order.php?id_active=$hot");
		}
	}
?>
