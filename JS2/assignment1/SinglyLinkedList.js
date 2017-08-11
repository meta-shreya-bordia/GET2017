//create a global single linked list object
var linked_list = new SinglyLinked();

/**@method  self-invoking anonymous function
executed before css files are loaded
binds action listner to each HTML button_id
event: button click
action: calls performAction method
*/
(function(){
  document.getElementById("AddAtBeginning").addEventListener("click", function(){performOperation(this);}, false);
  document.getElementById("AddAtEndOfList").addEventListener("click", function(){performOperation(this);}, false);
  document.getElementById("AddAtSpecifiedPosition").addEventListener("click", function(){performOperation(this);}, false);

  document.getElementById("RemoveByElementValue").addEventListener("click", function(){performOperation(this);}, false);
  document.getElementById("RemoveByElementPosition").addEventListener("click", function(){performOperation(this);}, false);

  document.getElementById("SearchByElementValue").addEventListener("click", function(){performOperation(this);}, false);
})();

/**@method  performOperation
calls appropriate event handler,
based on the event object passed
return  prints updated linked list object
*/
function performOperation(button_id){
  var element = document.getElementById("element_value").value;
  var place = document.getElementById("element_position").value;

  //call appropriate method
  switch(button_id.id){
    case "AddAtBeginning":
      linked_list.addToPositionInList(element, 0);
      break;

    case "AddAtEndOfList":
      linked_list.addToPositionInList(element, linked_list.lengthOfList);
      break;

    case "AddAtSpecifiedPosition":
      linked_list.addToPositionInList(element, place);
      break;

    case "RemoveByElementValue":
      linked_list.removeElement(element);
      break;

    case "RemoveByElementPosition":
      linked_list.removeElementFromPosition(place);
      break;

    case "SearchByElementValue":
      linked_list.searchAnElement(element);
      break;
  }

  document.body.appendChild(document.createElement("p").appendChild(document.createTextNode( JSON.stringify(linked_list) )));
}

/**@method  Node
Each node in the list contains data element
and pointer to the next node
return  node object
*/
function Node(data){
  this.data = data;
  this.next = null;
}

/**@method  SinglyLinked
constructor for creating singly linked list object
lengthOfList: number of nodes in object
head: points to start of list
*/
function SinglyLinked(){
  this.lengthOfList = 0;
  this.head = null;
}

var element_value, position;

/**@method  checkValidPosition
check if position for insertion is a valid position
throw error onto alert box
*/
SinglyLinked.prototype.checkValidPosition = function(position){
  try{
    if(position === -1 || position < 0 || position > this.lengthOfList){
      throw new Error('Index Out Of Bounds Exception');
    }
  }catch(user_error){
    alert(user_error);
    return false;
  }

  return true;
}

/**@method  addToPositionInList
create a node and insert user input value(element_value)
into appropriate position in the list
return  updated linked list
*/
SinglyLinked.prototype.addToPositionInList = function(element_value, position){
  var previous = null;
  var current_node = this.head;
  var iterate = 0;

  //throw exception if position entered is either negative or larger than current list size
  if(!this.checkValidPosition(position)){
    return;
  }

  //add element to the list
  var node = new Node(element_value);

  //iterate to the specified position
  while(current_node && iterate <= position){
    previous = current_node;
    current_node = current_node.next;
    iterate++;
  }

  // if list is empty or insertion at first position
  if(!previous){
    node.next = this.head;
    this.head = node;
  }else{  //insertion at specific position
    node.next = current_node;
    previous.next = node;
  }

  this.lengthOfList++;
}

/**@method  removeElementFromPosition
remove node from list is appropriate position and element value match to a node in the list
(update previous node pointer to the next node pointer)
return  list with node pointers updated
node dereferenced is garbage collected (no memory leaks)
*/
SinglyLinked.prototype.removeElementFromPosition = function(position){
  var previous = null;
  var current_node = this.head;
  var list_position = 0;

  //throw exception if position entered is either negative or larger than current list size
  if(!this.checkValidPosition(position)){
    return;
  }

  //iterate to position of element in the list
  while(current_node.next && list_position <= position){
    previous = current_node;
    current_node = current_node.next;
    list_position++;
  }

  //else, remove element
  previous.next = current_node.next;
  this.lengthOfList--;
}

/**@method  removeElement
iterate the list recursively until a matched element value's first occurrence is found
return  first node reference position in the list
element deleted by removeElementFromPosition method
*/
SinglyLinked.prototype.removeElement = function(element_value){
  var place = this.searchAnElement(element_value);
  alert(place);
  this.removeElementFromPosition(place);
}

/**@method  searchAnElement
linearly iterate the list_place
and compare each node data with the user input value
if these match, an element exists in the list_placeotherwise, throw an Error
return  first reference of data matched
*/
SinglyLinked.prototype.searchAnElement = function(element_value){
  var current_node = this.head;
  var list_place = 0;

  while(current_node && current_node.data != element_value){
    current_node = current_node.next;
    list_place++;
  }

  //if looping stops due to end of list traversal with element not being found
  try{
    if(!current_node){
      throw new Error('Element does not belong to the list');
    }
  }catch(e){
    alert(e);
  }

  //return position of element data match
  alert("Element found at: "+list_place);
  return list_place;
}
