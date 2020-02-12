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
        employeeId += 1;
        document.getElementById('registrationform').innerHTML = "";
        document.getElementById('employeeId').value = "Employee Id: " + employeeId;

        document.getElementById('registrationform1').style.display = "block";

        document.getElementById('formTitle').innerText = "Vehicle Registration Form";
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

function vehicleRegister() {
    var flag = 1;
    if (!vehicleNameValidate()) {
        document.getElementById("vecNameAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("vecNameAlert").style.display = "none";
    }
    if (!VehicleNumberValidate()) {
        document.getElementById("vecNumberAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("vecNumberAlert").style.display = "none";
    }
    if (flag == 0) {
        return false;
    } else {
        var vehicleType = document.getElementById("typeOfVehicle");
        document.getElementById('registrationform1').innerHTML = "";
        document.getElementById('registrationform2').style.display = "block";
        document.getElementById('formTitle').innerText = "Passes";
        selectedOption = vehicleType.options[vehicleType.selectedIndex].value;
        changeCurrency();
    }
}
const url = 'https://api.exchangerate-api.com/v4/latest/INR';


function isValid() {
    let value = document.getElementById("password").value;
    if (value.length < 8) {
        document.getElementById("password").style.border = "2px solid red";
    } else {
        document.getElementById("password").style.border = "2px solid green";
    }
}

function getBill() {
    if (document.getElementById('daily').checked) {
        price = document.getElementById('Daily').value;
    } else if (document.getElementById('monthly').checked) {
        price = document.getElementById('Monthly').value;
    } else {
        price = document.getElementById('Yearly').value;
    }

    /*document.getElementById('registrationform').innerHTML = "";
    document.getElementById('registrationform1').innerHTML = "";*/
    document.getElementById('employeename').innerText = fullName;
    document.getElementById('contact').innerText = number;
    document.getElementById('emailDetail').innerText = email;
    document.getElementById('employeeId1').innerText = employeeId;
    document.getElementById('vehicleName').innerText = vecName;
    document.getElementById('vehicleNumber').innerText = vecNumber;
    fetch(url)
        .then(res => res.json()) //response type
        .then(data => {
            document.getElementById('billINR').innerText = price;
            document.getElementById('billUSD').innerText = price * data["rates"]["USD"];
            document.getElementById('billYEN').innerText = price * data["rates"]["JPY"];

        });
    document.getElementById('registrationform2').style.display = "none";
    document.getElementById('detailTable').style.display = "block";
    document.getElementById('formTitle').innerText = "Your Deatils";

}