package entity.user;

import java.io.Serializable;

/**
 * Implement private class design pattern to reduce exposure of central user data
 */
public class UserAttributes implements Serializable {
    private final String id;
    private final String name;
    private final String password;

    /**
     * Constructor for user attributes
     * @param id The id of a user
     * @param name The name of a user
     * @param password The password of a user
     */
    public UserAttributes(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     * Get the id of a user
     * @return id of the user
     */
    public String getId() { return this.id; }

    /**
     * Get the name of the user
     * @return name of the user
     */
    public String getName() { return this.name; }

    /**
     * Get the password of the user
     * @return password of the user
     */
    public String getPassword() { return this.password; }
}
