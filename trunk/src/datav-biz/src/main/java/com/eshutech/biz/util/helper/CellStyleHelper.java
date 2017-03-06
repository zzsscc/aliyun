package com.eshutech.biz.util.helper;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

public class CellStyleHelper {

    /**
     * 标题样式
     *
     * @param xssBook
     * @return
     */
    public static CellStyle styleTitle(Workbook xssBook) {
        CellStyle styleTitle = xssBook.createCellStyle();
        styleTitle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        styleTitle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styleTitle.setAlignment(CellStyle.ALIGN_CENTER); // 居中
        styleTitle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 垂直居中
        styleTitle.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
        styleTitle.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
        styleTitle.setBorderTop(CellStyle.BORDER_THIN);// 上边框
        styleTitle.setBorderRight(CellStyle.BORDER_THIN);// 右边框
        return styleTitle;
    }

    /**
     * 默认样式
     *
     * @param xssBook
     * @return
     */
    public static CellStyle styleDefault(Workbook xssBook) {
        CellStyle styleDefault = xssBook.createCellStyle();
        styleDefault.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        styleDefault.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styleDefault.setAlignment(CellStyle.ALIGN_CENTER); // 居中
        styleDefault.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 垂直居中
        styleDefault.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
        styleDefault.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
        styleDefault.setBorderTop(CellStyle.BORDER_THIN);// 上边框
        styleDefault.setBorderRight(CellStyle.BORDER_THIN);// 右边框
        return styleDefault;
    }

    /**
     * 比率样式
     *
     * @param xssBook
     * @return
     */
    public static CellStyle styleRate(Workbook xssBook) {
        CellStyle styleRate = xssBook.createCellStyle();
        styleRate.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        styleRate.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styleRate.setAlignment(CellStyle.ALIGN_CENTER); // 居中
        styleRate.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 垂直居中
        styleRate.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
        styleRate.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
        styleRate.setBorderTop(CellStyle.BORDER_THIN);// 上边框
        styleRate.setBorderRight(CellStyle.BORDER_THIN);// 右边框
        styleRate.setDataFormat((short) BuiltinFormats.getBuiltinFormat("0.00"));
        return styleRate;
    }

    /**
     * 价格
     *
     * @param xssBook
     * @return
     */
    public static CellStyle stylePrice(Workbook xssBook) {
        CellStyle styleRate = xssBook.createCellStyle();
        styleRate.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        styleRate.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styleRate.setAlignment(CellStyle.ALIGN_CENTER); // 居中
        styleRate.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 垂直居中
        styleRate.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
        styleRate.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
        styleRate.setBorderTop(CellStyle.BORDER_THIN);// 上边框
        styleRate.setBorderRight(CellStyle.BORDER_THIN);// 右边框
        return styleRate;
    }

    /**
     * 超链接样式
     *
     * @param xssBook
     * @return
     */
    public static CellStyle styleLink(Workbook xssBook) {
        CellStyle styleLink = xssBook.createCellStyle();
        Font cellFont = xssBook.createFont();
        cellFont.setUnderline((byte) 1);
        cellFont.setColor(HSSFColor.BLUE.index);
        styleLink.setFont(cellFont);
        styleLink.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        styleLink.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styleLink.setAlignment(CellStyle.ALIGN_CENTER); // 居中
        styleLink.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 垂直居中
        styleLink.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
        styleLink.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
        styleLink.setBorderTop(CellStyle.BORDER_THIN);// 上边框
        styleLink.setBorderRight(CellStyle.BORDER_THIN);// 右边框
        return styleLink;
    }
}