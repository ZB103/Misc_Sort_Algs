import java.util.Arrays;

public class SortAlgs{
	//Cocktail sort of Container object list
	public static void cocktailSort(Container[] list){
		int n = list.length;
		boolean anySwapsMade;
		for(int i = 1; i <= (n - 1) / 2 + 1; i++){
			//Forward sort
			anySwapsMade = false;
			for(int j = i; j <= (n - i); j++){
				if(list[j].getKey() < list[j - 1].getKey()){
					Container temp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = temp;
					anySwapsMade = true;
				}
			}
			//Early exit if no swaps are made
			if(!anySwapsMade){return;}
			
			//Backward sort
			anySwapsMade = false;
			for(int j = n - i; j > i - 1; j--){
				if(list[j].getKey() < list[j - 1].getKey()){
					Container temp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = temp;
					anySwapsMade = true;
				}
			}
			//Early exit if no swaps are made
			if(!anySwapsMade){return;}
		}
	}
	
	//Quick sort of Container object list
	public static void quickSort(Container[] list, int left, int right){
		if(left < right){
			int p = partition(list, left, right);
			quickSort(list, left, p - 1);
			quickSort(list, p + 1, right);
		}
	}
	
	//Quick sort of Container object list - overload
	public static void quickSort(Container[] list){
		if(0 < list.length - 1){
			int p = partition(list, 0, list.length - 1);
			quickSort(list, 0, p - 1);
			quickSort(list, p + 1, list.length - 1);
		}
	}
	
	
	//Helper function for quick sort that sorts a smaller segment of the list
	private static int partition(Container[] list, int left, int right){
		int P = left;
		int L = left + 1;
		int R = right;
		//Parse list
		while(true){
			while(L < right && list[L].getKey() < list[P].getKey()){
				L++;
			}
			while(R > left && list[R].getKey() > list[P].getKey()){
				R--;
			}
			//Evaluate whether to swap
			if(L >= R){
				break;
			}else{
				//Swap L and R
				Container temp = list[R];
				list[R] = list[L];
				list[L] = temp;
				L++;
				R--;
			}
		}
		//Swap R and P
		Container temp = list[P];
		list[P] = list[R];
		list[R] = temp;
		return R;
	}
	
	//Counting sort of Container object list
	public static void countingSort(Container[] list){
		int n = list.length;
		
		//Allocate count array and init to all 0s
		int max = list[0].getKey();
		for(int i = 0; i < list.length; i++){
			if(list[i].getKey() > max){
				max = list[i].getKey();
			}
		}
		int[] count = new int[max + 1];
		for(int i = 0; i < count.length; i++){
			count[i] = 0;
		}
		
		//Calculate histogram of key frequencies
		for(int i = 0; i < n; i++){
			count[list[i].getKey()] += 1;
		}
		
		//Calculate starting index for each key
		int total = 0;
		for(int i = 0; i < count.length; i++){
			int oldCount = count[i];
			count[i] = total;
			total += oldCount;
		}
		
		//Allocate output array
		Container[] output = new Container[n];
		
		//Copy to output array
		for(int i = 0; i < n; i++){
			Container value = list[i];
			output[count[value.getKey()]] = value;
			count[value.getKey()]  = count[value.getKey()] + 1;
		}
		
		//Copy back to original list
		for(int i = 0; i < n; i++){
			list[i] = output[i];
		}
	}

	//Radix sort of Container object list
	//Look at me go, I feel so accomplished >:3
	public static void radixSort(Container[] list){
		//Temporary list of Containers acting as queue
		Container[] queue = new Container[list.length];
		int queueLength = 0;
		
	//Sort the values by the 1's place
		//For numbers 0-9:
		for(int i = 0; i <= 9; i++){
			//For the length of the list:
			for(int j = 0; j < list.length; j++){
				//Get the key as the 1's digit
				int onesPlace = list[j].getKey();
				onesPlace = getOnesPlace(onesPlace);
				//If the value is the number:
				if(onesPlace == i){
					//Send to queue
					queue[queueLength] = list[j];
					queueLength++;
				}
			}
		}
		//Add back into list from queue, now sorted by 1's place
		for(int i = 0; i < list.length; i++){
			list[i] = queue[i];
			queue[i] = null;
		}
		queueLength = 0;
		
	//Sort the values by the 10's place
		//For numbers 0-9:
		for(int i = 0; i <= 9; i++){
			//For the length of the list:
			for(int j = 0; j < list.length; j++){
				//Get the key as the 1's digit
				int tensPlace = list[j].getKey();
				tensPlace = getTensPlace(tensPlace);
				//If the value is the number:
				if(tensPlace == i){
					//Send to queue
					queue[queueLength] = list[j];
					queueLength++;
				}
			}
		}
		//Add back into list from queue, now sorted by 1's place
		for(int i = 0; i < list.length; i++){
			list[i] = queue[i];
			queue[i] = null;
		}
		queueLength = 0;
		
	//Sort the values by the 100's place
		//For numbers 0-9:
		for(int i = 0; i <= 9; i++){
			//For the length of the list:
			for(int j = 0; j < list.length; j++){
				//Get the key as the 1's digit
				int hundsPlace = list[j].getKey();
				hundsPlace = getHundsPlace(hundsPlace);
				//If the value is the number:
				if(hundsPlace == i){
					//Send to queue
					queue[queueLength] = list[j];
					queueLength++;
				}
			}
		}
		//Add back into list from queue, now sorted by 1's place
		for(int i = 0; i < list.length; i++){
			list[i] = queue[i];
			queue[i] = null;
		}
		queueLength = 0;
		
	}
	
	//Helper function that returns ones place
	private static int getOnesPlace(int key){
		if(key <= 9){return key;}
		else if(key <= 99){return key % 10;}
		else{return (key - 100) % 10;}
	}
	
	//Helper function that returns tens place
	private static int getTensPlace(int key){
		if(key <= 99){return key / 10;}
		else{return (key - 100) / 10;}
	}
	
	//Helper function that returns hundreds place
	public static int getHundsPlace(int key){
		return key / 100;
	}
}