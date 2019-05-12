/**
  
 */
import java.util.ArrayList;
import java.util.Arrays;

public class UserOfSubSortThenMerge {
    
    public static void main(String[] commandLine) {
        ArrayList< String> cards = new ArrayList< String>(
          /* Java's Arrays.asList provides a perspicuous
             way to build a Collection from literals,
             suitable for constructing an ArrayList */
          Arrays.asList(
              // data to be ignored; see README
              "z", "y"  // descending order
            , "4", "3", "6", "1", "7", "J", "Q", "K"
            
              // more data to be ignored
            , "-", "+", "*"  // descending order
            ));

        oneTest( "card decks"
               , cards, 2, 10 );

	// System.out.println("z".compareTo("7"));
	// System.out.println("6".compareTo("K"));
	// System.out.println("Q".compareTo("*"));

    }

    
    /** 
     Run one test
     */
    private static void oneTest(
        String description
      , ArrayList<String> sortMe
        // indexes of sub-list boundaries; see README
      , int start  // index of first item
      , int end  // number of items in the merged list

                               ) {

        SubSortThenMerge_Sorter sorter = new SubSortThenMerge_Sorter( sortMe);

        System.out.println( 
            System.lineSeparator()
          + description + System.lineSeparator()
          + "before: " + sorter
          );
        sorter.subSortThenMerge( start, end);
        System.out.println( "after:  " + sorter);
        System.out.println(
            "sorted: "
          + sorter.isSorted( start, end));
     }
    

}


