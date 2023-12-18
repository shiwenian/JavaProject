import java.util.concurrent.*;

public class MenuHandling {

  public Boolean ValidateLogin(int inputValue, String inputString) throws InterruptedException {

    Boolean result = false;

     if(inputString.equals("admin") && inputValue == 12345) {
      System.out.println("Successful Login!");
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

/*
 * public class MenuHandling {
 * 
 * public static Boolean validLogin() throws InterruptedException {
 * Scanner input = new Scanner(System.in);
 * Boolean validDetails = false;
 * String inputId = "";
 * int inputPassword = 0;
 * 
 * do {
 * System.out.println("Enter Admin ID or '-999' to exit: \n");
 * inputId = input.nextLine();
 * TimeUnit.MILLISECONDS.sleep(500); // This feature must be used along with
 * "throws InterruptedException".
 * System.out.println("Enter password: \n");
 * inputPassword = input.nextInt();
 * 
 * try {
 * if (inputId.equals("-999")) {
 * // Exit case
 * validDetails = true;
 * break;
 * } else if (inputId.equals("admin") && inputPassword == 12345) {
 * // Successful login
 * validDetails = true;
 * break;
 * } else {
 * System.out.
 * println("Invalid ID or password, please try again or exit using '-999'");
 * TimeUnit.MILLISECONDS.sleep(500);
 * }
 * } catch (InputMismatchException e) {
 * System.out.println("Invalid option selected, please try again.");
 * TimeUnit.MILLISECONDS.sleep(500);
 * }
 * } while (!validDetails);
 * 
 * input.close();
 * 
 * return validDetails; // Returns to starting menu if FALSE and continues if
 * TRUE
 * }
 * }
 * 
 */
