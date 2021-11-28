package constant.orderSystem;

import android.os.Parcel;
import android.os.Parcelable;

public enum BuildOrderInfo implements Parcelable {
    ORDER_TYPE, LOCATION, DISHES;

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest,int flags){
        dest.writeInt(this.ordinal());
    }

    public static final android.os.Parcelable.Creator<BuildOrderInfo> CREATOR=new Parcelable.Creator<BuildOrderInfo>(){
        @Override
        public BuildOrderInfo createFromParcel(Parcel in){
            return BuildOrderInfo.values()[in.readInt()];
        }

        @Override
        public BuildOrderInfo[]newArray(int size){
            return new BuildOrderInfo[size];
        }
    };


}
