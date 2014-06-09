package com.willshawmedia.phonegap;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;
import android.content.SharedPreferences;

public class StatusMessage extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ( action.equals( "progress" ) ) {
            this.progress( args.getLong( 0 ), callbackContext );
            return true;
        } else if ( action.equals( "show" ) ) {
            String msg = args.getString( 0 );
            String fade = args.getString( 1 );
            String style = args.getString( 2 );
            this.show( msg, fade, style, callbackContext );
            return true;
        } else if ( action.equals( "hide" ) ) {
            this.hide( callbackContext );
            return true;
        }
        return false;
    }

    private void progress( Float perc, CallbackContext callbackContext ) {
        try {
            // NSString* str_perc = [arguments objectAtIndex:1];
            
            // CGFloat perc = (CGFloat)[str_perc floatValue];
            // [JDStatusBarNotification showProgress:perc];
            
            callbackContext.success( packageInfo.versionCode );
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }
    }

    private void show( String msg, Boolean fade, String style, CallbackContext callbackContext ) {
        try {
            // if([fade boolValue]){
            //     [JDStatusBarNotification
            //         showWithStatus:message
            //         dismissAfter:2.0
            //         styleName: style
            //      ];
            // } else {
            //     [JDStatusBarNotification
            //         showWithStatus:message
            //         styleName: style
            //      ];
            // }
            callbackContext.success( packageInfo.versionCode );
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }

    }

    private void hide( CallbackContext callbackContext ) {
        try {
            // [JDStatusBarNotification dismiss];
            callbackContext.success( packageInfo.versionCode );
        } catch ( Exception e ) {
            callbackContext.error( e.getMessage() );
        }
    }

}
