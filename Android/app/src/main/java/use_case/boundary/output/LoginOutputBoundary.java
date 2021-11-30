package use_case.boundary.output;

import constant.uimessage.LoginResult;

public interface LoginOutputBoundary {
    void presentLoginResult(LoginResult result);
}
