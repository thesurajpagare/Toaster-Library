package library.slidewell.com.customlibrary.CustomView;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LinearLayout1 extends LinearLayout{
    public EditText e1,e2;
    public LinearLayout1(Context context) {
        super(context);


        e1 = new EditText(context);
        e1.setText("HELLO");

        addView(e1);

        EditText e2 = new EditText(context);
        e2.setText("WORLD");
        addView(e2);
    }
}
