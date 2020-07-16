package Heap;

public class MinHeap {

	static private int[] heap;
	static private int size;
	static private int maxSize;
	private static final int FRONT = 1;
	
	public static void main(String args[])
	{
		heap = new int[10];
		insert(10);
		insert(1);
		insert(5);
		insert(2);
		insert(7);
		insert(21);
		insert(31);
		insert(3);
		insert(13);
		Print();
		delete();
		Print();
		
		
	}
	


	public MinHeap(int maxSize){
	    this.heap = new int[maxSize+1];
	    heap[0] = Integer.MIN_VALUE;
	    this.size = 0;
	}

	private static int getParent(int position){
	    return position/2;
	}

	private static int getLeftChild(int position){
	    return 2*position;
	}

	private static int getRightChild(int position){
	    return 2*position+1;
	}

	private static void swap(int position1, int position2){
	    int temp = heap[position1];
	    heap[position1] = heap[position2];
	    heap[position2] = temp;
	}

	private static boolean isLeaf(int position){

	    if(position > size/2){
	        return true;
	    }
	    return false;
	}

	public static void insert(int data){
	    heap[++size] = data;
	    int currentItem = size;
	    while( heap[getParent(currentItem)] > heap[currentItem] ){
	        swap(getParent(currentItem),currentItem);
	        currentItem = getParent(currentItem);
	    }
	}

	public static int delete(){
	    int itemPopped = heap[FRONT];
	    heap[FRONT] = heap[size--];
	    heapify(FRONT);
	    return itemPopped;
	}

	public static void heapify1(int pos) {
		
		while(!isLeaf(pos)) {
			
			int left = getLeftChild(pos);
			int right = getRightChild(pos);
			
			if(heap[pos] > heap[left] || heap[pos] > heap[right]) {
				
				if(heap[left] < heap[right]) 
				{
					swap(pos,left);
					pos = left;
				} else
				{
					swap(pos,right);
					pos = right;
				}
			} else
			{
				break;
			}
		}
		
		
	}

	private static void heapify(int position){
	    while (!isLeaf(position)){
	        int left  = getLeftChild(position);
	        int right = getRightChild(position);
	        if (heap[position] > heap[left] || heap[position] > heap[right]){
	            if (heap[left] < heap[right]){  
	                swap(position, left);
	                position = left;
	            } else {
	                swap(position, right);
	                position = right;
	            }
	        } else
	            break;
	    }
	}


	public static void Print(){
	    StringBuilder output = new StringBuilder();
	    for(int i=1; i<= size/2; i++){
	        output.append("Parent :"+ heap[i]);
	        output.append("LeftChild : "+heap[getLeftChild(i)] +" RightChild :"+ heap[getRightChild(i)]).append("\n");
	    }
	    System.out.print(output.toString());
	    //return output.toString();
	}

}
