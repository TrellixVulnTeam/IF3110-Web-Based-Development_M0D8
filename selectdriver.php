<?php
  require 'preliminarycheck.php';

	if ($_SERVER['REQUEST_METHOD'] == 'POST')
	{
    require 'connection.php';
    
    $pickup = $mysqli->real_escape_string($_POST['pickup']);
    $dest = $mysqli->real_escape_string($_POST['dest']);
    $preferredDriver = [];
    if (isset($_POST['pref']) && $_POST['pref'] != ""){
      $preferredDriver = explode(',', $mysqli->real_escape_string($_POST['pref']));
    }
	}
?>

<!DOCTYPE html>
<html>
<head>
  <link rel="icon" href="img/icon.png" />
  <title>Ojek Panas | Order</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div id="navbar">
    <?php include("navbar.php"); ?>
    <div class="after-box">
      <ul class="centered">
      <li class="active"><a href="order.php?id_active=<?php echo $_GET['id_active']; ?>">ORDER</a>
      <li class="list-item"><a href="historyorder.php?id_active=<?php echo $_GET['id_active']; ?>">HISTORY</a>
      <li class="list-item"><a href="profile.php?id_active=<?php echo $_GET['id_active']; ?>">MY PROFILE</a>
      </ul>
    </div>
  </div>

  <div id="order-header">
    <div class="floating-box-left-mo">MAKE AN ORDER</div>
      <ul class="list-centered">
        <li class="list-order"><div class="circle">1</div>Select Destination</li>
        <li class="order-active"><div class="circle">2</div>Select a Driver</li>
        <li class="list-order"><div class="circle">3</div>Complete Your Order</li>
      </ul>
  </div>

  <div id="order-page">
    <!-- PREFERRED DRIVERS -->
    <div class="preferred-driver">
      <p class="header-pref">PREFERRED DRIVERS:</p>

      <table>

        <?php
          if ($preferredDriver == NULL) { // empty preferred driver
            echo "Nothing to display :("; 
          } else {
            $driverExist = false;
            foreach ($preferredDriver as $name) {
              $query = "SELECT * from (SELECT id, fullname, img_path, star, vote from user WHERE is_driver=1 AND fullname='$name') as U INNER JOIN preferredlocation as P ON U.id=P.id AND (P.location='$pickup' OR P.location='$dest')";
              $result = $mysqli->query($query);

              if ($result->num_rows > 0) {
                $driverExist = true;
                $loopResult = "";
                while($row = $result->fetch_array() ){
                  $loopResult .= 
                 '<form action="completeorder.php?id_active='.$_GET['id_active'].'" method="POST">
                    <tr>
                      <td rowspan="3"><img src='.$row['img_path'].' class="square-image"></td>
                      <td class="horizontal-space"></td>
                      <td class="horizontal-space"></td>
                      <td class="data-name">'.$row['fullname'].'</td>
                    </tr>
                    <tr>
                      <td class="horizontal-space"></td>
                      <td class="horizontal-space"></td>
                      <td class="data-rating"><font color="orange">&#9734; '.$row['star'].'</font> ('.$row['vote'].' votes)</td>
                    </tr>
                    <tr>
                      <td class="horizontal-space"></td>
                      <td class="horizontal-space"></td>

                      <input type="hidden" name="id_driver" value='.$row['id'].'>
                      <input type="hidden" name="pickup" value='.$pickup.'>
                      <input type="hidden" name="dest" value='.$dest.'>
                      
                      <td>
                        <br>
                        <button class="button-choose">I CHOOSE YOU!</div>
                      </td>
                    </tr>
                  </form>';
                }
                echo $loopResult;
              }
            }
            if (!$driverExist){
              echo "Nothing to display :(";
            }
          }
        ?>

      </table>
    </div>
    <br><br>
    <!-- OTHER DRIVERS -->
    <div class="preferred-driver">
      <p class="header-pref">OTHER DRIVERS:</p>
      <table>
        <tr>
          <td rowspan="3"><img src="img/fish.png" class="square-image"></td>
          <td class="horizontal-space"></td>
          <td class="horizontal-space"></td>
          <td class="data-name">Bomba-rattata Tattataata</td>
        </tr>
        <tr>
          <td class="horizontal-space"></td>
          <td class="horizontal-space"></td>
          <td class="data-rating"><font color="orange">&#9734; 4.7</font> (1,728 votes)</td>
        </tr>
        <tr>
          <td class="horizontal-space"></td>
          <td class="horizontal-space"></td>
          <td><br>
          <form method="POST">
            <div class="button-choose">I CHOOSE YOU!</div>
          </form></td>
        </tr>

        <tr>
          <td rowspan="3"><img src="img/fish.png" class="square-image"></td>
          <td class="horizontal-space"></td>
          <td class="horizontal-space"></td>
          <td class="data-name">Bomba-rattata Tattataata</td>
        </tr>
        <tr>
          <td class="horizontal-space"></td>
          <td class="horizontal-space"></td>
          <td class="data-rating"><font color="orange">&#9734; 4.7</font> (1,728 votes)</td>
        </tr>
        <tr>
          <td class="horizontal-space"></td>
          <td class="horizontal-space"></td>
          <td><br>
          <form method="POST">
            <div class="button-choose">I CHOOSE YOU!</div>
          </form></td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>
