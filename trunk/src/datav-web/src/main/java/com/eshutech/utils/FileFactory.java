/**
 * Copyright (c) 2016. Drore Co, Ltd. All rights reserved.
 * Filename: FileFactory
 * Creator:  wanggao
 * Create-Date: 下午8:31
 **/
package com.eshutech.utils;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Kim
 * @date: 16/6/26
 * @time: 下午8:31
 */
public class FileFactory {

    public static void saveFile(String filePath,String fileContent)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String fileName = format.format(new Date());
        try {
            FileFactory.saveFile(fileName,filePath,fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFile(String fileName, String filePath, String fileContent) throws IOException,RuntimeException {
        File file = new File(filePath + fileName);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new RuntimeException("创建文件失败!");
            }
        }
        else{
            if(file.delete())
            {
                if (!file.createNewFile()) {
                    throw new RuntimeException("创建文件失败!");
                }
            }
        }
        FileOutputStream out = new FileOutputStream(file, true);
        out.write(fileContent.getBytes("utf-8"));
        out.close();

    }

    public static void copyFile(String src,String dest) throws IOException{
        FileInputStream in=new FileInputStream(src);
        File file=new File(dest);
        if(!file.exists()) {
            if (!file.createNewFile()) {
                throw new RuntimeException("创建文件失败!");
            }
        }
        FileOutputStream out= null;
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        int c;
        byte buffer[]=new byte[1024];
        while((c=in.read(buffer))!=-1){
            for(int i=0;i<c;i++) {
                out.write(buffer[i]);
            }
        }
        in.close();
        out.close();
    }

    public static String readFile(String fileName,String filePath)
    {
        File file = new File(filePath+fileName);
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

}
