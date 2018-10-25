package library.slidewell.com.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

public class ForgetPassword extends AppCompatActivity {
   CardView SubmitUser;
   EditText edEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        edEmail=(EditText)findViewById(R.id.edEmail);
        SubmitUser=(CardView)findViewById(R.id.SubmitUser);
        SubmitUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=edEmail.getText().toString();
                if(mail.length()==0)
                {
                    edEmail.setError("Empty email");
                    edEmail.requestFocus();
                }else if(!isValidEmail(mail))
                {
                    edEmail.setError("Invalid email");
                    edEmail.requestFocus();
                }
            }
        });
    }
    private boolean isValidEmail(CharSequence email) {
        if (!TextUtils.isEmpty(email)) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false;
    }


}
