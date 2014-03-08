/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.pkg2;

import userinput.UserInput;
import java.util.Arrays;

public class LinearSearch {

    public static void main(String[] args) {
        
        int [] searches = new int[20];
        String[] names = { "fred" , "barney", "tom", "jerry", "larry", "moe", "curly", 
        "betty" , "wilma", "bart", "homer", "marge", "maggie", "lisa", 
        "pebbles" , "bambam", "smithers", "burns", "milhouse", "george", "astro", 
        "dino" , "mickey", "minnie", "pluto", "goofy", "donald", "huey", 
        "louie" , "dewey", "snowwhite", "happy", "doc", "grumpy", "sneezy", 
        "dopey" , "sleepy", "bambi", "belle", "gaston", "tarzan", "jane", 
        "simba" , "scar", "mufasa", "ariel", "flounder", "bugs", "daffy", 
        "elmer" , "foghorn", "chickenhawk", "roger", "jessica", "hank", "bobby", 
        "peggy" , "spot", "pongo", "perdy", "buzz", "potatohead", "woody", 
        "chuckie" , "tommy", "phil", "lil", "angelica", "dill", "spike", 
        "pepe" , "speedy", "yosemite", "sam", "tweety", "sylvester", "granny", 
        "spiderman" , "batman", "superman", "supergirl", "robin", "catwoman","penguin", 
        "thing" , "flash", "silversurfer", "xmen", "pokemon", "joker", "wonderwoman" 
        }; 
        String[] sortednames = new String[names.length];  // will contain a sorted copy of names Array ( not global )
        String input;
        LinearSearch search = new LinearSearch();
        int nextIndex = 0;
        
        do {
                System.out.print("Please enter a name to search for: ");
            
                input = UserInput.getString();
                int comparisons = search.linearSearch(names, input);
                searches[nextIndex] = comparisons;
                nextIndex++;
                int average = search.calculateAverage(searches);
                
                System.out.print("Linear search: " + comparisons + " comparisons, average " + average + " comparisons per linear search \n");
             
        } while ((!input.equalsIgnoreCase("exit") || !input.equalsIgnoreCase("quit")) && nextIndex < searches.length - 1);
    }
    
    public int linearSearch(String [] namesArray, String name) {
        
        int numComparisons = 0;
        
        for (int i = 0; i < namesArray.length; i++) {
            numComparisons++;
            if (name.equalsIgnoreCase(namesArray[i])) {
                return numComparisons;
            }
        }
        return numComparisons;
    }
    
    public void copyArray ( String [ ] source, String [ ] target ) {
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
        
        Arrays.sort(target);
    }
    
    public int binarySearch ( String [ ] sortedArray ) {
        
        for (int i = 0; i < sortedArray.length; i++) {
            
        }
        
        return 0;
    }
    
    private int calculateAverage(int [] nums) {
        int average;
        int total = 0;
        int numInts = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                numInts++;
                total += nums[i];
            }
            else {
                break;
            }
        }
        
        average = total / numInts;
                
        return average;
    }
}