console.log("in javascript");

function repeatString() {
    var stringName = document.getElementById("string").value;
    var count = document.getElementById("count").value;
    var newString = "";
    String.prototype.repeatify = function(count) {

        for (var itr = 0; itr < count; itr++) {
            newString += this;
        }
        return newString;
    }
    document.getElementById("inputSection").style.display = "none"
    document.getElementById("result").innerText = "result : " + stringName.repeatify(count);

}