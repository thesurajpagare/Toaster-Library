package library.slidewell.com.mylibrary;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class NavigationDrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        //addMenuItemInNavMenuDrawer();


    }
// add menu to drawer
    private void addMenuItemInNavMenuDrawer(String menuName,ArrayList<String> menus)
    {
        //add menus
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);

        Menu menu = navView.getMenu();
        Menu submenu = menu.addSubMenu(menuName);
        for(int i=0;i<menus.size();i++) {
            submenu.add(menus.get(i));
        }

        navView.invalidate();
    }
}
