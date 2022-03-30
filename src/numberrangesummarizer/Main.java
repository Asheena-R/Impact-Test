
/**
 *
 * @author Asheena
 */

package numberrangesummarizer;

import java.util.*;

public class Main extends NumberRangeSummarizer {

    public static void main (String [] args) {
        boolean completed = false;

        do{
            try {
                System.out.println("Enter a list of Values:");
                Scanner Obj = new Scanner(System.in);
                String input = Obj.nextLine();

                NumberRangeSummarizer method = new Main();
                Collection<Integer> output = method.collect(input);
                String Result = method.summarizeCollection(output);
                System.out.println(Result);
                completed=true;
                
            }
			
            catch (Exception e) {
                System.out.println("Incorrect Input. Enter numbers separated by comma with no spaces");
            }
        } while(completed==false);
    }// end of main method

    
    // Gets input and store in an ArrayList
    @Override
    public Collection<Integer> collect(String input) {
        Collection<Integer> sorted = new ArrayList<>();

        int[] a = Arrays.stream(input.split(",")).map(Integer::parseInt).mapToInt(i->i).toArray(); // split array by comma and convert them to int
        Arrays.sort(a);
        for(int s: a){
            if (!sorted.contains(s))
                sorted.add(s);
        }

        return sorted;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        String finalstring="";  // String to be returned

        // Removes brackets and spaces from Arraylist and converts it to a String
        String new_input= input.toString();
        String str = new_input.replaceAll("\\[(.*?)\\]", "$1");
        str= str.replaceAll("\\s+","");

        // Converts String to an Array by Separating the values by a comma
        int[] a = Arrays.stream(str.split(",")).map(Integer::parseInt).mapToInt(i->i).toArray();

        int count=0;  // counter that tracks how many numbers are sequential
        int start=a[0]; // First value of a sequential pattern
        String temp=""+ a[0];  // String that stores the current sequence
        int end=a[0]; // Last value of sequential pattern

        for (int i = 0; i < a.length - 1; i++) {
            // checks if Value is sequential
            if (a[i + 1] == a[i] + 1) {
                // check if value is start of sequential pattern- then stores its value
                if (count==0){
                    start= a[i];
                }
                end= a[i+1];
                count++;
            }

            // Else Value is not sequential
            else {
                if (count>0){
                    count=0;
                    temp = start+ "-"+ end;
                }
                finalstring= finalstring + temp+ ", ";
                temp= "" +(a[i+1]);
            }
        }
        // Checks if final value is part of a sequential pattern
        if (count>0){
            temp = start+ "-"+ end;
        }

        finalstring= finalstring + temp;
        return finalstring;
    } // End of summarizeCollection

} // End of Class
