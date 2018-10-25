package library.slidewell.com.mylibrary;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class NavigationDrawerActivity extends AppCompatActivity {

    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_navigationview);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        //addMenuItemInNavMenuDrawer();


    }
// add menu to drawer
    public void addMenuItemInNavMenuDrawer(String menuName,ArrayList<String> menus)
    {
        //add menus
      //  NavigationView navView = (NavigationView) findViewById(R.id.nav_view);

        Menu menu = navigationView.getMenu();
        Menu submenu = menu.addSubMenu(menuName);
        for(int i=0;i<menus.size();i++) {
            submenu.add(menus.get(i));
        }

        navigationView.invalidate();
    }
}
