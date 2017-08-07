var alphabet_set = "[A-Za-z]";
var letter_set = "[0-9]";
var special_char = "@";

var input_text;

function testForAlphabet(){
  if(input_text.match(alphabet_set)){
    return true;
  }
  return false;
}

function testForDigit(){
  if(input_text.match(letter_set)){
    return true;
  }
  return false;
}

function testUserName(){
  input_text = document.getElementById("u_name");
  if(input_text ==  null || input_text == ""){
    showError('Name field required');
  }
  else if(input_text.length > 20){
    showError('Name field required');
  }else if(!testForAlphabet){
    showError('Only character values are accepted');
  }
}

function testEmail(){

}

function testOption(){

}

function testOrganisationName(){

}

function testContactNumber(){

}

function testMessage(){

}

function testForm(){

}

/****** error handling *****/
function showError(var message){
  document.getElementById("display_error_message").innerHTML =
}
