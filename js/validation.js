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

  if (d.length < 9 || d.length > 12) {
    alert("Phone number must be filled with 9-12 digits number");
    return false;
  }
}