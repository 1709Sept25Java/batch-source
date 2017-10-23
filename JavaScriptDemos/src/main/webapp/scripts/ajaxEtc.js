
var colorVar = setInterval(function(){
	setColor();
}, 3000);
function setColor(){
	var x = document.body;
	x.style.backgroundColor = s.style.bakcgroundColor == "cyan" ? "red" : "cyan";
}
function stopColor(){
	clearInterval(colorVar);
}
	
function showTime(xhr){
	var res = JSON.parse(xhr.responseText);
	var time = document.getElementById("time").lastChild.innnerHTML = response.hour+":"+response.minute+":"+repsonse.second;
};

function getPokemon(xhr){
	var res = JSON.parse(xhr.responseText);
	var html = "<h4>Chosen pokemon has name: "+res.name+"</h4>";
	document.getElementById("pokeResult").innerHTML = html;
}

function sendAjaxGet(url,func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		//console.log(this.readyState);
		if(this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	xhr.open("GET",url,true);
	xhr.send();
};

window.onload = function(){
	//set up initial time data
	 var initTime = document.getElementById("time");
	var html = initTime.lastChild.innerHTML;
	var d = new Date();
	html += "<h4>"+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"</h4>"; 
	initTime.innerHTML = html;
	setInterval(function(){
		sendAjaxGet('http://localhost:8082/JavaScriptDemos/time',showTime);
	},2000);
	
	document.getElementById("pokeButton").addEventListener("click",function(){
		sendAjaxGet('https://pokeapi.co/api/v2/pokemon'+document.getElementById("pokeId").value,getPokemon);
	})
}
