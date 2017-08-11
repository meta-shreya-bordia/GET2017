//make this class as singleton class
var stack = new LinkedStack();

(function(){
  document.getElementById("PushToStack").addEventListener("click", function(){performOperation(this);}, false);
  document.getElementById("PopFromStack").addEventListener("click", function(){performOperation(this);}, false);
})();

function performOperation(button_id){
  var element = document.getElementById("element_value").value;

  //call appropriate method
  switch(button_id.id){
    case "PushToStack":
      stack.push(element);
      break;
    case "PopFromStack":
      stack.pop();
      break;
  }

  var stack_elements = document.body.appendChild(document.createElement("p"));
  stack_elements.id = "nodes_in_stack";
  stack_elements.appendChild(document.createTextNode( JSON.stringify(stack) ) );
}

function Node(data){
  this.data = data;
  this.previous = null;
}

function LinkedStack(){
  this.topOfStack = null;
}

LinkedStack.prototype.isEmpty = function(){
  try{
    if(!this.topOfStack){
      throw new Error("Stack Underflow");
    }
  }catch(e){
    alert(e);
    return true;
  }

  return false;
}

var element_value;

/**@method  push(data)
push element as a node onto stack
update stack pointer
and update the previous node pointer of new top
*/
LinkedStack.prototype.push = function(element_value){
  try{
    if(!element_value){
      throw new Error("Invalid element value");
    }
  }catch(user_error){
    alert(user_error);
    return;
  }

  //inserting element to the top of stack
  var node = new Node(element_value);
  node.previous = this.topOfStack;
  this.topOfStack = node;
}

/**@method  pop()
remove the top of the stack from the linked list
*/
LinkedStack.prototype.pop = function(){
  // if stack is empty, no element can be retrieved
  if(this.isEmpty()){
    return;
  }

  //dereference the top element to remove from stack
  var node = this.topOfStack;
  this.topOfStack = this.topOfStack.previous;

  //Show popped element
  /** To access all html tag textContent, use .innerHTML property. .value properties for containers like textbox and radio buttons*/
  var popped_element = document.body.appendChild(document.createElement("h2"));
  popped_element.id = "node_popped";
  popped_element.appendChild( document.createTextNode( node.data ) );

  return node;
}
