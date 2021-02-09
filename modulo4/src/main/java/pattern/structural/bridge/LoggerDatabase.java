package pattern.structural.bridge;

public class LoggerDatabase {

    private static void LogError(String message, int target) {
        switch (target) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        System.out.println(message);
    }

    private static void LogInfo(String message) {
        System.out.println(message);
    }

    private static void LogWarn(String message) {
        System.out.println(message);
    }

    private static void LogWarnFile(String message) {
        System.out.println(message);
    }

    private static void LogWarnTerminal(String message) {
        System.out.println(message);
    }
}
