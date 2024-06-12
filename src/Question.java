import java.util.List;

public class Question {

    private int id;
    private String title;
    private String body;

    private int userId;

    private List<Answer> answerList;

    private List<Comment> commentList;

    private  List<Tag> tagList;
    private int vote;

    public Question(int id, String title, String body, int userId, List<Answer> answerList, List<Comment> commentList, List<Tag> tagList) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.answerList = answerList;
        this.commentList = commentList;
        this.tagList = tagList;
        this.vote = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
