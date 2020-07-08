package com.gcosarba.notifications;

import java.util.HashMap;

public class NotificationMetadataService {
    // This will represent a topic and its subscribers
    private HashMap<String, String[]> topics;
    //TODO query by subscriber and get their topics

    // init a topic
    public NotificationMetadataService() {
        this.topics = new HashMap<>();
        String[] subscribers = {"customer"};
        this.topics.put("orderProcessed", subscribers);
    }

    public NotificationMetadataService(HashMap<String, String[]> topics) {
        this.topics = topics;
    }

    public HashMap<String, String[]> getTopics() {
        return topics;
    }

    public void setTopics(HashMap<String, String[]> topics) {
        this.topics = topics;
    }
}
