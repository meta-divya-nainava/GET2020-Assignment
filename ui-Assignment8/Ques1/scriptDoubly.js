function showOperation() {
    document.getElementById("submitSection").style.display = "block";
    document.getElementById("homeButton").style.display = "none";
    document.getElementById("addSection").style.display = "none";
    document.getElementById("removeSection").style.display = "none";
    document.getElementById("result").innerText = "";

}
class Node {
    constructor(element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
    }
    add(element) {
        if (element == "") {
            window.alert("Please add some element to be inserted");
        } else {
            var node = new Node(element);
            if (this.head == null) {
                this.head = node;
                this.tail = node;
            } else {
                node.prev = this.tail;
                this.tail.next = node;
                this.tail = node;
            }
        }
    }
    delete(element) {
        var currentNode = this.head;
        var prev = null;
        while (currentNode) {
            if (currentNode.element === element) {
                if (currentNode == this.head && currentNode == this.tail) {
                    this.head = null;
                    this.tail = null;
                } else if (currentNode == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if (currentNode == this.tail) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
                return 1;
            }
            currentNode = currentNode.next;
        }
        window.alert("Element not found!");
        return -1;
    }


    show() {
        var currentNode = this.head;
        var str = "";
        while (currentNode != null) {
            str += currentNode.element + "<code>--></code>";
            currentNode = currentNode.next;

        }
        document.getElementById("result").innerHTML = "result: " + str + "&#x25BC";
        return 1;
    }
}
var linkedList = new DoublyLinkedList();

function showList() {
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("submitSection").style.display = "none";
    linkedList.show();
}

function addElement() {
    document.getElementById("addSection").style.display = "block";
    document.getElementById("submitSection").style.display = "none";
    document.getElementById("homeButton").style.display = "block";
    document.getElementById("result").innerText = "result:";
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