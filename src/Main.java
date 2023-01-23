import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Main extends Application {

    //Save the Array List
    ArrayList<Image> imageList;

    public Main() throws FileNotFoundException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Photo Viewer App");

        //ImageViewer
        ImageView imageView = new ImageView();

        //Create the Array List
        imageList = new ArrayList();

        //Adding this first image into the array list
        Image image1 = new Image(new FileInputStream("flowerforest.png"));
        imageList.add(image1);
        imageView.setImage(image1);

        //Adding the second image to the array list
        Image image2 = new Image(new FileInputStream("treeroute.jpeg"));
        imageList.add(image2);

        Image image3 = new Image(new FileInputStream("mountains.jpeg"));
        imageList.add(image3);

        Image image4 = new Image(new FileInputStream("canyon.jpeg"));
        imageList.add(image4);

        Image image5 = new Image(new FileInputStream("snowroad.jpeg"));
        imageList.add(image5);


        HBox hbox1 = new HBox(imageView);

        //FileChooser
        FileChooser fileChooser = new FileChooser();

        Button button = new Button("Add Images");
        button.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);

            Image userImage = null;
            try {
                userImage = new Image(new FileInputStream(selectedFile));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            imageList.add(userImage);
        });


        ChoiceBox choiceBox = new ChoiceBox();

        choiceBox.getItems().add("Flower Forest");
        choiceBox.getItems().add("Tree Route");
        choiceBox.getItems().add("Mountains");
        choiceBox.getItems().add("Canyon");
        choiceBox.getItems().add("Snow Road");
        choiceBox.getItems().add("User Image");

        choiceBox.setOnAction(actionEvent -> {
            int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
            Image selectedImage = imageList.get(selectedIndex);
            imageView.setImage(selectedImage);
        });

        VBox vbox2 = new VBox(choiceBox);


        //Button to change the picture
        Button buttonNext = new Button("Press Me!");
        buttonNext.setOnAction(actionEvent ->  {
            imageView.setImage(image3);
        });
        VBox vbox3 = new VBox(buttonNext);

        hbox1.setAlignment(Pos.CENTER);
        VBox vBox1 = new VBox(button);
        HBox myHbox = new HBox(40, hbox1, vBox1,vbox2,vbox3);
        Scene scene = new Scene(myHbox, 1300, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}