package project.booking.dao;

import java.io.*;
import java.util.List;


public class DAOBin<T> {
    private final File file;
    private List<T> data;

    public DAOBin(File file, List<T> data) {
        this.file = file;
        this.data = data;
    }

    public List<T> load() {
        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                List<T> in = (List<T>) ois.readObject();
                data.addAll(in);
                ois.close();
                fis.close();
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File isn't there.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't initialize the stream.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }

    public void save() {
        try {
            file.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.reset();
            oos.writeObject(data);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("users.txt file not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error while initializing stream");
        }
    }

}
