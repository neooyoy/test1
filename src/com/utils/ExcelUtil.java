package com.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
   /* public static void main(String[] args) throws IOException {
        readExcel("C:\\\\Users\\\\cj\\\\Desktop\\\\1导入销控表.xlsx");
    }*/

    /**
     * 读取Excel测试，兼容 Excel 2003/2007/2010
     */
    public static JSONObject readExcel(String path) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        JSONObject returnJson = new JSONObject();
        List<String> headers = new ArrayList<String>();
        List<JSONObject> datas = new ArrayList<JSONObject>();
        try {
            File excelFile = new File(path); //创建文件对象
            FileInputStream is = new FileInputStream(excelFile); //文件流
            Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的
            int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量

            //遍历每个Sheet
            for (int s = 0; s < sheetCount; s++) {
                Sheet sheet = workbook.getSheetAt(s);
                int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数

                //遍历每一行
                for (int r = 0; r < rowCount; r++) {
                    Row row = sheet.getRow(r);
                    int cellCount = row.getPhysicalNumberOfCells(); //获取总列数

                    JSONObject data = new JSONObject();

                    //遍历每一列
                    for (int c = 0; c < cellCount; c++) {
                        Cell cell = row.getCell(c);
                        String cellValue = "";

                        if (cell != null) {
                            int cellType = cell.getCellType();
                            switch (cellType) {
                                case Cell.CELL_TYPE_STRING: //文本
                                    cellValue = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_NUMERIC: //数字、日期
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        cellValue = fmt.format(cell.getDateCellValue()); //日期型
                                    } else {
                                        DecimalFormat format = new DecimalFormat("#.00");
                                        String value = format.format(Double.valueOf(cell.getNumericCellValue()));
                                        if (value.substring(value.lastIndexOf(".") + 1, value.length()).equals("00")) {
                                            cellValue = value.substring(0, value.lastIndexOf(".")); //数字
                                        } else {
                                            cellValue = value; //数字
                                        }
                                    }
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN: //布尔型
                                    cellValue = String.valueOf(cell.getBooleanCellValue());
                                    break;
                                case Cell.CELL_TYPE_BLANK: //空白
                                    cellValue = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_ERROR: //错误
                                    cellValue = "错误";
                                    break;
                                case Cell.CELL_TYPE_FORMULA: //公式
                                    cellValue = "错误";
                                    break;
                                default:
                                    cellValue = "错误";
                            }
                        }

                        //第一行为表头
                        if (r == 0) {
                            headers.add(cellValue);
                        } else {//其余行为数据
                            data.put(headers.get(c), cellValue);
                        }
                    }

                    if (r != 0) {
                        datas.add(data);
                    }
                }
            }

            returnJson.put("headers", headers);
            returnJson.put("rows", datas);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnJson;
    }
}
