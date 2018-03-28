package terpene.model;

import terpene.entity.SimilarAbstract;

public interface SimilarityAlgorithm {
    public Double similarity(SimilarAbstract object1, SimilarAbstract object2, Integer typeSize);
}
