package entity;

import java.io.Serializable;

public interface HasFreshness extends Serializable {
    String getFreshness();
    void setFreshness(String NewFreshness);
}
