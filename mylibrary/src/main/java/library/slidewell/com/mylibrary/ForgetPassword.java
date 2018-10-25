package library.slidewell.com.mylibrary;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ForgetPassword extends AppCompatActivity {
    CardView SubmitUser;
    EditText edEmail;
    public static String forgotPasswordResponse = null;
    public static String FORGOTPASSWORDURL = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        edEmail = (EditText) findViewById(R.id.edEmail);
        SubmitUser = (CardView) findViewById(R.id.SubmitUser);
        SubmitUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = edEmail.getText().toString();
                if (mail.length() == 0) {
                    edEmail.setError("Empty email");
                    edEmail.requestFocus();
                } else if (!isValidEmail(mail)) {
                    edEmail.setError("Invalid email");
                    edEmail.requestFocus();
                } else {
                    sendEmail(edEmail.getText().toString());
                }
            }
        });
    }




    //Method to Check email validation
    private boolean isValidEmail(CharSequence email) {
        if (!TextUtils.isEmpty(email)) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false;
    }


    /**
     * METHOD TO GET Forgot Password RESPONSE
     */

    public void GetForgotPasswordResponse() {
        //  System.out.println("in get reponse method====" + loginResponse);
    }


    /**
     * METHOD TO SET LOGIN URL
     */
    public void SetForgetPasswordURI(String url) {
        FORGOTPASSWORDURL = url;

    }

    /**
     * call web api  FORGOT_PASSWORD to  send email to user
     */
    private void sendEmail(final String inputEmail) {


        final ProgressDialog progressDialog = new ProgressDialog(ForgetPassword.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait...");
        if (new ConnectionHelper().isConnected(ForgetPassword.this)) {
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, FORGOTPASSWORDURL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);

//                                String responseCode = jsonObject.getString(IJson.RESPONSE_CODE_KEY);
                                String message = jsonObject.getString("Message");
                                String isSuccess = jsonObject.getString("Success");
                                System.out.println("message " + message);

                                if ((isSuccess.equalsIgnoreCase("true"))) {
//
//                                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                                    AlertDialogUtils.showCustomAlertDialog(ForgetPassword.this, message);
                                    finish();
                                }
//                                else if (responseCode.equalsIgnoreCase(IJson.RESPONSE_INVALID_REQUEST)) {
//                                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
//                                    session.logoutUser();
//                                }
                                else {
                                    AlertDialogUtils.showCustomAlertDialog(ForgetPassword.this, message);

//                                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    try {
                        progressDialog.dismiss();
                        error.printStackTrace();
//                        Toast.makeText(LoginActivity.this, IErrorMessage.ERROR_RESPONSE, Toast.LENGTH_SHORT).show();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                VolleyErrorHelper.showErrorMessage(error, ForgetPassword.this);
                            }
                        });
                        //  ((DashboardActivity) getActivity()).showMessage(IErrorsMessages.ERROR_LISTENER);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }) {


                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Email", inputEmail);
                    System.out.println("sendEmail " + params);
                    return params;
                }
            };

            AppController.getInstance().addToRequestQueue(stringRequest);
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ForgetPassword.this, "Internet not available", Toast.LENGTH_LONG).show();

                }
            });
        }
    }

}
