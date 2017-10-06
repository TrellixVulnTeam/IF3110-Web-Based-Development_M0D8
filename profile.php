<?php
  require 'preliminarycheck.php';
?>

<!DOCTYPE html>
<html>
<head>
  <link rel="icon" href="img/icon.png" />
  <title>Ojek Panas | Profile</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div id="navbar">
    <?php include("navbar.php"); ?>
    <div class="after-box">
      <div class="centered">
        <a href="order.php?id_active=<?php echo $_GET['id_active']; ?>" class="list-item-order">ORDER
        <a href="historyorder.php?id_active=<?php echo $_GET['id_active']; ?>" class="list-item-history">HISTORY
        <a href="profile.php?id_active=<?php echo $_GET['id_active']; ?>" class="active-profile">MY PROFILE</a>
      </div>
    </div>
  </div>

  <div id="profile-header">
    <div class="floating-box-left-p">
      <span>MY PROFILE</span>
    </div>
    <div class="floating-box-right-p">
      <a href="editprofile.php?id_active=<?php echo $_GET['id_active']; ?>"><img src="img/pencil.png" width="30px" height="30px"></a>
    </div>
  </div>

  <div id="profile-content">
    <?php
      require 'connection.php';
      $query = "SELECT * FROM user WHERE id=$_GET[id_active]";
      $result = $mysqli->query($query);
      if (!$result) {
        exit("The query failed!");
      }
      $row = $result->fetch_assoc();

      $query_pl = "SELECT * FROM preferredlocation WHERE id=$_GET[id_active]";
      $result_pl = $mysqli->query($query_pl);
    ?>

    <img class="picture" src="<?=$row['img_path']?>"/>
    <p class="username">@<?=$row['username']?></p>
    <p class="data"><?=$row['fullname']?></p>

    <?php
      if ($row['is_driver'] == 0) {
        echo '<p class="data">Non-Driver</p>';
      } else {
        $printed = '';
        $printed .= '<p class="data">Driver | <font color="orange">&#9734;'.$row['star']. '</font> (' .$row['vote']. ' votes)</p>';
        echo $printed;
      }
    ?>

    <p class="data">&#9993; <?=$row['email']?></p>
    <p class="data">&#9743; <?=$row['phone_num']?></p>
  </div>
  <?php
    $printpreferred = '';
    if ($row['is_driver'] == 1) {
      $printpreferred .= '<div id="preferred-header">
      <div class="floating-box-left-l">
        <span>PREFERRED LOCATIONS:</span>';
      if ($result_pl->num_rows > 0) {
        while ($row_pl = $result_pl->fetch_assoc()) {
          $printpreferred .= '<div id="triangle"><ul><li>'.$row_pl['location'];
        }
        for ($i = 0; $i < $result_pl->num_rows; $i++) {
          $printpreferred .= '</li></ul></div>';
        }
      }
      $printpreferred .= '</div>
        <div class="floating-box-right-p">
          <a href="editlocation.php?id_active='.$_GET['id_active'].'"><img src="img/pencil.png" width="30px" height="30px"></a>
        </div>
      </div>';
      echo $printpreferred;
    }
  ?>
  
      
</body>
</html>
