package com.willshawmedia.phonegap;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.willshawmedia.pluginCheck.R;

import android.content.Context;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class StatusMessage extends CordovaPlugin {

    private int notification_static = 111;
    private int notification_progress = 222;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ( action.equals( "progress" ) ) {
            String msg = args.getString( 0 ); 
            String tmp_perc = args.getString( 1 ); 
            double perc = Double.parseDouble(tmp_perc);

            this.progress( msg, perc, callbackContext );
            return true;
        } else if ( action.equals( "show" ) ) {
            String msg = args.getString( 0 );
            this.show( msg, callbackContext );
            return true;
        } else if ( action.equals( "hide" ) ) {
            this.hide( callbackContext );
            return true;
        }
        return false;
    }

    private void progress( String msg, double perc, CallbackContext callbackContext ) {
        try {
        
            NotificationManager mNotificationManager =
                (NotificationManager) cordova.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);            

            Context context=this.cordova.getActivity().getApplicationContext();
                
            // increment progress bar
            Double incr_double = perc * 100;
            Integer incr = incr_double.intValue();

            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.status_message_progress)
                    .setContentTitle( msg )
                    .setTicker( msg )
                    .setNumber( incr )
                    .setContentText( "In progress" )
                    .setProgress( 100, incr, false );

            mNotificationManager.notify( notification_progress, mBuilder.build() );

            if( perc >= 1 ) {
                mNotificationManager.cancel( notification_progress );
            }
            
            callbackContext.success("val was " + perc + " and msg was " + msg);
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }
    }

    private void show( String msg, CallbackContext callbackContext ) {
        try {
            
        	Context context=this.cordova.getActivity().getApplicationContext();
        	
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.status_message_icon)
                    .setContentTitle( msg )
                    .setTicker( msg )
                    .setContentText("Test message");
            
            NotificationManager mNotificationManager =
                (NotificationManager) cordova.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            
            mNotificationManager.notify( notification_static, mBuilder.build() );

            // remove notification as soon as it's shown
            mNotificationManager.cancel( notification_static );
            
            callbackContext.success();
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }
    }

    private void hide( CallbackContext callbackContext ) {
        try {
            
            NotificationManager mNotificationManager =
                (NotificationManager) cordova.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

            mNotificationManager.cancel( notification_static );

            callbackContext.success();
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }
    }

}
