import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	
//	public Time() {
//		
//	}
	
	public static void main(String[] args) {
		System.out.println(new Date());
	}

	public static String getDateString() {
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yy");
		return dateFormat.format(new Date());
		
	}
}
