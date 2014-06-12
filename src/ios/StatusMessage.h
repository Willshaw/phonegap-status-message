//  StatusMessage
#import <Cordova/CDV.h>

@interface StatusMessage : CDVPlugin

- (void) progress:(CDVInvokedUrlCommand*)command;
- (void) show:(CDVInvokedUrlCommand*)command;
- (void) hide:(CDVInvokedUrlCommand*)command;

@end