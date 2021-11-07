package entity;

/**
 * Interface indicating whether an inventory has expired.
 */


import java.io.Serializable;

public interface HasExpiry extends Serializable {
    int getExpiryDate();
}
