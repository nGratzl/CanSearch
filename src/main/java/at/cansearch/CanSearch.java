package at.cansearch;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class CanSearch extends Application {





    //File ordner = new File("C:\\Users\\prakt\\Documents\\Dosen_Fotos_small");
    FlowPane layout = new FlowPane(10, 10);
    ScrollPane scrollPane = new ScrollPane(layout);

    Label outputLabel = new Label();
    //ArrayList<String> ergebnisse = new ArrayList();



    Button button;
    String sucheingabe;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label ueberschrift = new Label("u Can search");
        ueberschrift.setFont(Font.font("Roboto Serif", FontWeight.BOLD, 30));

        Label textsuche = new Label("Textsuche: ");
        textsuche.setFont(Font.font("Roboto Serif", 20));

        //Label kategorien = new Label("Kategorien:");
        //kategorien.setFont(Font.font("Roboto Serif", 20));










            primaryStage.setTitle("uCanSearch-Databank");
            TextField textField = new TextField();
            textField.setPromptText("Nach welchem Begriff soll gesucht werden");
            button = new Button();
            button.setText("Suchen");
        URL resource = getClass().getResource("/images");
        File ordner = new File(Objects.requireNonNull(resource).toURI());

        button.setOnAction(e -> {
                layout.getChildren().clear();

                sucheingabe = textField.getText();

                if (ordner.exists() && ordner.isDirectory()) {
                    File[] dateien = ordner.listFiles();
                    if (dateien != null) {
                        for (File datei : dateien) {
                            if ((datei.getName().toLowerCase()).contains(sucheingabe.toLowerCase())) {
                                Image image = new Image(datei.toURI().toString());
                                ImageView imageView = new ImageView(image);
                                imageView.setPreserveRatio(true);
                                imageView.setFitWidth(200);
                                layout.getChildren().add(imageView);

                            }
                        }
                        //outputLabel.setText(ergebnisse.toString().replace(' ', '\n').replace("[", "").replace("]", ""));
                    }
                }
            });
        //layout.prefWidthProperty().bind(Bindings.add(-5, scrollPane.widthProperty()));
        //layout.prefHeightProperty().bind(Bindings.add(-5, scrollPane.heightProperty()));
        scrollPane.setFitToWidth(true);    // Inhalt füllt Breite
        scrollPane.setFitToHeight(true);
        //scrollPane.setPrefHeight(400);

        scrollPane.setContent(layout);


        VBox root = new VBox(10, textField, layout);

            scrollPane.setStyle("-fx-padding: 20; -fx-alignment: center;");
            layout.getChildren().add( outputLabel);
            root.getChildren().addAll(scrollPane);
        VBox inhalt = new VBox(10);
        inhalt.setPadding(new Insets(20));
        inhalt.setAlignment(Pos.TOP_LEFT);

        inhalt.getChildren().addAll(
                ueberschrift,
                textsuche, textField,
                button,
                //kategorien,
                scrollPane
        );

            Scene scene = new Scene(inhalt, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        }


    }



/*
public class Main {

    public static void main(String[] args) {
        File ordner = new File("C:\\Users\\prakt\\Documents\\Dosen_Fotos"); // z. B. "C:/Users/DeinName/Desktop"
        Scanner scan = new Scanner(System.in);
        System.out.println("Nach was soll gesucht werden?");
        String sucheingabe = scan.next();

        if (ordner.exists() && ordner.isDirectory()) {
            File[] dateien = ordner.listFiles();

            if (dateien != null) {
                for (File datei : dateien) {
                    if (datei.isFile() && datei.getName().contains(sucheingabe)) {
                        System.out.println(datei.getName());
                    }
                }
            } else {
                System.out.println("Ordner ist leer");
            }
        } else {
            System.out.println("Pfad existiert nicht");
        }
    }
}
*/

