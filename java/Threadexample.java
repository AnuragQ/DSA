import java.util.Scanner;
import java.util.*;

class Question
{
  String question ;
  int no;
  HashMap<Integer,String> options;
  String correctanswer;

  public  void  q_no(){
    System.out.println("enter a question no");
    // int no;
    Scanner sc = new  Scanner(System.in);
    no = sc.nextInt();
    sc.close();
  }
  public  void set_question(){
    System.out.println("enter aquestion");
    Scanner f = new Scanner(System.in);
     question = f.nextLine();
f.close();
  }
  public  void set_options(){
    System.out.println("enter options");
    int count = 1;
    options = new HashMap<Integer, String>();
    String q;
    Scanner str = new Scanner(System.in);
    while(count<5){
      System.out.print("set option "+count);
      q= str.nextLine();
      options.put(count,q);
      count++;
    }
  }
  public  void set_correctanswer(){
    System.out.println("enter correct answer");
    Scanner d = new Scanner(System.in);
    correctanswer = d.nextLine();
    d.close();
  }

  public static void marks(){
  }
}
class Quiz
{
  ArrayList<Question> list = new ArrayList<Question>();
  public void adding(Question q){
    list.add(q);
    // return list;
  }
  public void show(int i) {
    int g = list.size();
    for(int j=0;j<i;j++){
        System.out.println(list.get(j));
    }

    //while(count<g){>
    //  list.get(count);
    //}
  }
}

class Menu{
  public static void main(String[] args) {
    System.out.println("enter 1 for adding questions");
    Scanner input = new Scanner(System.in);
    int g;
    g= input.nextInt();
    if (g == 1){
      System.out.println("how many questions do you add");
      int number;
      Scanner b = new Scanner(System.in);
      Quiz programming = new Quiz();
      number = b.nextInt();
      int count=0;
      while(count<number){//>
        Question q1 = new Question();
        q1.q_no();
        q1.set_question();
        q1.set_options();
        q1.set_correctanswer();
        programming.adding(q1);
        ++count;
      }
    }
    else if(g ==2){
      Quiz programming = new Quiz();
      programming.show(10);
    }
  }
}