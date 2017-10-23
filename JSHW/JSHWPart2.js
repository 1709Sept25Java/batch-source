// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

// window.onload = //to test
function getUSA() {
	var x = document.getElementById("usa").innerHTML;
	console.log(x);
};

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

// window.onload = //to test
function getPeopleInSales() {
	var x = document.getElementsByClassName("empName");
	for (i = 0; i < x.length; i++) {
		if (x[i].nextSibling.nextSibling.innerHTML == "Sales") {
			console.log(x[i].innerHTML);
		}
	}
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

// window.onload = // to test
function getAnchorChildren() {
	var x = document.getElementsByTagName("a");
	for (i = 0; i < x.length; i++) {
		if (x[i].children) {
			for (j = 0; j < x[i].children.length; j++) {
				if (x[i].children[j].tagName == "SPAN") {
					console.log(x[i].children[j].innerHTML);
				}
			}
		}
	}
}

// 4. Hobbies
// Define function
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

document.addEventListener('DOMContentLoaded', function() {
	document.querySelector('select[name="skills"]').onchange = selectChange;
});

function selectChange(event) {
	x = event.target.value;
	y = document.querySelector('option[value="' + x + '"]')
	alert("Skill selected: " + y.innerHTML);
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.

// window.onload =
function getCustomAttribute() {
	x = document.querySelectorAll("[data-customAttr]");
	for (i = 0; i < x.length; i++) {
		console.log(x[i].getAttribute("data-customAttr"));
		console.log(x[i]);
	}
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// <input id="num1" class="nums" type="text"/>
// <input id="num2" class="nums" type="text"/>
// <h3>Sum: span id="sum"></span></h3>
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

document.getElementById("num1").addEventListener("change", add);
document.getElementById("num2").addEventListener("change", add);

function add() {
	x = document.getElementById("num1").value;
	y = document.getElementById("num2").value;
	z = document.getElementById("sum").innerHTML;
	if (x == "" || y == "") {
		return;
	}
	if (isNaN(x) || isNaN(y)) {
		document.getElementById("sum").innerHTML = "Cannot add";
	} else {
		document.getElementById("sum").innerHTML = Number(x) + Number(y);
	}

}

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// "Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

document.getElementsByName("skills")[0].addEventListener("change", skillAlert);

function skillAlert(event) {
	x = event.target.value;
	y = document.querySelector('option[value="' + x + '"]')
	alert("Are you sure " + y.innerHTML + " is one of your skills?");
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// "So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons)
// the newly selected favoriteColor

x = document.getElementsByName("favoriteColor");
var previousColor;
for (i = 0; i < x.length; i++) {
	x[i].addEventListener("change", colorChangeAlert);
};

function colorChangeAlert() {
	currentColor = document
			.querySelector('input[name="favoriteColor"]:checked').value;
	console.log(previousColor);
	if (previousColor) {
		alert("So you like " + previousColor + " more than " + currentColor
				+ " now?");
		previousColor = currentColor;
		console.log(previousColor);
	} else {
		alert("So you like " + currentColor + " now?");
		previousColor = currentColor;
		console.log(previousColor);
	}
}

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// Hide the name if shown.
// Show the name if hidden.

x = document.getElementsByClassName("empName");
var placeholder;
for (i = 0; i < x.length; i++) {
	x[i].addEventListener("mouseenter", toggleName);
};

function toggleName() {
	if (this.innerHTML == "") {
		this.innerHTML = placeholder;
	} else {
		placeholder = this.innerHTML;
		this.innerHTML = "";
	}
}

// 10. Current Time
// Regarding this element:
// <h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

var dateString;
function getCurrentTime() {
	var date = new Date();
	var h = date.getHours();
	if (h > 12) {
		h = h - 12;
		partOfDay = "PM";
	} else {
		h = "0" + h;
		partOfDay = "AM"
	}
	var m = date.getMinutes();
	if (m < 10) {
		m = "0" + m;
	}
	var s = date.getSeconds();
	if (s < 10) {
		s = "0" + s;
	}
	document.getElementById("currentTime").innerHTML = h + ":" + m + ":" + s
			+ " " + partOfDay;
};
setInterval(getCurrentTime, 1000);

// 11. Delay
// Regarding this element:
// <p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a
// random color.

function getRandomColor() {
	var chars = "0123456789ABCDEF";
	var color = "#";
	for (var i = 0; i < 6; i++) {
		color += chars[Math.floor(Math.random() * 16)];
	}
	document.body.style.backgroundColor = color;
}

document.getElementById("helloWorld").addEventListener("click", changeColor);

function changeColor() {
	setTimeout(getRandomColor, 3000);
}

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM.
// Use recursion.
// On each node, call func(node).

function walkTheDomFromRoot(node, func) {
	func(node);
    node = node.firstChild;
    while (node) {
        walkTheDomFromRoot(node, func);
        node = node.nextSibling;
    }
}

function walkTheDom(node, func){ 
	root = node.getRootNode();
	walkTheDomFromRoot(root, func);
}

//window.onload = walkTheDom(document.getElementById("num1"), console.log); //to test
//window.onload = walkTheDomFromRoot(document, console.log); //to test
