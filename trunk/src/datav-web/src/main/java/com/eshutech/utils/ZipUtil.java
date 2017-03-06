package com.eshutech.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

	public static void unZipFile(String filePath, String zipFile) throws IOException {
		File zipSrc = new File(filePath, zipFile);
		if(zipSrc.exists()){
			ZipFile zip = new ZipFile(filePath+zipFile);
			ZipEntry entry = null;
			Enumeration entrys = zip.entries();
			while (entrys.hasMoreElements()) {
				entry = (ZipEntry)entrys.nextElement();
				String zipEntryName = entry.getName();
				InputStream in = zip.getInputStream(entry);
				String outPath = (filePath + zipEntryName).replaceAll("\\*", "/");
				// 判断路径是否存在,不存在则创建文件路径
				File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
				if (!file.exists()) {
					file.mkdirs();
				}
				// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
				if (new File(outPath).isDirectory()) {
					continue;
				}
				// 输出文件路径信息

				OutputStream out = new FileOutputStream(outPath);
				byte[] buf1 = new byte[1024];
				int len;
				while ((len = in.read(buf1)) > 0) {
					out.write(buf1, 0, len);
				}
				in.close();
				out.close();
			}
			zipSrc.delete();
		}
	}
	
	public static String strDoZipB64(String src) throws IOException {
		return strDoZipB64(src, null);
	}
	
	public static String encodeBase64(String src){
		BASE64Encoder encoder = new BASE64Encoder();
		String enStr = encoder.encode(src.getBytes());
		return enStr;
	}

	public static String decodeBase64(String src) throws IOException {
    	BASE64Decoder decoder = new BASE64Decoder();
        byte[] rs = decoder.decodeBuffer(src);
		String result = new String(rs);
		return result;
	}

	public static String b64DoUpzip(String src) throws IOException {
    	BASE64Decoder decoder = new BASE64Decoder();
    	src = src.replaceAll(" ", "");
        byte[] rs = decoder.decodeBuffer(src);
        return unzipString(rs);
	}
	
	public static byte[] zipString(String src) throws IOException {
		return zipString(src, null);
	}
	public static byte[] zipString(String src, String tmpFileName) throws IOException {
		if(tmpFileName == null) tmpFileName = "RPC";
		byte[] data = src.getBytes("utf-8");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);
		ZipEntry entry = new ZipEntry(tmpFileName);
		zos.putNextEntry(entry);
		zos.write(data);
		zos.closeEntry();
		zos.flush();
		zos.close();
		baos.close();
		byte[] dataZip = baos.toByteArray();
		return dataZip;
	}
	
	
	public static String unzipString(byte[] data) throws IOException {
    	String rtn = "";
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ZipInputStream zis = new ZipInputStream(bais);
        while (zis.getNextEntry() != null) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] sd = new byte[512];
            int count = 0;
            while ((count = zis.read(sd)) != -1) {
                bos.write(sd, 0, count);
            }
            bos.flush();
            bos.close();
            zis.closeEntry();
            rtn = new String(bos.toByteArray(),"utf-8");
        }
        zis.close();
        bais.close();
    	return rtn;

	}

	public static String strDoZipB64(String cdata, String tmpFileName) throws IOException {
		byte[] data = zipString(cdata, tmpFileName);
		BASE64Encoder encoder = new BASE64Encoder();
		String enStr = encoder.encode(data);
		return enStr;
	}
}
