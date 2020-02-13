
function firstNameValidate() {
    fullName = document.form.firstName.value;
    console.log("pattern")
    var pattern = /^[a-zA-Z]{1,}$/;
    return pattern.test(fullName);
}
function lastNameValidate() {
    fullName = fullName = document.form.lastName.value;
    var pattern = /^[a-zA-Z]{1,}$/;
    return pattern.test(fullName);
}
function fatherNameValidate() {
    fullName =fullName = document.form.fatherName.value;;
    var pattern = /^[a-zA-Z]{1,}\s{1}[a-zA-Z]{1,}$/;
    return pattern.test(fullName);
}
function emailValidate() {
    email = fullName = document.form.email.value;;
    var emailPattern = /^[a-zA-Z\$#\.!%&\^0-9]{1,}@[a-zA-Z]{1,}\.[a-zA-Z]{1,}$/;
    return emailPattern.test(email);
}
function register() {
    var flag = 1;

    if (!firstNameValidate()) {
        document.getElementById("firstnameAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("firstnameAlert").style.display = "none";
    }
    if (!lastNameValidate()) {
        document.getElementById("lastnameAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("lastnameAlert").style.display = "none";
    }
    if (!fatherNameValidate()) {
        document.getElementById("fathernameAlert").style.display = "block";
        flag = 0;
        console.log("fathername");
        console.log(flag);
    } else {
        document.getElementById("fathernameAlert").style.display = "none";
    }

    if (!emailValidate()) {
        document.getElementById("emailAlert").style.display = "block";
        flag = 0;
    } else {
        document.getElementById("emailAlert").style.display = "none";
    }
    if (flag == 0) {
        return false;
    } else {
       return true;
    }
}