package terpene.model.impl;

import terpene.entity.SimilarAbstract;
import terpene.model.SimilarityAlgorithm;

import java.util.ArrayList;

public class MahalanobisDistance implements SimilarityAlgorithm {

    @Override
    public Double similarity(SimilarAbstract object1, SimilarAbstract object2, Integer typeSize) {
        Double theStandardDeviation = 0.0;
        Double Average = 0.0;
        Double ans = 0.0;
        ArrayList<Object> t1 = object1.getAtomic();
        ArrayList<Object> t2 = object2.getAtomic();

//        System.out.println("----------------------------------------");
        for (int i = 1;i <= typeSize;i++){
            Average = (Double.valueOf((String)t1.get(i)) + Double.valueOf((String)t2.get(i))) / 2;
            theStandardDeviation = Math.sqrt((Math.pow(Double.valueOf((String)t1.get(i)) - Average,2) + Math.pow(Double.valueOf((String)t2.get(i)) - Average,2) ) / 2);
//            System.out.println(theStandardDeviation);
            ans += Math.pow(Double.valueOf((String)t1.get(i)) - Double.valueOf((String)t2.get(i)) ,2) / theStandardDeviation;
        }

        ans = Math.sqrt(ans);

        return ans;
    }

}
