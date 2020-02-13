var employeeId = 0;
var fullName;
var number;
var email;
var vecName;
var vecNumber;

function nameValidate() {
    fullName = document.getElementById('name').value;
    var pattern = /^[a-zA-Z]{1,}\s{1}[a-zA-Z]{1,}$/;
    return pattern.test(fullName);
}

function vehicleNameValidate() {
    vecName = document.getElementById('vecname').value;
    var pattern = /^[a-zA-Z]{1,}\s{0,}[a-zA-Z]{0,}$/;
    return pattern.test(vecName);
}

function numberValidate() {
    number = document.getElementById('number').value;
    var numPattern = /^[0-9]{10}$/;
    if (number == 0000000000) {
        return false;
    }
    return numPattern.test(number);
}

function VehicleNumberValidate() {
    vecNumber = document.getElementById('vecnumber').value;
    var numPattern = /^[0-9]{4}$/;
    return numPattern.test(vecNumber);
}

function emailValidate() {
    email = document.getElementById('email').value;
    var emailPattern = /^[a-zA-Z\$#\.!%&\^0-9]{1,}@[a-zA-Z]{1,}\.[a-zA-Z]{1,}$/;
    return emailPattern.test(email);
}

function passwordValidate() {
    var password = document.getElementById('password').value;
    var passPattern = /^[a-zA-Z0-9!@#$%\^&*()~]{8,}$/;
    return passPattern.test(password);
}

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

    if (!nameValidate()) {
        document.getElementById("nameAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("nameAlert").style.display = "none";
    }
    if (!numberValidate()) {
        document.getElementById("numberAlert").style.display = "block";
        flag = 0;

    } else {
        document.getElementById("numberAlert").style.display = "none";
    }

    if (!emailValidate()) {
        document.getElementById("emailAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("emailAlert").style.display = "none";
    }

    if (!passwordValidate()) {
        document.getElementById("passwordAlert").innerText = "Please enter valid password";
        flag = 0;
    } else {
        document.getElementById("passwordAlert").innerText = "*Length should be greater than 8";

    }

    if (!confirmPassValidate()) {
        document.getElementById("confirmAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("confirmAlert").style.display = "none";
    }

    if (flag == 0) {
        return;
    } else {
    	return true;
    	

        
    }
}
var price = 0;

function changeCurrency() {
    if (selectedOption == "Cycle") {
        document.getElementById('Daily').value = 5;
        document.getElementById('Monthly').value = 100;
        document.getElementById('Yearly').value = 500;
    } else if (selectedOption == "MotorCycle") {
        document.getElementById('Daily').value = 10;
        document.getElementById('Monthly').value = 200;
        document.getElementById('Yearly').value = 1000;
    } else {
        document.getElementById('Daily').value = 20;
        document.getElementById('Monthly').value = 500;
        document.getElementById('Yearly').value = 3500;

    }
}
var vehicleType;
var selectedOption;

function isValid() {
    let value = document.getElementById("password").value;
    if (value.length < 8) {
        document.getElementById("password").style.border = "2px solid red";
    } else {
        document.getElementById("password").style.border = "2px solid green";
    }
}

function getBill() {
    changeCurrency();
}