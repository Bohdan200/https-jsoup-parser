package web.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import web.paths.Paths;
import web.data.Post;
import web.data.Task;
import web.data.Comment;
import web.methods.DataMethods;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataParser {
    public static void getCommentsToLastPost(int userId) throws IOException {
        String posts = DataMethods.get(Paths.getUserPosts(userId));
        List<Post> allPosts = new Gson().fromJson(posts, DataMethods.getType(Post.class));

        int lastPostIdx = allPosts.get(1).getId();
        for (Post post : allPosts) {
            if (post.getId() > lastPostIdx)
                lastPostIdx = post.getId();
        }

        String comments = DataMethods.get(Paths.getComments(lastPostIdx));
        List<Comment> allComments = new Gson().fromJson(comments, DataMethods.getType(Comment.class));

        FileWriter fileWriter = new FileWriter("user-" + userId + "-posts-" + lastPostIdx + "-comments.json");

        for (Comment comment : allComments) {
            String parseBody = comment.getBody().lines().reduce("", (acc, p) -> acc + p);
            comment.setBody(parseBody);
            String jsonComment = new GsonBuilder().setPrettyPrinting().create().toJson(comment);

            System.out.println(jsonComment);
            fileWriter.write(jsonComment);
        }
        fileWriter.close();
    }
 public static void getUncompletedTasks(int userId) throws IOException {
        String tasks = DataMethods.get(Paths.getTasks(userId));
        List<Task> allTasks = new Gson().fromJson(tasks, DataMethods.getType(Task.class));

        for (Task task : allTasks) {
            if (!task.isCompleted()) {
                System.out.println(task);
            }
        }
    }
}
