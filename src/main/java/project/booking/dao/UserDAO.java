package project.booking.dao;

import project.booking.entity.User;

import java.io.*;
import java.util.*;

public class UserDAO implements DAO<User> {
    Map<Integer, User> users= new HashMap<>();
    File userFile= new File("users.txt");
    @Override
    public User get(int id) {
        User user= users.get(id);
        return user;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void create(User user) {
        users.put(user.id, user);
    }

    @Override
    public void delete(int id) {
        users.remove(id);
        Write();
    }
    @Override
    public void Write(){
        try( FileOutputStream fos= new FileOutputStream(userFile) ) {
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(users);
        }catch (IOException ex){
            System.out.println("No file found");
        }
    }
    @Override
    public void Read() {
        try( FileInputStream fis= new FileInputStream(userFile)){
            ObjectInputStream ois= new ObjectInputStream(fis);
            users= (Map<Integer, User>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException ex){
            System.out.println("File from user is not found");
        }
    }


}
