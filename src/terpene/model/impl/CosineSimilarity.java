package terpene.model.impl;

import terpene.entity.SimilarAbstract;
import terpene.model.SimilarityAlgorithm;

import java.util.ArrayList;


/*
余弦相似度算法
计算两个向量之间的 cos 值
cos 值接近 1 表示夹角接近 0，也就是相似度越高
*/
public class CosineSimilarity implements SimilarityAlgorithm {
    @Override
    public Double similarity(SimilarAbstract object1, SimilarAbstract object2, Integer typeSize) {
        Double ans = 0.0;
        Double numberator = 0.0;    //分子
        Double denominatorX = 0.0;   //分母 X
        Double denominatorY = 0.0;   //分母 Y
        ArrayList<Object> t1 = object1.getAtomic();
        ArrayList<Object> t2 = object2.getAtomic();
        for(int i = 1;i <= typeSize;i++){
            Double num1 = Double.valueOf((String)t1.get(i));
            Double num2 = Double.valueOf((String)t2.get(i));
//            System.out.println("num1  = " + num1 + " num2 = " + num2);
            numberator += (num1 * num2);
            denominatorX += Math.pow(num1,2);
            denominatorY += Math.pow(num2,2);
        }
//        System.out.println("numberator = " + numberator);
        ans = numberator / (denominatorX * denominatorY);
        return ans;
    }
}
