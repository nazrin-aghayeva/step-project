package az.company.booking_project.services;


import az.company.booking_project.Dao.UserDao;
import az.company.booking_project.entities.User;

public class UserService {
    private UserDao userDao =new UserDao();

    public User getUser(User user) {
        return userDao.get(user).orElseThrow(()->new IllegalArgumentException("User hasn't found"));
    }

    public void createNewUser(User user) {
        userDao.create(user);
    }

    public void deleteUser(int user_id){
        userDao.delete(user_id);
    }
}
