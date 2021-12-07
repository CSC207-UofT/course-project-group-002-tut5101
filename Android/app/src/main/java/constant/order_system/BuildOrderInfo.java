package constant.order_system;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Constant class for builder info
 */
public enum BuildOrderInfo implements Parcelable {
    ORDER_TYPE, LOCATION, DISHES, PRICES;

    /**
     * overriding method
     * @return 0
     */
    @Override
    public int describeContents(){
        return 0;
    }

    /**
     * overriding method
     * @param dest dest
     * @param flags flags
     */
    @Override
    public void writeToParcel(android.os.Parcel dest,int flags){
        dest.writeInt(this.ordinal());
    }

    /**
     * values.
     */
    public static final android.os.Parcelable.Creator<BuildOrderInfo> CREATOR=new Parcelable.Creator<BuildOrderInfo>(){
        /**
         * overriding method
         * @param in in
         * @return a builder order ingo.
         */
        @Override
        public BuildOrderInfo createFromParcel(Parcel in){
            return BuildOrderInfo.values()[in.readInt()];
        }

        /**
         * overriding method
         * @param size size
         * @return a builder order info.
         */
        @Override
        public BuildOrderInfo[]newArray(int size){
            return new BuildOrderInfo[size];
        }
    };


}
