/*
 * Copyright © 2016 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package co.cask.cdap.data2.dataset2.lib.partitioned;

/**
 * Represents an operation on a particular path. Must be used in context of a base location, because the path is a
 * relative path.
 */
final class PathOperation {
  private final String relativePath;
  private final OperationType operationType;

  enum OperationType {
    CREATE, DROP
  }

  PathOperation(String relativePath, OperationType operationType) {
    this.relativePath = relativePath;
    this.operationType = operationType;
  }

  public String getRelativePath() {
    return relativePath;
  }

  public OperationType getOperationType() {
    return operationType;
  }
}
