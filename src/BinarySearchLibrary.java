import java.util.*;

public class BinarySearchLibrary {
	
	public static <T>
	    int firstIndexSlow(List<T> list, 
	    		           T target, Comparator<T> comp) {
		int index = Collections.binarySearch(list, target,comp);
		
		if (index < 0) return index;
		
		while (0 <= index && comp.compare(list.get(index),target) == 0) {
			index -= 1;
		}
		return index+1;
	}
	/**
	 * Uses binary search to find the index of the first object in parameter
	 * list -- the first object o such that comp.compare(o,target) == 0.
	 * 
	 * This method should not call comparator.compare() more than 1+log n times
	 * @param list is the list of objects being searched
	 * @param target is the object being searched for
	 * @param comp is how comparisons are made
	 * @return index i such that comp.compare(list.get(i),target) == 0
	 * and there is no index < i such that this is true. Return -1
	 * if there is no such object in list.
	 */

	public static <T>
	int firstIndex(List<T> list, 
               	  T target, Comparator<T> comp) {
		
		int low = -1;
		int high = list.size();
		// target in [low,high)

 
		while(low+ 1 != high) {
			
			int mid = (high + low) /2;
			int a = comp.compare(list.get(mid), target);
			if(a < 0) {
				low = mid;
			}
			else if(a > 0) {
				high = mid;
			}
			else{
				while(mid >= 0 && a == 0){
					mid--;
				}
				System.out.println("returning " + (mid+1));
				return mid + 1;
			}
			
		}
		return -1;
	}
	

	/**
	 * Uses binary search to find the index of the last object in parameter
	 * list -- the first object o such that comp.compare(o,target) == 0.
	 * 
	 * This method should not call comparator.compare() more than 1+log n times
	 * @param list is the list of objects being searched
	 * @param target is the object being searched for
	 * @param comp is how comparisons are made
	 * @return index i such that comp.compare(list.get(i),target) == 0
	 * and there is no index > i such that this is true. Return -1
	 * if there is no such object in list.
	 */
	
		public static <T>
		int lastIndex(List<T> list, 
	               	T target, Comparator<T> comp) {
		
		int low = 0;
		int high = list.size()-1;
		//target in (low,high]
		
		while(low <= high) {
			
			int mid = (high + low) /2;
			int a = comp.compare(list.get(mid), target);
			if(a < 0) {
				low = mid+1;
			}
			else if(a > 0) {
				high = mid-1;
			}
			else {
				System.out.println("in while loop");

				 while(mid < list.size() && a == 0) {
					 System.out.println("in while loop");
	                 mid++;
	             }
				 System.out.println("outside while loop and returning " + (mid-1));
	             return mid - 1;
			}
		}
		System.out.println("returning -1");
		return -1;
	}
}
