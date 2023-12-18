import java.util.concurrent.*;

public class MenuHandling {

  public Boolean ValidateLogin(int inputValue, String inputString) throws InterruptedException {

    Boolean result = false;

     if(inputString.equals("admin") && inputValue == 12345) {
      System.out.println("Successful Login!\n");
      TimeUnit.MILLISECONDS.sleep(500);
      result = true;

    } else {
      System.out.println("Invalid ID or password, please try again or exit using '-999'\n");
      TimeUnit.MILLISECONDS.sleep(500);
      result = false;
    }

    return result; // Returns to starting menu if FALSE and continues if TRUE
  }

}

