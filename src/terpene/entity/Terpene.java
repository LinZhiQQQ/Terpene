package terpene.entity;

import java.util.ArrayList;

public class Terpene extends SimilarEntity{
    private ArrayList<Object> atomic = new ArrayList<Object>();

    public ArrayList<Object> getAtomic() {
        return atomic;
    }

    public void setAtomic(ArrayList<Object> atomic) {
        this.atomic = atomic;
    }

    public final static Integer TYPE_SIZE = 20;

    Terpene(){}

    public Terpene(ArrayList<Object> atomic){
        this.atomic = (ArrayList<Object>) atomic.clone();
    }

}
