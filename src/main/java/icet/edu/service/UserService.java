package icet.edu.service;





import icet.edu.dto.User;

import java.util.List;

public interface UserService {

      User findUserByEmailAndPassword(String email, String password) ;



    void addUser(User user);

    List<User> getUser();

    void deleteUser(Integer id);

    void updateUser(User user);

    User searchUser(Integer id);

    List<User> searchUserByEmail(String email);

}
