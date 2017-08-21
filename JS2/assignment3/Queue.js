//make this class as singleton class
var queue = new LinkedQueue();

(function(){
  document.getElementById("Enqueue").addEventListener("click", function(){performOperation(this);}, false);
  document.getElementById("Dequeue").addEventListener("click", function(){performOperation(this);}, false);
})();

function performOperation(button_id){
  var element = document.getElementById("element_value").value;

  //call appropriate method
  switch(button_id.id){
    case "Enqueue":
      queue.enqueue(element);
      break;
    case "Dequeue":
      queue.dequeue();
      break;
  }

  var queue_elements = document.body.appendChild(document.createElement("p"));
  queue_elements.id = "nodes_in_queue";

  //clear older list elements
  queue_elements.innerHTML = "";

  queue_elements.innerHTML = "Head: "+ linked_list.head.data + " Rear: "+ linked_list.rear.data + "<br>";

  var current_node = linked_list.head;
  while(current_node){
    queue_elements.innerHTML += current_node.data + " -> ";
    current_node = current_node.next;
  }
}

function Node(data){
  this.data = data;
  this.next = null;
}

function LinkedQueue(){
  this.head = null;
  this.rear = null;
}

LinkedQueue.prototype.isEmpty = function(){
    if(!this.head){
      return true;
    }

    return false;
}

var element_value;

/**@method  enqueue(data)
push element as a node onto stack
update stack pointer
and update the previous node pointer of new top
*/
LinkedQueue.prototype.enqueue = function(element_value){
  try{
    if(!element_value){
      throw new Error("Invalid element value");
    }
  }catch(user_error){
    alert(user_error);
    return;
  }

  var node = new Node(element_value);
  //inserting element to start of queue
  if(queue.isEmpty()){
    node.next = this.head;
    this.head = node;
    this.rear = node;
  }else{
	  this.rear.next = node;
  }


}

/**@method  dequeue()
remove from the head of the queue from the linked list
*/
LinkedQueue.prototype.dequeue = function(){
  // if queue is empty, no element can be retrieved
  if(this.isEmpty()){
    alert("Empty Queue");
    exit();
  }

  //dereference the head element to remove from queue
  var node = this.head;
  this.head = this.head.next;

  //Show dequeued element
  /** To access all html tag textContent, use .innerHTML property. .value properties for containers like textbox and radio buttons*/
  var dequeue_element = document.body.appendChild(document.createElement("h2"));
  dequeue_element.id = "node_dequeued";
  dequeue_element.appendChild( document.createTextNode( node.data ) );

  return node;
}
