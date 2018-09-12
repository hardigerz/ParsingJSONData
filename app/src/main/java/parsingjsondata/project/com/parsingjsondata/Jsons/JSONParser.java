package parsingjsondata.project.com.parsingjsondata.Jsons;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import parsingjsondata.project.com.parsingjsondata.Model.User;

public class JSONParser extends AsyncTask<Void,Void,Boolean> {

    Context context;
    String jsonData;
    ListView listView;

    ProgressDialog pd;
    ArrayList<User> users=new ArrayList<>();

    public JSONParser(Context context, String jsonData, ListView listView) {
        this.context = context;
        this.jsonData = jsonData;
        this.listView = listView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(context);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return parse();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        pd.dismiss();
        if(isParsed)
        {
            //BIND
            listView.setAdapter(new CustomAdapter(context,users));
        }else
        {
            Toast.makeText(context, "Unable To Parse,Check Your Log output", Toast.LENGTH_SHORT).show();
        }

    }

    private Boolean parse()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo;

            users.clear();
            User user;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                String name=jo.getString("name");
                String username=jo.getString("username");
                String email=jo.getString("email");
                JSONObject address = jo.getJSONObject("address");
//                String street = jo.getString("street");
                //String suite=jo.getString("suite");
//                String city=jo.getString("city");
//                String zipcode=jo.getString("zipcode");
                String phone=jo.getString("phone");
               String website=jo.getString("website");
//                String companyname=jo.getString("companyname");
//                String catchprase=jo.getString("catchprase");
//                String etc=jo.getString("etc");

                user=new User();

                user.setName(name);
                user.setUsername(username);
                user.setEmail(email);
//                user.setStreet(street);
//                user.setSuite(suite);
//                user.setCity(city);
//                user.setZipcode(zipcode);
                user.setPhone(phone);
               user.setWebsite(website);
//                user.setCompanyname(companyname);
//                user.setCatchprase(catchprase);
//                user.setEtc(etc);
                users.add(user);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}