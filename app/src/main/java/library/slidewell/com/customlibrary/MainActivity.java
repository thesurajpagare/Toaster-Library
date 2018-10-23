package library.slidewell.com.customlibrary;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import library.slidewell.com.customlibrary.CustomView.LinearLayout1;
import library.slidewell.com.customlibrary.CustomView.Login;

public class MainActivity extends AppCompatActivity {
  Login l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // LinearLayout1 l1=new LinearLayout1(this);
       l1=(Login)findViewById(R.id.l1);
       l1.SetLoginType("Email");
       l1.setLogo(MainActivity.this,R.drawable.ic_launcher_background);
       l1.setBackgroundColor(getResources().getColor(R.color.colorAccent));

    }

}