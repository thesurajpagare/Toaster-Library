package library.slidewell.com.customlibrary.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import library.slidewell.com.customlibrary.R;

public class Card extends RelativeLayout {
    private TextView header;
    private TextView description;
    private ImageView thumbnail;
    private ImageView icon;

    public Card(Context context) {
        super(context);
        init();
    }

    public Card(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Card(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.card, this);
      //  setBackgroundColor(getResources().getColor(R.color.card_background));

        //Add missing top level attributes
       // int padding = (int)getResources().getDimension(R.dimen.card_padding);
      //  setPadding(padding, padding, padding, padding);


        this.description = (TextView)findViewById(R.id.description);
        this.thumbnail = (ImageView)findViewById(R.id.thumbnail);
        this.icon = (ImageView)findViewById(R.id.icon);
    }
}