package entity;

import java.io.Serializable;

public interface HasExpiry extends Serializable {
    int getExpiryDate();
}
