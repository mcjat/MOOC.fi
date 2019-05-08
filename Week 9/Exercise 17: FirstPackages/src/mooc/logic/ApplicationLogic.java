import mooc.ui.UserInterface;
public class ApplicationLogic {
    private UserInterface ui;
    public ApplicationLogic(UserInterface ui){
        this.ui = ui;
    }
    public void execute(int howManyTimes){
        while(howManyTimes >0){
            System.out.println("The application logic works");
            this.ui.update();
            howManyTimes--;
        }
    }  
}
