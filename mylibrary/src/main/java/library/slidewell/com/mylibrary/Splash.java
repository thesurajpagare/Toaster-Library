package library.slidewell.com.mylibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class Splash  extends RelativeLayout {
    private String titleText;
    private boolean color;


    ImageView imv_logo;
    Context c1;
    ProgressBar pbar;
    LinearLayout mainlay;

    public Splash(Context context) {
        super(context);
        init();
        c1=context;

    }

    public Splash(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        c1=context;
        // retrieved values correspond to the positions of the attributes
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.Login);
        int count = typedArray.getIndexCount();
        try{

            for (int i = 0; i < count; ++i) {

                int attr = typedArray.getIndex(i);
                // the attr corresponds to the title attribute
                if(attr == R.styleable.Login_title) {

                    // set the text from the layout
                    titleText = typedArray.getString(attr);
                    //setTimeView();
                } else if(attr == R.styleable.Login_setColor) {
                    // set the color of the attr "setColor"
                    color = typedArray.getBoolean(attr, false);
                    decorateText();
                }
            }
        }

        // the recycle() will be executed obligatorily
        finally {
            // for reuse
            typedArray.recycle();
        }
    }

    public Splash(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        c1=context;
       // setTimeView();
    }



    private void decorateText() {
        // when we set setColor attribute to true in the XML layout
        if(this.color == true){
            // set the characteristics and the color of the shadow
            // setShadowLayer(4, 2, 2, Color.rgb(250, 00, 250));
            setBackgroundColor(Color.CYAN);
        } else {
            setBackgroundColor(Color.RED);
        }
    }

    private void init() {
        inflate(getContext(), R.layout.lay_splash, this);
        this.imv_logo = (ImageView) findViewById(R.id.imvlogo);
        this.pbar = (ProgressBar) findViewById(R.id.pbar);


        // this.icon = (ImageView)findViewById(R.id.icon);
    }



    public void setLogo(Context c,int d1) {
        this.imv_logo.setBackground(ContextCompat.getDrawable(c, d1));
    }

    public void setBackgroundColor(Context c,int d1) {
        this.mainlay.setBackgroundColor(ContextCompat.getColor(c, d1));
    }

    public void navigateActivity(String classname)
    {
        try {

            Class myClass = Class.forName(classname);
            Intent i = new Intent(c1, myClass);
            c1.startActivity(i);
            if(c1 instanceof Activity){
                ((Activity)c1).finish(); }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}