package parsingjsondata.project.com.parsingjsondata.Jsons;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class JSONDownloader extends AsyncTask<Void, Void, String> {

    Context context;
    String jsonURL;
    ListView listView;

    ProgressDialog progressDialog;

    public JSONDownloader(Context context, String jsonURL, ListView listView) {
        this.context = context;
        this.jsonURL = jsonURL;
        this.listView = listView;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Download JSON");
        progressDialog.setMessage("Downloading...Please wait");
        progressDialog.show();

    }

    @Override
    protected String doInBackground(Void... voids) {
        return download();
    }



    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        progressDialog.dismiss();

        if (jsonData.startsWith("Error")) {
            String error = jsonData;
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
        } else {
            //PARSER
            new JSONParser(context, jsonData, listView).execute();
        }

    }

    private String download()
    {
        Object connection=Connector.connect(jsonURL);
        if(connection.toString().startsWith("Error"))
        {
            return connection.toString();
        }

        try
        {
            HttpURLConnection con= (HttpURLConnection) connection;
            if(con.getResponseCode()==con.HTTP_OK)
            {
                //GET INPUT FROM STREAM
                InputStream is=new BufferedInputStream(con.getInputStream());
                BufferedReader br=new BufferedReader(new InputStreamReader(is));

                String line;
                StringBuffer jsonData=new StringBuffer();

                //READ
                while ((line=br.readLine()) != null)
                {
                    jsonData.append(line+"\n");
                }

                //CLOSE RESOURCES
                br.close();
                is.close();

                //RETURN JSON
                return jsonData.toString();

            }else
            {
                return "Error "+con.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error "+e.getMessage();

        }

    }


}


