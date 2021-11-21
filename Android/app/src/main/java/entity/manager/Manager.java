package entity.manager;

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
        super("100", "Professor", "999");

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
