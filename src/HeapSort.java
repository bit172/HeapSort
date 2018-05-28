
public class HeapSort 
{

	public static void main(String[] args)
	{
		int[] Array = {3,4,6,8,12,22,45,7,20};
		int n = Array.length;
		Heapify(Array,n);
		int prime = PrimePath(Array,0,n-1);
		for(int i = 0; i<n;i++)
			System.out.print(Array[i] + " ");
		
		System.out.println();
		
		System.out.println(prime);
		
		System.out.println();
		
		siftDown(Array,0,n-1);
		
		for(int i = 0; i<n;i++)
			System.out.print(Array[i] + " ");
	}
	
	/**
	 * This method heapifies a section of an array of integers and all of the affected nodes
	 * of each subsequent heapifies recursively. It is only used in the actual Heapify method. 
	 * @param array Array
	 * @param size  Size of Array
	 * @param parent_index Index of node to compare
	 */
	private static void HeapifySection(int[] array,int size,int parent_index)
	{
		int largest = parent_index;  // Assume parent is largest and compare later
		int leftchild = 2*parent_index + 1;  // Index starts at 0 so 2i + 1
 		int rchild = 2*parent_index + 2;  // Index starts at 0 so 2i + 2
		 
 		// left child is largest
		if (leftchild < size && array[leftchild] > array[largest])
			largest = leftchild;
		 
		    // right child is larger   
		if (rchild < size && array[rchild] > array[largest])
			largest = rchild;
		 
		        
		if (largest != parent_index)
		{
			swap(array,parent_index,largest);
		            
			// Recursively heapify the sub-trees 
			HeapifySection(array, size, largest);
		}
		
	}
	
	/**
	 * Heapifies an entire array of integers
	 * @param array Array
	 * @param size Size of Array
	 * @param parent_index Index of node to compare
	 */
	public static void Heapify(int[] array,int size)
	{
		for(int i = size/2 - 1; i >= 0; i--)
			HeapifySection(array,size,i);
		
		
	}
	
	public static void sort(int[] array)
	{
		
	}
	
	public static void sorttrace(int[] array)
	{
		
	}
	
	public static int PrimePath(int[] array, int i,int last)
	{	
		int prime_index = i;
		int lchild = 2 * i + 1;
		int rchild = 2 * i + 2;
		
		while(lchild <= last)
		{	
			if(rchild <= last && array[rchild] > array[lchild])
				prime_index = rchild;
			else
				prime_index = lchild;
			
			lchild = 2 * prime_index + 1;
			rchild = 2 * prime_index + 2;
		}
		return prime_index;
	}
	
	public static void siftDown(int[] array, int i, int last)
	{
		int prime_index = PrimePath(array,i,last);
		
		while( array[i] > array[prime_index])
			prime_index = (prime_index - 1)/2;
		
		int x = array[prime_index];
		array[prime_index] = array[i];
		
		while( prime_index > i)
		{
			array[(prime_index - 1)/2] = x;
			prime_index = (prime_index - 1)/2;
		}
	}
	
	public static void swap(int[] array,int a, int b)
	{	
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

}
