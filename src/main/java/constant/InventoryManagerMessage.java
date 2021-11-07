package constant;

/**
 * Constant class for Inventory Manager.
 */

public class InventoryManagerMessage {
    public static final String SELECT_ACTION = "1. Check information of \"Please give a name\"\n2. Add new item\n" + "3. Set freshness for \"Please give a name\"\n"+"4. Set quantity of \"Please give a name\"\n"+ "0. Logout";
    public static final String REQUEST_NAME = "A name of inventory";
    public static final String REQUEST_INFO = "Info of inventory, type,name,price,quantity,fresh,importdate\n or" +
            "type,name,price,quantity,expiry";
    public static final String REQUEST_FRESH = "A name of inventory and new freshness in name,fresh";
    public static final String REQUEST_USAGE = "A name of inventory and usage(a.bc) in name,usage";
}
