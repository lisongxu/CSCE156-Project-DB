package unl.soc;

public class View {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_Green = "\u001B[32m";
    public static final String ANSI_Yellow = "\u001B[33m";
    public static final String ANSI_Blue = "\u001B[34m";
    public static final String ANSI_Cyan = "\u001B[36m";
    public static final String ANSI_MENU = ANSI_Cyan;

    public static void mainWindow() {
        System.out.print(ANSI_MENU);
        System.out.println(" ============================================ ");
        System.out.println("|          Welcome to Jstgram 2.0!           |");
        System.out.println("|                                            |");
        System.out.println("|                *************               |");
        System.out.println("|                      *                     |");
        System.out.println("|                      *                     |");
        System.out.println("|                      *                     |");
        System.out.println("|                      *                     |");
        System.out.println("|                *     *                     |");
        System.out.println("|                *******                     |");
        System.out.println("|                                            |");
        System.out.println("|  Current number of users in database :     |");
        System.out.println(" ============================================ ");
        System.out.print(ANSI_RESET);
        System.out.print("Type your username : ");
    }

    public static void accountWindow() {
        System.out.print(ANSI_MENU);
        System.out.println(" ============================================ ");
        System.out.println("|                                            |");
        System.out.println("|  (P) Posts                                 |");
        System.out.println("|  (V) Post Visibility                       |");
        System.out.println("|  (Q) Quit                                  |");
        System.out.println("|                                            |");
        System.out.println("|  Current user :                            |");
        System.out.println(" ============================================ ");
        System.out.print(ANSI_RESET);
        System.out.print("Your choice : ");
    }

    public static void postListWindow() {
        System.out.print(ANSI_MENU);
        System.out.println(" ============================================ ");
        System.out.println("|  Posts visible to me                       |");
        System.out.println("|                                            |");
        System.out.println("|                                            |");
        System.out.println("|  (+) Publish a new post                    |");
        System.out.println("|  (B) Back                                  |");
        System.out.println("|                                            |");
        System.out.println("|  Current user :                            |");
        System.out.println(" ============================================ ");
        System.out.print(ANSI_RESET);
        System.out.print("Your choice : ");
    }

    public static void visibilityWindow() {
        System.out.print(ANSI_MENU);
        System.out.println(" ============================================ ");
        System.out.println("|  My visibility list                        |");
        System.out.println("|                                            |");
        System.out.println("|                                            |");
        System.out.println("|  (+) Add a user                            |");
        System.out.println("|  (-) Remove a user                         |");
        System.out.println("|  (B) Back                                  |");
        System.out.println("|                                            |");
        System.out.println("|  Current user :                            |");
        System.out.println(" ============================================ ");
        System.out.print(ANSI_RESET);
        System.out.print("Your choice : ");
    }
}
