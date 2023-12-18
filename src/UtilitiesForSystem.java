public class UtilitiesForSystem {

    public static void ClearScreen()
    {
        for (int i = 0; i < 10; i++) 
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

}
