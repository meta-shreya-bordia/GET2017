//create a global double linked list object
var linked_list = new DoublyLinked();

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

  //type error of converting circular list to string
  var print_list = document.getElementById("doubly_list");

  //clear old list details
  print_list.innerHTML = "";

  var current_node = linked_list.head;
  while(current_node){
    print_list.innerHTML += current_node.data + " -> ";
    current_node = current_node.next;
  }
}

/**
Each node in the list contains data element
and pointer to the next node and the node before it
*used for easy insertion and deletion*
*/
function Node(data){
  this.data     = data;
  this.previous = null;
  this.next     = null;
}

/**@method  DoublyLinked
constructor for creating doubly linked list object
(maintains a tab of the parent and successor node)
lengthOfList: number of nodes in object
head: points to start of list
*/
function DoublyLinked(){
  this.lengthOfList = 0;
  this.head         = null;
}

/**@method  checkValidPosition
check if position for insertion is a valid position
throw error onto alert box
*/
DoublyLinked.prototype.checkValidPosition = function(position){
  try{
    alert(this.lengthOfList);
    if(position < 0 || position > this.lengthOfList){
      throw new Error('Invalid position value');
    }
  }catch(e){
    alert(e);
    return false;
  }

  return true;
}

/**@method  addToPositionInList
create a node and insert user input value(element_value)
into appropriate position in the list
return  updated linked list
*/
DoublyLinked.prototype.addToPositionInList = function(element_value, position){
  //throw exception if position entered is either negative or larger than current list size
  //check valid element value
  alert(this.checkValidPosition(position));
  if(!element_value & !this.checkValidPosition(position)){
    return;
  }

  var node = new Node(element_value);
  if( position == 0 ){  //empty list insertion: insertion at start of list
    if(this.head != null){
      node.next = this.head;
    }
    this.head = node;
  }else{                //insert at position
    var current_node = this.head;
    var iterate = 1;

    //iterate to the specified position
    while(iterate < position){
      current_node = current_node.next;
      iterate++;
    }
    node.previous = current_node;
    node.next=current_node.next;

    if(current_node.next!= null){  //adding at end of list
      current_node.next.previous = node;
    }
      current_node.next =node;
  }

  this.lengthOfList++;
}

/**@method  removeElementFromPosition
remove node from list is appropriate position and element value match to a node in the list
(update previous node pointer to the next node pointer)
return  list with node pointers updated
node dereferenced is garbage collected (no memory leaks)
*/
DoublyLinked.prototype.removeElementFromPosition = function(position){
  var current_node = this.head;
  var list_position = 0;

  //throw exception if position entered is either negative or larger than current list size
  if(!this.head || !this.checkValidPosition(position)){
    return;
  }

  //else, iterate to position of element in the list
  while(current_node && list_position < position){
    current_node = current_node.next;
    list_position++;
  }

  //remove first element from the list
  if(current_node!=null & current_node.previous==null & position==0){
    this.head = current_node.next;
    if(current_node.next != null){
      (current_node.next).previous = null;
    }
    this.lengthOfList--;
    return;
  }

  //else, remove element
  current_node.previous.next = current_node.next;
  this.lengthOfList--;
}

/**@method  removeElement
iterate the list recursively until a matched element value's first occurrence is found
return  first node reference position in the list
element deleted by removeElementFromPosition method
*/
DoublyLinked.prototype.removeElement = function(element_value){
  var place = this.searchAnElement(element_value);
  this.removeElementFromPosition(place);
}

/**@method  searchAnElement
linearly iterate the list_place
and compare each node data with the user input value
if these match, an element exists in the list_placeotherwise, throw an Error
return  first reference of data matched
*/
DoublyLinked.prototype.searchAnElement = function(element_value){
  var current_node = this.head;
  var list_place = 0;

  if(!element_value){
    return;
  }

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
    return null;
  }

  //return position of element data match
  alert("Element found at: "+list_place);
  return list_place;
}
