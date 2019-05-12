import java.util.ArrayList;

public class SubSortThenMerge_Sorter {

    ArrayList<String> usersData, localCopy;

    public SubSortThenMerge_Sorter(ArrayList<String> list){
	usersData = list;
	
        /* copy the user's data, so that its two lists
         can be merged into usersData */
        localCopy = new ArrayList<String>();
        for( int iUserData = 0; iUserData < usersData.size(); iUserData++)
            localCopy.add( usersData.get( iUserData));
        // temp for debugging
        System.out.println( "localCopy: " + localCopy);
    }

    public String toString() {
        return "" + usersData; 
    }


    public void subSortThenMerge(int start,
				 int end){
	System.out.println("start: "+ start);
	System.out.println("end: "+ end);
	if (end - start <= 1);
	else {
	    subSortThenMerge(start,
			     (start+end)/2);
	    subSortThenMerge((start+end)/2,
			     end);
	
        /* copy the user's data, so that localCopy pertains the change after usersData has been changed into partially-sorted lists */
        localCopy = new ArrayList<String>();
        for( int iUserData = 0; iUserData < usersData.size(); iUserData++)
            localCopy.add( usersData.get( iUserData));
        // temp for debugging
        System.out.println( "localCopy: " + localCopy);

	    merge(start,
		  (start+end)/2,
		  end);
	}
	System.out.println(usersData);
    }

    
    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries in usersData; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int end1    // index past end of list1
      ) {
        mergeRange( start0,
		    start0,
		    start1,
		    start1,
		    end1);
    }


    /**
      problem: Merge the user data from the given range in localCopy
        into the usersData.
     recursive abstraction: When I am asked to {problem statement}, 
       the recursive abstraction can merge the results of a range
       that is one item smaller.
     */
    private void mergeRange(
        int target // destination in usersData. Probably redundant.

        // boundaries of lists in localCopy, NOT usersData!
      , int localStart0  // index of first item in list0
      , int localEnd0    // just past end of list0
      , int localStart1  // index of first item in list1
      , int localEnd1    // just past end of list0
      ) {
        // temp for debugging
        // System.out.println(
        //     " target = "      + target  
        //   + " localStart0 = " + localStart0
        //   + " localEnd0 = "   + localEnd0  
        //   + " localStart1 = " + localStart1
        //   + " localEnd1 = "   + localEnd1  
        //   );
          
        if( // both ranges are exhausted
            localStart0 == localEnd0 && localStart1 == localEnd1
          )
            // solution to base case
            return;  // merge is done
        else{ // there is at least 1 item remaining to merge
            if( // list0 exhausted
                localStart0 == localEnd0
              ) 
               // take an item from list1
                usersData.set( target++, localCopy.get( localStart1++));

            // similarly for exhausted list1
            else if( localStart1 == localEnd1)
                usersData.set( target++, localCopy.get( localStart0++));
            
            else // items remain in both lists
                // copy the smaller item
                if( localCopy.get( localStart0).compareTo( 
                    localCopy.get( localStart1)) < 0)
                    usersData.set( target++, localCopy.get( localStart0++));
                else
                    usersData.set( target++, localCopy.get( localStart1++));
            mergeRange( target, localStart0, localEnd0, localStart1, localEnd1);
        }
    
    }

    

    public boolean isSorted(int start,
			    int end){
	for (int i = start;
	     i < end;
	     i++)
	    if (usersData.get(i).compareTo(usersData.get(i + 1)) > 0)
		return false;
	return true;
    }
}
