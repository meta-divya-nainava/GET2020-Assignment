var password:String;
var employeeName:String;

 function validateField(idName:string) : boolean{
    let pattern :RegExp;
    let fieldValue:string = (<HTMLInputElement>document.getElementById(idName)).value;
    if (idName == "fullName") {
        pattern = /^[a-zA-Z]{2,}\s{1}[a-zA-Z]{1,}$/;
        if (pattern.test(fieldValue)) {
            employeeName = fieldValue;
        }

    } else if (idName == "password") {
        pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#%&*!~]){8,}/;
        if (pattern.test(fieldValue)) {
            password = fieldValue;
        }
    } else if (idName == "confirmPassword") {
        if (fieldValue != password) {
            return false;
        } else {
            return true;
        }
    } else if (idName == "contactNumber") {
        pattern = /^[0-9]{10}$/;
    } else if (idName == "emailId") {
        pattern = /^[a-zA-Z\$#\.!%&\^0-9]{1,}@[a-zA-Z]{1,}\.[a-zA-Z]{1,}$/;
    } else if (idName == "vecname") {
        pattern = /^[a-zA-Z]{1,}\s{0,}[a-zA-Z]{0,}$/;
    } else if (idName == "selectVehicle") {
        return true;
    } else if (idName == "vecnumber") {
        pattern = /^[A-Z]{2}\s{1}[0-9]{4}$/;
    } else if (idName =="gender") {
        if((<HTMLInputElement>document.getElementById('femaleButton')).checked==false && (<HTMLInputElement>document.getElementById('maleButton')).checked==false)
        {
            return false;
        }
        else{
            return true;
        }
    }
    else if (idName == "femaleButton" || idName == "maleButton") {
        if((<HTMLInputElement>document.getElementById('femaleButton')).checked==false && (<HTMLInputElement>document.getElementById('maleButton')).checked==false)
        
        {
            return false;
        }
        else{
            return true;
        }
    } else if (idName == "identification") {
        return true;
    } else {
        return false;
    }
    return pattern.test(fieldValue);
}
function changeLable(id: string):void {
    if (id == "gender") {
        (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName + ", May I know your gender?";
    } else if (id == "emailId") {
        (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName + ", May I know your email";
    } else if (id == "password") {
        (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName + ", May I know your password?";
    } else if (id == "confirmPassword") {
        (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName + ", May I know your password again?";
    } else if (id == "contactNumber") {
        (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName + ", May I know your contact number?";
    } else if (id == "typeOfVehicle") {
        (<HTMLElement>document.getElementById("labelMsg")).innerHTML= "Hi " + employeeName + ", Which type of vehicle you have?";
    } else if (id == "vecnumber") {
        (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName + ", May I know your vehicle number?";
    } else if (id == "identification") {
        (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName + ", May I know your vehicle identifications?";
    } else {
        (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName;
    }
}
/**
 * 
 * @param {*} ele 
 * @param {*} id 
 * @param {*} alertmsg 
 */
function validate(element:HTMLInputElement, id:string, alertmsg:string, event:KeyboardEvent) :void{
    if (event.key === 'Enter') {
        if (validateField(element.id)) {
            (<HTMLElement>document.getElementById(id)).style.display = "block";
            (<HTMLElement>document.getElementById(id)).focus();

            if (element.id == "femaleButton" || element.id == "maleButton") {
                (<HTMLElement>document.getElementById("gender")).style.display = "none";
            } 
            else if(id=="typeOfVehicle")
            {
                (<HTMLElement>document.getElementById(element.id)).style.display = "none";
                (<HTMLElement>document.getElementById("employeeId")).style.display = "none";

            }else {
                (<HTMLElement>document.getElementById(element.id)).style.display = "none";
            }

            changeLable(id);
            (<HTMLElement>document.getElementById(alertmsg)).style.display = "none";
        } else {
            (<HTMLElement>document.getElementById(alertmsg)).style.display = "block";
        }
    }

}
var employeeId :string="1";
/**
 * method to show vehicle form
 */
function showVehicle() {
    (<HTMLInputElement>document.getElementById("employeeId")).value = employeeId;
    (<HTMLElement>document.getElementById("heading")).innerText = "Vehicle Form";
    (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName + ", May I know your vehicle name?";
    (<HTMLElement>document.getElementById("employeeForm")).style.display = "none";
    (<HTMLElement>document.getElementById("vehicleForm")).style.display = "block";

}
/**
 * method to show pass detail
 */
var vehicleType:HTMLSelectElement;
var selectedOption:string;
function showPasses() {
    (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName + ", Please select any plan.";
    (<HTMLElement>document.getElementById("vehicleForm")).style.display = "none";
    (<HTMLElement>document.getElementById("passDetail")).style.display = "block";
    (<HTMLElement>document.getElementById("heading")).innerText = "Pass Detail";
    vehicleType= (<HTMLSelectElement>document.getElementById("selectVehicle"));
    selectedOption = vehicleType.options[vehicleType.selectedIndex].value;
    changeCurrencyINR();
}
/**
 * method to change currency into Inr
 */
function changeCurrencyINR() :void{
    if (selectedOption == "cycle") {
        (<HTMLInputElement>document.getElementById('Daily')).value = "5 INR";
        (<HTMLInputElement>document.getElementById('Monthly')).value = "100 INR";
        (<HTMLInputElement>document.getElementById('Yearly')).value = "500 INR";
    } else if (selectedOption == "MotorCycle") {
        (<HTMLInputElement>document.getElementById('Daily')).value = "10 INR";
        (<HTMLInputElement>document.getElementById('Monthly')).value = "200 INR";
        (<HTMLInputElement>document.getElementById('Yearly')).value = "1000 INR";
    } else {
        (<HTMLInputElement>document.getElementById('Daily')).value = "20 INR";
        (<HTMLInputElement>document.getElementById('Monthly')).value = "500 INR";
        (<HTMLInputElement>document.getElementById('Yearly')).value = "3500 INR";

    }
}
/**
 * method to change price into USD
 */
function getUSD():void {
    if (selectedOption == "cycle") {
        (<HTMLInputElement>document.getElementById('Daily')).value = (5 / 61.06).toFixed(3) + " USD";
        (<HTMLInputElement>document.getElementById('Monthly')).value = (100 / 61.06).toFixed(3) + " USD";
        (<HTMLInputElement>document.getElementById('Yearly')).value = (500 / 61.06).toFixed(3) + " USD";
    } else if (selectedOption == "MotorCycle") {
        (<HTMLInputElement>document.getElementById('Daily')).value = (10 / 61.06).toFixed(3) + " USD";
        (<HTMLInputElement>document.getElementById('Monthly')).value = (200 / 61.06).toFixed(3) + " USD";
        (<HTMLInputElement>document.getElementById('Yearly')).value = (1000 / 61.06).toFixed(3) + " USD";
    } else {
        (<HTMLInputElement>document.getElementById('Daily')).value = (20 / 61.06).toFixed(3) + " USD";
        (<HTMLInputElement>document.getElementById('Monthly')).value = (500 / 61.06).toFixed(3) + " USD";
        (<HTMLInputElement>document.getElementById('Yearly')).value = (3500 / 61.06).toFixed(3) + " USD";

    }

}
/**
 * method to change price into YEN
 */
function getYEN() :void{
    if (selectedOption == "cycle") {
        (<HTMLInputElement>document.getElementById('Daily')).value = (5 * 1.505).toFixed(3) + " JPY";
        (<HTMLInputElement>document.getElementById('Monthly')).value = (100 * 1.505).toFixed(3) + " JPY";
        (<HTMLInputElement>document.getElementById('Yearly')).value = (500 * 1.505).toFixed(3) + " JPY";
    } else if (selectedOption == "MotorCycle") {
        (<HTMLInputElement>document.getElementById('Daily')).value = (10 * 1.505).toFixed(3) + " JPY";
        (<HTMLInputElement>document.getElementById('Monthly')).value = (200 * 1.505).toFixed(3) + " JPY";
        (<HTMLInputElement>document.getElementById('Yearly')).value = (1000 * 1.505).toFixed(3) + " JPY";
    } else {
        (<HTMLInputElement>document.getElementById('Daily')).value = (20 * 1.505).toFixed(3) + " JPY";
        (<HTMLInputElement>document.getElementById('Monthly')).value = (500 * 1.505).toFixed(3) + " JPY";
        (<HTMLInputElement>document.getElementById('Yearly')).value = (3500 * 1.505).toFixed(3) + " JPY";

    }

}
/**
 * method to validate password 
 */
function isValid() {
    // let value =  (<HTMLInputElement>document.getElementById("password")).value;
    if (!validateField("password")) {
        (<HTMLInputElement>document.getElementById("password")).style.border = "2px solid red";
    } else {
        (<HTMLInputElement>document.getElementById("password")).style.border = "2px solid green";
    }
}
var price:string= "0";
/**
 * method to show total bill.
 */
function getBill():void{
    if ( (<HTMLInputElement>document.getElementById('daily')).checked) {
        price =  (<HTMLInputElement>document.getElementById('Daily')).value;
    } else if ( (<HTMLInputElement>document.getElementById('monthly')).checked) {
        price =  (<HTMLInputElement>document.getElementById('Monthly')).value;
    } else {
        price =  (<HTMLInputElement>document.getElementById('Yearly')).value;
    }
    (<HTMLElement>document.getElementById("passDetail")).style.display = "none";
    (<HTMLElement>document.getElementById("heading")).innerText = "Bill Detail";
    (<HTMLElement>document.getElementById("labelMsg")).innerHTML = "Hi " + employeeName;
    (<HTMLElement>document.getElementById("billDetail")).innerText = "Your bill is " + price;
}