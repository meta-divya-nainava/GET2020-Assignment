function repeatString() {
    var stringName = document.getElementById("string").value;
    var result = removeConsecutive(stringName);
    document.getElementById("inputSection").style.display = "none"
    document.getElementById("result").innerText = "result : " + result;

}

function removeConsecutive(str) {
    var itr = 0;
    while (itr < (str.length - 1)) {
        if (str[itr] == str[itr + 1]) {
            str = str.substr(0, itr) + str.substr(itr + 2);
            itr = 0;
        }
        itr++;
    }
    return str;

}