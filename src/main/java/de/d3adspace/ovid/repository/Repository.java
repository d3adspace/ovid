package de.d3adspace.ovid.repository;

import de.d3adspace.ovid.model.ModelMeta;

public final class Repository<ModelType> {
  private final ModelMeta<ModelType> modelMeta;

  Repository(ModelMeta<ModelType> modelMeta) {
    this.modelMeta = modelMeta;
  }
}
