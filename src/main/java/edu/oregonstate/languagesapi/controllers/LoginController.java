package edu.oregonstate.languagesapi.controllers;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.AdminInitiateAuthRequest;
import com.amazonaws.services.cognitoidp.model.AdminInitiateAuthResult;
import com.amazonaws.services.cognitoidp.model.AuthFlowType;
import edu.oregonstate.languagesapi.models.LoginRequest;
import edu.oregonstate.languagesapi.models.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private AWSCognitoIdentityProvider cognitoClient;

    @Value(value = "${aws.cognito.userPoolId}")
    private String userPoolId;
    @Value(value = "${aws.cognito.clientId}")
    private String clientId;

    @PostMapping("/login")
    public @ResponseBody
    LoginResponse login(@RequestBody LoginRequest loginRequest) {

        LoginResponse loginResponse = new LoginResponse();

        try {
            AdminInitiateAuthRequest request = new AdminInitiateAuthRequest()
                    .withUserPoolId(userPoolId)
                    .withClientId(clientId)
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
