/**
function to remove consecutive element from the string
*/
function removeConsecutiveElement(){
	var inputString = document.getElementById("input_string").value;

	var previousPosition=0;
	var currentPosition=0;
	var differenceInPosition=0;
  
	if(!inputString){
		alert("invalid String");
		return;
	}
	
	while(currentPosition != inputString.length+1){
		if(inputString.charAt(previousPosition).toUpperCase() == inputString.charAt(currentPosition).toUpperCase()){
			currentPosition++;
			differenceInPosition++;
		}else if (differenceInPosition>1) {
			inputString=inputString.slice(0,previousPosition)+inputString.slice(currentPosition,inputString.length+1);
			previousPosition=previousPosition-1>0?previousPosition-1:0;
			currentPosition=previousPosition;
			differenceInPosition=0;
		}else{
			previousPosition=previousPosition+1;
			currentPosition=previousPosition;
			differenceInPosition=0;
		}
	}
	
	var final_string = document.body.appendChild(document.createElement("h2"));
	final_string.id = "repeated_removed";
	final_string.appendChild( document.createTextNode( "Final string: "+ inputString ) );
}
