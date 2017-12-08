var app = (function () {
    function init() {
        $('#loginForm').on('submit', login);
        $('#logoutMenuItem').on('click', logout);
        $('#loginModal').on('shown.bs.modal', setFocusOnEmailInLoginForm)

        function login(event) {
            preventSubmitLoginForm();
            sendUserInfoToSparkcentral();
            loginInSparkcentral()
                .then(() => clearLoginForm());
            showLogoutButton();
            hideLoginModal();

            function preventSubmitLoginForm() {
                event.preventDefault();
            }

            function sendUserInfoToSparkcentral() {
                Sparkcentral.updateUser({
                    givenName: $('#firstName').val(),
                    surname: $('#lastName').val(),
                    email: $('#email').val()
                });
            }

            function loginInSparkcentral() {
                return fetch("jwt?userId=" + $('#email').val())
                    .then(response => response.json())
                    .then(json => Sparkcentral.login($('#email').val(), json.jsonwebtoken));
            }

            function clearLoginForm() {
                $('#loginForm').trigger('reset');
            }

            function showLogoutButton() {
                $('#loginMenuItem').hide();
                $('#logoutMenuItem').show();
            }

            function hideLoginModal() {
                $('#loginModal').modal('hide');
            }
        }

        function logout() {
            logoutInSparkcentral();
            showLoginButton();

            function showLoginButton() {
                $('#loginMenuItem').show();
                $('#logoutMenuItem').hide();
            }

            function logoutInSparkcentral() {
                Sparkcentral.logout();
            }
        }

        function setFocusOnEmailInLoginForm() {
            $('#email').focus();
        }
    };

    return {
        init: init
    };
})()

$(function () {
    app.init();

    Sparkcentral.init({
        appId: '59dfaccf38c35f002805cb66',
        customText: {
            headerText: 'How can we help?',
            inputPlaceholder: 'Type a message...',
            sendButtonText: 'Send',
            introductionText: 'We\'re here to talk, so ask us anything!',
            introAppText: 'Message us below or from your favorite app.',
            messageError: 'An error occured while sending your message. Please try again.',
            invalidFileError: 'Only images are supported. Choose a file with a supported extension (jpg, jpeg, png, gif, or bmp).',
            messageIndicatorTitleSingular: '({count}) New message',
            messageIndicatorTitlePlural: '({count}) New messages',
            connectNotificationText: 'Be notified inside your other apps when you get a reply.',
            fetchingHistory: 'Retrieving history...',
            fetchHistory: 'Load more',
            clickToRetry: 'Message not delivered. Click to retry.',
            tapToRetry: 'Message not delivered. Tap to retry.'
        }
    });
});
