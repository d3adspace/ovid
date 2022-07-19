package de.d3adspace.ovid.model;

import com.google.common.base.Preconditions;
import javax.inject.Singleton;

@Singleton
public final class ModelMetaFactory {
  private ModelMetaFactory() {
  }

  <T> ModelMeta<T> createMeta(Class<T> modelClass) {
    Preconditions.checkNotNull(modelClass);
    return null;
  }
}
