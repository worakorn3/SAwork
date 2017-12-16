package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;


public class POpageController {
    //valible
    private String searchKey;

    private String FirstPage = "firstpage.fxml";
    Date date;



    @FXML
    private RadioButton ID;
    @FXML
    private RadioButton Name;
    @FXML
    private RadioButton immediate;
    @FXML
    private RadioButton halfmonth;
    @FXML
    private RadioButton month;

    @FXML
    private DatePicker datePicker;


    //@FXID of textfiled textArea
    @FXML
    private TextArea deliveryAddress;
    @FXML
    private TextField CompanyIDorCompanyName;
    @FXML
    private TextField POID;
    @FXML
    private TextField email;





    @FXML
    private Button SubmitButton;
    @FXML
    private Button BackButton;
    @FXML
    private Button checkBtn;


    @FXML
    public void checkBtnAction(ActionEvent event){
        if (ID.isSelected()){
            searchKey = "ID";
            System.out.println("search by ID"); }
        else if (Name.isSelected()){
            searchKey = "Name";
            System.out.println("search by Name");
        }else{
            System.out.println("Not Select");
        }
    }

    @FXML
    public void createBtnAction(ActionEvent event){
        System.out.println("Submit");
        System.out.println(deliveryAddress.getText());








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
//        databaseController.addToDatabase();

        //databaseController.databaseHandle();
    }
}
