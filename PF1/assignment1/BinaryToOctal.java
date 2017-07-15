package assignment1;

//convert binary number to octal format
public class BinaryToOctal {
	int convertBinaryToOctal(int n){
		int no= n;
		while(no > 10) {
			if(no%10 != 0 | no%10 != 1){
				throw new Exception();
			}
		}
		return convertToOctal(convertToDecimal(n));
	}
	
	/* Convert binary number to decimal by repeated divide */
	int convertToDecimal(int binary_no){
		int decimal_no = 0;
		
		int power=0;
		while(binary_no>0){
			decimal_no += (binary_no%10)*((int)Math.pow(2, power++));
			binary_no = binary_no/10;
		}
		return decimal_no;
	
	}
	
	/* decimal to octal with base 8 (numbers between 0-7) by reversing remainder of division*/
	int convertToOctal(int decimal_no){
		int octal_no = 0;
		
		int power=0;
		while(decimal_no>0){
			octal_no += (decimal_no%8)*((int)Math.pow(10, power++));
			decimal_no = decimal_no/8;
		}
		return octal_no;
	}
}
