package terpene.controller;

import terpene.entity.Terpene;
import terpene.model.impl.CosineSimilarity;
import terpene.model.impl.EucledianDistance;
import terpene.model.impl.ManhattanDistance;

public class Computing {
    private CosineSimilarity cosineSimilarity = new CosineSimilarity();
    private EucledianDistance eucledianDistance = new EucledianDistance();
    private ManhattanDistance manhattanDistance = new ManhattanDistance();

    private String choice;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Computing(){}

    public Computing(String choice){
        this.choice = choice;
    }

    public Double getSimilarity(Terpene terpene1,Terpene terpene2, Integer typeSize){
        if(choice.equals("CosineSimilarity")){
            return cosineSimilarity.similarity(terpene1,terpene2,typeSize);
        }else if(choice.equals("EucledianDistance")){
            return eucledianDistance.similarity(terpene1,terpene2,typeSize);
        }else if(choice.equals("ManhattanDistance")){
            return manhattanDistance.similarity(terpene1,terpene2,typeSize);
        }else{
            return 0.0;
        }
    }
}
