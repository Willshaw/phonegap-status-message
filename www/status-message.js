var StatusMessage = {
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
    },
    progress: function( msg, perc ) {
        cordova.exec(
            function( msg ) {},
            function(err) {
                console.log( err );
            },
            "StatusMessage",
            "progress",
            [ msg, perc ]
        );
    },
    show: function( text ) {

        cordova.exec(
            function() {},
            function(err) {
                console.log( err );
            },
            "StatusMessage",
            "show",
            [ text ]
        );
    }
};

module.exports = StatusMessage;
