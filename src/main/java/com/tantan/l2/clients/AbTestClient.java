package com.tantan.l2.clients;

import com.tantan.l2.relevance.feature.Feature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class AbTestClient {
  /**
   * Get the treatment for a particular user ID with different test keys
   *
   * @param id       user id
   * @param testKeys test key set
   * @return return the treatment map
   */
  public Map<String, String> getTreatments(final int id, final Set<String> testKeys) {
    //TODO: add treatments
    String treatment = Feature.POPULARITY.name().toLowerCase() + ":0.5#" +
        Feature.TYPE.name().toLowerCase() + ":0.5#" +
        Feature.DISTANCE.name().toLowerCase() + ":0.5";
    Map<String, String> map = new HashMap<>();
    for(String key: testKeys) {
      map.put(key,treatment);
    }
    return map;
  }

  /**
   * Get the treatments for a particular user ID
   *
   * @param id      user id
   * @param testKey test key
   * @return return the treatment
   */
  public String getTreatment(final int id, final String testKey) {
    //TODO: mock data, update the treatment
    String treatment = Feature.POPULARITY.name().toLowerCase() + ":0.5#" +
        Feature.TYPE.name().toLowerCase() + ":0.5#" +
        Feature.DISTANCE.name().toLowerCase() + ":0.5";
    return id % 2 == 1 ? treatment : "control";
  }
}
