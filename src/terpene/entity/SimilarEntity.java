package terpene.entity;

import java.util.ArrayList;

public abstract class SimilarEntity {
    private ArrayList<Object> atomic = new ArrayList<Object>();
    public abstract ArrayList<Object> getAtomic();
    public abstract  void setAtomic(ArrayList<Object> actomic);

}
