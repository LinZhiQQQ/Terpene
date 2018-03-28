package terpene.model;

import terpene.entity.SimilarEntity;
import terpene.entity.Terpene;

public interface SimilarityAlgorithm {
    public Double similarity(SimilarEntity object1, SimilarEntity object2, Integer typeSize);
}
