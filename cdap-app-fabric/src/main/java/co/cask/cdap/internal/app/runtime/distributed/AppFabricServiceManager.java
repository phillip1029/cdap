/*
 * Copyright © 2015 Cask Data, Inc.
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

package co.cask.cdap.internal.app.runtime.distributed;

import co.cask.cdap.common.conf.CConfiguration;
import co.cask.cdap.common.conf.Constants;
import co.cask.cdap.common.twill.AbstractDistributedMasterServiceManager;
import co.cask.cdap.proto.Containers;
import co.cask.cdap.proto.SystemServiceLiveInfo;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.twill.api.TwillRunnerService;
import org.apache.twill.discovery.DiscoveryServiceClient;

import java.net.InetAddress;

/**
 * App Fabric Service Management in Distributed Mode.
 */
public class AppFabricServiceManager extends AbstractDistributedMasterServiceManager {

  private final InetAddress hostname;

  @Inject
  public AppFabricServiceManager(CConfiguration cConf, TwillRunnerService twillRunnerService,
                                 @Named(Constants.AppFabric.SERVER_ADDRESS) InetAddress hostname,
                                 DiscoveryServiceClient discoveryServiceClient) {
    super(cConf, Constants.Service.APP_FABRIC_HTTP, twillRunnerService, discoveryServiceClient);
    this.hostname = hostname;

  }

  @Override
  public String getDescription() {
    return Constants.AppFabric.SERVICE_DESCRIPTION;
  }

  @Override
  public int getMaxInstances() {
    return 1;
  }

  @Override
  public SystemServiceLiveInfo getLiveInfo() {
    SystemServiceLiveInfo.Builder builder = SystemServiceLiveInfo.builder();

    Containers.ContainerInfo containerInfo = new Containers.ContainerInfo(Containers.ContainerType.SYSTEM_SERVICE,
                                                                          serviceName, 0, "N/A", hostname.getHostName(),
                                                                          0, 0, null);
    builder.addContainer(containerInfo);
    return builder.build();
  }

  @Override
  public int getInstances() {
    return 1;
  }

  @Override
  public boolean setInstances(int instanceCount) {
    return false;
  }

  @Override
  public int getMinInstances() {
    return 1;
  }

  @Override
  public boolean isLogAvailable() {
    return true;
  }

  @Override
  public boolean canCheckStatus() {
    return true;
  }

  @Override
  public boolean isServiceAvailable() {
    return true;
  }

  @Override
  public boolean isServiceEnabled() {
    return true;
  }
}
