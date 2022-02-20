package emlakburada.service;

import emlakburada.model.dto.Advert;
import emlakburada.model.dto.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> findAllUser();

    User findByEmail(String email) throws Exception;

    void createUser(User user);

    Set<Advert> findFavouriteAdvertsByUserId(Long userId);

}
