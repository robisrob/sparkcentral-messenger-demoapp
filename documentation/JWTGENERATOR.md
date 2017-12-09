# sparkcentral-rtm-demo-jwtgenerator [![Build Status](https://travis-ci.org/sparkcentral/sparkcentral-rtm-demo-jwtgenerator.svg)](https://travis-ci.org/sparkcentral/sparkcentral-rtm-demo-jwtgenerator)
To identify a user in the sparkcentral chatclient, you need to pass a signed JWT to the login function. This jwt will contain the userId and is signed using the secret key from the app.

This application will create this token based on a given userId. This application is webapplication.

## Deploy
- `./gradlew shadowJar`
- deploy build/libs/sparkcentral-rtm-demo-jwtgenerator-all.jar as a AWS Lambda
- set the environment variables SECRETID and SECRETKEY when deploying the AWS Lambda

## Documentation

The application will create a JWT with the following header and payload.

JWT Header
```
{
  "kid": YOUR_SECRET_ID,
  "typ": "JWT",
  "alg": "HS256"
}
```
JWT payload
```
{
  "scope": "appUser",
  "userId": THE_USER_ID
}
```
The JWT is created using following [code](https://github.com/sparkcentral/sparkcentral-rtm-demo-jwtgenerator/blob/master/src/main/java/com/sparkcentral/smooch/jwtgenerator/UserJWTGenerator.java):

```
templates String createUserJwt(String userId, String secretId, String secretKey) {
  return Jwts.builder()
            .claim("scope", "appUser")
            .claim("userId", userId)
            .setHeaderParam("kid", secretId)
            .setHeaderParam("typ", "JWT")
            .signWith(HS256, base64Encoded(secretKey))
            .compact();
 }

private templates String base64Encoded(String value) {
  return new String(Base64.encode(value.getBytes()));
}
```
#Clear Credit demo application
## Run application
`docker run -eAPP_ID=${app_id} -eSECRET_ID=${secret_id} -eSECRET_KEY={secret_key} -p5000:8080 sparkcentralinc/sparkcentral-rtm-demo-jwtgenerator:26`

