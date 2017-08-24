var alphabet_set = "^[a-zA-Z]+$";
var letter_set = "^[0-9]+$";
var email_set = "^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+\.[a-zA-Z]$";

function validateForAlphabet(input_text){
  if(input_text.match(alphabet_set)){
    return true;
  }
  return false;
}

function validateForDigit(input_text){
  if(input_text.match(letter_set)){
    return true;
  }

  return false;
}

function validateForEmail(input_text){
  if(input_text.match(email_set)){
    return true;
  }

  return false;
}

function validateUserName(user_name){
  var input_text = user_name.value;
  var error_label= user_name.labels[1];

  if(!input_text){
    return showError('Name field required', error_label);
  }else if(input_text.length > 20){
    return showError('Maximum Name field is 20 characters', error_label);
  }else if(!validateForAlphabet(input_text)){
    return showError('Only alphabet values are accepted', error_label);
  }else{
    return showValid(error_label);
  }
}

function validateEmail(user_email){
  var input_text = user_email.value;
  var error_label= user_email.labels[1];

  if(!input_text){
    return showError('Email field required', error_label);
  }else if(!validateForEmail(input_text)){
    return showError('Invalid email format', error_label);
  }else{
    return showValid(error_label);
  }
}

function validateOption(user_option){
  var input_text = user_option.value;
  var error_label= user_option.labels[1];

  if(!input_text){
    return showError('City field required', error_label);
  }else{
    document.getElementById("city_selected").value = "you have selected this city : "+ input_text;
    document.getElementById("city_selected").style.display = "block";
    return showValid(error_label);
  }
}

function validateOrganisationName(user_organisation){
  var input_text = user_organisation.value;
  var error_label= user_organisation.labels[1];

  if(!input_text){
    return showError('Organisation name required', error_label);
  }else if(!validateForAlphabet(input_text)){
    return showError('Only alphabet values are allowed', error_label);
  }else{
    return showValid(error_label);
  }
}

function validateContactNumber(user_contactNumber){
  var input_text = user_contactNumber.value;
  var error_label = user_contactNumber.labels[1];

  if(!input_text){
    return showError('Contact Number required', error_label);
  }else if(input_text.length > 10){
    return showError('Enter valid contact number', error_label);
  }else if(!validateForDigit(input_text)){
    return showError('Only numeric values allowed', error_label);
  }else{
    return showValid(error_label);
  }
}

function validateMessage(user_message){
  var input_text = user_message.value;
  var error_label = user_message.labels[1];

  if(!input_text){
    return showError('Message required', error_label);
  }else if(input_text.length > 250){
    return showError('Maximum allowed length is 250 characters only', error_label);
  }else{
    return showValid(error_label);
  }
}

function validateForm(){
  var user_form = document.getElementById("user_form").elements;
  var form_validation = document.getElementById("invalid_submission");

  if(validateUserName(user_form[0]) & validateEmail(user_form[1]) & validateOption(user_form[2]) & validateOrganisationName(user_form[4]) & validateContactNumber(user_form[5]) & validateMessage(user_form[6]) ){
      showValid(form_validation);
	    alert("Submitted successfully");
  }else{
      showError('Cannot submit form with invalid details', form_validation);
  }
}

/****** error handling *****/
function showError(message, atLabel){
  atLabel.innerHTML = message;
  return false;
}

function showValid(atLabel){
  atLabel.innerHTML = "";
  return true;
}
