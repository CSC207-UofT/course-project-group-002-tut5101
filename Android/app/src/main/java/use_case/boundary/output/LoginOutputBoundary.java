package use_case.boundary.output;

import constant.uiMessage.LoginResult;

public interface LoginOutputBoundary {
    void presentLoginResult(LoginResult result);
}
