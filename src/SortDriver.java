import java.util.Random;

// Lydia K Fritz
// CST105
// Date: Jan 9, 2019
// This is my own work.

public class SortDriver {

	public static void main(String[] args) {
		
		final int CAP = 10;
		int [] myArr = new int[CAP];
		
		Random rnd = new Random();
		
		for(int i = 0; i < CAP; i++){
			myArr[i] = rnd.nextInt(50);
		}
		
		System.out.println("Unsorted array...");
		for (int i : myArr) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		//sort it
		selectionSort(myArr);
		
		System.out.println("\nSorted array...");
		for (int i : myArr) {
			System.out.print(i + "\t");
		}
		System.out.println();

	}
	
	public static void bubbleSort(int [] arr){
		int firstSorted = arr.length;
		
		//do this while firstSorted is position 1 or greater
		while(firstSorted >= 1){
			//compare adjacent elements
			for(int i = 0; i < firstSorted - 1; i++){
				//if elements are out of order
				if(arr[i] > arr[i+1]){
					//swap them
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			//firstSorted element is one position closer to the front
			firstSorted--;
		}
	}
	
	public static void selectionSort(int [] arr){
		//index of the largest element this pass
		int maxIndex = 0;
		//number of elements left in unsorted part of list
		int ct = arr.length;
		while(ct > 0){
			for(int i = 0; i < ct; i++){
				if(arr[i] > arr[maxIndex])
					maxIndex = i;
			}
			//maxIndex identifies largest unsorted element
			//swap this element with last unsorted element
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[ct-1];
			arr[ct-1] = temp;
			
			//reduce ct
			ct--;
		}
		
	}
	
	public static void insertSort(int [] arr){
		int firstUnsorted = 1;
		while(firstUnsorted < arr.length){
			int curr = arr[firstUnsorted];
			for (int i = firstUnsorted - 1; i >= 0; i--) {
				if(arr[i] > curr){
					//slide this element back one position
					arr[i+1] = arr[i];
					arr[i] = curr;
				}
				else{
					//found the final location for curr
					arr[i + 1] = curr;
					break;
				}
			}
			//first unsorted moves back one position
			firstUnsorted++;
		}
	}

}
