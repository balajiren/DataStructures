package Recursion;

import java.util.*;

public class PrintAllSubsets {

	static List<List<Integer>> output = new ArrayList();
	
	static int[] B = { 1, 2, 3 ,9};
	public static void main(String[] args) {
		/*int n = 2;
		int k = 3;

		print(n, k, new int[n]); */
		
		int[] A = new int[B.length];
		//combinations_Final(A, 0);
		int[] steps = new int[B.length];
		Arrays.fill(steps, 0);
		SubSets(B);
		for(List<Integer> res : output) {
			System.out.println(Arrays.toString(res.toArray()));
		}
		//PrintAllSubSets(B, steps, 0, "");

	}

	public static void backtrack(int first, int k, ArrayList<Integer> curr, int[] nums) {
		if(curr.size() == k) {
			output.add(new ArrayList(curr));
		}
		for(int i=first;i<nums.length;i++) {
            curr.add(nums[i]);
			backtrack(i+1,k,curr,nums);
			curr.remove(curr.size()-1);
		}
	}

	public static void SubSets(int[] nums) {

		int n = nums.length;
		for(int k=0;k<n;k++) {
			backtrack(0,k,new ArrayList<>(),nums);
		}


	}
	
//	public static int PrintAllSubSets(int[] nums,int[] steps,int step, String current)
//	{
//		if(step == nums.length-1)
//		{
//			current+="{";
//			steps[step] = 0;
//			for(int i=0;i<steps.length;i++)
//			{
//				if(steps[i] == 1)
//				{
//					current+=nums[i];
//				}
//			}
//			current+="}";
//			current+="{";
//			steps[step] = 1;
//			for(int i=0;i<steps.length;i++)
//			{
//				if(steps[i] == 1)
//				{
//					current+=nums[i];
//				}
//			}
//			current+="}";
//			System.out.println(current);
//			current = "";
//			return 1;
//		}
//		for(int i = step; i < nums.length; i++)
//		{
//			steps[step] = 1;
//		    int res = PrintAllSubSets( nums, steps, step+1, current);
//			steps[step] = 0;
//			int res1 =  PrintAllSubSets( nums, steps, step+1, current);
//			if(res == 1 && res1 ==1)
//			{
//				break;
//			}
//		}
//		return 1;
//
//
//
//	}
//
//
//
//	public static void combinations_Final(int[] A, int x) {
//		if (x == A.length - 1) {
//			A[x] = 0; // last digit, don't select it
//			printArray(A); // print the set
//			A[x] = 1; //// last digit, select it
//			printArray(A);
//			return;
//		}
//		A[x] = 0;   //either you will not select this digit
//		combinations_Final(A, x + 1);
//		A[x] = 1;  //either you will select this digit
//		combinations_Final(A, x + 1);
//	}
//
//
//	public static void printArray(int[] A) {
//		boolean isNULL = true;
//		System.out.print("{");
//		for (int i = 0; i < B.length; i++) {
//			if (A[i] == 1) {
//				System.out.print(B[i] + "");
//				isNULL = false;
//			}
//		}
//		if (isNULL == false) {
//			System.out.print("}");
//			System.out.print("  ");
//		}
//
//		if (isNULL) {
//			System.out.print("Empty");
//			System.out.print("} ");
//		}
//	}


}
