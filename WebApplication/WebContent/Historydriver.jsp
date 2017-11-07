<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="img/icon.png" />
	<title>Ojek Panas | History</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
  	<script src="js/hide.js"></script>
</head>
<body>
  	<div id="navbar">
    	<%@include file="Navbar.jsp" %>
    	<div class="after-box">
      		<div class="centered">
				<a href="Order.jsp" class="active-order">ORDER</a>
	      		<a href="Historyorder.jsp" class="list-item-history">HISTORY</a>
	      		<a href="Profile.jsp" class="list-item-profile">MY PROFILE</a>
    		</div>
    	</div>
  	</div>
    <div class="floating-box-left-mo2">TRANSACTIONS HISTORY</div>
    <div id="mini-navbar">
	   	<table>
	   		<tr>
				<td class="mini-navbar" onclick="location.href='Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>'">
					<a href="Historyorder.jsp?id_active=<%= request.getParameter("id_active") %>">MY PREVIOUS ORDERS</a>
				</td>
	   			<td class="selected-navbar" onclick="location.href='Historydriver.jsp?id_active=<%= request.getParameter("id_active") %>'">
	   				<a href="Historydriver.jsp?id_active=<%= request.getParameter("id_active") %>">DRIVER HISTORY</a>
	   			</td>
	   		</tr>
	   	</table>
    </div>
    <div class="empty-space"></div>
    
    <?php
        require 'connection.php';
        $id = $_GET['id_active'];
        $sql = "SELECT * FROM orderhistory WHERE id_driver=$id AND hidden_d=0 ORDER BY order_date DESC, id_order DESC";
        $result = $mysqli->query($sql);

        if ($result->num_rows > 0) {
            $loopResult = '';
            $counter = 1;
            // output data of each row
            while($row = $result->fetch_assoc()) {
                $idc = $row['id_customer'];
                $sql_customer = "SELECT * FROM user WHERE id=$idc";
                $resultc = $mysqli->query($sql_customer);
                $rowc = $resultc->fetch_assoc();
                $idd = $row['id_driver'];
                $idorder = $row['id_order'];
                $sql_driver = "SELECT * FROM user WHERE id=$idd";
                $resultd = $mysqli->query($sql_driver);
                $rowd = $resultd->fetch_assoc();
                $loopResult .= '<div class="history-list-item">
                    <table width="670px">
                        <tr>
                            <td rowspan="6" width="28"><img class="square-image" src='.$rowc['img_path'].' alt="User Profile"></td>
                            <td rowspan="6" class="horizontal-space" width="10px"></td>
                            <td colspan="2" class="history-date">';
                $loopResult .= date('l, F jS Y',strtotime($row['order_date']));
                $loopResult .= '</td>
                            <td width="100" rowspan="2"><div class="hide-button"><a href="hidedriver.php?id_active='.$id.'&id_order='.$idorder.'" id="'.$idorder.'" onclick="hidebutton(this.id)">HIDE</a></div></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="history-driver-name">'.$rowc['fullname'].'</td>
                        </tr>
                        <tr>
                            <td colspan="2" class="history-route">'.$row['pickup'].'-'.$row['dest'].'</td>
                        </tr>
                        <tr>
                            <td colspan="2" class="history-rating">gave <font color="orange">'.$row['rating'].'</font> stars for this order</td>
                        </tr>
                        <tr>
                            <td colspan="2">and left comment:</td>
                        </tr>
                        <tr>
                            <td class="horizontal-space-small"></td>
                            <td colspan="2">'.$row['feedback'].'</td>
                        </tr>
                        <tr><td class="vertical-space"></td></tr>
                    </table>
                </div>';
                $counter++;
            }
            echo $loopResult;
        } else {
            echo '<div class="nothing">Nothing to display &#128514;</div>';
        }
        $mysqli->close();
    ?>

</body>
</html>