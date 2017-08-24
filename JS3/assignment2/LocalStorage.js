function isStorageAvailable(){
  if (typeof(Storage) !== "undefined") {
    return true;
  }

  alert("Storage is blocked");
  return false;
}

var form_values ="form_details";

function populateValues(){
  if(!isStorageAvailable() || !validateForm()){
    return;
  }

  var form_details = {};
  var user_details = document.getElementById("user_form");

  form_details.user_name        = user_details.elements[0].value;
  form_details.user_email       = user_details.elements[1].value;
  form_details.user_city        = user_details.elements[2].value;
  form_details.user_organisation= user_details.elements[4].value;
  form_details.user_number      = user_details.elements[5].value;
  form_details.user_message     = user_details.elements[6].value;

  localStorage.setItem(this.form_values, JSON.stringify(form_details) );

  user_details.reset();
}

function clearFormDetails(){
  if(!isStorageAvailable()){
    return;
  }

  var form_details = {};
  var user_details = document.getElementById("user_form");

  if(user_details !=null && form_details != null && user_details.elements != null){
	   user_details.elements[0].value = "";
     user_details.elements[1].value = "";
     user_details.elements[2].value = "";
     user_details.elements[4].value = "";
     user_details.elements[5].value = "";
     user_details.elements[6].value = "";
	}

  localStorage.removeItem(this.form_values);
}

function getLocalStorageValue(){
	var form_details = JSON.parse(localStorage.getItem(form_values));
  var user_details = document.getElementById("user_form");
  if(user_details !=null && form_details != null && user_details.elements != null){
    user_details.elements[0].value = form_details.user_name;
    user_details.elements[1].value = form_details.user_email;
    user_details.elements[2].value = form_details.user_city;
    user_details.elements[4].value = form_details.user_organisation;
    user_details.elements[5].value = form_details.user_number;
    user_details.elements[6].value = form_details.user_message;
  }
}
window.oncomplete = getLocalStorageValue();
