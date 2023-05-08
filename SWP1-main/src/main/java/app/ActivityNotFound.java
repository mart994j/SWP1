package app;

public class ActivityNotFound extends Exception {
	  /**
     * Generated a default serial version unique ID
     */
    private static final long serialVersionUID = -5120818988866399660L;

    public ActivityNotFound(String errorMessage) {
        super(errorMessage);
    }
}
