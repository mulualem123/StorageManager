import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SpaceManagerTest {



	public static void main(String[] args) {
		FolderSelect f = new FolderSelect();
		Parts p = new Parts();
		
		System.out.println("\n Get Sum Test The Longer way");
		getSumTest(p);
		
		//getRightUnitTest(f);
		System.out.println("\n Compare and ADD Shortest way");
		compareAddTest(f);
		
	}

	/**
	 * 
	 */
	public static void getSumTest(Parts p) {

		System.out.println("1 "+p.getSum("100 gb", "40 gb"));
		System.out.println("2 "+p.getSum("200 gb", "11111111111140 byte"));
		System.out.println("3 "+p.getSum("300 byte", "40 gb"));
		System.out.println("4 "+p.getSum("400 gb", "4555555555550 KB"));
		System.out.println("5 "+p.getSum("500 KB", "4666666660 gb"));
		System.out.println("6 "+p.getSum("600 gb", "477777770 mb"));
		System.out.println("7 "+p.getSum("700 mb", "40 gb"));
		System.out.println("8 "+p.getSum("800 mb", "40 byte"));
		System.out.println("9 "+p.getSum("900 byte", "40 mb"));
		System.out.println("10 "+p.getSum("1000 mb", "40 kb"));
		System.out.println("11 "+p.getSum("1100 kb", "40 mb"));
		System.out.println("12 "+p.getSum("1200 kb", "40 byte"));
		System.out.println("13 "+p.getSum("1300 byte", "40 kb"));
		System.out.println("14 "+p.getSum("200 gb", "11111111111140 kb"));

		//		for(String dHol: holderList){
		//		System.out.println(dHol);
		//	}
		//		for(double dHol: doubleHolder){
		//		System.out.println(dHol);
		//	}

	}
	
	/**
	 * 
	 */
	public static void getRightUnitTest (FolderSelect g){
		System.out.println("Checks for Big numbers"+g.getRightUnit("100000000000 kb"));
	}
	
	public static void compareAddTest(FolderSelect f)  {
		System.out.println("1 " + f.compareAdd("100 gb", "40 gb"));
		System.out.println("2 " + f.compareAdd("200 gb", "11111111111140 byte"));
		System.out.println("3 " + f.compareAdd("300 byte", "40 gb"));
		System.out.println("4 " + f.compareAdd("400 gb", "4555555555550 KB"));
		System.out.println("5 " + f.compareAdd("500 KB", "4666666660 gb"));
		System.out.println("6 " + f.compareAdd("600 gb", "477777770 mb"));
		System.out.println("7 " + f.compareAdd("700 mb", "40 gb"));
		System.out.println("8 " + f.compareAdd("800 mb", "40 byte"));
		System.out.println("9 " + f.compareAdd("900 byte", "40 mb"));
		System.out.println("10 " + f.compareAdd("1000 mb", "40 kb"));
		System.out.println("11 " + f.compareAdd("1100 kb", "40 mb"));
		System.out.println("12 " + f.compareAdd("1200 kb", "40 byte"));
		System.out.println("13 " + f.compareAdd("1300 byte", "40 kb"));
		System.out.println("14 " +f.compareAdd("200 gb", "11111111111140 kb"));
	}
	
	public static void x (File input, double start){
		
	}
}
