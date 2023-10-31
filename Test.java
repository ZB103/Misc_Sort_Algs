class Test{
	public static void main(String[] args){
		Container c = new Container(14);
		Container d = new Container(141);
		Container e = new Container(76);
		Container f = new Container(58);
		Container g = new Container(99);
		Container h = new Container(106);
		Container[] arr = {c,d,e,f,g,h};
		SortAlgs.radixSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i].getKey() + " ");
		}
	}
}