//
//  AppChecks.m
//  socialite-pw-build
//
//  Created by Peter Williamson on 11/10/2013.
//
//

#import "AppDelegate.h"
#import "StatusMessage.h"
#import "JDStatusBarNotification.h"
#import <Cordova/CDVPluginResult.h>

@implementation StatusMessage

- (void)progress:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    NSString* str_perc = [arguments objectAtIndex:1];
    
    CGFloat perc = (CGFloat)[str_perc floatValue];
    [JDStatusBarNotification showProgress:perc];
}

- (void)show:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    NSString* message = [arguments objectAtIndex:1];
    NSString* fade = [arguments objectAtIndex:2];
    NSString* style = [arguments objectAtIndex:3];
    
    if([fade boolValue]){
        [JDStatusBarNotification
            showWithStatus:message
            dismissAfter:2.0
            styleName: style
         ];
    } else {
        [JDStatusBarNotification
            showWithStatus:message
            styleName: style
         ];
    }

}

- (void)hide:(NSMutableArray *)arguments withDict:(NSMutableDictionary *)options {
    [JDStatusBarNotification dismiss];
}

@end