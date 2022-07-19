package de.d3adspace.ovid.model;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ModelRegistry {
  private final ModelMetaFactory modelMetaFactory;
  private final Map<Class<?>, ModelMeta<?>> cachedMeta;

  @Inject
  private ModelRegistry(ModelMetaFactory modelMetaFactory) {
    this(modelMetaFactory, Maps.newHashMap());
  }

  private ModelRegistry(ModelMetaFactory modelMetaFactory, Map<Class<?>, ModelMeta<?>> cachedMeta) {
    this.modelMetaFactory = modelMetaFactory;
    this.cachedMeta = cachedMeta;
  }

  public <T> ModelMeta<T> findOrCreateMeta(Class<T> modelClass) {
    return findMeta(modelClass).orElseGet(() -> createMeta(modelClass));
  }

  private <T> ModelMeta<T> createMeta(Class<T> modelClass) {
    return modelMetaFactory.createMeta(modelClass);
  }

  <T> Optional<ModelMeta<T>> findMeta(Class<T> modelClass) {
    var modelMeta = (ModelMeta<T>) cachedMeta.get(modelClass);
    return Optional.ofNullable(modelMeta);
  }
}
