package terpene.model.impl;

import terpene.model.SimilarityAlgorithm;
import terpene.entity.Terpene;


/*
欧几里得距离
计算两个向量之间的欧几里得距离
距离越大说明相似度越低
*/
public class EucledianDistance implements SimilarityAlgorithm{
    @Override
    public Double similarity(Terpene terpene1, Terpene terpene2) {
        Double ans = 0.0;
        Double[] t1 = terpene1.getAtomic();
        Double[] t2 = terpene2.getAtomic();
        for(int i = 0;i < t1.length;i++){
            ans += Math.pow(t1[i] - t2[i],2);
        }
        ans = Math.sqrt(ans);
        return ans;
    }
}
