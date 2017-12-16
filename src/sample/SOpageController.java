package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class SOpageController {
    private String FirstPage = "firstpage.fxml";


    //FXID of Radio=======================================
    @FXML
    private RadioButton ID;
    @FXML
    private RadioButton name;
    @FXML
    private RadioButton imm;
    @FXML
    private RadioButton halfmonth;
    @FXML
    private RadioButton month;

    //FXID of Btn=========================================
    @FXML
    private Button BackButton;

    @FXML
    private Button CheckBtn;

    @FXML
    public void checkBtnAction(ActionEvent event){
        if(ID.isSelected()){
            System.out.println("ID");

        }else if (name.isSelected()){
            System.out.println("name");

        }else{
            System.out.println("Not Select");

        }
    }
    @FXML
    public void submitBtnAction(ActionEvent event){
        System.out.println("submit");

    }






    @FXML
    public void handleBackButtonAction(ActionEvent e){
        Button b = (Button) e.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setTitle("Main Menu");
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FirstPage));
        try{
            stage.setScene(new Scene(loader.load(),800,600));
            FirstPageController controller = (FirstPageController) loader.getController();

        } catch (IOException e1){
            e1.printStackTrace();
        }
    }
}
