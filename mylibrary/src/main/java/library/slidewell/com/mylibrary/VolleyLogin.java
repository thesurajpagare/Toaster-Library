package library.slidewell.com.mylibrary;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VolleyLogin {

    public static String vresponse = null,vresponse1 = null;



    public static String volleyLogin(final Context c,final String url, final HashMap<String, String> parameters) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //hiding the progressbar after completion
                                //  progressBar.setVisibility(View.INVISIBLE);
                                System.out.println("volley response==" + response);
                                Toast.makeText(c, response, Toast.LENGTH_SHORT).show();
                                vresponse=response;


                                try {
                                    //getting the whole json object from the response
                                    JSONObject obj = new JSONObject(response);

                                    //we have the array named hero inside the object
                                    //so here we are getting that json array
                                    JSONArray heroArray = obj.getJSONArray("heroes");


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //displaying the error in toast if occurrs
                                Toast.makeText(c, error.getMessage(), Toast.LENGTH_SHORT).show();
                                vresponse = null;
                            }
                        }) {

                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();

                        for (Map.Entry<String, String> entry : parameters.entrySet()) {
                            params.put(entry.getKey(), entry.getValue());


                        }
                        System.out.println("params===" + params.toString());


                        return params;
                    }
                };


                //creating a request queue
                RequestQueue requestQueue = Volley.newRequestQueue(c);

                //adding the string request to request queue

                requestQueue.add(stringRequest);

            }
        }, 5000);


        return vresponse;


    }


}

