package library.slidewell.com.customlibrary.CustomView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import library.slidewell.com.customlibrary.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText e1,e2;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.edusername);
        e2=(EditText)findViewById(R.id.edpassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnLogin:
                Toast.makeText(LoginActivity.this,"hii",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
