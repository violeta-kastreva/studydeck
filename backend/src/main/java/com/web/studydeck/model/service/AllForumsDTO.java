package com.web.studydeck.model.service;

import java.util.ArrayList;
import java.util.List;

public class AllForumsDTO {
    ForumStatisticsDTO statistics = new ForumStatisticsDTO();
    List<ForumDTO> threads = new ArrayList<>();

    public ForumStatisticsDTO getStatistics() {
        return statistics;
    }

    public void setStatistics(ForumStatisticsDTO statistics) {
        this.statistics = statistics;
    }

    public List<ForumDTO> getThreads() {
        return threads;
    }

    public void setThreads(List<ForumDTO> messages) {
        this.threads = messages;
    }
}
