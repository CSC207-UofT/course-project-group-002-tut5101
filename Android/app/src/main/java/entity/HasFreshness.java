package entity;


/**
 * Interface indicating whether an inventory is fresh.
 */

import java.io.Serializable;

public interface HasFreshness extends Serializable {
    String getFreshness();
    void setFreshness(String NewFreshness);
}
