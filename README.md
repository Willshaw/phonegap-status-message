Phonegap Status Message
======================

Show a message in the app status bar

### Install/Remove

Use the cordova CLI:

#### Install

```cordova plugin add https://github.com/willshaw/phonegap-status-message.git```

#### Setup

For Android add a **status_message_icon.png** to the **res/drawable** folders, this is required for the notification icon.

#### Requirements

Thanks to MPJHorner for pointing out this requires the `QuartzCore` framework to work with iOS - doesn't compile without

#### Remove 

```cordova plugin remove com.willshawmedia.phonegap.StatusMessage```
