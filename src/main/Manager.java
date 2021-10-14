/**
 * Public class storing information of a manager.
 *
 * @author Chan Yu & Naihe Xiao
 */

public class Manager extends User {

    /**
     * Constructor of Manager with default info
     */
    public Manager() {
    }

    /**
     * Constructor of Manager with id, name and password provided
     *
     * @param id       id of the Manager
     * @param name     name of the Manager
     * @param password password of the Manager acct
     */
    public Manager(String id, String name, String password) {
        super(id, name, password);
    }

    /**
     * Override the toString method of Object and return a fine illustration of a Manager information
     *
     * @return a string representation of this Manager
     */
    @Override
    public String toString() {
        return "(Manager) " + super.toString();
    }
}
