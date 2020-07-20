import java.util.ArrayList;
import java.util.Date;

public class Patient extends Person {
	private ArrayList<Headache> headaches;

	/**
	 * @param name
	 * @param age
	 */
	public Patient(String name, int age) {
		super(name, age);
		headaches = new ArrayList<Headache>();
	}

	/**
	 * @param name
	 * @param age
	 * @param headaches
	 */
	public Patient(String name, int age, ArrayList<Headache> headaches) {
		super(name, age);
		this.headaches = headaches;
	}

	public void addHeadache(Headache headache) {
		headaches.add(headache);
	}
	
	public String getRawData(Date start, Date end) {
	  ArrayList<Headache> headaches = getHeadaches(start, end);
	  String headacheInfo = "";
	  
	  for (Headache headache : headaches){
	    headacheInfo += NEWLINE + headache.getRawData();
	  }
	  
	  return 
	      "Name: " + name + NEWLINE +
	      "Age: " + age + NEWLINE +
	      headacheInfo;
	}

	public ArrayList<Headache> getHeadaches(Date start, Date end) {
		ArrayList<Headache> result = new ArrayList<Headache>();

		for (Headache headache : headaches) {
			if (headache.getStartDate().equals(start)
					|| headache.getStartDate().after(start) && headache.getEndDate().equals(end)
					|| headache.getEndDate().before(end)) {
				result.add(headache);
			}
		}

		return result;
	}

}
