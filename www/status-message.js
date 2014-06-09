var StatusMessage = {
    progress: function( perc ) {
        cordova.exec(
            function() {},
            function(err) {
                console.log( err );
            },
            "StatusMessage",
            "progress",
            [ perc ]
        );
    },
    show: function( text, fade, style ) {
        cordova.exec(
            function() {},
            function(err) {
                console.log( err );
            },
            "StatusMessage",
            "show",
            [ text, fade, style ]
        );
    },
    hide: function() {
        cordova.exec(
            function() {},
            function(err) {
                console.log( err );
            },
            "StatusMessage",
            "hide",
            []
        );
    }
};

module.exports = StatusMessage;
