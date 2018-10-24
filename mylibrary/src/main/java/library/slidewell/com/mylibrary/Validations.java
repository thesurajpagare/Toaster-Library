package library.slidewell.com.mylibrary;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class Validations {

    public  Validations(Context context) {

    }

    private boolean isValidEmail(CharSequence email) {
        if (!TextUtils.isEmpty(email)) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false;
    }

    private boolean isValidPhoneNumber(CharSequence phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            return Patterns.PHONE.matcher(phoneNumber).matches();
        }
        return false;
    }
}
