package library.slidewell.com.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
   EditText e1,e2;
   Button btnLogin;
   public static String loginResponse=null;
    public static String LOGINURL=null;
    public static String METHODTYPE=null;
    //public static String METHODTYPE=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.edusername);
        e2=(EditText)findViewById(R.id.edpassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this,"hi login",Toast.LENGTH_LONG).show();
                loginResponse="succes response";
                System.out.println("url=="+LOGINURL+"method=="+METHODTYPE);
                GetResponse();
            }
        });

    }

    public void GetResponse()
    {
        System.out.println("in get reponse method===="+loginResponse);
    }
    public void SetURI(String url,String method)
    {
        LOGINURL=url;
        METHODTYPE=method;
    }


}


