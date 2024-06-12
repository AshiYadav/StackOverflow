import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflowController {

    private static StackOverflowController instance;
    private ConcurrentHashMap<Integer, User> userMap;
    private ConcurrentHashMap<Integer, Question> questionMap;
    private ConcurrentHashMap<String, List<Question>> tagMap;

    private User currentUser;




    public StackOverflowController() {
        this.userMap = new ConcurrentHashMap<>();
        this.questionMap = new ConcurrentHashMap<>();
        this.tagMap = new ConcurrentHashMap<>();
    }

    public static StackOverflowController getInstance(){
        if(instance == null){
            synchronized (StackOverflowController.class){
                if(instance == null){
                    return  new StackOverflowController();
                }
            }
        }
        return instance;
    }

    public void userSignup(int id, User user){
        userMap.put(id, user);
    }

    public User login(String email, String password){
        for (User user : userMap.values()) {

            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                currentUser = user;
                return user;
            }
        }
        return null;

    }

    public void logout(String email){
        this.currentUser = null;
    }

    public void addQuestion(Question question){
        questionMap.put(1,question);
        for (Tag tag : question.getTagList()) {
            tagMap.computeIfAbsent(tag.getKeyTag(), k -> new ArrayList<>()).add(question);
        }
    }

    public void addAnswer(Answer ans, int questionId){
        Question qu = questionMap.get(questionId);
        List<Answer> answerList = qu.getAnswerList();
        answerList.add(ans);

    }

    public void addQuestionComments(Comment comm, int questionId){
        Question qu = questionMap.get(questionId);
        List<Comment> commentList = qu.getCommentList();
        commentList.add(comm);
    }

    public void upVoteQuestion(Question question, int value){
//        if(questionMap.containsKey(id)){
//            Question qu = questionMap.get(id);
//            qu.setVote(qu.getVote() + 1);
//        }
//        else{
//            System.out.println("Question Id does not exists");
//        }
        synchronized (question) {
            question.setVote(question.getVote() + value);
        }
        updateUserReputation(userMap.get(question.getUserId()), value);
    }

    public void upVoteAnswer(Answer ans, int value){
//        if(questionMap.containsKey(id)){
//            Question qu = questionMap.get(id);
//            List<Answer> ansList = qu.getAnswerList();
//            for(Answer aa : ansList){
//                if(aa.getBody().equals(ans.getBody())){
//                    aa.setVote(aa.getVote()+1);
//                }
//            }
//        }
//        else{
//            System.out.println("Question Id does not exists");
//        }
        synchronized (ans) {
            ans.setVote(ans.getVote() + value);
        }
        updateUserReputation(userMap.get(ans.getUserId()), value);
    }

    private void updateUserReputation(User user, int value) {
        synchronized (user) {
            user.setReputation(user.getReputation() + value);
        }
    }

    public List<Question> filterByQuestion(String tt){
        List<Question> questionList = new ArrayList<>();
        for(Question qu : questionMap.values()){
            if(qu.getTitle().contains(tt) || qu.getBody().contains(tt)){
                questionList.add(qu);
            }
        }

        return questionList;
    }

    public List<Question> filterByTag(String tt){
        if(tagMap.get(tt) != null) {
            return tagMap.get(tt);
        }
        return new ArrayList<>();
    }

    public List<Question> filterByUser(int userId){
        List<Question> questionList = new ArrayList<>();
        for(Question qu : questionMap.values()){
            if(qu.getUserId() == userId){
                questionList.add(qu);
            }
        }

        return questionList;
    }
}
