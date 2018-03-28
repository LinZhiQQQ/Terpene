package terpene.entity;

public class Terpene {
    private Double[] atomic = new Double[36];

    public Double[] getAtomic() {
        return atomic;
    }

    public void setAtomic(Double[] atomic) {
        this.atomic = atomic;
    }

    Terpene(){}

    Terpene(Double[] atomic){
        this.atomic = atomic.clone();
    }

}
