//
//  JDStatusBarStyle.m
//  JDStatusBarNotificationExample
//
//  Created by Markus on 04.12.13.
//  Copyright (c) 2013 Markus. All rights reserved.
//

#import "JDStatusBarStyle.h"

NSString *const JDStatusBarStyleDefault = @"JDStatusBarStyleDefault";
NSString *const JDStatusBarStyleTutorial = @"JDStatusBarStyleTutorial";

@implementation JDStatusBarStyle

- (instancetype)copyWithZone:(NSZone*)zone;
{
    JDStatusBarStyle *style = [[[self class] allocWithZone:zone] init];
    style.barColor = self.barColor;
    style.textColor = self.textColor;
    style.textShadow = self.textShadow;
    style.font = self.font;
    style.textVerticalPositionAdjustment = self.textVerticalPositionAdjustment;
    style.animationType = self.animationType;
    style.progressBarColor = self.progressBarColor;
    style.progressBarHeight = self.progressBarHeight;
    style.progressBarPosition = self.progressBarPosition;
    return style;
}

+ (NSArray*)allDefaultStyleIdentifier;
{
    return @[JDStatusBarStyleTutorial];
}

+ (JDStatusBarStyle*)defaultStyleWithName:(NSString*)styleName;
{
    // setup default style
    JDStatusBarStyle *style = [[JDStatusBarStyle alloc] init];
    
    style.barColor = [UIColor colorWithRed:0.678 green:0.169 blue:0.118 alpha:1]; // #ad2b1e
    style.progressBarColor = [UIColor whiteColor];
    style.progressBarHeight = 1.0;
    style.progressBarPosition = JDStatusBarProgressBarPositionBottom;
    style.textColor = [UIColor whiteColor];
    style.font = [UIFont boldSystemFontOfSize:13.0];
    style.animationType = JDStatusBarAnimationTypeMove;

    if ([styleName isEqualToString:JDStatusBarStyleTutorial]) {
        // JDStatusBarStyleTutorial
        style.barColor = [UIColor colorWithRed:0.722 green:0.122 blue:0.106 alpha:1]; // #b81f1b
        style.textColor = [UIColor whiteColor];
        style.progressBarColor = [UIColor redColor];
        style.progressBarHeight = 2.0;
        return style;
    }
   
    return style;
}

@end
