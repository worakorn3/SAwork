package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPageController {
    @FXML
    private Button loginButton;
    @FXML
    private Button FindPageButton;
    @FXML
    private Button SOPageButton;
    @FXML
    private Button POPageButton;




    @FXML
    public void handlePOButton(ActionEvent event){
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle("Create PO");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("po.fxml"));
        try{
            stage.setScene(new Scene(loader.load(),800,600));
            POpageController controller = (POpageController) loader.getController();

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @FXML
    public void handleSOButton(ActionEvent event){
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle("Create SO");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("so.fxml"));
        try{
            stage.setScene(new Scene(loader.load(),800,600));
            SOpageController controller = (SOpageController) loader.getController();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void handleFindButton(ActionEvent event){
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle("Find PO/SO");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("findpage.fxml"));
        try{
            stage.setScene(new Scene(loader.load(),800,600));
            FindpageController controller = (FindpageController) loader.getController();

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @FXML
    public void handleCompanyButton(ActionEvent event){
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle("Create Company");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("company.fxml"));
        try{
            stage.setScene(new Scene(loader.load(),800,600));
            CompanyController controller = (CompanyController) loader.getController();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void handleEditButtonAction(ActionEvent e){
        Button b = (Button) e.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setTitle("Edit Company");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit.fxml"));
        try{
            stage.setScene(new Scene(loader.load(),800,600));
            EditController controller = (EditController) loader.getController();

        } catch (IOException e1){
            e1.printStackTrace();
        }
    }






}
