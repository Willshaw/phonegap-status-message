var StatusMessage = {
    progress: function( msg, perc ) {
        cordova.exec(
            function( msg ) {
                console.log('it worked: ' + msg);
            },
            function(err) {
                console.log( err );
            },
            "StatusMessage",
            "progress",
            [ msg, perc ]
        );
            // [{ "msg": msg, "perc": perc }]
    },
    show: function( text, fade, style ) {

        if( typeof fade === 'undefined' ) {
            fade = 0;
        }

        if( typeof style === 'undefined' ) {
            style = '';
        }        

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
