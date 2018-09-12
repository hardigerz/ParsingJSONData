package parsingjsondata.project.com.parsingjsondata.Jsons;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import parsingjsondata.project.com.parsingjsondata.DetailActivity;
import parsingjsondata.project.com.parsingjsondata.Model.User;
import parsingjsondata.project.com.parsingjsondata.R;

class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<User> users;
    public CustomAdapter(Context context, ArrayList<User> users) {
        this.context=context;
        this.users=users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(context).inflate(R.layout.model,viewGroup,false);
        }

        TextView nameTxt= (TextView) view.findViewById(R.id.nameTxt);
        TextView emailTxt= (TextView) view.findViewById(R.id.emailTxt);
        TextView usernameTxt= (TextView) view.findViewById(R.id.usernameTxt);
        TextView phoneTxt =(TextView) view.findViewById(R.id.phoneTxt);
        TextView webTxt =(TextView) view.findViewById(R.id.webTxt);


        User user= (User) this.getItem(position);

        final String name=user.getName();
        final String email=user.getEmail();
        final String username=user.getUsername();
        final String phone =user.getPhone();
        final String web =user.getWebsite();


        nameTxt.setText(name);
        emailTxt.setText(email);
        usernameTxt.setText(username);
        phoneTxt.setText(phone);
        webTxt.setText(web);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //OPEN DETAIL ACTIVITY
                openDetailActivity(name,email,username,phone,web);

            }
        });
        return view;
    } ////open activity
    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(context,DetailActivity.class);
        i.putExtra("NAME_KEY",details[0]);
        i.putExtra("EMAIL_KEY",details[1]);
        i.putExtra("USERNAME_KEY",details[2]);
        i.putExtra("PHONE_KEY",details[3]);
        i.putExtra("WEB_KEY",details[4]);

        context.startActivity(i);

    }


}
