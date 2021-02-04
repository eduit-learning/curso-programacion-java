package pattern.behavioral.observer;

public class Observer {
    public static void main(String[] args) {
        Button button = new Button();
        ShowMessageListener sml = new ShowMessageListener();
        button.addListener(new SaveFileListener());
        button.addListener(sml);
        button.addListenerPropertyChanged(sml);
        //button.click();
        button.setText("");
        
        //button.removeListener(sml);
        //button.click();
    }
}
