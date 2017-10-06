<?php
	require 'preliminarycheck.php';

	if ($_SERVER['REQUEST_METHOD'] == 'POST')
	{
		require 'connection.php';
		$imgFile = $_FILES['user_image']['name'];
		$tmp_dir = $_FILES['user_image']['tmp_name'];
		$imgSize = $_FILES['user_image']['size'];
		if (!empty($imgFile)) {
			$upload_dir = 'profiles/'; // upload directory
			$imgExt = strtolower(pathinfo($imgFile,PATHINFO_EXTENSION)); // get image extension
			// valid image extensions
			$valid_extensions = array('jpeg', 'jpg', 'png', 'gif'); // valid extensions
			// rename uploading image
			$userpic = $_GET['id_active'].".".$imgExt;
			// allow valid image file formats
			if (in_array($imgExt, $valid_extensions)) {
				// Check file size '5MB'
				if($imgSize < 5000000) {
					move_uploaded_file($tmp_dir,$upload_dir.$userpic);
				} else {
					$errMSG = "Sorry, your file is too large.";
				}
			} else {
				$errMSG = "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";  
			}
			if (!isset($errMSG)) {
				$hot_dir = $upload_dir.$userpic;
				$query = "UPDATE user SET img_path='$hot_dir' WHERE id='$_GET[id_active]'";
				$mysqli->query($query);
			}
		}
		if (isset($_POST['yourname'])) {
			$updatedname = mysqli_real_escape_string($mysqli, $_POST['yourname']);
			$query = "UPDATE user SET fullname='$updatedname' WHERE id='$_GET[id_active]'";
			$mysqli->query($query);
			// query update name
		}
		if (isset($_POST['phone'])) {
			$updatedphone = mysqli_real_escape_string($mysqli, $_POST['phone']);
			$query = "UPDATE user SET phone_num='$updatedphone' WHERE id='$_GET[id_active]'";
			$mysqli->query($query);
		}
		if (isset($_POST['isdriver'])) {
			$query = "UPDATE user SET is_driver=1 WHERE id='$_GET[id_active]'";
			$mysqli->query($query);
		} else {
			$query = "UPDATE user SET is_driver=0 WHERE id='$_GET[id_active]'";
			$mysqli->query($query);
		}
		$idactive=$_GET['id_active'];
		/*header('Location: profile.php?id_active='.$idactive.'');*/
		// query update isdriver
	}
?>

<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="img/icon.png" />
	<title>Ojek Panas | Edit</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<script src="js/validation.js"></script>
</head>
<body>
	<div class="edit-title">
        <span>EDIT PROFILE INFORMATION</span>
    </div>
    <div id="edit-profile-content">
    <form action="editprofile.php?id_active=<?=$_GET['id_active']?>" method="POST" name="editprofile-form" enctype="multipart/form-data">
    	<table>
			<?php
				require 'connection.php';
				$query = "SELECT * FROM user WHERE id=$_GET[id_active]";
				$result = $mysqli->query($query);
				if (!$result) {
					exit("The query failed!");
				}
				$row = $result->fetch_assoc();
			?>

	    	<tr>
	    		<td rowspan="2"><img class="square-image" src="<?=$row['img_path']?>" alt="Profile Picture"></td>
	    		<td class="horizontal-space"></td>
	    		<td class="bottom-table"><label class="label">Update profile picture</label></td>
	    	</tr>
	    	<tr>
	    		<td class="horizontal-space"></td>
	    		<td class="upper-table"><input type="file" name="user_image" accept="image/*"></td>
	    	</tr>
	    	<tr>
	    		<td colspan="3" class="vertical-space"></td>
	    	</tr>
	    	<tr>
	    		<td><label class="label" for="yourname">Your Name</label></td>
	    		<td class="horizontal-space"></td>
	    		<td><input class="text-field" type="text" name="yourname" id="yourname" value="<?=$row['fullname']?>"></td>
	    	</tr>
	    	<tr>
	    		<td><label class="label" for="phone">Phone</label></td>
	    		<td class="horizontal-space"></td>
	    		<td><input class="text-field" type="text" name="phone" id="phone" value="<?=$row['phone_num']?>"></td>
	    	</tr>
	    	<tr>
	    		<td><label class="label" for="isdriver">Status Driver</label></td>
	    		<td class="horizontal-space"></td>
	    		<td class="content-right">
		    		<label class="switch">
		    			<?php
		    				if ($row['is_driver'] == 0) {
		    					echo '<input name="isdriver" id="isdriver" type="checkbox">';

		    				} else {
		    					echo '<input name="isdriver" id="isdriver" type="checkbox" checked>';
		    				}
		    			?>
	  					
	  					<span class="slider round"></span>
					</label>
				</td>
	    	</tr>
	    	<tr>
	    		<td colspan="3" class="vertical-space"></td>
	    	</tr>
	    	<tr>
	    		<td><input type="button" class="back-button" value="BACK" onclick="window.location.href='profile.php?id_active=<?php echo $_GET['id_active']; ?>'"></td>
	    		<td class="horizontal-space"></td>
	    		<td><button class="save-button" name="editprofile" value="submit" onclick="window.location.href='profile.php?id_active=<?php echo $_GET['id_active']; ?>'">SAVE</button></td>
	    	</tr>
	    </table>
    </form>
    </div>

</body>
</html>
