package web.data;

public class Comment {
    private final int postId;
    private final int id;
    private final String name;
    private final String email;
    private String body;

    public Comment(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\tpostId: \"" + postId + "\";\n" +
                "\tid: \"" + id + "\";\n" +
                "\tname: \"" + name + "\";\n" +
                "\temail: \"" + email + "\";\n" +
                "\tbody: \"" + body + "\";\n" +
                "},";
    }
}
