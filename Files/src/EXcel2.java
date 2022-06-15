import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * This Class will take two String array then print out Folders and their size.
 * @author Mulualem Hailom
 *
 *
 */
public class EXcel2 {

	static HashMap<String,String> Folder_Size;
	static String title;
/**
 * 
 * @param folderList
 * @param sizeValue
 * @param title
 * 
 * Constructor
 */
	public EXcel2(HashMap<String, String> Folder_Size, String title) {

		this.Folder_Size = Folder_Size;
		this.title = title;

	}

	//	public static void main(String[] args) throws IOException {
	//	}

	//public static void registerList(String[] folderList, String[] sizeValue) throws IOException {
	public static void createEXCELSheet() throws IOException {
		XSSFWorkbook workBook = new XSSFWorkbook(); //create Workbook
		XSSFSheet sheet = workBook.createSheet("FolderSize");
		XSSFRow row;
		XSSFCell cell;

		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("Name");
		cell = row.createCell(1);
		cell.setCellValue("Size");
		cell = row.createCell(2);
		cell.setCellValue("Unit");
		int track = 1;
		try {
			for(String str: Folder_Size.keySet()) {

				row = sheet.createRow(track);
				Scanner input = new Scanner(Folder_Size.get(str));

				for(int i = 0; i<3; i++) {

					cell = row.createCell(i);
					if(i==0) {
						cell.setCellValue(str);
					}else if(i==1) {

						cell.setCellValue(input.nextDouble());
					}else {

						cell.setCellValue(input.next());

					}

				}//ends the inner for loop
				track++; 
			}//ends the for loop
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yy HH-mm");

			File file = new File("RDC106 "+ dateFormat.format(new Date())+ " " + title + ".xlsx");

			FileOutputStream out = new FileOutputStream(file);
			workBook.write(out);
			out.close();
			System.out.println("The excel is created successful.");
		}catch (FileNotFoundException ex){

		}
	}

}
