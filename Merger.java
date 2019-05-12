/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData, list;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
	int counter = 2;
	int index0;
	int index1;
        list = new ArrayList<String>();
	for (int i = 0; i < usersData.size(); i++)
	    list.add(usersData.get(i));
	
	for (index0 = start0, index1 = start1; counter < nItems; counter++){
	    if (index0 >= start1 && index1 < nItems)
	        counter = nItems;
	    else if (index1 == nItems && index0 < start1
		|| usersData.get(index0).compareTo( usersData.get(index1)) <= 0){
		list.set(counter, usersData.get(index0));
	    
		// System.out.println(usersData.get(index0));
		// System.out.println(usersData.get(index1));
		// System.out.println("counter " + counter);
		// System.out.println("idx0  " + index0);
		// System.out.println("idx1  " + index1);
		index0++;
	    }
	    else {
		list.set(counter, usersData.get(index1));
	    
		// System.out.println(usersData.get(index0));
		// System.out.println(usersData.get(index1));
		// System.out.println("counter " + counter);
		// System.out.println("idx0  " + index0);
		// System.out.println("idx1  " + index1);
		index1++;
	    }
		// System.out.println(list);
	}
	// System.out.println("J vs. Q " + "J".compareTo("Q"));
	// System.out.println("Q vs. K " + "Q".compareTo("K"));
	// System.out.println("J vs. K " + "J".compareTo("K"));
	usersData = list;

	// for recursion
	// mergeRange(start0, start0, start1, start1, nItems);
    }

    //for recursion

    private void mergeRange(int target,
    			    int localStart0,
    			   int localEnd0,
    			   int localStart1,
    			   int localEnd1){
    	if (localStart0 == localEnd0 && localStart1 == localEnd1);
    	else {
    	    if (localStart0 == localEnd0){
    		usersData.set(target, list.get(localStart1));
    		target++;
    		localStart1++;
    	    }
    	    else if (localStart1 == localEnd1){
    		usersData.set(target, list.get(localStart0));
    		target++;
    		localStart0++;
    	    }
    	    else {
    		if (list.get(localStart0).compareTo(
    			        list.get(localStart1)) <= 0){
    		    usersData.set(target, list.get(localStart0));
    		    target++;
    		    localStart0++;
    		}
    		else {
    		    usersData.set(target, list.get(localStart1));
    		    target++;
    		    localStart1++;
    		}
    	    }
    	    mergeRange(target, localStart0, localEnd0, localStart1, localEnd1);
	    
    	}
    }

    
    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0)
		return false;
        return true;
    }
}
