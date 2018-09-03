package com.kangtian.util.http;


import javax.servlet.http.HttpServletRequest;

/*
 * @author FIRE
 */
public class HttpServletRequestUtil {
    //获取整数
	public static int getInt(HttpServletRequest request, String key) {
		try {
			return Integer.decode(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}
	//获取long型整数
	public static Long getLong(HttpServletRequest request, String key) {
		try {
			return Long.decode(request.getParameter(key));
		} catch (Exception e) {
			return -1L;
		}
	}


	//获取Double
	public static Double getDouble(HttpServletRequest request, String key) {
		try {
			return Double.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1d;
		}
	}

	//获取布尔值
	public static boolean getBoolean(HttpServletRequest request, String key) {
		try {
			return Boolean.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return false;
		}
	}
    //获取String
	public static String getString(HttpServletRequest request, String name) {
		try {
			String result = request.getParameter(name);
			if (result != null) {
				result = result.trim();
			}
			if ("".equals(result))
				result = null;
			return result;
		} catch (Exception e) {
			return null;
		}

	}

}
