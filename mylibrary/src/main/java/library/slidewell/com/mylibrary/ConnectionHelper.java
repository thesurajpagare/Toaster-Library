package library.slidewell.com.mylibrary;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Check Network Connectivity
 *
 * @author Madhuri Patil
 * @since 08/05/2017
 */
public class ConnectionHelper {

    public boolean isConnected(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    /**
     * Check if there is any connectivity for a Wifi network
     *
     * @param context Application Context
     * @return
     */
    public boolean isConnectedWifi(Context context) {
        NetworkInfo info = Connectivity.getNetworkInfo(context);
        return info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI;
    }


    /**
     * Check if there is any connectivity for a mobile network
     *
     * @param context Application Context
     * @return
     */
    public boolean isConnectedMobile(Context context) {
        NetworkInfo info = Connectivity.getNetworkInfo(context);
        return info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_MOBILE;
    }

    /**
     * Check all connectivity whether available or not
     *
     * @param context Application Context
     * @return
     */
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        // if no network is available networkInfo will be null otherwise check if we are connected
        return networkInfo != null && networkInfo.isConnected();
    }
}
