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
        
        int [] linearSearches = new int[20];
        int [] binarySearches = new int[20];
        int numSearches = 0;
        
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
        String[] sortedNames = new String[names.length];  // will contain a sorted copy of names Array ( not global )
        String input;
        
        LinearSearch search = new LinearSearch();
        search.copyArray(names, sortedNames);
        
        do {
            
                System.out.print("Please enter a name to search for: ");
            
                input = UserInput.getString();
                int linearComparisons = search.linearSearch(names, input);
                int binaryComparisons = search.binarySearch(sortedNames, input);
                        
                linearSearches[numSearches] = linearComparisons;
                binarySearches[numSearches] = binaryComparisons;
                numSearches++;
                
                int linearAverage = search.calculateAverage(linearSearches);
                int binaryAverage = search.calculateAverage(binarySearches);
                
                System.out.print("\nLinear search: " + linearComparisons + " comparisons, average " + linearAverage + " comparisons per linear search \n");
                System.out.print("Binary search: " + binaryComparisons + " comparisons, average " + binaryAverage + " comparisons per binary search \n");
                System.out.print("Binary search currently 'saves' " + (linearAverage - binaryAverage) + " comparisons on average per search.\n\n");
                
        } while ((!input.equalsIgnoreCase("exit") || !input.equalsIgnoreCase("quit")) && numSearches < linearSearches.length - 1);
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
    
    public int binarySearch ( String [ ] sortedArray, String name ) {
        
        int indexesSearched = 0;
        int lowerBound = 0;
        int upperBound = sortedArray.length - 1;
        int currentIndex;
        
        while(true) {
            currentIndex = (lowerBound + upperBound) / 2;
            indexesSearched++;
            
            if (name.compareTo(sortedArray[currentIndex]) ==  0) {
                return indexesSearched;
            }
            else if (lowerBound > upperBound) {
                return indexesSearched;
            }
            else {
                if (name.compareTo(sortedArray[currentIndex]) > 0) {
                    lowerBound = currentIndex + 1;
                }
                else {
                    upperBound = currentIndex - 1;
                }
            }
                
            indexesSearched++;
        }
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