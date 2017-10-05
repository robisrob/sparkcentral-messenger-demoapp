package com.sparkcentral.smooch.jwtgenerator;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;

import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.util.Base64;
import io.jsonwebtoken.Jwts;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

public class UserJWTGeneratorHandler implements RequestStreamHandler {

    private final static String SECRETID = System.getenv("SECRETID");
    private final static String SECRETKEY = System.getenv("SECRETKEY");

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(createResponseJson(getUserId(inputStream)));
        writer.close();
    }

    private String createResponseJson(String userId) {
        JSONObject responseJson = new JSONObject();
        responseJson.put("headers", createJson("Access-Control-Allow-Origin", "*"));
        responseJson.put("statusCode", "200");
        responseJson.put("body", createJson("jsonwebtoken", UserJWTGenerator.createUserJwt(userId, SECRETID, SECRETKEY)).toString());
        return responseJson.toJSONString();
    }

    private JSONObject createJson(String key, String value) {
        JSONObject responseBody = new JSONObject();
        responseBody.put(key, value);
        return responseBody;
    }

    private String getUserId(InputStream inputStream) throws IOException {
        try {
            return tryGetUserId(inputStream);
        } catch(ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String tryGetUserId(InputStream inputStream) throws IOException, ParseException {
        JSONObject event = (JSONObject) new JSONParser().parse(new BufferedReader(new InputStreamReader(inputStream)));
        JSONObject qps = (JSONObject)event.get("queryStringParameters");
        return (String)qps.get("userId");
    }
}
