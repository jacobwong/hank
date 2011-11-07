/**
 *  Copyright 2011 Rapleaf
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

package com.rapleaf.hank.coordinator;

import com.rapleaf.hank.partition_server.PartitionAccessor;
import com.rapleaf.hank.partition_server.PartitionAccessorRuntimeStatistics;
import com.rapleaf.hank.partition_server.RuntimeStatisticsAggregator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class Hosts {

  private Hosts() {
  }

  /**
   * Returns true when the host is online. Note that this is distinct from
   * "serving data" - a host is online when it's NOT offline.
   *
   * @param host
   * @return
   * @throws IOException
   */
  public static boolean isOnline(Host host) throws IOException {
    return host.getState() != HostState.OFFLINE;
  }

  public static UpdateProgress computeUpdateProgress(Host host, DomainGroupVersion domainGroupVersion) throws IOException {
    int numPartitions = 0;
    int numPartitionsUpToDate = 0;
    for (DomainGroupVersionDomainVersion dgvdv : domainGroupVersion.getDomainVersions()) {
      Domain domain = dgvdv.getDomain();
      HostDomain hostDomain = host.getHostDomain(domain);
      if (hostDomain != null) {
        for (HostDomainPartition partition : hostDomain.getPartitions()) {
          // Ignore deletable partitions
          if (!partition.isDeletable()) {
            ++numPartitions;
            if (partition.getCurrentDomainGroupVersion() != null
                && partition.getCurrentDomainGroupVersion().equals(domainGroupVersion.getVersionNumber())) {
              ++numPartitionsUpToDate;
            }
          }
        }
      }
    }
    return new UpdateProgress(numPartitions, numPartitionsUpToDate);
  }

  /**
   * Return true if all partitions assigned to that host for domains of the given domain group version
   * are at the correct version.
   *
   * @param host
   * @param domainGroupVersion
   * @return
   * @throws IOException
   */
  public static boolean isUpToDate(Host host, DomainGroupVersion domainGroupVersion) throws IOException {
    // Check that each domain of the given domain group version is up to date on this host
    for (DomainGroupVersionDomainVersion dgvdv : domainGroupVersion.getDomainVersions()) {
      Domain domain = dgvdv.getDomain();
      HostDomain hostDomain = host.getHostDomain(domain);
      if (hostDomain != null) {
        for (HostDomainPartition partition : hostDomain.getPartitions()) {
          // Ignore deletable partitions
          if (!partition.isDeletable()) {
            // If the partition is not currently at the given domain group version, the host is not up-to-date
            if (partition.getCurrentDomainGroupVersion() != domainGroupVersion.getVersionNumber()) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  public static ServingStatusAggregator
  computeServingStatusAggregator(Host host, DomainGroupVersion domainGroupVersion) throws IOException {
    ServingStatusAggregator result = new ServingStatusAggregator();
    for (HostDomain hostDomain : host.getAssignedDomains()) {
      for (HostDomainPartition partition : hostDomain.getPartitions()) {
        // Ignore deletable partitions
        if (!partition.isDeletable()) {
          // Check if partition is served and up to date
          boolean servedAndUpToDate =
              host.getState() == HostState.SERVING &&
                  partition.getCurrentDomainGroupVersion() != null &&
                  partition.getCurrentDomainGroupVersion().equals(domainGroupVersion.getVersionNumber());
          // Aggregate counts
          result.add(hostDomain.getDomain(), partition.getPartitionNumber(), servedAndUpToDate);
        }
      }
    }
    return result;
  }

  public static Map<Domain, RuntimeStatisticsAggregator> computeRuntimeStatistics(Host host) throws IOException {
    Map<Domain, RuntimeStatisticsAggregator> result = new HashMap<Domain, RuntimeStatisticsAggregator>();
    for (HostDomain hostDomain : host.getAssignedDomains()) {
      Domain domain = hostDomain.getDomain();
      for (HostDomainPartition partition : hostDomain.getPartitions()) {
        // Ignore deletable partitions
        if (!partition.isDeletable()) {
          String partitionRuntimeStatistics = partition.getStatistic(PartitionAccessor.RUNTIME_STATISTICS_KEY);
          if (partitionRuntimeStatistics != null) {
            if (!result.containsKey(domain)) {
              result.put(domain, new RuntimeStatisticsAggregator());
            }
            result.get(domain).add(
                new PartitionAccessorRuntimeStatistics(partitionRuntimeStatistics).getRuntimeStatistics());
          }
        }
      }
    }
    return result;
  }

  public static RuntimeStatisticsAggregator
  computeRuntimeStatisticsForHost(Map<Domain, RuntimeStatisticsAggregator> runtimeStatistics) {
    RuntimeStatisticsAggregator result = new RuntimeStatisticsAggregator();
    for (Map.Entry<Domain, RuntimeStatisticsAggregator> entry : runtimeStatistics.entrySet()) {
      result.add(entry.getValue());
    }
    return result;
  }

  public static RuntimeStatisticsAggregator
  computeRuntimeStatisticsForDomain(Map<Domain, RuntimeStatisticsAggregator> runtimeStatistics,
                                    Domain domain) {
    if (runtimeStatistics.containsKey(domain)) {
      return runtimeStatistics.get(domain);
    } else {
      return new RuntimeStatisticsAggregator();
    }
  }
}
