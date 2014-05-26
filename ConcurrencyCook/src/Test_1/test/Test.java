package Test_1.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
	public static String getConnectionJson(String strUrl, String json) {  
        // 存放响应结果  
        String sTotalString = "";  
        int result=0;  
        HttpURLConnection httpConn = null;  
        OutputStream os = null;  
        OutputStreamWriter osw = null;  
        try {  
            URL url = new URL(strUrl);  
            httpConn = (HttpURLConnection) url.openConnection();  
            HttpURLConnection.setFollowRedirects(true);// 支持跳转  
            httpConn.setDoOutput(true);  
            httpConn.setUseCaches(false);//POST不使用缓存  
            httpConn.setRequestMethod("POST");  
            httpConn.setRequestProperty("Content-Type", "text/html");  
            // 设置连接超时时间  
            httpConn.setConnectTimeout(30000);  
            // 设置读取超时时间  
            httpConn.setReadTimeout(30000);  
            httpConn.connect();  
            os = httpConn.getOutputStream();  
            osw = new OutputStreamWriter(os);  
            osw.write(json.toCharArray(), 0, json.length());  
            osw.flush();  
  
            // 读取响应数据  
            int code = httpConn.getResponseCode();  
  
            if (httpConn.getConnectTimeout() == 0) {  
                System.out.println("请求超时!");  
                result=1;  
            }  
            // 是否正常响应  
            if (code == 200) {  
                String sCurrentLine = "";  
  
                // 读取响应数据  
                InputStream is = httpConn.getInputStream();  
  
                BufferedReader reader = new BufferedReader(  
                        new InputStreamReader(is));  
                while ((sCurrentLine = reader.readLine()) != null) {  
                    if (sCurrentLine.length() > 0) {  
                        sTotalString = sTotalString + sCurrentLine.trim();  
                    }  
                }  
                is.close();  
                //System.out.println("OOOO:"+sTotalString);  
                return sTotalString;  
            } else {  
                result=1;  
                //sTotalString="远程服务器连接失败,错误代码:" + code;  
            }  
        } catch (Exception e) {  
            result=1;  
            //sTotalString="远程服务器异常:" + e.getMessage();  
        } finally {  
            if (osw != null && os != null && httpConn != null) {  
                try {  
                    // 关闭流  
                    osw.close();  
                    os.close();  
                } catch (final IOException e) {  
                    e.printStackTrace();  
                }  
                // 断开连接  
                httpConn.disconnect();  
            }  
            if(result==1){  
                return "error";  
            }  
            return sTotalString;  
        }  
    }  
}
