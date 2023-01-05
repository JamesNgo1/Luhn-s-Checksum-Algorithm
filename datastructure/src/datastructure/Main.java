package datastructure;

import java.util.Scanner;

public class Main 
{

	/**
	 * Main method to test Luhn's checksum algorithm.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//declare of a scanner class.
		Scanner scnr = new Scanner(System.in);
		
		//Ask user to enter number of runs 
		int numberOfTrials = scnr.nextInt();
		
		//scanner to reset due to previous use of scanner object.
		scnr.nextLine();
		
		
		//if statement to meet correct range for number of trial.
		if(numberOfTrials >= 1 && numberOfTrials <= 100)
		{
			for(int d = 0; d < numberOfTrials; d++)
			{
			
				int luhnCheckSum = 0;
				
				/*
				 * The section where we collect user input as a string
				 * ,split into a string array and then parse into an int array
				*/
				String userInput = scnr.nextLine();
				String[] stringArray = userInput.split("");
				int [] numArray = new int[stringArray.length];
				for(int i = 0; i < numArray.length ;i++) 
				{
					numArray[i] = Integer.parseInt(stringArray[i]); 
				}
				
		
				int counter = 0; //the counter helps signal when to transform the digit
		
				for(int j = numArray.length - 1; j >= 0 ; j--)//algorithm to start at the end and go left and collect 2nd digit and transform it met condition.
				{
					//if block to check conditions of the counter if need to make a transformation
					int checking = numArray[j] * 2;
					if(!(counter % 2 == 0)) 
					{
						//further condition block if the product of an array times two is greater than 9
						if(checking > 9) 
						{
							int newNumber = 0;
							String str = Integer.toString(checking);
							String[] stringArray2 = str.split("");
							
							int [] numArray2 = new int[str.length()];
							for(int q = 0; q < numArray2.length;q++)
							{
								numArray2[q] = Integer.parseInt(stringArray2[q]);
							}
							
							for(int c = 0; c < numArray2.length;c++) {
								newNumber += numArray2[c];
							}
							luhnCheckSum += newNumber;
							
						}
						
						//else block 
						else {
							luhnCheckSum += checking;
						}
					}
					
			
					else {
						luhnCheckSum += numArray[j];
						
					}
					counter++;//iterate after each array element
					
				}//end of for loop
				
				//if else block to print conditional statement
				if(luhnCheckSum % 10 == 0)
				{
					System.out.println("PASS");
				}
				else {
					System.out.println("FAIL");
				}
				
			
			}//end of the for loop
			
		}//end of the if statement
		scnr.close();
	}

}
