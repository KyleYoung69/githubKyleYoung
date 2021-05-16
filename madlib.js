

var userInputs = {
	noun1: "", noun2: "", adj1: "", adj2: "", verb1: ""
};
const SUBMIT_BTN  = document.querySelector("#submitBtn")
const story = "<h1>THE STORY </h1><p> THE <span id\"adj1output\"></span> -ish <span id\"noun1output\"></span> did the <span id\"verb1output\"></span> on the <span id\"adj2output\"></span> -ish <span id\"noun2output\"></span> and then they all died the end. </p>";
function useInputs()
{
	userInputs.noun1 = document.getElementById('noun1input').value;
	userInputs.noun2 = document.getElementById('noun2input').value;
	userInputs.verb1 = document.getElementById('verb1input').value;
	userInputs.adj1 = document.getElementById('adj1input').value;
	userInputs.adj2 = document.getElementById('adj2input').value;

	createMadLib();
}
function createMadLib()
{
	document.getElementsById("adj1output").innerHTML = userInputs.adj1;
	document.getElementsById("adj2output").innerHTML = userInputs.adj2;
	document.getElementsById("noun1output").innerHTML = userInputs.noun1;
	document.getElementsById("noun2output").innerHTML = userInputs.noun2;
	document.getElementsById("verb1output").innerHTML = userInputs.verb1;

	document.getElementsById("displayArea").innerHTML = story;


}

SUBMIT_BTN.addEventListener('click', useInputs) 