package com.eshutech.biz.util.helper;


import com.eshutech.biz.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.util.List;

/**
 * @Author:Lajiao
 * @Date:2014年8月12日
 * @Time:上午11:53:00
 * @Description:
 */
public class CellValueHelper {

    public static void setCellValue(Workbook xssBook, Row row, int i, Object value) {
        CellStyle styleDefault = CellStyleHelper.styleDefault(xssBook);
        try {
            if (value == null) {
                row.createCell(i).setCellStyle(styleDefault);
                row.getCell(i).setCellType(XSSFCell.CELL_TYPE_STRING);
                row.getCell(i).setCellValue("");
            } else {
                row.createCell(i).setCellStyle(styleDefault);
                row.getCell(i).setCellType(XSSFCell.CELL_TYPE_STRING);
                row.getCell(i).setCellValue(value.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            row.createCell(i).setCellValue("e");
        }
    }

    public static void setCellValuePrice(Workbook xssBook, Row row, int i, Object value) {
        CellStyle stylePrice = CellStyleHelper.stylePrice(xssBook);
        try {
            if (value == null) {
                row.createCell(i).setCellValue("0.00");
                row.getCell(i).setCellStyle(stylePrice);
            } else {
                row.createCell(i).setCellValue(StringUtil.parseLong(value, 0l) / 100.00);
                row.getCell(i).setCellStyle(stylePrice);
            }
        } catch (Exception ex) {
            row.createCell(i).setCellValue("e");
        }
    }

    public static void setCellValueRate(Workbook xssBook, Row row, int i, Object value) {
        CellStyle styleRate = CellStyleHelper.styleRate(xssBook);
        try {
            if (value == null) {
                row.createCell(i).setCellValue("0.00%");
                row.getCell(i).setCellStyle(styleRate);
            } else {
                row.createCell(i).setCellValue(value + "%");
                row.getCell(i).setCellStyle(styleRate);
            }
        } catch (Exception ex) {
            row.createCell(i).setCellValue("e");
        }
    }

    public static String getCellValue(XSSFCell xCell) {
        if (xCell == null) {
            return "";
        }

        try {
            switch (xCell.getCellType()) {
                case XSSFCell.CELL_TYPE_NUMERIC: // 数字
                    return String.valueOf(xCell.getNumericCellValue());
                case XSSFCell.CELL_TYPE_STRING: // 字符串
                    return String.valueOf(xCell.getStringCellValue());
                case XSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    return String.valueOf(xCell.getBooleanCellValue());
                case XSSFCell.CELL_TYPE_FORMULA: // 公式
                    return String.valueOf(xCell.getCellFormula());
                case XSSFCell.CELL_TYPE_BLANK: // 空值
                    return "";
                case XSSFCell.CELL_TYPE_ERROR: // 故障
                    return String.valueOf(xCell.getStringCellValue());
                default:
                    return String.valueOf(xCell.getStringCellValue());
            }
        } catch (Exception ex) {
            return "-";
        }
    }

    public static String getCellValue(HSSFCell xCell) {
        if (xCell == null) {
            return "";
        }
        try {
            switch (xCell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                    return String.valueOf(xCell.getNumericCellValue());
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    return String.valueOf(xCell.getStringCellValue());
                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    return String.valueOf(xCell.getBooleanCellValue());
                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                    return String.valueOf(xCell.getCellFormula());
                case HSSFCell.CELL_TYPE_BLANK: // 空值
                    return "";
                case HSSFCell.CELL_TYPE_ERROR: // 故障
                    return String.valueOf(xCell.getStringCellValue());
                default:
                    return String.valueOf(xCell.getStringCellValue());
            }
        } catch (Exception ex) {
            return "-";
        }
    }

    public static void createRow(Workbook xssBook, Sheet sheet, int sheetRow, List<String> arrys, boolean title) {
        if (arrys == null) {
            return;
        }
        int c = arrys.size();
        Row row = sheet.createRow(sheetRow);
        for (int j = 0; j < c; j++) {
            CellValueHelper.setCellValue(xssBook, row, j, arrys.get(0));
        }
        if (title) {
            CellStyle styleTitle = CellStyleHelper.styleTitle(xssBook);
            for (int j = 0; j <= 17; j++) {
                row.getCell(j).setCellStyle(styleTitle);
            }
        }
    }
}