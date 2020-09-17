package com.anshuman;

        import javafx.application.Application;
        import javafx.application.Platform;
        import javafx.fxml.FXMLLoader;

        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;


public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayGround();
        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.setTitle("Connect Four");
        primaryStage.show();

    }

    private MenuBar createMenu() {
        Menu fileMenu = new Menu("File");
        MenuItem newFileMenu = new MenuItem("New Game");
        newFileMenu.setOnAction(event -> controller.resetGame());
        MenuItem resetFileMenu = new MenuItem("Reset Game");
        resetFileMenu.setOnAction(event -> controller.resetGame());
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitFileMenu = new MenuItem("Exit Game");
        exitFileMenu.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newFileMenu, resetFileMenu, separatorMenuItem, exitFileMenu);

        Menu aboutMenu = new Menu("About");
        MenuItem aboutUsMenu = new MenuItem("About Us");
        aboutUsMenu.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About The Developer");
            alert.setHeaderText("Anshuman Singh");
            alert.setContentText("This game is developed by Anshuman Singh. Feel free to express your views about the game. Share this game among your friends.\n ");
            alert.show();
        });
        MenuItem aboutConnect4Menu = new MenuItem("About Connect Four");
        aboutConnect4Menu.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About Connect Four");
            alert.setHeaderText("How To Play");
            alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
            alert.show();
        });
        aboutMenu.getItems().addAll(aboutUsMenu, aboutConnect4Menu);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, aboutMenu);
        return menuBar;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
