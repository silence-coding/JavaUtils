package com.kangtian.util.string;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return (null == str || "".equals(str));
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    //判断字符串为空或则为空格
    public static boolean isBlank(String str) {
        if (isEmpty(str))
            return true;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**清除首尾的某个字符
     * @param str 原字符串
     * @param stripStr 要清除的字符
     * @return
     */
    public static String strip(String str, String stripStr) {
        if (null == str || str.length() == 0)
            return str;
        str = stripHead(str, stripStr);
        return stripButtom(str, stripStr);
    }

    /**
     * 清除首尾空格
     * @param str
     * @return
     */
    public static String strip(String str) {
        return strip(str, null);
    }
    /**清除首的某个字符
     * @param str 原字符串
     * @param stripStr 要清除的字符
     * @return
     */
    public static String stripHead(String str, String stripStr) {
        int strLen = str.length();
        int begin = 0;
        if (null == str || strLen == 0)
            return str;
        if (null == stripStr)
            while ((begin <= strLen) && Character.isWhitespace(str.charAt(begin))) {
                begin++;
            }
        else if (stripStr.length() == 0) return str;
        else
            while ((begin != strLen) && (stripStr.indexOf(str.charAt(begin)) != -1)) {
                begin++;
            }
        return str.substring(begin);
    }
    /**清除尾的某个字符
     * @param str 原字符串
     * @param stripStr 要清除的字符
     * @return
     */
    public static String stripButtom(String str, String stripStr) {
        int strLen = str.length();
        if (null == str || strLen == 0) {
            return str;
        }
        if (stripStr == null)
            while ((strLen != 0) && Character.isWhitespace(str.charAt(strLen - 1))) {
                strLen--;
            }
        else if (stripStr.length() == 0) return str;
        else
            while ((strLen != 0) && (stripStr.indexOf(str.charAt(strLen - 1)) != -1)) {
                strLen--;
            }
        return str.substring(0, strLen);
    }

    /**
     * 删除原字符串中所有子串
     * @param str 原字符串
     * @param deleteStr 要删除的子串
     * @return
     */
    public static String deleteChidStr(String str,String deleteStr){
        return str.replaceAll(deleteStr,"");
    }

}
