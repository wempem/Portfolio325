/**
 *  Creator : Matthew Wempe
 *  Program Title: FitnessGUI
 *  Creation Date: 4/13/2017
 *  Last Date Modified: 4/25/2017
 *  CSCI COURSE: CSCI-325 Obejct Oriented Programming
 *  Grade Recieved: A
 *  Comments: The program was coded in Java and is best compiled with a Java IDE such as Intellij or NetBeans.
 *            Unfortunately, with my outdated code I could not get my code to be run off an executable but works fine
 *            in my Intellij.
 */

package Fitness;

// Imported libraries are listed below

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;


public class FitnessGUI extends Application{
    // main function
    public static void main(String[] args) {
        launch(args);
    }

    // objects are created
    private Button btnscene1, btnscene2;
    private Scene scene1, scene2;
    private Stage thestage;
    private String userChoice, userChoice2;
    private String[] imageArray = new String[2];
    private String[] exerciseArray = new String[2];
    //Primary stage is set
    @Override
    public void start(Stage primaryStage) throws Exception {

        // music file for background
        String musicFile = "mp3.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);

        //grid made with scene and buttons
        GridPane grid = new GridPane();
        scene1 = new Scene(grid, 530, 400);
        btnscene1 = new Button("Submit");
        btnscene2 = new Button("Go Back");

        //added image to button
        Button button = new Button();
        Image buttonImage = new Image("https://i.ytimg.com/vi/p7UGysLNnVQ/hqdefault.jpg");
        ImageView imageView = new ImageView(buttonImage);

        //added button action
        btnscene1.setOnAction(e-> ButtonClicked(e));
        btnscene2.setOnAction(e-> ButtonClicked(e));

        thestage = primaryStage;
        // drop down box to select which part of the body to workout
        final ComboBox<String> emailComboBox = new ComboBox();
        emailComboBox.getItems().addAll(
                "Upper",
                "Lower",
                "Core",
                "Cardio"
        );

        //Upper set as default
        emailComboBox.setValue("Upper");

        //intensity seleciton with a drop down box
        final ComboBox<String> priorityComboBox = new ComboBox();
        priorityComboBox.getItems().addAll(
                "1",
                "2",
                "3",
                "4",
                "5"
        );

        //default value of drop down set to 1
        priorityComboBox.setValue("1");

        // grid gaps being set
        grid.setVgap(4);
        grid.setHgap(10);
        // background display
        grid.setStyle("-fx-background-image: url('https://s-media-cache-ak0.pinimg.com/originals/79/98/b9/7998b934a2c30eb6b0bf02d056911ccb.jpg'); -fx-background-repeat: no-repeat;");

        //padding set
        grid.setPadding(new Insets(5, 5, 5, 5));

        // Area to Focus added to emailComboBox
        grid.add(new Label("Area to Focus: "), 6, 1);

        // Level added to priorityComboBoc
        grid.add(new Label("Level: "), 6, 2);
        // ComboBoxes added to the grid
        grid.add(emailComboBox, 7, 1);
        grid.add(priorityComboBox, 7, 2);

        //btnscene1 and button added to grid
        grid.add(btnscene1, 7, 6);
        grid.add(button, 0, 0);

        //setting the size of imageView in preparation of button.setAction
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        button.setGraphic(imageView);

        // actionEvent for song to played when clicked
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer.play();
            }
        });

        // actionEvent for new scene to be displayed
        btnscene1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                // userChoice and userChoice 2 are collected from the comboBoces
                userChoice = emailComboBox.getSelectionModel().getSelectedItem();
                userChoice2 = priorityComboBox.getSelectionModel().getSelectedItem();
                //print out statment to verify where the user is going
                System.out.println(userChoice + " " + userChoice2);

                // objects being created
                ToggleButton toggle1 = new ToggleButton();
                ToggleButton toggle2 = new ToggleButton();
                Image unselected = new Image("http://res.freestockphotos.biz/pictures/15/15107-illustration-of-a-red-close-button-pv.png");
                Image selected = new Image("http://www.iconsdb.com/icons/preview/green/check-mark-8-xxl.png");
                Image unselected1 = new Image("http://res.freestockphotos.biz/pictures/15/15107-illustration-of-a-red-close-button-pv.png");
                Image selected1 = new Image("http://www.iconsdb.com/icons/preview/green/check-mark-8-xxl.png");
                ImageView toggleImage = new ImageView();
                ImageView toggleImage1 = new ImageView();
                GridPane grid2 = new GridPane();
                Label workoutArea = new Label("");
                Label level = new Label("");
                //new scene being created
                scene2 = new Scene(grid2, 530, 400);

                //setImage being called to grab which image needs to be used
                setImage(userChoice, imageArray);
                //setWorkout is grabbing the correct workout
                setWorkout(userChoice, userChoice2, exerciseArray);
                // workoutArea will be set by whatever setText brings back
                workoutArea.setText(setArea(userChoice));
                //level will be chosen by userChoice2
                level.setText(setLevel(userChoice2));

                // new objects being created
                Image workoutImage = new Image(imageArray[0]);
                Image workoutImage2 = new Image(imageArray[1]);
                Label exercise1 = new Label(exerciseArray[0]);
                Label exercise2 = new Label(exerciseArray[1]);

                ImageView imageView1 = new ImageView(workoutImage);
                ImageView imageView2 = new ImageView(workoutImage2);

                // heights and widths being adjusted
                imageView1.setFitHeight(175);
                imageView1.setFitWidth(175);

                imageView2.setFitHeight(175);
                imageView2.setFitWidth(175);

                toggleImage.setFitWidth(50);
                toggleImage.setFitHeight(50);

                toggleImage1.setFitWidth(50);
                toggleImage1.setFitHeight(50);

                toggle1.setGraphic(toggleImage);
                toggle2.setGraphic(toggleImage1);

                // toggle buttons being told how to behave. Switching back and forth between images when selected each time
                toggleImage.imageProperty().bind(Bindings
                        .when(toggle1.selectedProperty())
                        .then(selected)
                        .otherwise(unselected)
                );
                toggleImage1.imageProperty().bind(Bindings
                        .when(toggle2.selectedProperty())
                        .then(selected1)
                        .otherwise(unselected1)
                );

                // grid 2 being set
                grid2.setVgap(5);
                grid2.setHgap(10);
                grid2.setPadding(new Insets(5, 5, 5, 5));

                // everything being added to grid2
                grid2.add(btnscene2, 0, 20);
                grid2.add(workoutArea, 0, 0);
                grid2.add(level, 1, 0);
                grid2.add(exercise1 , 1, 7);
                grid2.add(exercise2 , 2, 7);
                grid2.add(imageView1, 1, 8);
                grid2.add(imageView2, 2, 8);
                grid2.add(toggle1, 1,9);

                // cardio gets it's own special page
                if(userChoice != "Cardio")
                    grid2.add(toggle2, 2,9);

                if (e.getSource()==btnscene1)
                    thestage.setScene(scene2);
                else
                    thestage.setScene(scene1);

            }});
        // Title beign displayed on Primary Stage
        primaryStage.setTitle("Fitness Tracker");
        primaryStage.setScene(scene1);
        // stage is shown
        primaryStage.show();

    }
    // function that switches back and forth between scenes
    private void ButtonClicked(ActionEvent e)
    {
        if (e.getSource()==btnscene1)
            thestage.setScene(scene2);
        else
            thestage.setScene(scene1);
    }
    // setWorkout sets the correct text to be used for each different workout
    private void setWorkout (String workout, String level, String[] exerciseArray){
        switch(workout){
            case "Upper":
                switch(level){
                    case "1":
                        exerciseArray[0] = "15 push ups";
                        exerciseArray[1] = "15 pull ups";
                        break;
                    case "2":
                        exerciseArray[0] = "30 push ups";
                        exerciseArray[1] = "30 pull ups";
                        break;
                    case "3":
                        exerciseArray[0] = "45 push ups";
                        exerciseArray[1] = "45 pull ups";
                        break;
                    case "4":
                        exerciseArray[0] = "60 push ups";
                        exerciseArray[1] = "60 pull ups";
                        break;
                    case "5":
                        exerciseArray[0] = "75 push ups";
                        exerciseArray[1] = "75 pull ups";
                        break;
                    default:
                        exerciseArray[0] = "Didn't Work";
                        exerciseArray[1] = "";
                        break;
                }
                break;
            case "Lower":

                switch(level){
                    case "1":
                        exerciseArray[0] = "15 squats";
                        exerciseArray[1] = "15 lunges";
                        break;
                    case "2":
                        exerciseArray[0] = "30 squats";
                        exerciseArray[1] = "30 lunges";
                        break;
                    case "3":
                        exerciseArray[0] = "45 squats";
                        exerciseArray[1] = "45 lunges";
                        break;
                    case "4":
                        exerciseArray[0] = "60 squats";
                        exerciseArray[1] = "60 lunges";
                        break;
                    case "5":
                        exerciseArray[0] = "75 squats";
                        exerciseArray[1] = "75 lunges";
                        break;
                    default:
                        exerciseArray[0] = "Didn't Work";
                        exerciseArray[1] = "";
                        break;
                }
                break;
            case "Cardio":

                switch(level){
                    case "1":
                        exerciseArray[0] = "1 Mile Steady Jog";
                        exerciseArray[1] = "";
                        break;
                    case "2":
                        exerciseArray[0] = "2 Mile Steady Jog";
                        exerciseArray[1] = "";
                        break;
                    case "3":
                        exerciseArray[0] = "3 Mile Steady Jog";
                        exerciseArray[1] = "";
                        break;
                    case "4":
                        exerciseArray[0] = "4 Mile Steady Jog";
                        exerciseArray[1] = "";
                        break;
                    case "5":
                        exerciseArray[0] = "5 Mile Steady Jog";
                        exerciseArray[1] = "";
                        break;
                    default:
                        exerciseArray[0] = "Go run a marathon";
                        exerciseArray[1] = "";
                        break;
                }
                break;
            case "Core":

                switch(level){
                    case "1":
                        exerciseArray[0] = "20 sit ups";
                        exerciseArray[1] = "30 second plank";
                        break;
                    case "2":
                        exerciseArray[0] = "40 sit ups";
                        exerciseArray[1] = "60 second plank";
                        break;
                    case "3":
                        exerciseArray[0] = "60 sit ups";
                        exerciseArray[1] = "100 second plank";
                        break;
                    case "4":
                        exerciseArray[0] = "80 sit ups";
                        exerciseArray[1] = "150 second plank";
                        break;
                    case "5":
                        exerciseArray[0] = "100 sit ups";
                        exerciseArray[1] = "210 second plank";
                        break;
                    default:
                        exerciseArray[0] = "Didn't Work";
                        exerciseArray[1] = "";
                        break;
                }
                break;
        }
    }
    // setLevel sets the correct text for the level/intensity that will be chosen
    private String setLevel(String level){
        level = "Level: " + level;

        return level;
    }
    // setArea returns string for area of body that is being used
    private String setArea(String area) {
        switch (userChoice) {
            case "Upper":
            case "Lower":
                area += " Body Workout";
                break;
            case "Cardio":
            case "Core":
                area += " Workout";
                break;
            default:
                area += "Something ain't right";
                break;
        }

        return area;
    }
    //setImage updated the imageArray to use the correct images for the workout
    private void setImage(String area, String[] imageArray){
        switch (area){
            case "Upper":
                imageArray[0] = "https://yurielkaim.com/wp-content/uploads/2013/07/Advanced-Push-up-Variations-Traditional-Push-up.jpg";
                imageArray[1] = "http://cdn-mf0.heartyhosting.com/sites/mensfitness.com/files/rookie-mistakes-the-pullup-main.jpg";
                break;
            case "Lower":
                imageArray[0] = "http://t2conline.com/wp-content/uploads/2017/01/correct-squat-tips.jpg";
                imageArray[1] = "http://3i133rqau023qjc1k3txdvr1.wpengine.netdna-cdn.com/wp-content/uploads/2014/08/Alternating-Forward-Lunges_Exercise.jpg";
                break;
            case "Cardio":
                imageArray[0] = "https://media.tenor.co/images/7c055ab2ba5746039696b98bae0953ed/tenor.gif";
                imageArray[1] = "https://everydaylisamae.files.wordpress.com/2015/02/running.jpg";
                break;
            case "Core":
                imageArray[0] = "http://68.media.tumblr.com/586bae1d9492345315b7a066c69287cb/tumblr_inline_mx42q8LFnF1rdu2za.jpg";
                imageArray[1] = "http://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/articles/health_tools/diabetes_strength_training_slideshow/getty_rm_photo_of_woman_doing_plank.jpg";
                break;
            default:
                imageArray[0] = "http://www.womenshealthmag.com/sites/womenshealthmag.com/files/styles/slideshow-desktop/public/images/slide2-bweight-squat.jpg?itok=nGvYxHiX";
                imageArray[1] = "http://www.womenshealthmag.com/sites/womenshealthmag.com/files/styles/slideshow-desktop/public/images/slide8dbell-split-squat.jpg?itok=5Ic6dU_-";
                break;
        }

    }
}