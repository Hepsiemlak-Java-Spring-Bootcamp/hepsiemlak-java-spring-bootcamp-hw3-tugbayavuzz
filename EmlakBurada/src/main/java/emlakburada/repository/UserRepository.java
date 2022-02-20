package emlakburada.repository;

import emlakburada.model.dto.Advert;
import emlakburada.model.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepository {

    private static List<User> userList = new ArrayList<>();

    public void createUser(User user) {
        userList.add(user);
        System.out.println(userList);
    }

    public List<User> findAllUser() {
        return userList;
    }

    public User findByEmail(String email) { //find one user
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public Set<Advert> findFavouriteAdvertsByUserId(Long userId) {
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                return user.getFavoriIlanlar();
            }
        }
        return null;
    }

}
