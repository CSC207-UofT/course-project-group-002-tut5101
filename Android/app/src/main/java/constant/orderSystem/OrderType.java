package constant.orderSystem;


import android.os.Parcel;
import android.os.Parcelable;

public enum OrderType implements Parcelable {
    DINE_IN, DELIVERY;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ordinal());
    }

    public static final Creator<OrderType> CREATOR = new Creator<OrderType>() {
        @Override
        public OrderType createFromParcel(Parcel in) {
            return OrderType.values()[in.readInt()];
        }

        @Override
        public OrderType[] newArray(int size) {
            return new OrderType[size];
        }
    };

}
