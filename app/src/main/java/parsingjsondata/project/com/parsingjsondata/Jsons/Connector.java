package parsingjsondata.project.com.parsingjsondata.Jsons;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


// set conncetion properties
//establish and return conn obj
public class Connector  {

    public static Object connect(String jsonURL)
    {
        try
        {
            URL url=new URL(jsonURL);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();

            //CON PROPS
            con.setRequestMethod("GET");
            con.setConnectTimeout(15000);
            con.setReadTimeout(15000);
            con.setDoInput(true);

            return con;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Error "+e.getMessage();

        } catch (IOException e) {
            e.printStackTrace();
            return "Error " + e.getMessage();

        }
    }

}
