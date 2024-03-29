package com.apress.quickpoll.dto;

import java.util.Collection;

public class VoteResult {
    private int totalVotes;
    private Collection<OptionACount> results;

    public VoteResult() {
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public Collection<OptionACount> getResults() {
        return results;
    }

    public void setResults(Collection<OptionACount> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "VoteResult{" +
                "totalVotes=" + totalVotes +
                ", results=" + results +
                '}';
    }

}
