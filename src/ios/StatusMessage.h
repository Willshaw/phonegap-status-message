//  StatusMessage
#import <Cordova/CDV.h>

@interface StatusMessage : CDVPlugin

- (void) progress:(CDVInvokedCommand*)command;
- (void) show:(CDVInvokedCommand*)command;
- (void) hide:(CDVInvokedCommand*)command;

@end