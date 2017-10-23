/*
 Janine Lee
 10/22/17
 JS HW Part 2
 */


/*1*/
function getUSA()
{
	//get tag h1
	var x = document.getElementsByTagName("h1")[0];
	//get nested span tag
	var x2= x.getElementsByTagName("span")[1];
	return console.log(x2.innerHTML);
};
getUSA();
/*2*/
function getPeopleInSales()
{
	//get empName
	var emp=document.getElementsByClassName("empName");
	//nested node... get those in sales
	var emp2=emp.contains("tr");
	//childnode with tr=sales
	return console.log(emp);
};
getPeopleInSales();
/*3*/
function getAnchorChildren()
{
	//grab all from a, and nested span element
	var child=document.querySelectorAll("a span");
	//loop through array
	for(var i=0; i<child.length;i++){
		var child2=child[i].innerHTML;
	console.log(child2);
	}
};
getAnchorChildren();
/*4*/
function Hobbies()
{
	//get num2
	var h = document.getElementById("num2");
	//list all
	 var select = "Select: ";
	    for (var i = 0; i < h.length; i++) {
	        select = select + "\n" + h.options[i].select;
	    }
	    console.log(select);
};
Hobbies();
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

function Sum()
{
	//event handler
	document.getElementById("sum").onchange=function(){getSum()};
	return function getSum(){
	//get values for each input
	var num1=document.getElementById("num1").value;
	var num2=document.getElementById("num2").value;
	//get sum
	var sum=num1+num2;
	document.getElementById("sum").innerHTML=sum;
	};
};
/*7*/

function skills()
{
	//event listener
	document.getElementById("num2").addEventListener("skll", skll());
	// selection
	return function skll(){
	var s=document.getElementById("num2");
	var select=s.options.value.text;
    alert("Are you sure "+select+ " is one of your skills?");
	}
};
skills();
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

function mouse() {
	var empn= document.getElementsByClassName("empName");
	empn.addEventListener("mouseover", mouseOver);
	
	return function mouseOver(){
	 if (empn.style.display === "none") {
	        empn.style.display = "block";
	    } else {
	        empn.style.display = "none";
	    }
	}
}
mouse();

/*10*/
function currentTime()
{
	//get Date
	var d = new Date();
	//get hours+minutes+seconds
	var ds = ("0" + d.getHours()).slice(-2) + ":" + ("0" + d.getMinutes()).slice(-2) + ":" +
			+ ("0" + d.getSeconds()).slice(-2);
	var dl=document.getElementById("currentTime").innerHTML;
	
	return console.log(ds);
};
currentTime();
/*11*/
function delay()
{
	//get helloWorld element
	var dl=document.getElementById("helloWorld").innerHTML;
	//delay ...3000=3s
	dl.onclick="setTimeout(colorChange(), 3000)";
	return function colorChange(){
		dl.style.color=blue;
	}
};
delay();
/*12
This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
 */
function walkTheDOM(node, func)
{
	//transverse through child nodes
	function func(){
	for (var i = 0; i < document.body.childNodes.length; i++) {
	     ( document.body.childNodes[i] )}; // Text, DIV, Text, UL, ..., SCRIPT
	return console.log(node);   
	}
};




