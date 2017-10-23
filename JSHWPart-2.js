/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.*/

	/*function getUSA() {
    var searchText = "USA";
   var getTags = document.body.getElementsByTagName("*");
    for (var i = 0; i < getTags.length; i++) {
       if (getTags[i].textContent == searchText){
          console.log(getTags[i]);
				break;		  }}};*/

/*2. Sales

Define function getPeopleInSales()
Print the names of all the people in the sales department.*/

	/*function getPeopleInSales(){
		var value = "Sales";
	var getPeople = document.getElementsByTagName("td");
		for (var i=0; i<getPeople.length; i++) {
		if( getPeople[i+1].innerHTML==value){
			var salesPeople = getPeople[i].innerHTML;
				console.log(salesPeople); }}};
*/


/*3. Click Here

Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>*/

	/*function getAnchorChildren(){
		var childElement = document.getElementsByTagName("span");
					for (var i=0; i<childElement.length; i++) {
					var contents = childElement[i].parentNode.innerHTML;
						console.log(contents); }};*/
/*4. Hobbies
Define function 	
Find all checked options in the 'skills' select element.
Print the value and the contents.	*/

				/*function Hobies(){
				var skills = document.getElementsByName("skills");
				for (var i=0; i<skills.length; i++) {
				var selectFromSkills = skills[i].options[skills[i].selectedIndex].value;
				var contentFromSkills = skills[i].options[skills[i].selectedIndex].textContent;
				console.log(contentFromSkills + ":" + selectFromSkills); }};*/

/*5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.*/	

			/*function getCustomAttribute() {
				var attr =  "data-customAttr";
			var allElements = document.getElementsByTagName("*");
			for (var i = 0; i < allElements.length; i++) {
				if (allElements[i].getAttribute(attr)!==null) {
			console.log(allElements[i].getAttribute(attr));
			console.log(allElements[i]); }}};*/
			
/*6. Sum Event

NOTE: Write unobtrusive Javascript
Regarding these elements:
<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: span id="sum"></span></h3>
	Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element */

		function sumEvent(){
		var n1=Number(document.getElementById("num1").value);
		var n2=Number(document.getElementById("num2").value);
		if (n1+n2!==NaN && n1+n2!==null){
		document.getElementById("sum").innerHTML= sum;
		} else {
		document.getElementById("sum").innerHTML="Cannot add"; }}
		
		document.getElementById("sum").addEventListener("change", sumEvent);

/*7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.*/
			
				  skills = document.getElementsByName("Skills");
				  function selectAlert (){
				  for (var i=0; i< skills.length; i++) {
					 if (skills[i].selected=true) {
						  var selectOption = skills[i].options[skills[i].selectedIndex].value;
							alert("Are you sure " +selectOption +"is one of your skills?"); }}};
				
					for (var j=0; j<skills.length; j++) {
					skills[j].addEventListener("change", selectAlert);
				 
				 
/*8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor*/

				 favColor = document.getElementsByName("favoriteColor");
				function colorEvent(){
				for (var i=0; i<favColor.length; i++) {
					if (favColor[i+1].checked=true) {
						var oldColor = favColor[i].value;
						var newColor= favColor[i+1].value;
						 favColor[i+1].style.backGround = newColor;
				alert ("So you like " + newColor +"more than "+ oldColor + "now?"); }}};
				
				for (var j=0; i<favColor.length; j++) {
				favColor[j].addEventListener("click", colorEvent); }
				
/*9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
Hide the name if shown.
Show the name if hidden.*/

	var employeesName = document.getElementsByClassName("empName");
				function showHideEvent () {
				for (var i=0; i<employeesName.length; i++) {
						if (employeesName[i].style.display =="none") {
							employeesName[i].style.display = "block"; }
						else {
							employeesName[i].style.display= "none"; }}};
				for (var j=0; j<employeesName.length; j++) {
					employeesName.addEventListener("mouseover", showHideEvent);
				
/*10. Current Time
Regarding this element:
<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.*/


			document.getElementById("currentTime").addEventListener(
					
							