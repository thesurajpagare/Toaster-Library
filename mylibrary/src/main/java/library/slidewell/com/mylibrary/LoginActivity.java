package library.slidewell.com.mylibrary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText e1, e2;
    Button btnLogin;
    public static String loginResponse = null;
    public static String LOGINURL = null;
    public static String METHODTYPE = null;
    private RequestQueue mRequestQueue;
    private RequestQueue mRequestQueue1;
    LinearLayout mainlay;
    CardView cv_login;
    TextView textForgetPassword;

    //public static String METHODTYPE=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        e1 = (EditText) findViewById(R.id.edusername);
        e2 = (EditText) findViewById(R.id.edpassword);
        mainlay = (LinearLayout) findViewById(R.id.mainlay);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        cv_login = (CardView) findViewById(R.id.Login_User);
        textForgetPassword=(TextView)findViewById(R.id.textForgetPassword);

        textForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,ForgetPassword.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "hi login", Toast.LENGTH_LONG).show();
                loginResponse = "succes response";
                e1.setError(null);
                e2.setError(null);
                System.out.println("url==" + LOGINURL + "method==" + METHODTYPE);
                if (e1.getText().toString().length() == 0) {
                    e1.setError("Empty Username");
                    e1.requestFocus();
                } else if (e2.getText().toString().length() == 0) {
                    e2.setError("Empty Password");
                    e2.requestFocus();
                } else {
                    checkCredentials();
                }

                // GetLoginResponse();
            }
        });

        cv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  loginResponse="succes response";
                e1.setError(null);
                e2.setError(null);
                // System.out.println("url=="+LOGINURL+"method=="+METHODTYPE);
                if (e1.getText().toString().length() == 0) {
                    e1.setError("Empty Username");
                    e1.requestFocus();
                } else if (e2.getText().toString().length() == 0) {
                    e2.setError("Empty Password");
                    e2.requestFocus();
                } else {
                    checkCredentials();
                }
            }
        });

    }

  /*
  Method : checkCredentials
  network call for login using volley library
   */

    private void checkCredentials() {
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait while login...");
        mRequestQueue = Volley.newRequestQueue(this);
        if (new ConnectionHelper().isConnected(LoginActivity.this)) {
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGINURL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                progressDialog.dismiss();
                                loginResponse = response;
                                GetLoginResponse();
                               // System.out.println("checkCredentials response " + response);

                            } catch (Exception e) {
                               // System.out.println("out of memory==" + e.getMessage());
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    try {
                        progressDialog.dismiss();
                        error.printStackTrace();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                VolleyErrorHelper.showErrorMessage(error, LoginActivity.this);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Username", e1.getText().toString());
                    params.put("Password", e2.getText().toString());
                    // System.out.println("login_param: " + params.toString());

                    return params;
                }
            };

            mRequestQueue.add(stringRequest);
        } else {
            Toast.makeText(LoginActivity.this, "Internet not availbale", Toast.LENGTH_LONG).show();
        }
    }


    public void GetLoginResponse() {
      //  System.out.println("in get reponse method====" + loginResponse);
    }

    public void SetLoginURI(String url, String method) {
        LOGINURL = url;
        METHODTYPE = method;
    }

    public void SetScreenBackground(String background_type, int value) {
        if (background_type.equalsIgnoreCase("image")) {

            mainlay.setBackground(ContextCompat.getDrawable(LoginActivity.this, value));

        } else {
            mainlay.setBackgroundColor(ContextCompat.getColor(LoginActivity.this, value));

        }
    }

}


