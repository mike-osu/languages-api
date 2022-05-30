package edu.oregonstate.languagesapi.controllers;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.AdminInitiateAuthRequest;
import com.amazonaws.services.cognitoidp.model.AdminInitiateAuthResult;
import com.amazonaws.services.cognitoidp.model.AuthFlowType;
import com.fasterxml.jackson.core.JsonProcessingException;
import edu.oregonstate.languagesapi.models.LoginRequest;
import edu.oregonstate.languagesapi.models.LoginResponse;
import edu.oregonstate.languagesapi.models.Secret;
import edu.oregonstate.languagesapi.security.SecretManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private AWSCognitoIdentityProvider cognitoClient;

    @PostMapping("/login")
    public @ResponseBody
    LoginResponse login(@RequestBody LoginRequest loginRequest) throws JsonProcessingException {

        LoginResponse loginResponse = new LoginResponse();

        try {
            Secret secret = SecretManager.getSecret();

            AdminInitiateAuthRequest request = new AdminInitiateAuthRequest()
                    .withUserPoolId(secret.getUserPoolId())
                    .withClientId(secret.getAppClientId())
                    .withAuthFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
                    .withAuthParameters(getAuthParams(loginRequest));

            AdminInitiateAuthResult result = cognitoClient.adminInitiateAuth(request);
            loginResponse.setIdToken(result.getAuthenticationResult().getIdToken());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return loginResponse;
    }

    private Map<String, String> getAuthParams(LoginRequest loginRequest) {
        Map<String, String> authParams = new HashMap<>();
        authParams.put("USERNAME", loginRequest.getUsername());
        authParams.put("PASSWORD", loginRequest.getPassword());
        return authParams;
    }
}
