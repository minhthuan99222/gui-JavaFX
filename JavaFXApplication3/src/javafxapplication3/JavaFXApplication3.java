/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;  
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;


/**
 *
 * @author Minh Thuan
 */
public class JavaFXApplication3 extends Application {
    ImageView myImageView;
    ImageView logo;
    Button btnSearch;
    Button btnLoad;
    TextField TfInput;
    Image imageInput;
    StackPane root;
    ScrollPane sp;
    TableView table;
    boolean check = false;
    
    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException {
        Group group = new Group();
        HBox box = new HBox();
        sp = new ScrollPane();
        table = new TableView();
        if(check == false){
            table = getTableView();
            table.setMaxSize(0,0);
            table.setTranslateX(-430);
            table.setTranslateY(700);
        }
            
        
        myImageView = new ImageView();

        
        btnLoad = new Button();
        btnLoad.setText("...");
        btnLoad.setTranslateX(-29);
        btnLoad.setTranslateY(100);
        btnLoad.setOnAction(btnLoadEventListener);
        
        logo = new ImageView();
        logo.setImage(new Image("logo2.png"));
        logo.setTranslateX(206);
        logo.setTranslateY(30);
        logo.setFitHeight(170);
        logo.setFitWidth(270);
        
        
        btnSearch = new Button();
        btnSearch.setText("Search");
        btnSearch.setTranslateX(456);
        btnSearch.setTranslateY(100);
        btnSearch.setOnAction(btnSearchEvent);
        
        
        TfInput = new TextField();
        TfInput.setMinWidth(440);
        TfInput.setTranslateX(206);
        TfInput.setTranslateY(100);
        TfInput.setOnDragOver(TfInputDragOver);   
        TfInput.setOnDragDropped(TfInputDragDropped);
        
        
        
        root = new StackPane();
        box.getChildren().addAll(root,table);
        root.getChildren().addAll(btnLoad, btnSearch,TfInput,myImageView, logo);
        
        group.getChildren().add(box);
        sp.setContent(group);
        
        sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        
        Scene scene = new Scene(sp, 885, 600);
        
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.setTitle("iSearch");
        primaryStage.setScene(scene);
        primaryStage.setMaxWidth(900);
        //primaryStage.setMaxHeight(600);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    public TableView getTableView() throws IOException, InterruptedException{
        TableView<ListImage> table = new TableView<ListImage>(); 
        table.setTableMenuButtonVisible(true);
        
        /*
         * Creating the TableColumn for the TableView
         * The property value Factory name must match with the 
         * Generic Class's(ListImage's) property
         */
        TableColumn<ListImage,Pictures> pictures = new TableColumn<ListImage,Pictures>("List Of Image");
        pictures.setCellValueFactory(new PropertyValueFactory("pictures"));
        pictures.setPrefWidth(830); 
        
        
        // SETTING THE CELL FACTORY FOR THE ALBUM ART                 
        pictures.setCellFactory(new Callback<TableColumn<ListImage,Pictures>,TableCell<ListImage,Pictures>>(){        
            @Override
            public TableCell<ListImage, Pictures> call(TableColumn<ListImage, Pictures> param) {                
                TableCell<ListImage, Pictures> cell = new TableCell<ListImage, Pictures>(){
                    @Override
                    public void updateItem(Pictures item, boolean empty) {                        
                        if(item!=null){       
                           
                            
                            
                            HBox box = new HBox(); 
                            
                            
                            ImageView imageview1 = new ImageView();
                            imageview1.setFitHeight(150);
                            imageview1.setFitWidth(200);
                            imageview1.setTranslateX(0);
                            imageview1.setTranslateY(0);
                            imageview1.setImage(new Image(JavaFXApplication3.class.getResource("image").toString()+"/"+item.getPath1())); 
                            if(item.path4!=null){
                                ImageView imageview2 = new ImageView();
                                imageview2.setFitHeight(150);
                                imageview2.setFitWidth(200);
                                imageview2.setTranslateX(10);
                                imageview2.setImage(new Image(JavaFXApplication3.class.getResource("image").toString()+"/"+item.getPath2()));  

                                ImageView imageview3 = new ImageView();
                                imageview3.setFitHeight(150);
                                imageview3.setFitWidth(200);
                                imageview3.setTranslateX(20);
                                imageview3.setImage(new Image(JavaFXApplication3.class.getResource("image").toString()+"/"+item.getPath3()));  

                                ImageView imageview4 = new ImageView();
                                imageview4.setFitHeight(150);
                                imageview4.setFitWidth(200);
                                imageview4.setTranslateX(30);
                                imageview4.setImage(new Image(JavaFXApplication3.class.getResource("image").toString()+"/"+item.getPath4()));
                                box.getChildren().addAll(imageview1, imageview2, imageview3, imageview4);
                            }
                            else{
                                if(item.path3!=null){
                                    ImageView imageview2 = new ImageView();
                                    imageview2.setFitHeight(150);
                                    imageview2.setFitWidth(200);
                                    imageview2.setTranslateX(10);
                                    imageview2.setImage(new Image(JavaFXApplication3.class.getResource("image").toString()+"/"+item.getPath2()));  

                                    ImageView imageview3 = new ImageView();
                                    imageview3.setFitHeight(150);
                                    imageview3.setFitWidth(200);
                                    imageview3.setTranslateX(20);
                                    imageview3.setImage(new Image(JavaFXApplication3.class.getResource("image").toString()+"/"+item.getPath3()));
                                    
                                    box.getChildren().addAll(imageview1, imageview2, imageview3);
                                }
                                    else{
                                            if(item.path2!=null){
                                                ImageView imageview2 = new ImageView();
                                                imageview2.setFitHeight(150);
                                                imageview2.setFitWidth(200);
                                                imageview2.setTranslateX(10);
                                                imageview2.setImage(new Image(JavaFXApplication3.class.getResource("image").toString()+"/"+item.getPath2()));  
                                                box.getChildren().addAll(imageview1, imageview2);
                                            }
                                            else  box.getChildren().addAll(imageview1);
                                        }
                            }
                           
                            
                            
                            
                             
                            //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                            setGraphic(box);
                            
                        }
                    }
                };
                System.out.println(cell.getIndex());               
                return cell;
            }
            
        });        
        
        
        
        //ADDING ALL THE COLUMNS TO TABLEVIEW
        table.getColumns().addAll(pictures);     
        
        //ADDING ROWS INTO TABLEVIEW
        ObservableList<ListImage> listImage = getOservableListListImage();
        

        table.setItems(listImage); 
       
        return table;
    }
    // 
    

