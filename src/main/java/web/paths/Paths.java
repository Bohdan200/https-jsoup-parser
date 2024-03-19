package web.paths;

public class Paths {
    private static final String root = "https://jsonplaceholder.typicode.com/";

    public static String getRoot() { return root + "users"; }

    public static String getUserById(int id) {
        return root + "users/" + id;
    }

    public static String getUserByName(String username) {
        return root + "users?username=" + username;
    }

    public static String getUserPosts(int id) {
        return root + "users/" + id + "/posts";
    }

    public static String getComments(int id) {
        return root + "posts/" + id + "/comments";
    }

    public static String getTasks(int id) {
        return root + "users/" + id + "/todos";
    }
}
