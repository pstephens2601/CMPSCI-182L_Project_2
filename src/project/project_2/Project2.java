/* Patrick Stephens
 * 3/11/14
 * Project 2:  / CMPSCI 182L - Ferguson
 * Description:  Class which compares the number of array slots looked at in linear 
 * and binary searches.
 */

package project.project_2;

import userinput.UserInput;

public class Project2 {

    public static void main(String[] args) {
        
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
        
        int [] linearSearches = new int[20];
        int [] binarySearches = new int[20];
        int numSearches = 0;
        String[] sortedNames = new String[names.length];  // will contain a sorted copy of names Array
        String input; //used to store user input
        
        Project2 search = new Project2();
        
        //copy and sort name array and then store the number of comparisons needed in sortComparisons
        int sortComparisons = search.copyArray(names, sortedNames);
        
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
                int numberOfRequiredSearches = (sortComparisons + binaryAverage) / linearAverage;
                
                System.out.print("\nLinear search: " + linearComparisons + " comparisons, average " + linearAverage + " comparisons per linear search \n");
                System.out.print("Binary search: " + binaryComparisons + " comparisons, average " + binaryAverage + " comparisons per binary search \n");
                System.out.print("Binary search currently 'saves' " + (linearAverage - binaryAverage) + " comparisons on average per search.\n");
                System.out.print("It will take " + numberOfRequiredSearches + " searches before binary sort overhead of " + sortComparisons + " comparisons is crossed.\n\n");
                
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
    
    public int copyArray ( String [ ] source, String [ ] target ) {
        
        int comparisons;
        
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
        
        comparisons = insertionSort(target);
        
        return comparisons;
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
        }
    }
    
    public int insertionSort(String [] unsortedArray) {
        
        int comparisons = 0;
        
        int insertionIndex, targetIndex;
        
        for (targetIndex = 1; targetIndex < unsortedArray.length; targetIndex++) {
            
            String temp = unsortedArray[targetIndex];
            insertionIndex = targetIndex;
            
            while(insertionIndex > 0 && temp.compareTo(unsortedArray[insertionIndex - 1]) <= 0) {
                unsortedArray[insertionIndex] = unsortedArray[insertionIndex - 1];
                comparisons++;
                --insertionIndex;
            }
            unsortedArray[insertionIndex] = temp;
        }
        
        return comparisons;
    }
            
    public int calculateAverage(int [] nums) {
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