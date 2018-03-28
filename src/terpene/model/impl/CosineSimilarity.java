package terpene.model.impl;

import terpene.model.SimilarityAlgorithm;
import terpene.entity.Terpene;


/*
余弦相似度算法
计算两个向量之间的 cos 值
cos 值接近 1 表示夹角接近 0，也就是相似度越高
*/
public class CosineSimilarity implements SimilarityAlgorithm {
    @Override
    public Double similarity(Terpene terpene1, Terpene terpene2) {
        Double ans = 0.0;
        Double numberator = 0.0;    //分子
        Double denominatorX = 0.0;   //分母 X
        Double denominatorY = 0.0;   //分母 Y
        Double[] t1 = terpene1.getAtomic();
        Double[] t2 = terpene2.getAtomic();
        for(int i = 0;i < t1.length;i++){
            numberator += (t1[i] * t2[i]);
            denominatorX += Math.pow(t1[i],2);
            denominatorY += Math.pow(t2[i],2);
        }
        ans = numberator / (denominatorX * denominatorY);
        return ans;
    }
}
