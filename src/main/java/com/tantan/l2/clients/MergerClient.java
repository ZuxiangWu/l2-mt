package com.tantan.l2.clients;

import com.tantan.l2.models.Resp;
import com.tantan.l2.models.User;
import com.tantan.l2.models.UserList;
import com.tantan.l2.models.Meta;
import com.tantan.l2.models.Extra;


import com.tantan.l2.relevance.SuggestedUserRanker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.tantan.l2.utils.WxMappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

@Component
public class MergerClient {
  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private SuggestedUserRanker _suggestedUserRanker;
  /**
   * This method will get a user from id
   *
   * @param id - user id
   * @return
   */
//    private final static String url_link = "http://127.0.0.1:6669/users?search=suggested,scenario-suggested" +
//            "&filter=&with=contacts,questions,scenarios,user.publicMoments,relationships&user_id=";
  public Resp getUsers(Long id, String limit, String search, String filter, String with) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());

    //Get from merger
    //String url = url_link + id + "&limit=" + limit;
    //convert json to java object
//        ObjectMapper mapper = new ObjectMapper();
//        String usersFromMerger = restTemplate.getForObject(url, String.class);
//        Resp userList = null;
//        try {
//            userList = mapper.readValue(usersFromMerger, Resp.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        LOGGER.info("usersFromMerger data is :  " + usersFromMerger.toString());
//        return userList;
//
    //Test
    User user1 = new User().setId(1L).setDistance(1).setLastactivity("none").setPopularity(22).setScore(3).setType("type");
    User user2 = new User().setId(2L).setDistance(2).setLastactivity("none").setPopularity(33).setScore(4).setType("type");
    User user3 = new User().setId(3L).setDistance(3).setLastactivity("none").setPopularity(44).setScore(5).setType("type");

    List<User> userList = new ArrayList<User>();
    userList.add(user1);
    userList.add(user2);
    userList.add(user3);
    return new Resp().setMeta(new Meta(1L, "test")).setData(new UserList(_suggestedUserRanker.getSuggestedUsers(1, userList, 1))).setExtra(new Extra(false, 2));


  }
}
