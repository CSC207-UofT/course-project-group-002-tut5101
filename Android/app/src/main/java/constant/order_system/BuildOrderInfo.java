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
     * Flatten this object in to a Parcel.

     * overriding method
     * @param dest dest
     * @param flags flags
     */
    @Override
    public void writeToParcel(android.os.Parcel dest,int flags){
        dest.writeInt(this.ordinal());
    }
    // Parcelable.Creator<BuildOrderInfo> is the Interface that must be implemented and provided as
    // a public CREATOR field that
    // generates instances of your Parcelable class from a Parcel.
    /**
     * Mandatory creator for implementing this interface.
     */
    public static final android.os.Parcelable.Creator<BuildOrderInfo> CREATOR=new Parcelable.Creator<BuildOrderInfo>(){
        /**
         * Create a new BuildOrderInfo from parcel.

         * overriding method
         * @param in in
         * @return a builder order ingo.
         */
        @Override
        public BuildOrderInfo createFromParcel(Parcel in){
            return BuildOrderInfo.values()[in.readInt()];
        }
        /**
         * Create the new array of build order info.

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
