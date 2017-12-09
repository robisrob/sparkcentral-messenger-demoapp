# Add Sparkcentral Messenger to your website
Demo application that uses Sparkcentral real-time messaging

## Documentation
### Include the following script on [the html page](../src/main/resources/static/index.html)
```
<script>
var loaderUrl = 'https://cdn.sparkcentral.com/rtm/web/loader.latest.json';
!function (e, n, t, r) { function s() { try { var e; if ((e = "string" == typeof this.response ? JSON.parse(this.response) : this.response).url) { var t = n.getElementsByTagName("script")[0], r = n.createElement("script"); r.async = !0, r.src = e.url, t.parentNode.insertBefore(r, t) } } catch (e) { } } var o, a, p, c = [], i = []; e[t] = { init: function () { o = arguments; var e = { then: function (n) { return i.push({ type: "t", next: n }), e }, catch: function (n) { return i.push({ type: "c", next: n }), e } }; return e }, on: function () { c.push(arguments) }, render: function () { a = arguments }, destroy: function () { p = arguments } }, e.__onWebMessengerHostReady__ = function (n) { if (delete e.__onWebMessengerHostReady__, e[t] = n, o) for (var r = n.init.apply(n, o), s = 0; s < i.length; s++) { var u = i[s]; r = "t" === u.type ? r.then(u.next) : r.catch(u.next) } a && n.render.apply(n, a), p && n.destroy.apply(n, p); for (s = 0; s < c.length; s++)n.on.apply(n, c[s]) }; var u = new XMLHttpRequest; u.addEventListener("load", s), u.open("GET", loaderUrl, !0), u.responseType = "json", u.send() }(window, document, "Sparkcentral");
</script>
```
To prevent delay, we have put this script in the bottom of our page.
### Setting up the webmessenger in [the javascript file](../src/main/resources/static/js/app.js)
#### Call the init function on Sparkcentral
````
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
````
### Identify a user
Default an anonymous chatsession is started. To identify the user we call the login function on Sparkcentral. We need to pass the identifier of our choice and a json webtoken containing the identifier. This token is signed with the app secret. Because we don't want to expose our app secret, we deployed a service that can generate the json webtoken given an identifier.

Documentation of such a service [JWT generator](JWTGENERATOR.md).

```
function loginInSparkcentral() {
    return fetch("jwt?userId=" + $('#email').val())
                               .then(response => response.text())
                               .then(webtoken => Sparkcentral.login($('#email').val(), webtoken));
    }
```
When we login, we also want to set some information about the user. We call the updateUser on Sparkcentral
```
function sendUserInfoToSparkcentral() {
    Sparkcentral.updateUser({
        givenName: $('#firstName').val(),
        surname: $('#lastName').val(),
        email: $('#email').val()
    });
}
```
To logout we call the following function
```
function logoutInSparkcentral() {
    Sparkcentral.logout();
}
