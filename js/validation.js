function validateForm() {
    var x = document.forms["myForm"]["username"].value;
    if (x == "") {
        alert("Username must be filled out");
        return false;
    }

    var y = document.forms["myForm"]["pass"].value;
    if (y == "") {
        alert("Password must be filled out");
        return false;
    }
}

function validateForm1() {
  var a = document.forms["register-form"]["fullname"].value;
  if (a == "") {
      alert("Full name must be filled out");
      return false;
  }

  if (a.length > 20) {
    alert("Full name must be filled with maximum 20 characters");
    return false;
  }

  var b = document.forms["register-form"]["pass"].value;
  if (b == "") {
      alert("Password must be filled out");
      return false;
  }

  var c = document.forms["register-form"]["cpass"].value;
  if (c == "") {
      alert("Confirm password must be filled out");
      return false;
  }

  if (b != c) {
    alert("The password doesn't match!");
    return false;
  }

  var d = document.forms["register-form"]["phone"].value;
  if (d == "") {
      alert("Phone number must be filled out");
      return false;
  }

  var isnum = /^\d+$/.test(d);
  if (isnum == false) {
    alert("Wrong phone number format");
    return false;
  }

  if (d.length < 9 || d.length > 12) {
    alert("Phone number must be filled with 9-12 digits number");
    return false;
  }

  var e = document.forms["register-form"]["username"].value;
  if (e.length < 5) {
    alert("Username must be filled with minimum of 5 characters");
    return false;
  }
}

function validateEditProfileForm() {
  var a = document.forms["editprofile-form"]["yourname"].value;
  if (a == "") {
      alert("Full name must be filled out");
      return false;
  }

  if (a.length > 20) {
    alert("Full name must be filled with maximum 20 characters");
    return false;
  }

  var d = document.forms["editprofile-form"]["phone"].value;
  if (d == "") {
      alert("Phone number must be filled out");
      return false;
  }

  var isnum = /^\d+$/.test(d);
  if (isnum == false) {
    alert("Wrong phone number format");
    return false;
  }

  if (d.length < 9 || d.length > 12) {
    alert("Phone number must be filled with 9-12 digits number");
    return false;
  }
}

function validateForm2() {
  var e = document.forms["myForm2"]["pickup"].value;
  if (e == "") {
      alert("Picking point must be filled out");
      return false;
  }

  var f = document.forms["myForm2"]["dest"].value;
  if (f == "") {
      alert("Destination must be filled out");
      return false;
  }
}

function validate_username(field, query) {
  var xmlhttp;

  if (window.XMLHttpRequest) {
    xmlhttp = new XMLHttpRequest();
  } else {
    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
  }

  console.log(field);
  console.log(query);
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState != 4 && xmlhttp.status == 200) {
      document.getElementById(field).innerHTML = "Validating..";
    } else if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
      document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
    } else {
      document.getElementById("txtHint").innerHTML = "";
    }
  }

  xmlhttp.open("GET", "getUser.php?field=" + field + "&query=" + query, true);
  xmlhttp.send();
}

function validate_email(field, query) {
  var xmlhttp;

  if (window.XMLHttpRequest) {
    xmlhttp = new XMLHttpRequest();
  } else {
    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
  }

  console.log(field);
  console.log(query);
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState != 4 && xmlhttp.status == 200) {
      document.getElementById(field).innerHTML = "Validating..";
    } else if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
      document.getElementById("txtHint1").innerHTML = xmlhttp.responseText;
    } else {
      document.getElementById("txtHint1").innerHTML = "";
    }
  }

  xmlhttp.open("GET", "getUser.php?field=" + field + "&query=" + query, true);
  xmlhttp.send();
}

function starValidation() {
  var star5 = document.getElementById("star-5");
  var star4 = document.getElementById("star-4");
  var star3 = document.getElementById("star-3");
  var star2 = document.getElementById("star-2");
  var star1 = document.getElementById("star-1");
  if (!star5.checked && !star4.checked && !star3.checked && !star2.checked && !star1.checked){
    alert("Rating must be filled out");
    return false;
  } else {
    return true;
  }
}

function validateFileUpload() {
  var fuData = document.getElementById('user_image');
  var FileUploadPath = fuData.value;
  var Extension = FileUploadPath.substring(FileUploadPath.lastIndexOf('.') + 1).toLowerCase();
  if (Extension == "gif" || Extension == "png" || Extension == "jpeg" || Extension == "jpg") {
    if (fuData.files && fuData.files[0]) {
      var size = fuData.files[0].size;
      if (size > 5000000){
        alert("Maximum file size exceeds");
        return false;
      }
    }
  } else {
    alert("Photo only allows file types of GIF, PNG, JPG, and JPEG. ");
    return false;
  }
}

function validateAddLocation() {
  var newLocation = document.getElementById('newloc');
  if (!newLocation.value) {
    alert("Location name is empty");
    return false;
  }
  return true;
}

function loadFile(event) {
  var output = document.getElementById('output');
  output.src = URL.createObjectURL(event.target.files[0]);
}

function uploadFileHandler(event) {
  if (validateFileUpload() != false) {
    loadFile(event);
  }
}