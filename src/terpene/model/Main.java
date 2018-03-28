package terpene.model;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/terpene/model/data/lz01.xls");
        ArrayList<ArrayList<Object>> result = ExcelUtil.readExcel(file);
        for(int i = 0 ;i < result.size() ;i++){
            for(int j = 0;j<result.get(i).size(); j++){
                System.out.println(i+"行 "+j+"列  "+ result.get(i).get(j).toString());
            }
        }
//        ExcelUtil.writeExcel(result,"F:/excel/bb.xls");
    }
}
