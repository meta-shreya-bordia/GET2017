/*
timestamp_holder holds the reference to the HTML element on which date is to be inserted
web_worker is an instance of worker class
*/
var timestamp_holder = document.getElementById("timestamp");
var web_worker;

/*@method timer
setTimeout function executes your function after said time interval has lapsed.
*/
Worker.prototype.timer = function(){
  setTimeout(
    function(){
      	var date = new Date();
      	timestamp_holder.innerHTML = date;
	       },
         2*1000 );
}

/*@method startTimeStamp
event listner that instantiates an object of worker class,
such that execution is carried out in the background.
*/
function startTimeStamp() {
  if(typeof(Worker) !== "undefined") {
    if(typeof(web_worker) == "undefined") {
      web_worker = new Worker('WebWorker.js');
      web_worker.timer();
    }
  } else {
    //when web worker feature is not supported
    timestamp_holder.innerHTML = "Sorry, your browser does not support Web Workers";
  }
}
