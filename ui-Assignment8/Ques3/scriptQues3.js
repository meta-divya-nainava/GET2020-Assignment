function enqueue() {
    document.getElementById("pushSection").style.display = "block";
    document.getElementById("submitSection").style.display = "none";
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "";
}
class Queue {
    constructor() {
        this.collection = [];
    }
    enqueue = function(element) {
        this.collection.push(element);
    }
    dequeue = function() {
        this.collection.shift();
    }

}


queue = new Queue();

function showList() {
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "result:" + queue.collection;
    document.getElementById("submitSection").style.display = "none";
}

function enqueueElement() {
    var element = document.getElementById("inputValue").value;
    queue.enqueue(element);
    document.getElementById("submitSection").style.display = "none";
    document.getElementById("pushSection").style.display = "none";
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "successfully added";
}

function dequeue() {
    queue.dequeue();
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