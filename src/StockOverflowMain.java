import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockOverflowMain {

    public static void main(String args[]){

        StackOverflowController con = StackOverflowController.getInstance();

        User u1 = new User(1,"ash1@gmaiil.com", "Test@123", "Ashi1");
        User u2 = new User(1,"ash2@gmaiil.com", "Test@123", "Ashi2");
        User u3 = new User(1,"ash3@gmaiil.com", "Test@123", "Ashi3");

        con.userSignup(1,u1);
        con.userSignup(2,u2);
        con.userSignup(3,u3);

        User us = con.login("ash1@gmaiil.com", "Test@123");
        if(us == null){
            System.out.println("Please provide correct credential");
        }
        else{
            System.out.println("User is logged in : "+us);
            Question q = new Question(1,"Java","What is Java", us.getId(), new ArrayList<>(),new ArrayList<>(), Arrays.asList(new Tag(1,"OOPS", Instant.now()),new Tag(2,"Java", Instant.now())));
            con.addQuestion(q);

            Answer ans1 = new Answer(1,"Java is beautiful", us.getId(),1);
            Answer ans2 = new Answer(2,"Java is good", us.getId(),1);
            Answer ans3 = new Answer(3,"Java is so so", us.getId(),1);

            con.addAnswer(ans1, q.getId());
            con.addAnswer(ans2, q.getId());
            con.addAnswer(ans3, q.getId());

            con.addQuestionComments(new Comment(1,"Nice", us.getId()), q.getId());

            con.upVoteQuestion(q,1);
            con.upVoteAnswer(ans1,1);
            con.upVoteAnswer(ans2,1);
            con.upVoteAnswer(ans3,1);

            List<Question> searchResults = con.filterByQuestion("Java");
            System.out.println("Search Results:");
            for (Question question : searchResults) {
                System.out.println(question.getTitle());
            }

            List<Question> searchTagResults = con.filterByTag("OOPS");
            System.out.println("Search Results:");
            for (Question question : searchTagResults) {
                System.out.println(question.getTitle());
            }

            List<Question> searchUserResults = con.filterByUser(us.getId());
            System.out.println("Search Results:");
            for (Question question : searchUserResults) {
                System.out.println(question.getTitle());
            }


        }


    }
}
