package presenter.user_system;

import presenter.user_system.view_interfaces.DisplayUsersViewInterface;
import presenter.user_system.view_interfaces.UserOutputBoundary;
import use_case.user_list.UserList;

/**
 * Presenter class for users
 */
public class UserPresenter implements UserOutputBoundary {

    private final UserList userList;
    private DisplayUsersViewInterface displayUsersViewInterface;

    public UserPresenter(){
        userList = new UserList();
        userList.setUserOutputBoundary(this);
    }

    /**
     * Setting up the DisplayUsersViewInterface.
     * @param viewInterface the view to display things to
     */
    public void setDisplayUsersViewInterface(DisplayUsersViewInterface viewInterface){
        this.displayUsersViewInterface = viewInterface;
    }

    /**
     * Update the display to show users
     * @param userItems the list of users as a string
     */
    @Override
    public void updateUserItemsDisplay(String userItems) {
        displayUsersViewInterface.setUserItemsText(userItems);
    }

    /**
     * Display users as string
     */
    public void displayUsersAsString(){
        userList.usersString();
    }

}
