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

    private int notificationID = 100;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ( action.equals( "progress" ) ) {
//            this.progress( args.getLong( 0 ), callbackContext );
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

    private void progress( Long perc, CallbackContext callbackContext ) {
        try {
            // NSString* str_perc = [arguments objectAtIndex:1];
            
            // CGFloat perc = (CGFloat)[str_perc floatValue];
            // [JDStatusBarNotification showProgress:perc];
            
            callbackContext.success();
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
            
            mNotificationManager.notify(notificationID, mBuilder.build());

            // remove notification as soon as it's shown
            mNotificationManager.cancel(notificationID);
            
            callbackContext.success();
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }

    }

    private void hide( CallbackContext callbackContext ) {
        try {
            
            NotificationManager mNotificationManager =
                (NotificationManager) cordova.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

            mNotificationManager.cancel(notificationID);

            callbackContext.success();
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }
    }

}
