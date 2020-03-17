function showOperation() {
    document.getElementById("submitSection").style.display = "block";
    document.getElementById("homeButton").style.display = "none";
    document.getElementById("addSection").style.display = "none";
    document.getElementById("removeSection").style.display = "none";
    document.getElementById("result").innerText = "";

}
class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
    add(value) {
        if (this.value == null) {
            this.value = value;
        } else {
            var currentNode = this;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(value);
        }
    }
    delete(value) {
        var currentNode = this;
        var nextNode = this.next;
        if (this.value == value && nextNode == null) {
            this.value = null;

        } else if (this.value == value) {
            currentNode.value = nextNode.value;
            currentNode.next = nextNode.next;

            return;
        } else {
            while (nextNode != null) {
                if (nextNode.value == value) {
                    currentNode.next = nextNode.next;
                    return;
                }
                nextNode = nextNode.next;
                currentNode = currentNode.next;
            }
            currentNode.next = null;

        }
    }
    show() {
        var node = this;
        var str = ""
        while (node) {
            str += node.value + "<code>--></code>";
            node = node.next;
        }
        document.getElementById("result").innerHTML = str + "&#x25BC";
    }
}
let linkedList = new Node();

function showList() {
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("submitSection").style.display = "none";
    linkedList.show();
}

function addElement() {
    document.getElementById("addSection").style.display = "block";
    document.getElementById("submitSection").style.display = "none";
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "";
    document.getElementById("removeSection").style.display = "none";
}

function add() {
    var element = document.getElementById("addinputValue").value;
    linkedList.add(element);
    document.getElementById("submitSection").style.display = "none";
    document.getElementById("addSection").style.display = "none";
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "successfully added";
    document.getElementById("removeSection").style.display = "none";
}

function removeElement() {
    document.getElementById("addSection").style.display = "none";
    document.getElementById("submitSection").style.display = "none";
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "";
    document.getElementById("removeSection").style.display = "block";
}

function remove() {
    var element = document.getElementById("removeinputValue").value;
    linkedList.delete(element);
    document.getElementById("submitSection").style.display = "none";
    document.getElementById("addSection").style.display = "none";
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "successfully deleted";
    document.getElementById("removeSection").style.display = "none";
}