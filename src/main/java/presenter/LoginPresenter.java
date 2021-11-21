package presenter;

import constant.uiMessage.LoginResult;
import use_case.boundary.output.LoginOutputBoundary;

public class LoginPresenter implements LoginOutputBoundary {
    @Override
    public LoginResult presentLoginResult(LoginResult result) {
        return result;
    }
}