    //Clicked Event for Search Button       
    EventHandler<ActionEvent> btnSearchEvent 
    = new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            System.out.println("Searched");
            
            String x = TfInput.getText();
            System.out.println(x);
            
            File file = new File(x);
            if (file.exists()){
                System.out.println("exist");
                
                table.setMaxSize(830,150*10);
                table.setTranslateX(-420);
                check = true;
            }       
        }
    };
    
    
    //Read link in result.txt file
    public ArrayList<String> readFile(){
        ArrayList<String> s = new ArrayList<String>();
        try {
            //#### Link file đọc kết quả lưu ý là chỉ có tên của ảnh và ảnh được đặt trong folder image
            File f = new File("src/result.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
                s.add(readLine);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
    
    
    //#Thay đổi command line với tham số là ảnh input
    public void ExecutePy() throws IOException{
        String command = "python D:\\Code\\pythonScripts\\randomImage.py";
        Process p = Runtime.getRuntime().exec(command );
    }
    
    
    //DragEvent for TextField Input
    EventHandler<DragEvent> TfInputDragOver
    = new EventHandler<DragEvent>(){
        @Override
        public void handle(DragEvent event){
            Dragboard db = event.getDragboard();
            if (db.hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            } else {
                event.consume();
            }
        }
                
    };
    
   ///////Fix here
    EventHandler<DragEvent> TfInputDragDropped
    = new EventHandler<DragEvent>(){
        
        @Override
        public void handle(DragEvent event){
            if(check==true){
                
                try {  
                    table.setMaxSize(0,0);
                    table.setItems(getOservableListListImage());
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(JavaFXApplication3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JavaFXApplication3.class.getName()).log(Level.SEVERE, null, ex);
                }
                check = false;
            }
            
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasFiles()) {
                success = true;
                String filePath = null;
                for (File file:db.getFiles()) {
                    filePath = file.getAbsolutePath();
                    try {
                        BufferedImage bufferedImage = ImageIO.read(file);
                        String path = file.toString();
                        Image image = SwingFXUtils.toFXImage(bufferedImage,null);
                        imageInput = image;
                        double WidthView = image.getWidth();
                        double HeightView = image.getHeight();
                        while(WidthView > 250){
                            WidthView /= 2;
                            HeightView /= 2;

                        }
                        myImageView.setFitHeight(HeightView);
                        myImageView.setFitWidth(WidthView);
                        
                            
                        myImageView.setTranslateX(206);
                        myImageView.setTranslateY(100+HeightView);
                        TfInput.setText(path);
                        
                        myImageView.setImage(image);
        
                    }catch (IOException ex) {
                        Logger.getLogger(JavaFXApplication3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(filePath);
                }
                    
            }
            event.setDropCompleted(success);
            event.consume();
        }
        
        
    };
    
    
    public ObservableList<ListImage> getOservableListListImage() throws InterruptedException, IOException{
        ObservableList<ListImage> listImage = FXCollections.observableArrayList();
        ArrayList<String> imgs = new ArrayList<String>();
        ExecutePy();
        Thread.sleep(1000);
        imgs = readFile();
        System.out.println(imgs);
        int numOfImage = imgs.size();
        System.out.println(numOfImage);
        if (numOfImage>=4){
            int start = numOfImage/4*4;
            for(int i = 0; i<= start-4; i+=4){
                Pictures ps = new Pictures(imgs.get(i),imgs.get(i+1),imgs.get(i+2),imgs.get(i+3)); 
                ListImage li = new ListImage(ps); 
                listImage.add(li); 
                System.out.println("sssssssssssssss");
            }  
        }
        int start = numOfImage/4*4;
        numOfImage%=4;
        Pictures ps;
        ListImage li;
        switch(numOfImage){
            case 0:
                break;
            case 1:
                ps = new Pictures(imgs.get(start));
                li = new ListImage(ps);
                listImage.add(li);
                break;
            case 2:
                ps = new Pictures(imgs.get(start),imgs.get(start+1));
                li = new ListImage(ps);
                listImage.add(li);
                break;
            case 3:
                ps = new Pictures(imgs.get(start),imgs.get(start+1),imgs.get(start+2));
                li = new ListImage(ps);
                listImage.add(li);
                break;
        }
        return listImage;
    }
    
    //File Chooser Button
    EventHandler<ActionEvent> btnLoadEventListener
    = new EventHandler<ActionEvent>(){
 
        @Override
        public void handle(ActionEvent t) {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
              
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
            //ShowImage(file);
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                System.out.println(file);
                String path = file.toString();
                Image image = SwingFXUtils.toFXImage(bufferedImage,null);
                imageInput = image;
                double WidthView = image.getWidth();
                double HeightView = image.getHeight();
                while (WidthView > 250){
                    WidthView /= 2;
                    HeightView /= 2;
                }
          
                myImageView.setFitHeight(HeightView);
                myImageView.setFitWidth(WidthView);
                TfInput.setText(path);
                myImageView.setTranslateX(206);
                myImageView.setTranslateY(100+HeightView);
                myImageView.setImage(image);
                if(check==true){

                        table.setMaxSize(0,0);
                        table.setItems(getOservableListListImage());

                    
                    check = false;
                }
            } catch (IOException ex) {
                Logger.getLogger(JavaFXApplication3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(JavaFXApplication3.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        }
    };
    
}
