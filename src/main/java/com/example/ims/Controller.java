package com.example.ims;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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
    private Label errorMessageLabel1;

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
        if(usernameTextField1.getText().isBlank() == false && passwordTextField1.getText().isBlank() == false){
            //Validate Login
            validateLogin();
        } else if (usernameTextField1.getText().isBlank() == true && passwordTextField1.getText().isBlank() == false){
            errorMessageLabel1.setText("Please enter username!");
        } else if (usernameTextField1.getText().isBlank() == false && passwordTextField1.getText().isBlank() == true){
            errorMessageLabel1.setText("Please enter password!");
        } else {
            errorMessageLabel1.setText("Please enter username and password!");
        }
    }

    //Login helper method:
    public void validateLogin() throws IOException {
        Model connectNow = new Model();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM accounts WHERE username = '" + usernameTextField1.getText() + "' AND password = '" + passwordTextField1.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
                    stage = (Stage) loginButton.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    errorMessageLabel1.setText("Invalid login credentials! Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //CreateAccount.fxml
    @FXML
    private PasswordField passwordTextField2;

    @FXML
    private Button saveAccountButton;

    @FXML
    private TextField usernameTextField2;

    @FXML
    private Label errorMessageLabel2;

    @FXML
    void saveAccount(ActionEvent event) throws IOException {
        if(usernameTextField2.getText().isBlank() == false && passwordTextField2.getText().isBlank() == false){
            //Save Account
            saveAccount();
        } else if (usernameTextField2.getText().isBlank() == true && passwordTextField2.getText().isBlank() == false){
            errorMessageLabel2.setText("Please enter username!");
        } else if (usernameTextField2.getText().isBlank() == false && passwordTextField2.getText().isBlank() == true){
            errorMessageLabel2.setText("Please enter password!");
        } else {
            errorMessageLabel2.setText("Please enter username and password!");
        }
    }

    //Save Account helper method:
    public void saveAccount() throws IOException {
        Model connectNow = new Model();
        Connection connectDB = connectNow.getConnection();

        String username = usernameTextField2.getText();
        String password = passwordTextField2.getText();

        String accountExists = "SELECT count(1) FROM accounts WHERE username = '" + username + "'";
        String insertFields = "INSERT INTO accounts(username, password) VALUES('" + username + "', '" + password + "')";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(accountExists);

            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    errorMessageLabel2.setText("Username is in use! Try a different username.");
                } else {
                    statement.executeUpdate(insertFields);
                    root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                    stage = (Stage) saveAccountButton.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Inventory.fxml
    @FXML
    private ChoiceBox<String> categoryChoiceBox;

    @FXML
    private TableColumn<Product, String> columnCategory;

    @FXML
    private TableColumn<?, String> columnID;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnPrice;

    @FXML
    private TableColumn<?, ?> columnQuantity;

    @FXML
    private Button deleteProductButton;

    @FXML
    private Button manageAddProductButton;

    @FXML
    private Button manageCategoriesButton;

    @FXML
    private Button manageUpdateProductButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<Product> inventoryTableView;

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
    private ChoiceBox<String> categoryChoiceBox1;

    @FXML
    void addProduct(ActionEvent event) throws IOException {
//        Model connectNow = new Model();
//        Connection connectDB = connectNow.getConnection();
//
//        String productName = productNameTextField1.getText();
//        String productPrice = productPriceTextField1.getText();
//        String productQuantity = productQuantityTextField1.getText();
//        String category = categoryChoiceBox1.getValue().toString();
//
//        ObservableList<String> categories = FXCollections.observableArrayList();
//        categories.add("None");
//        categoryChoiceBox1.setValue("None");
//
//        String productExists = "SELECT count(1) FROM ims.inventory WHERE username = '" + productName + "'";
//        String insertFields;
//        if(category == null){
//            insertFields = "INSERT INTO ims.inventory(productName, price, quantity) VALUES('" + productName + "', '" + productPrice + "' + '" + productQuantity + "')";
//        } else {
//            insertFields = "INSERT INTO ims.inventory(productName, price, quantity, category) VALUES('" + productName + "', '" + productPrice + "' + '" + productQuantity + "' + '" + category + "')";
//        }
//
//        try {
//            Statement statement = connectDB.createStatement();
//            ResultSet queryResult = statement.executeQuery(productExists);
//
//            while(queryResult.next()){
//                if(queryResult.getInt(1) == 1){
//                    errorMessageLabel2.setText("Username is in use! Try a different username.");
//                } else {
//                    statement.executeUpdate(insertFields);
                    root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
                    stage = (Stage) addProductButton.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
//        Model connectNow = new Model();
//        Connection connectDB = connectNow.getConnection();
//
//        String productName = productNameTextField2.getText();
//        String productPrice = productPriceTextField2.getText();
//        String productQuantity = productQuantityTextField2.getText();
//
//        String productExists = "SELECT count(1) FROM ims.inventory WHERE username = '" + productName + "'";
//        String updateFields = "UPDATE ims.inventory SET price = '" + productPrice + "', quantity = '" + productQuantity + "' WHERE productName = '" + productName + "'";
//
//        try {
//            Statement statement = connectDB.createStatement();
//            ResultSet queryResult = statement.executeQuery(productExists);
//
//            while(queryResult.next()){
//                if(queryResult.getInt(1) == 1){
//                    statement.executeUpdate(updateFields);
                    root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
                    stage = (Stage) updateProductButton.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
//                } else {
//                    errorMessageLabel2.setText("Product does not exist! Please try again.");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
    void addCategory(ActionEvent event) throws IOException {
//        Model connectNow = new Model();
//        Connection connectDB = connectNow.getConnection();
//
//        String newCategoryName = newCategoryNameTextField.getText();
//
//        String categoryExists = "SELECT count(1) FROM ims.categories WHERE category = '" + newCategoryName + "'";
//        String insertFields = "INSERT INTO ims.categories(Name) VALUES('" + newCategoryName + "')";
//
//        try {
//            Statement statement = connectDB.createStatement();
//            ResultSet queryResult = statement.executeQuery(categoryExists);
//
//            while(queryResult.next()){
//                if(queryResult.getInt(1) == 1){
//                    errorMessageLabel2.setText("Category already exists! Try a different category name.");
//                } else {
//                    statement.executeUpdate(insertFields);
                    root = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
                    stage = (Stage) addCategoryButton.getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initialize Inventory Table (TableView)
        Model connectNow = new Model();
        Connection connectDB = connectNow.getConnection();

        String query = "SELECT * FROM inventory";

        ObservableList<Product> products = FXCollections.observableArrayList();

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            while(queryResult.next()){
                columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
                columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
                columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
                columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                columnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));

                products.add(new Product(queryResult.getInt("productID"), queryResult.getString("productName"), queryResult.getDouble("price"), queryResult.getInt("quantity"), queryResult.getString("category")));
            }

            inventoryTableView.setItems(products);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Initialize Category ChoiceBox
//        String query2 = "SELECT * FROM categories";
//          try{
//            ObservableList<String> categories = FXCollections.observableArrayList();
//            categories.add("None");
//            categoryChoiceBox1.setItems(categories);
//            categoryChoiceBox1.setValue("None");
    }
}