package w3LabHomeworkLesson8;
import java.util.Comparator;


public class SalesAmtComparator implements Comparator<Marketing>{

	@Override
	public int compare(Marketing o1, Marketing o2) {
		// TODO Auto-generated method stub
		Double amt1= o1.getSalesamount();
		Double amt2 = o2.getSalesamount();
		return amt1.compareTo(amt2);
	}

}
