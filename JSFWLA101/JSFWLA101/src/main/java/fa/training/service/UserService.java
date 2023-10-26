package fa.training.service;

import fa.training.dto.UserForCreate;
import fa.training.entity.TurbineUser;

import java.util.List;

public interface UserService {
    public void addUserWithPosts(UserForCreate userForCreate);

    public List<Object[]> list();

    public TurbineUser findByUsername(String username);
}
