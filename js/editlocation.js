function changeImage() {
	if (document.getElementById("editsave").name == "pencil") {
        document.getElementById("editsave").src = "./save.png";
        document.getElementById("editsave").name = "disk";
    } else if (document.getElementById("editsave").name == "disk") {
        document.getElementById("editsave").src = "./pencil.png";
        document.getElementById("editsave").name = "pencil";
    }
        /*else 
        {
            document.getElementById("editsave").src = "./save.png";
        }*/
}
function confirm_delete() {
  return confirm('Are you sure want to delete this location?');
}
