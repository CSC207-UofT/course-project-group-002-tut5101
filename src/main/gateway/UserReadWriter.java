package gateway;
import entity.User;
import use_case.UserList;

import java.io.*;
import java.util.HashMap;

public class UserReadWriter extends SuperReadWriter {


    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of users
     * @throws IOException
     */
    @Override
    public UserList readFromFile(String filePath){
        UserList users = new UserList();
        try{
        File f = new File(filePath);
        f.createNewFile();
        InputStream file = new FileInputStream(f);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        users = (UserList) input.readObject();
        input.close();
        }
        catch(IOException|ClassNotFoundException e){e.printStackTrace();}
        return users;
    }
}
