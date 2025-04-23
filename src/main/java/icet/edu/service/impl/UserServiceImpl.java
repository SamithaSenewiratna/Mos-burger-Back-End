package icet.edu.service.impl;


import icet.edu.dto.User;
import icet.edu.entity.UserEntity;
import icet.edu.repository.UserRepository;
import icet.edu.service.UserService;
import lombok.RequiredArgsConstructor;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final private UserRepository repository;

    final  private ModelMapper mapper;




    @Override
    public void addUser(User user) {

       repository.save(mapper.map(user, UserEntity.class));

    }

    @Override
    public List<User> getUser() {

        List<UserEntity> all = repository.findAll();
        List<User>  users = new ArrayList<>();


        all.forEach(UserEntity ->{
            users.add(mapper.map(UserEntity, User.class));
        });

     return users;

    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
       repository.save(mapper.map(user,UserEntity.class));
    }

    @Override
    public User searchUser(Integer id) {

       return mapper.map(repository.findById(id),User.class);
    }

    @Override
    public List<User> searchUserByEmail(String email) {

        List<UserEntity> byEmail = repository.findByEmail(email);
        List<User> userList = new ArrayList<>();

        byEmail.forEach(UserEntity ->{

            userList.add(mapper.map(UserEntity,User.class));

        });

        return userList;
    }


    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        UserEntity userEntity = repository.findByEmailAndPassword(email, password);

        return (userEntity != null) ? mapper.map(userEntity, User.class) : null;
    }

}