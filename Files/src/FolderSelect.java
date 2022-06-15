
/**
 *  correction The GB grows unfair'
 *  
 * This class selects a folder and calculate the size.
 * The size displays in the right unit.
 * the Methods are y, x, getFolderPath, and setUnit.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.Arrays;
public class FolderSelect {
	static File file = new File("");
	
	public FolderSelect(File file) {
		this.file = file;
	}
	
//	public static void main(String[] args) throws NullPointerException, IOException{
//		Long startTime = System.currentTimeMillis()/(10^9);
//
//		//Parts p = new Parts();
//		System.out.println(" 6 chosen folder size = " + frontDesk(file));
//
//		Long endTime = System.currentTimeMillis()/(10^9);
//		System.out.println(endTime-startTime);
//	}

	/**
	 * This method takes in any File type. if the File in is not directory it returns size of the file.
	 * if the file is directory it send it to method y and to get the total size.
	 * 
	 * @param file
	 * @return 
	 * @return
	 * @throws IOException 
	 */
	//public static String frontDesk (File input ) throws IOException {

	public static String[] frontDesk ( ) throws IOException {
		System.out.println("1 Y " + file.getAbsolutePath());
		System.out.println("2 Y File exit " + file.exists());
		
		String[] subFolderValues = new String[file.list().length];

		if (file.isFile()) {
			System.out.println("3 vFile Name " + file.getName());
			System.out.println("4 Size " + file.length());
			//return getRightUnit(file.length() + " BYTE");
		}else {

			//System.out.println(" 5 File Name " + input.getName());
			//System.out.println(" 6 chosen folder size = " + x(input, 0.0)/1024); 
			String[] subFolderList = file.list();
			String orgFolder = file.getAbsolutePath();
			String totalString = "";
			int track = 0;
			try {
				for(String str : subFolderList) {
					subFolderValues[track] = x(new File (orgFolder+"\\"+str),0 + " BYTE");

					System.out.println(str);
					System.out.println(subFolderValues[track]);
					track++;
				}

				//////////////////////////it might not work///////////////////////////
				for(int i = 0; i<subFolderValues.length; i++) {
					totalString = getRightUnit(getSum(totalString, subFolderValues[i]));
				}
				//////////////////////////////                  /////////////////////

			}catch(Exception e) {

			}
			//EXcel cel = new EXcel(subFolderList, subFolderValues, file.getName()); 
			//cel.createEXCELSheet();
			
			

		
			//return x(input, 0 + " BYTE", p, input.list(), new double[input.list().length], track);
		}
		return subFolderValues;

	}

	/**
	 * This method takes Directory Files; and 0 for the first time. 
	 * But for the recursion the method takes sum size as start from parent folder
	 * @param input
	 * @param valueUnit
	 * @param p
	 * @param l going to be sent to the subFolders method
	 * @param d going to be sent to the subFolders method
	 * @param track
	 * @return
	 */
	//public static String x (File input, String valueUnit,Parts p, String[] l, double[] d, int track)
	public static String x (File input, String valueUnit)

	{
		String s = valueUnit;
		String orgFolder = input.getAbsolutePath();
		String[] fileList = input.list();

		try {
			if(input.isFile()) {
				
				s = getRightUnit(new File(orgFolder).length() + " BYTE");
				
			}else {
				//System.out.println("8 X orgFolder " + orgFolder + " " + fileList.length);

				for (String fileName: fileList)
				{
					//change every element in the list to file

					//System.out.println(orgFolder + " + " + fileName);

					File tempfile = new File(orgFolder+"\\"+fileName);
					//System.out.println("7 X the file  " + tempfile.getAbsolutePath() +" \\ "+ tempfile.exists());

					if(tempfile.isFile()) 
					{
						s = getSum(s, tempfile.length() + " BYTE");

						//System.out.println("7 X the file  " + tempfile.getAbsolutePath() +" \\ "+ tempfile.exists());
						//System.out.println("8 x "+s);
					}else {
						s = getRightUnit(x(tempfile, s));
						//s = getRightUnit(x(tempfile, s, p, l, d, track));

						//					if(track <= l.length) {
						//						
						//						subFolders(l, d, s, fileName, track);
						//						System.out.println(track);
						//						
						//					}

						//System.out.println("9 x "+s);
					}

				}
			}
			//System.out.println("10 Y " + s);
		}catch(Exception e) {

		}

		return s;
	}

	/**
	 * @param singleValue takes in single string value containing value and unit.
	 * @return a value with the highest unit it can have with out going to decimal mode.
	 * 
	 * This method might cause upperCase problem. Possible solutions instead of returning 
	 * "singleValue" we can return String attaching doubleValue and unit
	 */

	public static String getRightUnit(String singleValue) {
		Scanner input =new Scanner(singleValue.toUpperCase());
		double doubleValue = input.nextDouble();
		String unit =input.next();

		String[] unitList = {"BYTE", "KB", "MB", "GB"};
		int index  = Arrays.asList(unitList).indexOf(unit);
		//System.out.println(index);
		if(doubleValue >= 1024 && index < unitList.length-1) {

			return getRightUnit((doubleValue/1024) + " " + unitList[index+1]);

		}else {

			return singleValue;

		}
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

	}





	//####################################################################################################//
		//public static void subFolders(String[] l, double[] d, String s, String fileName, int track) {
		//
		//		for(String str: l) {
		//			if(str.contains(fileName)){
		//				if(track == 0) {
		//
		//					d[0]=new Scanner(s).nextDouble();
		//					System.out.println("20 " + str + " "+ d[0] );
		//					System.out.println("21 track " + track);
		//					track++;
		//					System.out.println("22 track" + track);
		//
		//				}else {
		//
		//					d[track] = new Scanner(s).nextDouble()- d[track - 1];
		//					System.out.println("23 " + str + " " + d[0] );
		//					System.out.println("24 track " + track);
		//					track++;
		//					System.out.println("25 track" + track);
		//				}
		//
		//
		//			}else {
		//
		//			}
		//		}
		//
	    //}


}

