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
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CanSearch extends Application {


    //File ordner = new File("C:\\Users\\prakt\\Documents\\Dosen_Fotos_small");
    FlowPane layout = new FlowPane(10, 10);
    ScrollPane scrollPane = new ScrollPane(layout);

    List<Can> cans = new ArrayList<>();

    Label outputLabel = new Label();


    Button button;
    String sucheingabe;
    Button name;
    Button form;
    Button geschmack;
    Button farbe;
    Button land;
    Button kontinent;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label ueberschrift = new Label("u Can search\n\n");
        ueberschrift.setFont(Font.font("Roboto Serif", FontWeight.BOLD, 45));

        Label textsuche = new Label("Textsuche: ");
        textsuche.setFont(Font.font("Roboto Serif", 30));
        Label kategorienueberschrift = new Label("Kategorien: ");
        kategorienueberschrift.setFont(Font.font("Roboto Serif", 20));

        //Label kategorien = new Label("Kategorien:");
        //kategorien.setFont(Font.font("Roboto Serif", 20));


        name = new Button();
        name.setText("Name");
        form = new Button();
        form.setText("Form");
        geschmack = new Button();
        geschmack.setText("Geschmack");
        farbe = new Button();
        farbe.setText("Farbe");
        land = new Button();
        land.setText("Land");
        kontinent = new Button();
        kontinent.setText("Kontinent");


        primaryStage.setTitle("uCanSearch-Databank");
        TextField textField = new TextField();
        textField.setPromptText("Nach welchem Begriff soll gesucht werden");
        textField.setStyle("-fx-font-size: 20 px;");
        textField.setPrefHeight(40);
        textField.setPrefWidth(500);
        button = new Button();
        button.setText("Suchen");
        button.setStyle("-fx-font-size: 20px;");
        button.setPrefWidth(130);
        button.setPrefHeight(40);

        loadCans();



        button.setOnAction(e -> {
            layout.getChildren().clear();

            sucheingabe = textField.getText();

            for (Can can : cans) {
                if ((can.name().toLowerCase()).contains(sucheingabe.toLowerCase())) {
                    Image image = new Image(can.path());
                    ImageView imageView = new ImageView(image);
                    imageView.setPreserveRatio(true);
                    imageView.setFitWidth(200);
                    layout.getChildren().add(imageView);

                }
            }

                    //outputLabel.setText(ergebnisse.toString().replace(' ', '\n').replace("[", "").replace("]", ""));


        });
        //layout.prefWidthProperty().bind(Bindings.add(-5, scrollPane.widthProperty()));
        //layout.prefHeightProperty().bind(Bindings.add(-5, scrollPane.heightProperty()));
        scrollPane.setFitToWidth(true);    // Inhalt füllt Breite
        scrollPane.setFitToHeight(true);
        //scrollPane.setPrefHeight(400);

        scrollPane.setContent(layout);


        VBox root = new VBox(10, textField, layout);

        scrollPane.setStyle("-fx-padding: 20; -fx-alignment: center;");
        layout.getChildren().add(outputLabel);
        root.getChildren().addAll(scrollPane);
        HBox texteingabe = new HBox(20);
        texteingabe.getChildren().addAll(textsuche, textField, button);
        HBox kategorien = new HBox(10);
        kategorien.getChildren().addAll(name, form, geschmack, farbe, land, kontinent);
        VBox inhalt = new VBox(10);
        inhalt.setPadding(new Insets(20));
        inhalt.setAlignment(Pos.TOP_LEFT);

        inhalt.getChildren().addAll(
                ueberschrift,
                texteingabe,
                kategorienueberschrift,
                kategorien,
                scrollPane
        );

        Scene scene = new Scene(inhalt, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadCans() {
        URL resource = getClass().getResource("/images");
        try {
            File ordner = new File(Objects.requireNonNull(resource).toURI());
            if (ordner.exists() && ordner.isDirectory()) {
                File[] dateien = ordner.listFiles();
                for (File file : Objects.requireNonNull(dateien)) {
                    cans.add(new Can(file.getName(), file.toURI().toString()));
                }

            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


}
