package constant.order_system;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Constant class for order type
 */
public enum OrderType implements Parcelable {
    DINE_IN, DELIVERY;

    /**
     * overriding method
     * @return 0
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * overriding method
     * @param dest dest
     * @param flags flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ordinal());
    }

    /**
     * New creator.
     */
    public static final Creator<OrderType> CREATOR = new Creator<OrderType>() {
        /**
         * overriding method
         *
         * @param in in.
         * @return order type
         */
        @Override
        public OrderType createFromParcel(Parcel in) {
            return OrderType.values()[in.readInt()];
        }

        /**
         * overriding method
         *
         * @param size size.
         * @return an array of order type.
         */
        @Override
        public OrderType[] newArray(int size) {
            return new OrderType[size];
        }
    };

}
