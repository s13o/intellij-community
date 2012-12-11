/*
 * Copyright 2000-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jetbrains.jps.model.serialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.model.JpsProject;
import org.jetbrains.jps.model.module.JpsModule;
import org.jetbrains.jps.model.serialization.impl.JpsModuleSerializationDataExtensionImpl;
import org.jetbrains.jps.model.serialization.impl.JpsProjectSerializationDataExtensionImpl;
import org.jetbrains.jps.model.serialization.module.JpsModuleSerializationDataExtension;

import java.io.File;

/**
 * @author nik
 */
public class JpsModelSerializationDataService {

  @Nullable
  public static JpsProjectSerializationDataExtension getProjectExtension(@NotNull JpsProject project) {
    return project.getContainer().getChild(JpsProjectSerializationDataExtensionImpl.ROLE);
  }

  @Nullable
  public static File getBaseDirectory(@NotNull JpsProject project) {
    JpsProjectSerializationDataExtension extension = getProjectExtension(project);
    return extension != null ? extension.getBaseDirectory() : null;
  }

  @Nullable
  public static JpsModuleSerializationDataExtension getModuleExtension(@NotNull JpsModule project) {
    return project.getContainer().getChild(JpsModuleSerializationDataExtensionImpl.ROLE);
  }

  @Nullable
  public static File getBaseDirectory(@NotNull JpsModule module) {
    JpsModuleSerializationDataExtension extension = getModuleExtension(module);
    return extension != null ? extension.getBaseDirectory() : null;
  }
}
