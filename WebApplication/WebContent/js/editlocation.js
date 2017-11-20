function editdata(clicked_id, clicked_name) {
    var isPencilAlreadyClicked = document.getElementsByClassName('save');
    if (clicked_name == "pencil") {
        //Kalau belum ada pensil yang diklik sebelumnya
        if (isPencilAlreadyClicked.length == 0) {
            document.getElementById("data" +clicked_id).setAttribute("contenteditable", true);
            document.getElementById(clicked_id).style.display = "none";
            document.getElementById("imagefunc" + clicked_id).style.display = "block";
        }
    } /*else if (clicked_name == "save") {
        document.getElementById(clicked_id).name = "pencil";
        document.getElementById(clicked_id).className = "pencil";
        document.getElementById("image" + clicked_id).src = "./img/pencil.png";
        document.getElementById("data" +clicked_id).setAttribute("contenteditable", false);
    }*/
}
function savedata(clicked_id, clicked_name) {
    var id_hot = clicked_id.split("save").pop();
    document.getElementById(id_hot).name = "pencil";
    document.getElementById(id_hot).className = "pencil";
    document.getElementById("data" +id_hot).setAttribute("contenteditable", false);
    document.getElementById(id_hot).style.display = "block";
    document.getElementById("imagefunc" + id_hot).style.display = "none";
    var a = document.getElementById("data" + id_hot).innerHTML;
    window.location.replace("EditLocation?id_active=" + clicked_name + "&loc=" + id_hot + "&newloc=" + a);
}
function confirm_delete() {
  return confirm('Are you sure want to delete this location?');
}
