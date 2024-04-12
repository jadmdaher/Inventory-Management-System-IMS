package com.example.ims;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    private Parent root;

    private Stage stage;

    private Scene scene;

    //Login.fxml
    @FXML
    private Button createAccountButton;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTextField1;

    @FXML
    private TextField usernameTextField1;

    @FXML
    void createAccount(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        stage = (Stage) createAccountButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
        stage = (Stage) loginButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //CreateAccount.fxml
    @FXML
    private PasswordField passwordTextField2;

    @FXML
    private Button saveAccountButton;

    @FXML
    private TextField usernameTextField2;

    @FXML
    void saveAccount(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) saveAccountButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Inventory.fxml
    @FXML
    private Button manageAddProductButton;

    @FXML
    private ChoiceBox<?> categoryChoiceBox;

    @FXML
    private Button deleteProductButton;

    @FXML
    private Button manageCategoriesButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button manageUpdateProductButton;

    @FXML
    void manageAddProduct(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        stage = (Stage) manageAddProductButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deleteProduct(ActionEvent event) {

    }

    @FXML
    void manageCategories(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ManageCategories.fxml"));
        stage = (Stage) manageCategoriesButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void manageUpdateProduct(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UpdateProduct.fxml"));
        stage = (Stage) manageUpdateProductButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //AddProduct.fxml
    @FXML
    private Button addProductButton;

    @FXML
    private TextField productNameTextField1;

    @FXML
    private TextField productPriceTextField1;

    @FXML
    private TextField productQuantityTextField1;

    @FXML
    void addProduct(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
        stage = (Stage) addProductButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //UpdateProduct.fxml
    @FXML
    private TextField productNameTextField2;

    @FXML
    private TextField productPriceTextField2;

    @FXML
    private TextField productQuantityTextField2;

    @FXML
    private Button updateProductButton;

    @FXML
    void updateProduct(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
        stage = (Stage) updateProductButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //ManageCategories.fxml
    @FXML
    private Button addCategoryButton;

    @FXML
    private Button deleteCategoryButton;

    @FXML
    private TextField newCategoryNameTextField;

    @FXML
    private ChoiceBox<?> selectCategoryToDeleteChoiceBox;

    @FXML
    private ChoiceBox<?> selectCategoryToUpdateChoiceBox;

    @FXML
    private Button updateCategoryButton;

    @FXML
    private TextField updatedCategoryNameTextField;

    @FXML
    private Button returnButton;

    @FXML
    void addCategory(ActionEvent event) {

    }

    @FXML
    void deleteCategory(ActionEvent event) {

    }

    @FXML
    void updateCategory(ActionEvent event) {

    }

    @FXML
    void returnToInventory(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
        stage = (Stage) returnButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}