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
        // �����Ӧ���  
        String sTotalString = "";  
        int result=0;  
        HttpURLConnection httpConn = null;  
        OutputStream os = null;  
        OutputStreamWriter osw = null;  
        try {  
            URL url = new URL(strUrl);  
            httpConn = (HttpURLConnection) url.openConnection();  
            HttpURLConnection.setFollowRedirects(true);// ֧����ת  
            httpConn.setDoOutput(true);  
            httpConn.setUseCaches(false);//POST��ʹ�û���  
            httpConn.setRequestMethod("POST");  
            httpConn.setRequestProperty("Content-Type", "text/html");  
            // �������ӳ�ʱʱ��  
            httpConn.setConnectTimeout(30000);  
            // ���ö�ȡ��ʱʱ��  
            httpConn.setReadTimeout(30000);  
            httpConn.connect();  
            os = httpConn.getOutputStream();  
            osw = new OutputStreamWriter(os);  
            osw.write(json.toCharArray(), 0, json.length());  
            osw.flush();  
  
            // ��ȡ��Ӧ����  
            int code = httpConn.getResponseCode();  
  
            if (httpConn.getConnectTimeout() == 0) {  
                System.out.println("����ʱ!");  
                result=1;  
            }  
            // �Ƿ�������Ӧ  
            if (code == 200) {  
                String sCurrentLine = "";  
  
                // ��ȡ��Ӧ����  
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
                //sTotalString="Զ�̷���������ʧ��,�������:" + code;  
            }  
        } catch (Exception e) {  
            result=1;  
            //sTotalString="Զ�̷������쳣:" + e.getMessage();  
        } finally {  
            if (osw != null && os != null && httpConn != null) {  
                try {  
                    // �ر���  
                    osw.close();  
                    os.close();  
                } catch (final IOException e) {  
                    e.printStackTrace();  
                }  
                // �Ͽ�����  
                httpConn.disconnect();  
            }  
            if(result==1){  
                return "error";  
            }  
            return sTotalString;  
        }  
    }  
}
