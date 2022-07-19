package de.d3adspace.ovid.repository;

import de.d3adspace.ovid.model.ModelRegistry;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class RepositoryFactory {
  private final ModelRegistry modelRegistry;

  @Inject
  private RepositoryFactory(ModelRegistry modelRegistry) {
    this.modelRegistry = modelRegistry;
  }

  public <ModelType>  Repository<ModelType> createRepository(Class<ModelType> modelClass) {
    var modelMeta = modelRegistry.findOrCreateMeta(modelClass);
    return new Repository<>(modelMeta);
  }
}
