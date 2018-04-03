package terpene.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import terpene.controller.Computing;
import terpene.entity.Terpene;
import terpene.model.ExcelUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Painting extends Pane{

    private Button btn;

    public Painting(){
        btn = new Button();
        btn.setText("相似度匹配");
        btn.setStyle("-fx-base: #ee2211;");
        btn.setLayoutX(50);
        btn.setLayoutY(50);
        btn.setMinWidth(40);
        btn.setMinHeight(35);


        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll("CosineSimilarity","EucledianDistance","MahalanobisDistance","ManhattanDistance");
        ComboBox comboBox = new ComboBox(options);
        comboBox.setValue("CosineSimilarity");
        comboBox.setLayoutX(150);
        comboBox.setLayoutY(50);
        this.getChildren().addAll(btn,comboBox);
        btn.setOnAction(e->{
            File file = new File("src/terpene/model/data/data.xls");
            ArrayList<ArrayList<Object>> result = ExcelUtil.readExcel(file);
            Computing computing = new Computing((String)comboBox.getValue());
            for(int i = 2;i <= 20;i++){
                Terpene terpene1 = new Terpene(result.get(1));
                Terpene terpene2 = new Terpene(result.get(i));
                System.out.println(computing.getSimilarity(terpene1,terpene2,Terpene.TYPE_SIZE));
            }

        });
    }
}
