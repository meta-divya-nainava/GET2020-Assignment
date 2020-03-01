var employeeId = 0;
var fullName;
var number;
var email;
var vecName;
var vecNumber;

function confirmPassValidate() {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('re_password').value;
    if (password != confirmPassword) {
        return false;
    } else {
        return true;
    }
}

function employeeRegister() {
    var flag = 1;

    if (!confirmPassValidate()) {
        document.getElementById("confirmAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("confirmAlert").style.display = "none";
    }

    if (flag == 0) {
        return false;
    } else {
    	return true;
    	

        
    }
}


function isValid() {
    let value = document.getElementById("password").value;
    if (value.length < 8) {
        document.getElementById("password").style.border = "2px solid red";
    } else {
        document.getElementById("password").style.border = "2px solid green";
    }
}