package constant.manager_system;

/**
 * Class for use_case.review messages.
 */
public class ReviewMessage {
    /**
     * The message sent after deletion of reviews.
     */
    public static final String CONFIRM = "Are you sure you want to delete reviews?";
    /**
     * The message sent when reviews under certain score are deleted.
     */
    public static final String DELETE_REVIEW = "Review under this score will be deleted.";
    /**
     * The message sent for clicking to agree.
     */
    public static final String YES = "Yes";
    /**
     * The message sent for clicking to stop further action.
     */
    public static final String NO = "No";
}
