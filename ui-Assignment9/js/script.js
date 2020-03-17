var password;
var employeeName;
function validateField(idName) {
    var pattern;
    var fieldValue = document.getElementById(idName).value;
    if (idName == "fullName") {
        pattern = /^[a-zA-Z]{2,}\s{1}[a-zA-Z]{1,}$/;
        if (pattern.test(fieldValue)) {
            employeeName = fieldValue;
        }
    }
    else if (idName == "password") {
        pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#%&*!~]){8,}/;
        if (pattern.test(fieldValue)) {
            password = fieldValue;
        }
    }
    else if (idName == "confirmPassword") {
        if (fieldValue != password) {
            return false;
        }
        else {
            return true;
        }
    }
    else if (idName == "contactNumber") {
        pattern = /^[0-9]{10}$/;
    }
    else if (idName == "emailId") {
        pattern = /^[a-zA-Z\$#\.!%&\^0-9]{1,}@[a-zA-Z]{1,}\.[a-zA-Z]{1,}$/;
    }
    else if (idName == "vecname") {
        pattern = /^[a-zA-Z]{1,}\s{0,}[a-zA-Z]{0,}$/;
    }
    else if (idName == "selectVehicle") {
        return true;
    }
    else if (idName == "vecnumber") {
        pattern = /^[A-Z]{2}\s{1}[0-9]{4}$/;
    }
    else if (idName == "gender") {
        if (document.getElementById('femaleButton').checked == false && document.getElementById('maleButton').checked == false) {
            return false;
        }
        else {
            return true;
        }
    }
    else if (idName == "femaleButton" || idName == "maleButton") {
        if (document.getElementById('femaleButton').checked == false && document.getElementById('maleButton').checked == false) {
            return false;
        }
        else {
            return true;
        }
    }
    else if (idName == "identification") {
        return true;
    }
    else {
        return false;
    }
    return pattern.test(fieldValue);
}
function changeLable(id) {
    if (id == "gender") {
        document.getElementById("labelMsg").innerHTML = "Hi " + employeeName + ", May I know your gender?";
    }
    else if (id == "emailId") {
        document.getElementById("labelMsg").innerHTML = "Hi " + employeeName + ", May I know your email";
    }
    else if (id == "password") {
        document.getElementById("labelMsg").innerHTML = "Hi " + employeeName + ", May I know your password?";
    }
    else if (id == "confirmPassword") {
        document.getElementById("labelMsg").innerHTML = "Hi " + employeeName + ", May I know your password again?";
    }
    else if (id == "contactNumber") {
        document.getElementById("labelMsg").innerHTML = "Hi " + employeeName + ", May I know your contact number?";
    }
    else if (id == "typeOfVehicle") {
        document.getElementById("labelMsg").innerHTML = "Hi " + employeeName + ", Which type of vehicle you have?";
    }
    else if (id == "vecnumber") {
        document.getElementById("labelMsg").innerHTML = "Hi " + employeeName + ", May I know your vehicle number?";
    }
    else if (id == "identification") {
        document.getElementById("labelMsg").innerHTML = "Hi " + employeeName + ", May I know your vehicle identifications?";
    }
    else {
        document.getElementById("labelMsg").innerHTML = "Hi " + employeeName;
    }
}
/**
 *
 * @param {*} ele
 * @param {*} id
 * @param {*} alertmsg
 */
function validate(element, id, alertmsg, event) {
    if (event.key === 'Enter') {
        if (validateField(element.id)) {
            document.getElementById(id).style.display = "block";
            document.getElementById(id).focus();
            if (element.id == "femaleButton" || element.id == "maleButton") {
                document.getElementById("gender").style.display = "none";
            }
            else if (id == "typeOfVehicle") {
                document.getElementById(element.id).style.display = "none";
                document.getElementById("employeeId").style.display = "none";
            }
            else {
                document.getElementById(element.id).style.display = "none";
            }
            changeLable(id);
            document.getElementById(alertmsg).style.display = "none";
        }
        else {
            document.getElementById(alertmsg).style.display = "block";
        }
    }
}
var employeeId = "1";
/**
 * method to show vehicle form
 */
function showVehicle() {
    document.getElementById("employeeId").value = employeeId;
    document.getElementById("heading").innerText = "Vehicle Form";
    document.getElementById("labelMsg").innerHTML = "Hi " + employeeName + ", May I know your vehicle name?";
    document.getElementById("employeeForm").style.display = "none";
    document.getElementById("vehicleForm").style.display = "block";
}
/**
 * method to show pass detail
 */
var vehicleType;
var selectedOption;
function showPasses() {
    document.getElementById("labelMsg").innerHTML = "Hi " + employeeName + ", Please select any plan.";
    document.getElementById("vehicleForm").style.display = "none";
    document.getElementById("passDetail").style.display = "block";
    document.getElementById("heading").innerText = "Pass Detail";
    vehicleType = document.getElementById("selectVehicle");
    selectedOption = vehicleType.options[vehicleType.selectedIndex].value;
    changeCurrencyINR();
}
/**
 * method to change currency into Inr
 */
function changeCurrencyINR() {
    if (selectedOption == "cycle") {
        document.getElementById('Daily').value = "5 INR";
        document.getElementById('Monthly').value = "100 INR";
        document.getElementById('Yearly').value = "500 INR";
    }
    else if (selectedOption == "MotorCycle") {
        document.getElementById('Daily').value = "10 INR";
        document.getElementById('Monthly').value = "200 INR";
        document.getElementById('Yearly').value = "1000 INR";
    }
    else {
        document.getElementById('Daily').value = "20 INR";
        document.getElementById('Monthly').value = "500 INR";
        document.getElementById('Yearly').value = "3500 INR";
    }
}
/**
 * method to change price into USD
 */
function getUSD() {
    if (selectedOption == "cycle") {
        document.getElementById('Daily').value = (5 / 61.06).toFixed(3) + " USD";
        document.getElementById('Monthly').value = (100 / 61.06).toFixed(3) + " USD";
        document.getElementById('Yearly').value = (500 / 61.06).toFixed(3) + " USD";
    }
    else if (selectedOption == "MotorCycle") {
        document.getElementById('Daily').value = (10 / 61.06).toFixed(3) + " USD";
        document.getElementById('Monthly').value = (200 / 61.06).toFixed(3) + " USD";
        document.getElementById('Yearly').value = (1000 / 61.06).toFixed(3) + " USD";
    }
    else {
        document.getElementById('Daily').value = (20 / 61.06).toFixed(3) + " USD";
        document.getElementById('Monthly').value = (500 / 61.06).toFixed(3) + " USD";
        document.getElementById('Yearly').value = (3500 / 61.06).toFixed(3) + " USD";
    }
}
/**
 * method to change price into YEN
 */
function getYEN() {
    if (selectedOption == "cycle") {
        document.getElementById('Daily').value = (5 * 1.505).toFixed(3) + " JPY";
        document.getElementById('Monthly').value = (100 * 1.505).toFixed(3) + " JPY";
        document.getElementById('Yearly').value = (500 * 1.505).toFixed(3) + " JPY";
    }
    else if (selectedOption == "MotorCycle") {
        document.getElementById('Daily').value = (10 * 1.505).toFixed(3) + " JPY";
        document.getElementById('Monthly').value = (200 * 1.505).toFixed(3) + " JPY";
        document.getElementById('Yearly').value = (1000 * 1.505).toFixed(3) + " JPY";
    }
    else {
        document.getElementById('Daily').value = (20 * 1.505).toFixed(3) + " JPY";
        document.getElementById('Monthly').value = (500 * 1.505).toFixed(3) + " JPY";
        document.getElementById('Yearly').value = (3500 * 1.505).toFixed(3) + " JPY";
    }
}
/**
 * method to validate password
 */
function isValid() {
    // let value =  (<HTMLInputElement>document.getElementById("password")).value;
    if (!validateField("password")) {
        document.getElementById("password").style.border = "2px solid red";
    }
    else {
        document.getElementById("password").style.border = "2px solid green";
    }
}
var price = "0";
/**
 * method to show total bill.
 */
function getBill() {
    if (document.getElementById('daily').checked) {
        price = document.getElementById('Daily').value;
    }
    else if (document.getElementById('monthly').checked) {
        price = document.getElementById('Monthly').value;
    }
    else {
        price = document.getElementById('Yearly').value;
    }
    document.getElementById("passDetail").style.display = "none";
    document.getElementById("heading").innerText = "Bill Detail";
    document.getElementById("labelMsg").innerHTML = "Hi " + employeeName;
    document.getElementById("billDetail").innerText = "Your bill is " + price;
}
