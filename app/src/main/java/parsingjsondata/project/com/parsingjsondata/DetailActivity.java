package parsingjsondata.project.com.parsingjsondata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView nameTxt,emailTxt, usernameTxt, phoneTxt,webTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameTxt = (TextView) findViewById(R.id.nameDetailTxt);
        emailTxt= (TextView) findViewById(R.id.emailDetailTxt);
        usernameTxt = (TextView) findViewById(R.id.usernameDetailTxt);
        phoneTxt = (TextView) findViewById(R.id.phoneDetailTxt);
        webTxt = (TextView) findViewById(R.id.webDetailTxt);


        //GET INTENT
        Intent i=this.getIntent();

        //RECEIVE DATA
        String name=i.getExtras().getString("NAME_KEY");
        String email=i.getExtras().getString("EMAIL_KEY");
        String username=i.getExtras().getString("USERNAME_KEY");
        String phone =i.getExtras().getString("PHONE_KEY");
        String web =i.getExtras().getString("WEB_KEY");


        //BIND DATA
        nameTxt.setText(name);
        emailTxt.setText(email);
        usernameTxt.setText(username);
        phoneTxt.setText(phone);
        webTxt.setText(web);

    }

}
