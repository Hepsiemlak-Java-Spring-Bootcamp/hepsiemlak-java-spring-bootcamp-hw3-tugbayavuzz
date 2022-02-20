package emlakburada.service.impl;

import emlakburada.model.dto.Advert;
import emlakburada.model.dto.User;
import emlakburada.repository.UserRepository;
import emlakburada.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public User findByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("Data not found!");
        }

        return user;
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public Set<Advert> findFavouriteAdvertsByUserId(Long userId) {
        return userRepository.findFavouriteAdvertsByUserId(userId);
    }

}
