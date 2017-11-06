<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="img/icon.png" />
	<title>Ojek Panas | Edit</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<script type="text/javascript" src="./js/editlocation.js"></script>
    <script type="text/javascript" src="js/validation.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="edit-title">
        <span>EDIT PREFERRED LOCATIONS</span>
    </div>
    
    <div id="edit-profile-content">
    	<div id="edit-location-list">
    		<table id="preferredlocation" class="border-table" width="550px">

		    	<tr>
		    		<th>No</th>
		    		<th>Location</th>
		    		<th colspan="2">Actions</th>
		    	</tr>
		    	<?php
		    	    require 'connection.php';
		    	    $id = $_GET['id_active'];
					$sql = "SELECT * FROM preferredlocation WHERE id=$id";
					$result = $mysqli->query($sql);

					if ($result->num_rows > 0) {
						$loopResult = '';
						$counter = 1;
						// output data of each row
						while($row = $result->fetch_assoc()) {
							$loopResult .= '<tr id="tabel'.$row['location'].'">
					    		<td>'.$counter.'</td>
					    		<td id="data'.$row['location'].'">'.$row['location'].'</td>
					    		<td class="pencil-image"><a href="javascript:" id="'.$row['location'].'" name="pencil" class="pencil" onclick="return editdata(this.id, this.name)"><img id="image'.$row['location'].'" width="20px" height="20px"  src="img/pencil.png"></a>
                                    <center><a href="javascript:" id="save'.$row['location'].'" name="'.$id.'" class="functionalsave" onclick="return savedata(this.id, this.name)"><img id="imagefunc'.$row['location'].'" width="20px" height="20px"  src="img/save.png" style="display:none;"></a></center>
                                    </td>
					    		<td class="cancel-image"><a href="delete.php?id_active='.$id.'&loc='.$row['location'].'" class="confirmation" onclick="return confirm_delete()"><img src="img/cancel.png" width="20px" height="20px"></a></td>
                                
                            </tr>';
                            $counter++;
                        }
					    echo $loopResult;
					} else {
						echo "<td colspan='4' class='nothing'>Nothing to display &#128514;</td>";
					}
					$mysqli->close();
				?>
		    </table>
		    <div class="small-empty-space"></div>
    		<div class="small-title">
        		<span>ADD NEW LOCATIONS:</span>
    		</div>
    		<form method="POST" action="Editlocation.jsp?id_active=<%= request.getParameter("id_active") %>" onsubmit="return validateAddLocation()">
    			<table width="550px">
    				<tr>
    					<td>
    						<input class="text-field" type="text" name="newloc" id="newloc">
    					</td>
    					<td><button class="save-button" name="addloc">ADD</button></td>
    				</tr>
    			</table>

    		</form>
    		<div class="small-empty-space"></div>
    		<input type="button" class="back-button" value="BACK" onclick="window.location.href='Profile.jsp?id_active=<%= request.getParameter("id_active") %>'">
    	</div>

    </div>	
</body>
</html>