//  AppChecks.m
#import "AppDelegate.h"
#import "StatusMessage.h"
#import "JDStatusBarNotification.h"
#import <Cordova/CDV.h>

@implementation StatusMessage

- (void)progress:(CDVInvokedUrlCommand*)command {
    NSString* str_perc = [command.arguments objectAtIndex:1];
    
    CGFloat perc = (CGFloat)[str_perc floatValue];
    [JDStatusBarNotification showProgress:perc];
}

- (void)show:(CDVInvokedUrlCommand*)command {
    NSString* message = [command.arguments objectAtIndex:0];

    [JDStatusBarNotification
        showWithStatus:message
        dismissAfter:2.0
     ];
}

- (void)hide:(CDVInvokedUrlCommand*)command {
    [JDStatusBarNotification dismiss];
}

@end