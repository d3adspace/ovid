package de.d3adspace.ovid;

import com.google.common.base.Preconditions;
import de.d3adspace.ovid.repository.Repository;
import de.d3adspace.ovid.repository.RepositoryFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class Ovid {
  private final RepositoryFactory repositoryFactory;

  @Inject
  private Ovid(RepositoryFactory repositoryFactory) {
    this.repositoryFactory = repositoryFactory;
  }

  public <ModelType> Repository<ModelType> createRepository(Class<ModelType> modelClass) {
    Preconditions.checkNotNull(modelClass);
    return repositoryFactory.createRepository(modelClass);
  }
}
