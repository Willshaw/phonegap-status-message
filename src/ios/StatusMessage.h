//
//  StatusMessage
//
//  Created by Peter Williamson on 09/06/2014
//
//
#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>

@interface StatusMessage : CDVPlugin

- (void) progress:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
- (void) show:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
- (void) hide:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

@end