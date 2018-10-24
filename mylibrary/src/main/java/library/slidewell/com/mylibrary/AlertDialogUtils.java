package library.slidewell.com.mylibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


/**
 * Created by Madhuri Patil , Nashik on 31/7/17.
 */

public class AlertDialogUtils {

//    public static void showCustomAlertDialogSwitching(final Context context, String message, final int switchFragment)
//    {
//        try {
//            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
//            builder.setMessage(message);
//            builder.setCancelable(false);
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                    ((DashboardActivity) context).getSupportFragmentManager().popBackStack(null, ((DashboardActivity) context).getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
//                    ((DashboardActivity) context).setPhotoImage(switchFragment);
//                }
//            });
//            builder.show();
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    public static void showCustomAlertDialogSwitchingNotification(final Context context, String message, final int switchFragment)
//    {
//        try {
//            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
//            builder.setMessage(message);
//            builder.setCancelable(false);
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                    ((DashboardActivity) context).getSupportFragmentManager().popBackStack(null, ((DashboardActivity) context).getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
//                    ((DashboardActivity) context).setPhotoImage(switchFragment);
//                }
//            });
//            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            });
//            builder.show();
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }

    public static void showCustomAlertDialog(final Context context, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.AlertDialogTheme);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        builder.show();
    }

}
