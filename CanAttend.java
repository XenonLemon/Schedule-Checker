//Peter Daniel 2/10/26
import java.util.ArrayList;

public class CanAttend {

	//precondition: The ArrayList containing the Meeting intervals is not null and does not contain any null values.  
	//postcondition: Will output if false if any meetings start and end times overlap with each other, and true if the meetings don't conflict each other.
	public static boolean canAttend(ArrayList<MeetingInterval> meetings) {
		//your implementation here
		System.out.println(meetings);
		
		for(int i = 0; i < meetings.size(); i++){
			for(int j = i+1; j<meetings.size(); j++){
				
				int start1 = meetings.get(i).getStart();
				int end1 = meetings.get(i).getEnd();
				int start2 = meetings.get(j).getStart();
				int end2 = meetings.get(j).getEnd();
				
				if(start1 < start2 && end1 > start2){
					return false;
				}
				
			}
		}
		return true;

	}
	public static void main(String[] args) {
		ArrayList<MeetingInterval> meet = new ArrayList<MeetingInterval>();
		for(int i =0; i<10; i++) {
			int start = (int)(Math.random()*2399);
			int end = start + ((int)(Math.random()*(2399-start)));
			meet.add(new MeetingInterval(start, end));

		}
		System.out.println(canAttend(meet) ? "There is no conflict with attending "+meet+" meetings":"Can't attend "+meet+" meetings due to conflict");
		//please include additional testing here!
		meet.clear();
		meet.add(new MeetingInterval(0,20));
		//meet.add(new MeetingInterval(10,30));
		meet.add(new MeetingInterval(60 ,100));
		meet.add(new MeetingInterval(110 ,120));
		//meet.add(new MeetingInterval(160 ,140));
		System.out.println(canAttend(meet) ? "There is no conflict with attending "+meet+" meetings":"Can't attend "+meet+" meetings due to conflict");

	}
}
