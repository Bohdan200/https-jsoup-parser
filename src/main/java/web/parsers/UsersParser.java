package web.parsers;

import com.google.gson.Gson;
import web.paths.Paths;
import web.methods.UserMethods;
import web.user.User;
import web.user.UserAddress;
import web.user.UserGeolocaton;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class UsersParser {
    public static void getUsers() throws IOException {
        String jsonAllUsers =  UserMethods.get(Paths.getRoot());
        Type typeToken = UserMethods.getType();

        List<User> users = new Gson().fromJson(jsonAllUsers, typeToken);
        users.forEach(System.out::println);
    }

    public static void getUserById(int userId) throws IOException {
        String jsonUserById =  UserMethods.get(Paths.getUserById(userId));
        User user = new Gson().fromJson(jsonUserById, User.class);

        System.out.println(user.toString());
    }
    public static void getUserByName() throws IOException {
        String jsonUserByName =  UserMethods.get(Paths.getUserByName("Samantha"));
        Type typeToken = UserMethods.getType();

        List<User> usersByName = new Gson().fromJson(jsonUserByName, typeToken);
        usersByName.forEach(System.out::println);
    }

    public static void postUser() throws IOException {
        UserGeolocaton geolocaton = new UserGeolocaton("30", "50");
        UserAddress address = new UserAddress("48th Terrace", "112", "Miami", "58804-1099", geolocaton);
        User newUser = new User(11, "Henry Sonvar", "Halk", "sonvar@billy.biz", address, "210.066.5836", "sonvar.io");

        String postResponse = UserMethods.post(Paths.getRoot(), newUser);
        System.out.println(postResponse);
    }

    public static void putUser(int userId) throws IOException {
        String putResponse = UserMethods.put(Paths.getUserById(userId));
        System.out.println(putResponse);
    }
    public static void removeUser() throws IOException {
        String removeResponse = UserMethods.remove(Paths.getUserById(8));
        System.out.println(removeResponse);
    }
}
