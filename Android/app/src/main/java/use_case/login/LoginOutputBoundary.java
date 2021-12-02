package use_case.login;

import constant.uimessage.LoginResult;

public interface LoginOutputBoundary {
    void presentLoginResult(LoginResult result);
}
