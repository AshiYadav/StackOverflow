public class Answer {

    private int id;
    private String body;
    private int userId;
    private int vote;

    public Answer(int id, String body, int userId, int vote) {
        this.id = id;
        this.body = body;
        this.userId = userId;
        this.vote = vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
