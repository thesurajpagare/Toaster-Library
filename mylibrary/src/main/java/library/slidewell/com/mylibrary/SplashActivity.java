package library.slidewell.com.mylibrary;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

//Custom Splash Screen Activity Library
public class SplashActivity extends AppCompatActivity {
    LinearLayout mainlay;
    ImageView imvlogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mainlay=(LinearLayout)findViewById(R.id.mainlay);
        imvlogo=(ImageView)findViewById(R.id.imvlogo);

        new Handler().postDelayed(new Runnable() {
            public void run() {
               navigatetoActivity();
            }
        }, 3000);             //delay to splash screen

    }

    /*Method :navigatetoActivity (to navigate to another activity)

    */

    public void navigatetoActivity()
    {

    }

    /*

    Function: SetLogo
    input:    int i.e. R.drawable.background
    */

    public void SetLogo(int drawable)
    {
        imvlogo.setBackground(ContextCompat.getDrawable(SplashActivity.this,drawable));
    }

     /*

    Function: SetScreenBackground
    input:
    String(BackgroundType i.e. value maybe color or image
    String(value i.e for color R.color.blue and for image R.drawable.background)
    */

    public void SetScreenBackground(String background_type,int value)
    {
        if(background_type.equalsIgnoreCase("image"))
        {

            mainlay.setBackground(ContextCompat.getDrawable(SplashActivity.this, value));

        }else
        {
            mainlay.setBackgroundColor(ContextCompat.getColor(SplashActivity.this, value));

        }
    }
}
