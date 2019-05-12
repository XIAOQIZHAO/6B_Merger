import java.util.ArrayList;

public class SubSortThenMerge_Sorter {

    ArrayList<String> usersData, localCopy;

    public SubSortThenMerge_Sorter(ArrayList<String> list){
	usersData = list;
	localCopy = new ArrayList<String>(usersData.size());
	if (usersData.size() != 0)
	    for (int i = 0; i < usersData.size(); i++)
		localCopy.add(i, usersData.get(i));
    }

    public void merge(int start0,
		 int start1,
		 int nItems){
	subSortThenMerge(usersData,
			 start0,
			  start1,
			  start1,
			  nItems);
    }

    
    private ArrayList<String> subSortThenMerge(ArrayList<String> list,
					       int start0,
					       int end0,
					       int start1,
					       int end1){
	if (list.size() <= 1)
	    return list;
	else {
	    ArrayList<String> collection0 = subSortThenMerge(new ArrayList<String> (list.subList(start0, end0)),
							    start0,
							    (start0 + end0) / 2,
							    (start0 + end0) / 2,
							    end0);
	    ArrayList<String> collection1 = subSortThenMerge(new ArrayList<String> (list.subList(start1, end1)),
							     start1,
							     (start1 + end1) / 2,
							     (start1 + end1) / 2,
							     end1);
	    for (int i = 0; i < list.size(); i++){
		list.set(i, collection0.get(i));
		list.set(i + end0, collection1.get(i));
	    }
	    return merge(list,
			 start0,
			 start0,
			 (start0 + end0) / 2,
			 (start0 + end0) / 2,
			 end0);
			 
	}
    }

	private ArrayList<String> merge(ArrayList<String> list,
					int target,
					int start0,
					int end0,
					int start1,
					int end1){
	ArrayList<String> copy = new ArrayList<String>();
	if(start0 == end0 && start1 == end1)
	    return list;
        else{
            if(start0 == end0)
		list.set( target++, copy.get( start1++));

	    else if( start1 == end1)
                list.set( target++, copy.get( start0++));
            
            else
		if( copy.get( start0).compareTo( 
                    copy.get( start1)) < 0)
                    list.set( target++, copy.get(start0++));
                else
                    list.set( target++, copy.get( start1++));
	return merge( list, target, start0, end0, start1, end1);
        }
    }

    public boolean isSorted(int start0,
			    int nItems){
	for (int i = 0;
	     i < usersData.size() - 1;
	     i++)
	    if (usersData.get(i).compareTo(usersData.get(i + 1)) > 0)
		return false;
	return true;
    }
}
