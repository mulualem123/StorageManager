import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author selon
 *
 */
public class Gui1 extends Application { 


	/**
	 * @param args
	 */
	public static void main(String args[]) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button folderBut = new Button("Choose Folder"); 
		Button excelBut  = new Button("Print Excel");
		Text text = new Text();

		folderBut.setOnAction(e ->{
			try {
				DirectoryChooser folderChooser = new DirectoryChooser();
				folderChooser.setTitle("Choose Folder");
				File selected = folderChooser.showDialog(primaryStage);

				SizeCalculator sizeCal = new SizeCalculator(selected);

				HashMap<String, String> subFolder_size = sizeCal.frontDesk();

				String list ="";

				for (String str : subFolder_size.keySet()) {
					list = list + "\n" + str + "\t " + subFolder_size.get(str);
				}
				text.setText(list);

				excelBut.setOnAction(e1 ->{
					EXcel2 printEcel = new EXcel2(subFolder_size, selected.getName().toUpperCase());
					try {
						printEcel.createEXCELSheet();
						FileChooser fileChooser = new FileChooser();
						fileChooser.setTitle("work please");
						fileChooser.setInitialDirectory(new File("."));
						Process pro = Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + fileChooser.showOpenDialog(primaryStage));
						pro.wait();
					} catch (IOException | InterruptedException f2) {
						f2.printStackTrace();	
					}
				});

			} catch (Exception f1) {
				f1.printStackTrace();
			}

		});
		HBox buttonsHBox = new HBox(folderBut, excelBut);
		VBox buttonsVBox= new VBox(buttonsHBox, text);
		buttonsVBox.applyCss();
		Scene scene = new Scene(buttonsVBox, 500, 500);

		primaryStage.setTitle("Sizeer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
