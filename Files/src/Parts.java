import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Parts {

	public Parts() {
			
	}
	
	public static void main (String arg[]) {
		
	}
	
	public static double x (File input, double start)
	{
		double s = start;
		String orgFolder = input.getAbsolutePath();
		String[] fileList = input.list();

		try {
			System.out.println();
			System.out.println("8 X orgFolder " + orgFolder + " " + fileList.length);

			for (String absolutPath: fileList)
			{
				//change every element in the list to file

				System.out.println(orgFolder + " + " + absolutPath);

				File tempfile = new File(orgFolder+"\\"+absolutPath);
				//System.out.println("7 X the file  " + tempfile.getAbsolutePath() +" \\ "+ tempfile.exists());

				if(tempfile.isFile()) 
				{
					start += tempfile.length();
					//System.out.println("8  single size = " + tempfile.length() + "   sum = " + start );
				}else {
					start += x(tempfile, start);
					//System.out.println("9  single size = " + tempfile.length() + "   sum = " + start );
				}
			}

		}catch(Exception e) {

		}

		return start;
	}
	
	/**
	 * 
	 * @param calByte
	 * @return 
	 * @throws FileNotFoundException 
	 * 
	 * Improvement use a String array to get the index and compare the units 
	 * then divide the value with small unit by 1024 time index difference. 
	 */
	public static String getSum(String inported, String exported)  {

		String[] holder = {inported, exported};
		String[] holderList = new String[2];
		double[] doubleHolder = new double[2]; 
		int tracker = 0;

		for(String str: holder) {
			String UpStr = str.toUpperCase();  //Changes the Units to Upper Case. //System.out.println(UpStr);
			Scanner holderElement = new Scanner(UpStr);

			while(holderElement.hasNext()) {

				doubleHolder[tracker]= holderElement.nextDouble();
				holderList[tracker]=holderElement.next();
				tracker++;
			}

		}

		//the codes below take two values then change the value with the smaller unit to bigger unit
		if(holderList[0].equals(holderList[1])) {
			//System.out.println("1 Thesame unit");
			return doubleHolder[0]+doubleHolder[1] + " " + holderList[1];

		}else if(holderList[0].contains("GB") && holderList[1].contains("BYTE")){
			//System.out.println("2 GB Vs BYTE");
			return (doubleHolder[0] + doubleHolder[1]/1073741824.0) + " GB";

		}else if(holderList[0].contains("BYTE") && holderList[1].contains("GB")){
			//System.out.println("3 BYTE Vs GB");
			return (doubleHolder[0]/1073741824.0 + doubleHolder[1]) + " GB";

		}else if(holderList[0].contains("GB") && holderList[1].contains("KB")){
			//System.out.println("4 GB Vs KB");
			return (doubleHolder[0] + doubleHolder[1]/1048576.0) + " GB";

		}else if(holderList[0].contains("KB") && holderList[1].contains("GB")){
			//System.out.println("5 KB Vs GB");
			return (doubleHolder[0]/1048576.0 + doubleHolder[1]) + " GB";

		}else if(holderList[0].contains("GB") && holderList[1].contains("MB")){
			//System.out.println("6 GB Vs MB");
			return (doubleHolder[0] + doubleHolder[1]/1024.0) + " GB";

		}else if(holderList[0].contains("MB") && holderList[1].contains("GB")){
			//System.out.println("7 MB Vs GB");
			return (doubleHolder[0]/1024.0 + doubleHolder[1]) + " GB";

		}else if(holderList[0].contains("MB") && holderList[1].contains("BYTE")){
			//System.out.println("8 MB Vs BYTE");
			return (doubleHolder[0] + doubleHolder[1]/1048576.0) + " MB";

		}else if(holderList[0].contains("BYTE") && holderList[1].contains("MB")){
			//System.out.println("9 BYTE Vs MB");
			return (doubleHolder[0]/1048576.0 + doubleHolder[1]) + " MB";

		}else if(holderList[0].contains("MB") && holderList[1].contains("KB")){
			//System.out.println("10 MB Vs KB");
			return (doubleHolder[0] + doubleHolder[1]/1024.0) + " MB";

		}else if(holderList[0].contains("KB") && holderList[1].contains("MB")){
			//System.out.println("11 KB Vs MB");
			return (doubleHolder[0]/1024.0 + doubleHolder[1]) + " MB";

		}else if(holderList[0].contains("KB") && holderList[1].contains("BYTE")){
			//System.out.println("12 KB Vs BYTE");
			return (doubleHolder[0] + doubleHolder[1]/1024.0) + " KB";

		}else if(holderList[0].contains("BYTE") && holderList[1].contains("KB")){
			//System.out.println("13 BYTE Vs KB");
			return (doubleHolder[0]/1024.0 + doubleHolder[1]) + " KB";

		}else {
			//System.out.println("it doesn't fit in non of the above, this is error fillfullment.");
			return (doubleHolder[0] + doubleHolder[1]/1073741824.0) + " GB";

		}
		
		// Focus	method that uses takes a string returns wiht the right unit.
		//		double inByte = calByte;
		//		if (inByte > 1073741824) {
		//
		//			return inByte/1073741824 + " GB";
		//
		//		}else if(inByte > 1048576 ) {
		//
		//			return inByte/1048576 + " MB";
		//
		//		}else if(inByte > 1024 ) {
		//
		//			return inByte/1024 + " KB";
		//
		//		}else {
		//
		//			return inByte + " Bytes";
		//		}
	}
	
	/**
	 * 
	 * @param imported
	 * @param exported
	 * @return
	 */
	public static String compareAdd(String imported, String exported)  {
		//Improvement use a String array to get the index and compare the units 
		// then divide the value with small unit by 1024 time index difference. 
		String[] inputs = {imported, exported}; //String[] inputs = {getRightUnit(imported), getRightUnit(exported)};
		String[] unitList = {"BYTE", "KB", "MB", "GB"};
		String[] inportedUnitList = new String[2];
		double[] doubleHolder = new double[2]; 
		int tracker = 0;
		
		for(String str: inputs) {
			String UpStr = str.toUpperCase();  //Changes the Units to Upper Case. //System.out.println(UpStr);
			Scanner holderElement = new Scanner(UpStr);

			while(holderElement.hasNext()) {

				doubleHolder[tracker]= holderElement.nextDouble();
				inportedUnitList[tracker]=holderElement.next().toUpperCase();
				tracker++;
				
			}
		}
		
		boolean isBig = Arrays.asList(unitList).indexOf(inportedUnitList[0]) > Arrays.asList(unitList).indexOf(inportedUnitList[1]);
		long comp = Arrays.asList(unitList).indexOf(inportedUnitList[0]) - Arrays.asList(unitList).indexOf(inportedUnitList[1]);
		System.out.println(isBig + " " + comp);
		
		if(comp == 0 && !isBig) {
			//System.out.println(doubleHolder[0]+doubleHolder[1] +" "+ inportedUnitList[0]);
			return "what is wrong " + (doubleHolder[0]+doubleHolder[1]) +" "+ inportedUnitList[0]; //return getRightUnit(doubleHolder[0]+doubleHolder[1] +" "+ inportedUnitList[0]);
			
		}else if(isBig) {
			//System.out.println(doubleHolder[0]+(doubleHolder[1]/(1024^comp)) +" "+ inportedUnitList[0]);
			return doubleHolder[0]+(doubleHolder[1]/(1024^comp)) +" "+ inportedUnitList[0];
			
		}else {
			//System.out.println(doubleHolder[0]+(doubleHolder[1]/(1024^(comp*(-1)))) +" "+ inportedUnitList[1]);
			return doubleHolder[0]+(doubleHolder[1]/(1024^(comp*(-1)))) +" "+ inportedUnitList[1];
			
		}		
	}

	/**
	 * Improvement use a String array to get the index and compare the units 
	 * then divide the value with small unit by 1024 time index difference. 
	 * @param imported
	 * @param exported
	 * @return
	 */
	public static String compareAdd1(String imported, String exported)  { 
		String[] inputs = {getRightUnit(imported),getRightUnit (exported)}; 
		String[] unitList = {"BYTE", "KB", "MB", "GB"};
		String[] inportedUnitList = new String[2];
		double[] doubleHolder = new double[2]; 
		int tracker = 0;

		for(String str: inputs) {
			String UpStr = str.toUpperCase();  //Changes the Units to Upper Case. //System.out.println(UpStr);
			Scanner holderElement = new Scanner(UpStr);

			while(holderElement.hasNext()) {

				doubleHolder[tracker]= holderElement.nextDouble();
				inportedUnitList[tracker]=holderElement.next().toUpperCase();
				tracker++;

			}
		}

		boolean isBig = Arrays.asList(unitList).indexOf(inportedUnitList[0]) > Arrays.asList(unitList).indexOf(inportedUnitList[1]);
		long comp = Arrays.asList(unitList).indexOf(inportedUnitList[0]) - Arrays.asList(unitList).indexOf(inportedUnitList[1]);
		//System.out.println(isBig + " " + comp);

		if(comp == 0 && !isBig) {
			//System.out.println(doubleHolder[0]+doubleHolder[1] +" "+ inportedUnitList[0]);
			return getRightUnit(doubleHolder[0]+doubleHolder[1] +" "+ inportedUnitList[0]);

		}else if(isBig) {
			//System.out.println(doubleHolder[0]+(doubleHolder[1]/(1024^comp)) +" "+ inportedUnitList[0]);
			return getRightUnit(doubleHolder[0]+(doubleHolder[1]/(1024^comp)) +" "+ inportedUnitList[0]);

		}else {
			//System.out.println(doubleHolder[0]+(doubleHolder[1]/(1024^(comp*(-1)))) +" "+ inportedUnitList[1]);
			return getRightUnit((doubleHolder[0]/(1024^(comp*(-1)))) + doubleHolder[1] +" "+ inportedUnitList[1]);

		}
	}

	private static String getRightUnit(String imported) {
		// TODO Auto-generated method stub
		return null;
	}
	private static void printToCSV(String imported) throws IOException {
		FileWriter recorder = new FileWriter("data.txt");
		CSVPrinter Printer= new CSVPrinter(recorder, CSVFormat.DEFAULT.withHeader("File Name ", "Size ");
	}
}
