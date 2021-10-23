package entity;

import entity.User;

/**
 * Public class storing information of a manager.
 *
 * @author Chan Yu & Naihe Xiao
 */

public class Manager extends User {

    /**
     * Constructor of UseCase.Manager with default info
     */
    public Manager() {
    }

    /**
     * Constructor of UseCase.Manager with id, name and password provided
     *
     * @param id       id of the UseCase.Manager
     * @param name     name of the UseCase.Manager
     * @param password password of the UseCase.Manager acct
     */
    public Manager(String id, String name, String password) {
        super(id, name, password);
    }

    /**
     * Override the toString method of Object and return a fine illustration of a UseCase.Manager information
     *
     * @return a string representation of this UseCase.Manager
     */
    @Override
    public String toString() {
        return "(Manager) " + super.toString();
    }
}
