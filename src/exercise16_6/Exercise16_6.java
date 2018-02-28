/*
 *  Program:    Exercise 16.6
 *  Date:       2/27/18
 *  Developer:  Garrett Wolfe
 *  Purpose:    Write a program that sets the horizontal alignment 
 *              and column-size properties of a text field dynamically, 
 *              as shown in figure 16.38a.  
 */
package exercise16_6;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Exercise16_6 extends Application{
    protected TextField tfTextField = new TextField();
    protected TextField tfColumnSize = new TextField();

    @Override
    public void start(Stage primaryStage) {
	tfTextField.setText("Enter text");
	tfTextField.setAlignment(Pos.BOTTOM_CENTER);
	tfColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
	tfColumnSize.setPrefColumnCount(3);
	tfTextField.setPrefColumnCount(12);
	tfColumnSize.setText("12");

	RadioButton rbLeft = new RadioButton("Left");
	RadioButton rbCenter = new RadioButton("Center");
	RadioButton rbRight = new RadioButton("Right");
	rbCenter.setSelected(true);

	ToggleGroup group = new ToggleGroup();
	rbLeft.setToggleGroup(group);
	rbCenter.setToggleGroup(group);
	rbRight.setToggleGroup(group);
		
	HBox paneForRadioButtons = new HBox(5);
	paneForRadioButtons.getChildren().addAll(rbLeft, rbCenter, rbRight);
	paneForRadioButtons.setAlignment(Pos.BOTTOM_LEFT);

	HBox paneForColumnSize = new HBox(5);
	paneForColumnSize.getChildren().addAll(
	new Label("Column size"), tfColumnSize);

	HBox paneForTextField = new HBox(5);
	paneForTextField.setAlignment(Pos.CENTER);
	paneForTextField.getChildren().addAll(
	new Label("Text Field"), tfTextField);

	HBox hbox = new HBox(10);
	hbox.getChildren().addAll(paneForRadioButtons, paneForColumnSize);

	VBox pane = new VBox(10);
	pane.setPadding(new Insets(5, 5, 5, 5));
	pane.getChildren().addAll(paneForTextField, hbox);

	rbLeft.setOnAction(e -> {
            if (rbLeft.isSelected()) {
                tfTextField.setAlignment(Pos.BOTTOM_LEFT);
            }
	});

	rbCenter.setOnAction(e -> {
            if (rbCenter.isSelected()) {
		tfTextField.setAlignment(Pos.BOTTOM_CENTER);
            }
	});

	rbRight.setOnAction(e -> {
            if (rbRight.isSelected()) {
		tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
            }
	});

	tfColumnSize.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
		tfTextField.setPrefColumnCount(Integer.parseInt(tfColumnSize.getText()));
            }
	});

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Text field1"); 
        primaryStage.setScene(scene); 
	primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    } 
}