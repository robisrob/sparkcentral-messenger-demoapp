var app = (function () {
    function pageInit() {
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
                return fetch("rest/jwt?userId=" + $('#email').val())
                    .then(response => response.text())
                    .then(webtoken => Sparkcentral.login($('#email').val(), webtoken));
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

    function sparkcentralInit() {

        getAppId().then(appId => init(appId));

        function init(appId) {
            Sparkcentral.init({
                appId: appId,
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
        }

        function getAppId() {
            return fetch("rest/properties/appId").then(appIdResponse => appIdResponse.text());
        }
    }

    return {
        pageInit: pageInit,
        sparkcentralInit: sparkcentralInit
    };
})()


$(function () {
    app.pageInit();
    app.sparkcentralInit();
});
