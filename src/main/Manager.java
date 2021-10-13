/**
 * Public class storing information of a manager.
 *
 * @author Chan Yu & Naihe Xiao
 */

public class Manager extends User{

    /**
     * Constructor of Manager without parameter
     *
     */
    public Manager() {
    }

    /**
     * Constructor of Manager with id, username and password provided
     *
     * @param id
     * @param username
     * @param password
     */
    public Manager(String id, String username, String password) {
        super(id, username, password);
    }
}
