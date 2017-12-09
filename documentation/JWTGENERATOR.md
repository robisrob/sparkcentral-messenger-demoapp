# JWT Generator
To identify a user in Sparkcentral Messenger, you need to pass a signed JWT to the login function. This jwt will contain the userId and is signed using the secret key from the app.

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
The JWT is created using following [code](../src/main/java/com/sparkcentral/jwtgenerator/services/UserJWTGenerator.java):

```
public String createUserJwt(String userId) {
        return Jwts.builder()
                .claim("scope", "appUser")
                .claim("userId", userId)
                .setHeaderParam("kid", secretId)
                .setHeaderParam("typ", "JWT")
                .signWith(HS256, base64Encoded(secretKey))
                .compact();
    }

    private String base64Encoded(String value) {
        return new String(encodeBase64(value.getBytes()));
    }
```


