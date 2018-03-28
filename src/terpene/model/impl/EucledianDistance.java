package terpene.model.impl;

import terpene.entity.SimilarAbstract;
import terpene.model.SimilarityAlgorithm;

import java.util.ArrayList;


/*
欧几里得距离
计算两个向量之间的欧几里得距离
距离越大说明相似度越低
*/
public class EucledianDistance implements SimilarityAlgorithm{
    @Override
    public Double similarity(SimilarAbstract object1, SimilarAbstract object2, Integer typeSize) {
        Double ans = 0.0;
        ArrayList<Object> t1 = object1.getAtomic();
        ArrayList<Object> t2 = object2.getAtomic();
        for(int i = 1;i <= typeSize;i++){
//            System.out.println("i = "+  i + "  : "  + t2.get(i));
            Double num1 = Double.valueOf((String) t1.get(i));
            Double num2 = Double.valueOf((String) t2.get(i));
            ans += Math.pow(num1 - num2,2);
        }
        ans = Math.sqrt(ans);
        return ans;
    }
}
