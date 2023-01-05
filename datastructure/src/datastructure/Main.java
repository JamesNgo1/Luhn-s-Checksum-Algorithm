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

		//int variables for trial run value conditions.
        int minTrials = 1;
        int maxTrials = 100;

        //Ask user to enter number of runs and change value to an int.
        String numberOfTrials = scnr.nextLine();
        int numberOfTrialsInInteger = Integer.parseInt(numberOfTrials);

        //if statement to meet correct range for number of trial.
        if(numberOfTrialsInInteger >= minTrials && numberOfTrialsInInteger <= maxTrials)
        {
            for(int d = 0; d < numberOfTrialsInInteger; d++)
            {
               
				//block of code to get user input in string , put into a string array , parse into a num array to be passed through the luhn's checksum algorithm.
                String userInput = scnr.nextLine();
                String[] stringArray = userInput.split("");
                int [] numArray = new int[stringArray.length];
                for(int i = 0; i < numArray.length ;i++)
                {
                    numArray[i] = Integer.parseInt(stringArray[i]);
                }

                luhnCheckSumFunction(numArray);

            }//end of the for loop
        }//end of the if statement
        scnr.close();
	}

/**
 * LuhnCheckSum function to calculate if an integer is passing or failing the algorithm.
 * Takes in an int array and prints out string message .
 * @param anArray
 */
public static void luhnCheckSumFunction(int[] anArray)
    {
        int luhnCheckSum = 0;
        int counter = 0; //the counter helps signal when to transform the digit

		//String messages for outcome of luhnCheckSUm.
		String passingMessage = "PASS";
		String failingMessage = "FAIL";

        for(int j = anArray.length - 1; j >= 0 ; j--)//algorithm to start at the end and go left and collect 2nd digit and transform it met condition.
        {
            //if block to check conditions of the counter if need to make a transformation
            int checking = anArray[j] * 2;
            if(!(counter % 2 == 0))
            {
                //further condition block if the product of an array times two is greater than 9
                if(checking > 9)
                {
					//same procedure of converting int to a string value , splitting into an string array , then parsing into an int array.
                    int newNumber = 0;
                    String str = Integer.toString(checking);
                    String[] stringArray2 = str.split("");
                    int [] numArray2 = new int[str.length()];
                    for(int q = 0; q < numArray2.length;q++)
                    {
                        numArray2[q] = Integer.parseInt(stringArray2[q]);
                    }

					//For loop through the int array and adding the values up.
                    for (int i : numArray2) {
                        newNumber += i;
                    }
					//first check sum condition.
                    luhnCheckSum += newNumber;

                }

                //else block
                else {
					//second check sum condition.
                    luhnCheckSum += checking;
                }
            }//end of if statement.

            else {
				//third check sum condition.
                luhnCheckSum += anArray[j];

            }
            counter++;//iterate after each array element

        }//end of for loop

        //if else block to print conditional statement
        if(luhnCheckSum % 10 == 0)
        {
            System.out.println(passingMessage);
        }
        else {
            System.out.println(failingMessage);
        }
       

    }//end of method function

}
