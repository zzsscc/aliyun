package com.eshutech.biz.util;

public class ByteUtil {

    public static final String nLine = "----------------------------------------------------------------------------";

    /**
     * @param iSource
     * @param iArrayLen
     * @return
     */
    public static byte[] Int2ByteArray(int iSource, int iArrayLen) {
        byte[] bLocalArr = new byte[iArrayLen];
        for (int i = iArrayLen; (i < 4) && (i > 0); i--) {
            bLocalArr[i - 1] = (byte) (iSource >> 8 * (iArrayLen - i) & 0xFF);
        }
        return bLocalArr;
    }

    public static String trace(byte[] inBytes) {
        int i, j = 0;
        byte[] temp = new byte[76];
        bytesSet(temp, ' ');
        StringBuffer strc = new StringBuffer("");
        strc.append(nLine + "\n");
        for (i = 0; i < inBytes.length; i++) {
            if (j == 0) {
                System.arraycopy(String.format("%03d: ", i).getBytes(), 0, temp, 0, 5);
                System.arraycopy(String.format(":%03d", i + 15).getBytes(), 0, temp, 72, 4);
            }
            System.arraycopy(String.format("%02X ", inBytes[i]).getBytes(), 0, temp, j * 3 + 5 + (j > 7 ? 1 : 0), 3);
            if (inBytes[i] == 0x00) {
                temp[j + 55 + ((j > 7 ? 1 : 0))] = '.';
            } else {
                temp[j + 55 + ((j > 7 ? 1 : 0))] = inBytes[i];
            }
            j++;
            if (j == 16) {
                strc.append(new String(temp)).append("\n");
                bytesSet(temp, ' ');
                j = 0;
            }
        }
        if (j != 0) {
            strc.append(new String(temp)).append("\n");
            bytesSet(temp, ' ');
        }
        strc.append(nLine + "\n");
        System.out.println(strc.toString());
        return strc.toString();
    }

    private static void bytesSet(byte[] inBytes, char fill) {
        if (inBytes.length == 0) {
            return;
        }
        for (int i = 0; i < inBytes.length; i++) {
            inBytes[i] = (byte) fill;
        }
    }

    public static byte[] byteAndByte(byte[] begin, byte[] second) {

        if (begin == null || begin.length == 0) {

            if (second != null && second.length != 0) {

                return second;

            } else {

                return null;
            }

        } else if (second == null || second.length == 0) {

            return begin;
        }

        byte[] newTotal = new byte[begin.length + second.length];

        for (int i = 0; i < begin.length; i++) {

            newTotal[i] = begin[i];
        }

        for (int i = begin.length; i < second.length + begin.length; i++) {

            newTotal[i] = second[i - begin.length];
        }

        return newTotal;
    }

    public static byte[] getsubByte(byte[] total, int begin, int length) {

        if (length > 0) {
            byte[] newTotal = new byte[length];

            for (int i = begin; i < length + begin; i++) {

                newTotal[i - begin] = total[i];

            }
            return newTotal;
        }
        return null;
    }

    /**
     * 填充字符串
     *
     * @param string      填充前的字符串
     * @param filler      需要填充的字符
     * @param totalLength 填充后的总长度
     * @param atEnd       true为在原字符串的右边添加,false为在原字符串的昨天添加
     * @return String
     */
    public static String fillString(String string, char filler, int totalLength, boolean atEnd) {

        byte[] tempbyte = string.getBytes();
        int currentLength = tempbyte.length;
        int delta = totalLength - currentLength;

        for (int i = 0; i < delta; i++) {
            if (atEnd) {
                string += filler;
            } else {
                string = filler + string;
            }
        }

        return string;
    }

    /**
     * Convert hex string to byte[]
     *
     * @param hexString the hex string
     * @return byte[]s
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * Convert char to byte
     *
     * @param c char
     * @return byte
     */

    public static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static String bytesToHexString(byte[] src) {

        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();

    }

    public static String bytesToString(byte[] src, int begin, int length) {

        String str1 = null;
        StringBuilder sb = new StringBuilder("");
        if (begin == 0 && length == 0) {
            for (byte element : src) {
                sb.append(String.valueOf(element));
            }
        } else {
            for (int i = begin; i < begin + length; i++) {
                byte element = src[i];
                sb.append(String.valueOf(element));
            }
        }

        str1 = sb.toString();
        System.out.println(str1);
        return str1;

    }

    public static byte[] getByteMessageLen(int len) {
        byte[] buf = new byte[2];
        // 取高8位
        buf[0] = (byte) (len >> 8);
        // 取低8
        buf[1] = (byte) (len & 0xff);
        return buf;
    }

    public static int getMessageLen(byte[] blen) {
        String hexlen = Integer.toHexString(blen[0]) + Integer.toHexString(blen[1] & 0xff);
        return Integer.parseInt(hexlen, 16);
    }

    public static int OxStringtoInt(String ox) throws Exception {
        ox = ox.toLowerCase();
        if (ox.startsWith("0x")) {
            ox = ox.substring(2, ox.length());
        }
        int ri = 0;
        int oxlen = ox.length();
        if (oxlen > 8) throw (new Exception("too lang"));
        for (int i = 0; i < oxlen; i++) {
            char c = ox.charAt(i);
            int h;
            if (('0' <= c && c <= '9')) {
                h = c - 48;
            } else if (('a' <= c && c <= 'f')) {
                h = c - 87;

            } else if ('A' <= c && c <= 'F') {
                h = c - 55;
            } else {
                throw (new Exception("not a integer "));
            }
            byte left = (byte) ((oxlen - i - 1) * 4);
            ri |= (h << left);
        }
        return ri;

    }

    /**
     * 将指定byte数组以16进制的形式打印到控制台
     *
     * @param hint String
     * @param b    byte[]
     * @return void
     */
    public static void printHexString(String hint, byte[] b) {
        System.out.print(hint);
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase() + " ");
        }
        System.out.println("");
    }

    /**
     * @param b byte[]
     * @return String
     */
    public static String Bytes2HexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    /**
     * 将两个ASCII字符合成一个字节； 如："EF"–> 0xEF
     *
     * @param src0 byte
     * @param src1 byte
     * @return byte
     */
    public static byte uniteBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[]{src0})).byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[]{src1})).byteValue();
        byte ret = (byte) (_b0 ^ _b1);
        return ret;
    }

    /**
     * 将指定字符串src，以每两个字符分割转换为16进制形式 如："2B" –> byte[]{0x2B}
     *
     * @param src String
     * @return byte[]
     */
    public static byte[] HexString2Bytes(String src) {
        byte[] ret = new byte[src.length()];
        byte[] tmp = src.getBytes();
        for (int i = 0; i < src.length() / 2; ++i) {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;

    }

    // 223344，转成byte数组，内容也为223344
    public static byte[] String2Bytes(String strTmp) {
        byte[] b = new byte[strTmp.length() / 2];
        for (int i = 0; i < strTmp.length() / 2; i++) {
            String str1 = strTmp.substring(i * 2, (i + 1) * 2);
            int iTmp = Integer.parseInt(str1);
            b[i] = (byte) iTmp;
        }
        return b;
    }

    public static byte[] String2ASCII(String strTmp) {
        byte[] b = new byte[strTmp.length() / 2];
        for (int i = 0; i < strTmp.length() / 2; i++) {
            String str1 = strTmp.substring(i * 2, (i + 1) * 2);
            // int iTmp=char(str1);
            b[i] = str1.getBytes()[0];
        }
        return b;
    }

}
