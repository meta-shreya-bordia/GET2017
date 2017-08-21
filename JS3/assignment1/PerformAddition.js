function performAddition(firstNumber,secondNumber){
    if(secondNumber == null){
      return function(secondNumber){
                          if(checkValues(firstNumber, secondNumber)){
                              return parseInt(firstNumber)+parseInt(secondNumber);
                          }
                          else{
                              return ;
                          }
                      }
    }else{
      if(checkValues(firstNumber, secondNumber)){
        return parseInt(firstNumber)+parseInt(secondNumber);
      }
    }
}

  function checkValues(firstNumber, secondNumber){
    if( isNaN(firstNumber) & isNaN(secondNumber)){
      console.log("Enter valid number");
      return false;
    }

    return true;
  }
