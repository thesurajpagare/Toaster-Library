package library.slidewell.com.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Login extends RelativeLayout {
    private String titleText;
    private boolean color;

    EditText e1,e2;
    ImageView imv_logo;
    Context c1;
    Button btnlogin;

    public Login(Context context) {
        super(context);
        init();
        c1=context;
        setTimeView();
    }

    public Login(Context context, AttributeSet attrs) {
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
                    setTimeView();
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

    public Login(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        c1=context;
        setTimeView();
    }

    private void setTimeView() {
        System.out.println("fdgdkjdkhjdh");
        // has the format hour.minuits am/pm
        /*SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String time = dateFormat.format(Calendar.getInstance().getTime());*/

        //  if(this.titleText != null )
        e1.setText("hi1");
        //   else
        e2.setText("hi2");
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
        inflate(getContext(), R.layout.lay_login, this);
        //  setBackgroundColor(getResources().getColor(R.color.card_background));

        //Add missing top level attributes
        // int padding = (int)getResources().getDimension(R.dimen.card_padding);
        //  setPadding(padding, padding, padding, padding);


        this.e1 = (EditText) findViewById(R.id.edusername);
        this.e2 = (EditText)findViewById(R.id.edpassword);
        this.imv_logo=(ImageView)findViewById(R.id.imv_logo);
        this.btnlogin=(Button)findViewById(R.id.btnLogin);


        this.btnlogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        // this.icon = (ImageView)findViewById(R.id.icon);
    }

    public void SetLoginType(String type) {

        if(type.matches("username")) {
            this.e1.setHint("Username");
        }else
        {
            this.e1.setHint("Email");
        }

    }

    public void setLogo(Context c,int d1) {
        this.imv_logo.setBackground(ContextCompat.getDrawable(c, d1));
    }
}