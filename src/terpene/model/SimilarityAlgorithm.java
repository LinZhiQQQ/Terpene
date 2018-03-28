package terpene.model;

import terpene.entity.Terpene;

public interface SimilarityAlgorithm {
    public Double similarity(Terpene terpene1,Terpene terpene2);
}
