/*
 Janine Lee
 10/22/17
 JS HW Part 2
 */


/*1*/
function getUSA()
{
	var x = document.getElementsByTagName("h1")[0];
	var x2= x.getElementsByTagName("span")[1];
	return console.log(x2.innerHTML);
};
getUSA();
/*2*/
function getPeopleInSales()
{
	var emp=document.getElementsByClassName("empName");
	var emp2=emp.contains("tr");
	//childnode with tr=sales
	return console.log(emp);
};
getPeopleInSales();
/*3*/
function getAnchorChildren()
{
	var child=document.querySelectorAll("a span");
	for(var i=0; i<child.length;i++){
		var child2=child[i].innerHTML;
	console.log(child2);
	}
};
getAnchorChildren();
/*4*/
function Hobbies()
{
	var h = document.getElementById("num2");
	
	 var select = "Select: ";
	    for (var i = 0; i < h.length; i++) {
	        select = select + "\n" + h.options[i].select;
	    }
	    console.log(select);
}
;Hobbies();
//Hobbies;
/*5*/
function getCustomAttribute()
{
	var ca= document.getElementsByClassName("data-customAttr").innerHTML
	return console.log(ca);
};
getCustomAttribute();
/*6
Regarding these elements:
	
<input id="num1" class="nums" type="text"/>
	
<input id="num2" class="nums" type="text"/>
	
<h3>Sum: <span id="sum"></span></h3>


Define onchange event handler.

Add <input> element values.

Put the sum in the <span> element.

If values cannot be added, put "Cannot add" in the <span> element*/
document.getElementById("sum").onchange=function(){Sum()};
function Sum()
{
	var num1=document.getElementById("num1").value;
	var num2=document.getElementById("num2").value;
	var sum=num1+num2;
	document.getElementById("sum").innerHTML=sum;
};
/*7*/

function skills()
{
	var s=document.getElementById("num2");
	var select=s.options.value.text;
    alert("Are you sure "+select+ " is one of your skills?");
};
document.getElementById("num2").addEventListener("skills", skills());
/*8
 When a user selects a color, create an alert with a message similar to:
	
"So you like green more than blue now?"

In this example, green is the new value and blue is the old value.

Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor
 */
function favColor()
{
	//five colors: green, blue, red, purple, yellow... default is yellow
	var def_color="yellow";
	var current=document.getElementsByTagName("select")[0].value;
	current.onchange=alert("So you like" +current+ " more than yellow now?");
};
favColor();
/*9*/
var empn= document.getElementsByClassName("empName");
empn.addEventListener("mouseover", mouseOver);

function mouseOver() {
	 if (empn.style.display === "none") {
	        empn.style.display = "block";
	    } else {
	        empn.style.display = "none";
	    }
}

/*10*/
function currentTime()
{
	var d = new Date();
	var ds = ("0" + d.getHours()).slice(-2) + ":" + ("0" + d.getMinutes()).slice(-2) + ":" +
			+ ("0" + d.getSeconds()).slice(-2);
	var dl=document.getElementById("currentTime").innerHTML;
	
	return console.log(ds);
};
currentTime();
/*11*/
function delay()
{
	var dl=document.getElementById("helloWorld").innerHTML;
	var color=dl.style.color=blue;
	dl.onclick="setTimeout(color, 3000)";
	
};
//delay();
/*12
This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
 */
function walkTheDOM(node, func)
{
	for (var i = 0; i < document.body.childNodes.length; i++) {
	      function func(node){( document.body.childNodes[i] )}; // Text, DIV, Text, UL, ..., SCRIPT
	    }
};




