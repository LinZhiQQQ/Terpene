package terpene.model;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ExcelUtil {
    //默认单元格内内容为数字时格式
    private static DecimalFormat decimalFormat = new DecimalFormat("0");

    //默认单元格格式化日期字符串
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");

    //格式化数字
    private static DecimalFormat nf = new DecimalFormat("0.00");

    public static ArrayList<ArrayList<Object>> readExcel(File file){
        if(file == null){
            return null;
        }
        if(file.getName().endsWith("xlsx")){
            return readExcel_xlsx(file);
        }else{
            return readExcel_xls(file);
        }
    }

    private static ArrayList<ArrayList<Object>> readExcel_xls(File file){
        try {
            ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
            ArrayList<Object> colList;
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(file));
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;
            Object value;
            for (int i = hssfSheet.getFirstRowNum(),rowCount = 0;rowCount < hssfSheet.getPhysicalNumberOfRows();i++){
                row = hssfSheet.getRow(i);
                colList = new ArrayList<Object>();
                if(row == null){
                    //读取空行
                    if(i != hssfSheet.getPhysicalNumberOfRows()){
                        rowList.add(colList);
                    }
                    continue;
                }else{
                    rowCount++;
                }
                for(int j = row.getFirstCellNum();j <= row.getLastCellNum();j++){
                    cell = row.getCell(j);
                    if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){
                        //该单元格为空
                        if(j != row.getLastCellNum()){
                            colList.add("");
                        }
                        continue;
                    }
                    switch (cell.getCellType()){
                        case HSSFCell.CELL_TYPE_STRING:
                            System.out.println(i + "行" + j + "列 is String Type");
                            value = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                                value = decimalFormat.format(cell.getNumericCellValue());
                            } else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                                value = nf.format(cell.getNumericCellValue());
                            } else {
                                value = simpleDateFormat.format(HSSFDateUtil.getJavaDate(cell
                                        .getNumericCellValue()));
                            }
                            System.out.println(i + "行" + j
                                    + " 列 is Number type ; DateFormt:"
                                    + value.toString());
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            System.out.println(i + "行" + j + " 列 is Boolean type");
                            value = Boolean.valueOf(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            System.out.println(i + "行" + j + " 列 is Blank type");
                            value = "";
                            break;
                        default:
                            System.out.println(i + "行" + j + " 列 is default type");
                            value = cell.toString();
                    }
                    colList.add(value);
                }
                rowList.add(colList);
            }
            return rowList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static ArrayList<ArrayList<Object>> readExcel_xlsx(File file){
        try{
            ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
            ArrayList<Object> colList;
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;
            Object value;
            for(int i = sheet.getFirstRowNum() , rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows() ; i++ ){
                row = sheet.getRow(i);
                colList = new ArrayList<Object>();
                if(row == null){
                    //当读取行为空时
                    if(i != sheet.getPhysicalNumberOfRows()){//判断是否是最后一行
                        rowList.add(colList);
                    }
                    continue;
                }else{
                    rowCount++;
                }
                for( int j = row.getFirstCellNum() ; j <= row.getLastCellNum() ;j++){
                    cell = row.getCell(j);
                    if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){
                        //当该单元格为空
                        if(j != row.getLastCellNum()){//判断是否是该行中最后一个单元格
                            colList.add("");
                        }
                        continue;
                    }
                    switch(cell.getCellType()){
                        case XSSFCell.CELL_TYPE_STRING:
                            System.out.println(i + "行" + j + " 列 is String type");
                            value = cell.getStringCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_NUMERIC:
                            if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                                value = decimalFormat.format(cell.getNumericCellValue());
                            } else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                                value = nf.format(cell.getNumericCellValue());
                            } else {
                                value = simpleDateFormat.format(HSSFDateUtil.getJavaDate(cell
                                        .getNumericCellValue()));
                            }
                            System.out.println(i + "行" + j
                                    + " 列 is Number type ; DateFormt:"
                                    + value.toString());
                            break;
                        case XSSFCell.CELL_TYPE_BOOLEAN:
                            System.out.println(i + "行" + j + " 列 is Boolean type");
                            value = Boolean.valueOf(cell.getBooleanCellValue());
                            break;
                        case XSSFCell.CELL_TYPE_BLANK:
                            System.out.println(i + "行" + j + " 列 is Blank type");
                            value = "";
                            break;
                        default:
                            System.out.println(i + "行" + j + " 列 is default type");
                            value = cell.toString();
                    }// end switch
                    colList.add(value);
                }//end for j
                rowList.add(colList);
            }//end for i

            return rowList;
        }catch(Exception e){
            System.out.println("exception");
            return null;
        }
    }

    public static void writeExcel(ArrayList<ArrayList<Object>> result,String path){
        if(result == null){
            return;
        }
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet1");
        for(int i = 0 ;i < result.size() ; i++){
            HSSFRow row = sheet.createRow(i);
            if(result.get(i) != null){
                for(int j = 0; j < result.get(i).size() ; j ++){
                    HSSFCell cell = row.createCell(j);
                    cell.setCellValue(result.get(i).get(j).toString());
                }
            }
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try
        {
            wb.write(os);
        } catch (IOException e){
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        File file = new File(path);//Excel文件生成后存储的位置。
        OutputStream fos  = null;
        try
        {
            fos = new FileOutputStream(file);
            fos.write(content);
            os.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public static void setDecimalFormat(DecimalFormat decimalFormat) {
        ExcelUtil.decimalFormat = decimalFormat;
    }

    public static SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public static void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        ExcelUtil.simpleDateFormat = simpleDateFormat;
    }

    public static DecimalFormat getNf() {
        return nf;
    }

    public static void setNf(DecimalFormat nf) {
        ExcelUtil.nf = nf;
    }
}
