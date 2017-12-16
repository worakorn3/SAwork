package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class EditController {
    private String strCompID,strCompName, strAddress,strEmail,strFax,strTaxNO,strPhone;


    @FXML
    private TextField compID;
    @FXML
    private TextField compName;
    @FXML
    private TextField address;
    @FXML
    private TextField email;
    @FXML
    private TextField fax;
    @FXML
    private TextField taxNO;
    @FXML
    private TextField phone;

    private DBType select = DBType.SELECT;
    private DBType update = DBType.UPDATE;

    @FXML
    public void searchBtnAction(ActionEvent event){
        DatabaseController dbController = new DatabaseController(select);
        strCompID = compID.getText() ;
        strCompName = compName.getText();
//        System.out.println(strCompID);
        String sqlStatement = "SELECT * "+
                "FROM Companies "+
                "WHERE Company_ID="+"\""+strCompID+"\" "+
                "AND Company_Name="+"\""+strCompName+"\"";
        // if any field is empty
        if (strCompID.equals("") || strCompName.equals("")){
            // Popup Warning
            System.out.println("Please fill both Company ID and Company Name fields.");
            dbController.close();
        } else { // no field is empty
            dbController.execute(sqlStatement);
                email.setText(dbController.getEmail());
                address.setText(dbController.getAddr());
                fax.setText(dbController.getFax());
                taxNO.setText(dbController.getTaxNO());
                phone.setText(dbController.getPhone());
                System.out.println("Output: ");

        }
        System.out.println("search");
    }
    @FXML
    public void saveBtnAction(ActionEvent event){
        strAddress = address.getText();
        strEmail = email.getText();
        strFax = fax.getText();
        strTaxNO = taxNO.getText();
        strPhone = phone.getText();
        System.out.println(":"+address.toString()+email+fax+taxNO+phone);
    }
    @FXML
    public void handleBackButtonAction(ActionEvent e){
        Button b = (Button) e.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setTitle("Main Menu");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("firstpage.fxml"));
        try{
            stage.setScene(new Scene(loader.load(),800,600));
            FirstPageController controller = (FirstPageController) loader.getController();

        } catch (IOException e1){
            e1.printStackTrace();
        }
    }
}
