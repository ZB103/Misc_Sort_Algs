/*
Name: Zoe B
Date: 10/31/2023
Description: A test file for a variety of sorting algorithms. 'I FOUND THE BONUS'
*/

import java.lang.Math;

class Main{
	public static void main(String[] args){
		//Generate an array of 20 random Container objects
		//with a key from 0-150 (inc) and duplicate twice
		int range = 149; //max of 150 - min of 0 + 1 = 149
		final int TEST_LENGTH = 20;
		final int TIMING_LENGTH = 20000;
		
		Container[] arr1 = new Container[TEST_LENGTH];
		Container[] arr2 = new Container[TEST_LENGTH];
		Container[] arr3 = new Container[TEST_LENGTH];
		Container[] arr4 = new Container[TEST_LENGTH];
		for(int i = 0; i < arr1.length; i++){
			int rand = (int)(Math.random() * range);
			Container c = new Container(rand);
			arr1[i] = c;
			Container d = new Container(rand);
			arr2[i] = d;
			Container e = new Container(rand);
			arr3[i] = e;
			Container f = new Container(rand);
			arr4[i] = f;
		}
		
		//Print original array
		System.out.println("TESTING with n = 20");
		System.out.print("Original List: ");
		for(int i = 0; i < arr1.length; i++){
			System.out.print(arr1[i].getKey() + " ");
		}
		
	//Sort the arrays
		//Cocktail sort
		SortAlgs.cocktailSort(arr1);
		//Quick sort
		SortAlgs.quickSort(arr2, 0, arr2.length - 1);
		//Counting sort
		SortAlgs.countingSort(arr3);
		//Radix sort
		SortAlgs.radixSort(arr4);
		
		//Print sorted arrays
		System.out.print("\n\tCocktail sorted: ");
		for(int i = 0; i < arr1.length; i++){
			System.out.print(arr1[i].getKey() + " ");
		}
		System.out.print("\n\tQuick sorted: ");
		for(int i = 0; i < arr2.length; i++){
			System.out.print(arr2[i].getKey() + " ");
		}
		System.out.print("\n\tCounting sorted: ");
		for(int i = 0; i < arr3.length; i++){
			System.out.print(arr3[i].getKey() + " ");
		}
		System.out.print("\n\tRadix sorted: ");
		for(int i = 0; i < arr4.length; i++){
			System.out.print(arr4[i].getKey() + " ");
		}
		
	//Calculating timings
		//Initialization
		double cocktailTime;
		double quickTime;
		double countingTime;
		double radixTime;
		double startTime, endTime;
		
		//Generate an array of 20000 random Container objects
		//with a key from 0-150 (inc) and duplicate twice
		Container[] arr5 = new Container[TIMING_LENGTH];
		Container[] arr6 = new Container[TIMING_LENGTH];
		Container[] arr7 = new Container[TIMING_LENGTH];
		Container[] arr8 = new Container[TIMING_LENGTH];
		for(int i = 0; i < arr5.length; i++){
			int rand = (int)(Math.random() * range);
			Container c = new Container(rand);
			arr5[i] = c;
			Container d = new Container(rand);
			arr6[i] = d;
			Container e = new Container(rand);
			arr7[i] = e;
			Container f = new Container(rand);
			arr8[i] = f;
		}
		
	//Begin the timer
		startTime = System.currentTimeMillis();
		//Sort
		SortAlgs.cocktailSort(arr5);
		//End the timer
		endTime = System.currentTimeMillis();
		cocktailTime = endTime - startTime;
		
	//Begin the timer
		startTime = System.currentTimeMillis();
		//Sort
		SortAlgs.quickSort(arr6, 0, arr6.length - 1);
		//End the timer
		endTime = System.currentTimeMillis();
		quickTime = endTime - startTime;
		
		
	//Begin the timer
		startTime = System.currentTimeMillis();
		//Sort
		SortAlgs.countingSort(arr7);
		//End the timer
		endTime = System.currentTimeMillis();
		countingTime = endTime - startTime;
		
	//Begin the timer
		startTime = System.currentTimeMillis();
		//Sort
		SortAlgs.radixSort(arr8);
		//End the timer
		endTime = System.currentTimeMillis();
		radixTime = endTime - startTime;
		
		//Print timings
		System.out.println("\n\nTIMING with n = 20000");
		System.out.println("\tCocktail took " + cocktailTime + " ms");
		System.out.println("\tQuick took " + quickTime + " ms");
		System.out.println("\tCounting took " + countingTime + " ms");
		System.out.println("\tRadix took " + radixTime + " ms");
	}
}