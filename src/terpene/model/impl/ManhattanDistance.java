package terpene.model.impl;

import terpene.model.SimilarityAlgorithm;
import terpene.entity.Terpene;

/*
曼哈顿距离
计算两个向量之间的曼哈顿距离
距离越大说明相似度越低
*/
public class ManhattanDistance implements SimilarityAlgorithm {
    @Override
    public Double similarity(Terpene terpene1, Terpene terpene2) {
        Double ans = 0.0;
        Double[] t1 = terpene1.getAtomic();
        Double[] t2 = terpene2.getAtomic();
        for(int i = 0;i < t1.length;i++){
            ans += Math.abs(t1[i] - t2[i]);
        }
        return ans;
    }
}
