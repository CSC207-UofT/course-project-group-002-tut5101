package use_case.userList;

import constant.mangerSystem.UserType;
import use_case.boundary.input.EnrollUserInputBoundary;
import use_case.boundary.output.EnrollUserOutputBoundary;

public class EnrollStaffUseCase implements EnrollUserInputBoundary {

    private EnrollUserOutputBoundary enrollUserOutputBoundary;
    private final UserList userList;

    public EnrollStaffUseCase(UserList userList) {
        this.userList = userList;

    }

    public void setOutputBoundary(EnrollUserOutputBoundary enrollUserOutputBoundary) {
        this.enrollUserOutputBoundary = enrollUserOutputBoundary;
    }

    @Override
    public void getStaffTypes() {
        String[] staffTypes = {UserType.SERVING_STAFF.toString(),
                UserType.DELIVERY_STAFF.toString(),
                UserType.KITCHEN.toString(),
                UserType.INVENTORY_STAFF.toString()};
        this.enrollUserOutputBoundary.setNumPickerUserType(staffTypes, staffTypes.length - 1);
    }

    @Override
    public void enrollNewStaff(String id, String name, String password, String userType, int salary) {
        userList.addStaff(id, name, password, userType, salary);
    }

    @Override
    public void getNewUserId() {
        int userListSize = this.userList.getUsers().size();
        this.enrollUserOutputBoundary.setNewUserId(String.valueOf(userListSize));
    }


}
