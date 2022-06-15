import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFileChooser;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author selon
 *
 */
public class Gui extends Application {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
	
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//		FolderSelect fs;
		//		StackPane layout = new StackPane();
		//		StackPane layout2 = new StackPane();
		//		
		//		Scene scene = new Scene(layout, 400, 300);
		//		Scene scene2 = new Scene(layout2, 400, 200);
		//		
		//		
		//		mainStage.setTitle("Storage Manager");
		//		mainStage.setScene(scene);
		//		mainStage.show();
		//
		//		
		//		Button button = new Button("GoForward");
		//		button.setOnAction(e -> mainStage.setScene(scene2));
		//		
		//		Button button2 = new Button("getSize");
		//		button2.setOnAction(e -> {
		//			try {
		//				new FolderSelect(getFolderPath()).frontDesk();
		//			} catch (IOException e1) {
		//				// TODO Auto-generated catch block
		//				e1.printStackTrace();
		//			}
		//		});
		//		
		//		layout.getChildren().addAll(button);
		//		layout2.getChildren().addAll(button2);
		//#############################################################//
		Button button1 = new Button("Choose Folder");
		Button button2 = new Button("Choose File");
		Button button3 = new Button("Print EXcel Sheet");
		Text folderName = new Text();
		Text sizeValue = new Text();
	
		button1.setOnAction(e -> {
			//            FileChooser filechooser = new FileChooser();  
			//            filechooser.setTitle("Open File");  
			//            File selected = filechooser.showOpenDialog(primaryStage); 
			DirectoryChooser directoryChooser = new DirectoryChooser();
			directoryChooser.setTitle("Choose Folder");
			
			File selected = directoryChooser.showDialog(primaryStage);
			
			try {
				folderName.setText(selected.getAbsolutePath());
				
				//FolderSelect fs = new FolderSelect(selected);
				SizeCalculator fs = new SizeCalculator(selected);
				
				//String[] folderSize = fs.frontDesk();
				HashMap<String, String> subFolders_Value = fs.frontDesk();
				
				String nameInput = " ";
				String valueInput = " ";
				
				//int track = 0;
				
				for (String sub: subFolders_Value.keySet()) {
					
					nameInput = nameInput + " \n " + sub  ;
					valueInput = valueInput + " \n " + subFolders_Value.get(sub);
					
		//			track++;
				}
				
				folderName.setText(nameInput);
				sizeValue.setText(valueInput);
			}catch(Exception e1) {

			}
		});

		button2.setOnAction(e -> {
			FileChooser filechooser = new FileChooser();  
			filechooser.setTitle("Open File");  
			File selected = filechooser.showSaveDialog(primaryStage);           
		});
		
		button3.setOnAction(e -> {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			directoryChooser.setTitle("Create EXCEL");
			
			File selected = directoryChooser.showDialog(primaryStage);
			
			FolderSelect fs = new FolderSelect(selected);
		
			try {
				String[] folderSize = fs.frontDesk();
				EXcel ex = new EXcel(selected.list(), folderSize, selected.getName());
				ex.createEXCELSheet();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// you can open the file when the excel is saved instade opening new windows.
			FileChooser filechooser = new FileChooser();  
			filechooser.setTitle("Print EXCEL Sheet"); 
			filechooser.setInitialDirectory(new File("C:\\Users\\selon\\Documents\\Eclipse projects\\Files"));
			File selected1 = filechooser.showOpenDialog(primaryStage);
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.open(selected1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		ScrollPane scrollName = new ScrollPane();
		scrollName.setContent(folderName);
		scrollName.setPannable(true);
		//scrollName.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		//scrollName.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		
		ScrollPane scrollValue= new ScrollPane();
		scrollValue.setContent(sizeValue);
		scrollValue.setPannable(true);
		
		//////////////////////////Layout//////////////////////////	
		TilePane layout = new TilePane(button1, button2, button3); 
		//layout.setAlignment(Pos.CENTER);
		
		HBox layout1 = new HBox(scrollName, scrollValue);
		//layout1.setAlignment(Pos.CENTER);
		
		VBox layout2 = new VBox(layout, layout1); 
		//layout1.setAlignment(Pos.CENTER);
		layout2.setSpacing(25);
		
		//////////////////////////Scene//////////////////////////
		Scene scene = new Scene(layout2, 400, 400);  
		
		//////////////////////////Stage//////////////////////////
		primaryStage.setTitle("CodersLegacy");
		primaryStage.setScene(scene);   
		primaryStage.show();  

	}

	/**
	 * GUI folder selector using JFileChooser class.
	 * 
	 * @return File (the selected directory as a File)
	 */
	public static File getFolderPath() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("choosertitle");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("10 getCurrentDirectory(): " + chooser.getCurrentDirectory());
			System.out.println("11 getSelectedFile() : " + chooser.getSelectedFile());
			return chooser.getSelectedFile();
		} else {
			System.out.println("12 No Selection ");
			return null;
		}
	}

	/**
	 * 
	 */
	public static void getDirectory() {

	}


}
