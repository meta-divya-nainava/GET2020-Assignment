function push() {
    document.getElementById("pushSection").style.display = "block";
    document.getElementById("submitSection").style.display = "none";
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "";
}
class Stack {
    constructor() {
        this.collection = [];
    }

    push = function(element) {
        this.collection.push(element);
    }
    pop = function() {
        this.collection.pop();

    }

}
stack = new Stack();

function showList() {
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "result:" + stack.collection;
    document.getElementById("submitSection").style.display = "none";
}

function pushElement() {
    var element = document.getElementById("inputValue").value;
    stack.push(element);
    document.getElementById("submitSection").style.display = "none";
    document.getElementById("pushSection").style.display = "none";
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "successfully added";
}

function pop() {
    stack.pop();
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "successfully removed";
    document.getElementById("submitSection").style.display = "none";
}

function showOperation() {
    document.getElementById("submitSection").style.display = "block";
    document.getElementById("homeButton").style.display = "none";
    document.getElementById("pushSection").style.display = "none";
    document.getElementById("result").innerText = "";

}