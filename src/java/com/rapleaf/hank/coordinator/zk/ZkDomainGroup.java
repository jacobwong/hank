/**
 *  Copyright 2012 Rapleaf
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.rapleaf.hank.coordinator.zk;

import com.rapleaf.hank.coordinator.*;
import com.rapleaf.hank.generated.DomainGroupMetadata;
import com.rapleaf.hank.zookeeper.WatchedThriftNode;
import com.rapleaf.hank.zookeeper.ZkPath;
import com.rapleaf.hank.zookeeper.ZooKeeperPlus;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZkDomainGroup extends AbstractDomainGroup implements DomainGroup {

  private final ZooKeeperPlus zk;
  private final Coordinator coordinator;
  private final String name;
  private final String path;
  private final WatchedThriftNode<DomainGroupMetadata> metadata;

  public static ZkDomainGroup create(final ZooKeeperPlus zk,
                                     final Coordinator coordinator,
                                     final String rootPath,
                                     final String name) throws InterruptedException, KeeperException, IOException {
    String path = ZkPath.append(rootPath, name);
    DomainGroupMetadata initialMetadata = new DomainGroupMetadata();
    initialMetadata.set_next_version_number(0);
    initialMetadata.set_domain_versions_map(new HashMap<Integer, Integer>());
    return new ZkDomainGroup(zk, coordinator, path, true, initialMetadata);
  }

  public ZkDomainGroup(final ZooKeeperPlus zk,
                       final Coordinator coordinator,
                       final String path) throws IOException, InterruptedException, KeeperException {
    this(zk, coordinator, path, false, null);
  }

  public ZkDomainGroup(final ZooKeeperPlus zk,
                       final Coordinator coordinator,
                       final String path,
                       final boolean create,
                       final DomainGroupMetadata initialMetadata)
      throws InterruptedException, KeeperException, IOException {
    this.zk = zk;
    this.coordinator = coordinator;
    this.path = path;
    this.name = ZkPath.getFilename(path);
    this.metadata = new WatchedThriftNode<DomainGroupMetadata>(zk, path, true, create, initialMetadata, new DomainGroupMetadata());
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Set<DomainGroupDomainVersion> getDomainVersions() throws IOException {
    Set<DomainGroupDomainVersion> result = new HashSet<DomainGroupDomainVersion>();
    for (Map.Entry<Integer, Integer> entry : metadata.get().get_domain_versions_map().entrySet()) {
      result.add(new DomainGroupDomainVersion(coordinator.getDomainById(entry.getKey()), entry.getValue()));
    }
    return result;
  }

  @Override
  public void setDomainVersions(final Map<Domain, Integer> domainVersions) throws IOException {
    try {
      metadata.update(metadata.new Updater() {
        @Override
        public void updateCopy(DomainGroupMetadata currentCopy) {
          Map<Integer, Integer> map = new HashMap<Integer, Integer>();
          for (Map.Entry<Domain, Integer> entry : domainVersions.entrySet()) {
            map.put(entry.getKey().getId(), entry.getValue());
          }
          currentCopy.set_domain_versions_map(map);
        }
      });
    } catch (InterruptedException e) {
      throw new IOException(e);
    } catch (KeeperException e) {
      throw new IOException(e);
    }
  }

  @Override
  public void removeDomain(final Domain domain) throws IOException {
    try {
      metadata.update(metadata.new Updater() {
        @Override
        public void updateCopy(DomainGroupMetadata currentCopy) {
          currentCopy.get_domain_versions_map().remove(domain.getId());
        }
      });
    } catch (InterruptedException e) {
      throw new IOException(e);
    } catch (KeeperException e) {
      throw new IOException(e);
    }
  }

  public boolean delete() throws IOException {
    try {
      zk.deleteNodeRecursively(path);
      return true;
    } catch (Exception e) {
      throw new IOException(e);
    }
  }

  @Override
  public String toString() {
    return "ZkDomainGroup [name=" + getName() + "]";
  }

  public String getPath() {
    return path;
  }
}
