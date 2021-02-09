package pattern.structural.bridge;

public interface LoggerMethods {
    void LogError(String message, int target);

    void LogInfo(String message);

    void LogWarn(String message);
    
    void LogStatus(String message);
}
