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

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public final class RingGroups {
  private RingGroups() {}

  public static boolean isUpdating(RingGroup ringGroup) throws IOException {
    return ringGroup.getUpdatingToVersion() != null;
  }

  public static boolean isUpToDate(RingGroup ringGroup, DomainGroupVersion domainGroupVersion) throws IOException {
    for (Ring ring : ringGroup.getRings()) {
      if (!Rings.isUpToDate(ring, domainGroupVersion)) {
        return false;
      }
    }
    return true;
  }

  public static UpdateProgress computeUpdateProgress(RingGroup ringGroup,
                                                     DomainGroupVersion domainGroupVersion) throws IOException {
    UpdateProgress result = new UpdateProgress();
    for (Ring ring : ringGroup.getRings()) {
      result.aggregate(Rings.computeUpdateProgress(ring, domainGroupVersion));
    }
    return result;
  }

  public static int getNumHosts(RingGroup ringGroup) {
    int result = 0;
    for (Ring ring : ringGroup.getRings()) {
      result += ring.getHosts().size();
    }
    return result;
  }

  public static Set<Host> getHostsInState(RingGroup ringGroup, HostState state) throws IOException {
    Set<Host> result = new TreeSet<Host>();
    for (Ring ring : ringGroup.getRings()) {
      result.addAll(Rings.getHostsInState(ring, state));
    }
    return result;
  }

  public static ServingStatusAggregator
  computeServingStatusAggregator(RingGroup ringGroup, DomainGroupVersion domainGroupVersion) throws IOException {
    ServingStatusAggregator servingStatusAggregator = new ServingStatusAggregator();
    for (Ring ring : ringGroup.getRings()) {
      servingStatusAggregator.aggregate(Rings.computeServingStatusAggregator(ring, domainGroupVersion));
    }
    return servingStatusAggregator;
  }
}