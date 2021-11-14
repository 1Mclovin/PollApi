package com.apress.quickpoll.dto;

public class OptionACount {
    private Long optionId;
    private int count;

    public OptionACount() {
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OptionACount{" +
                "optionId=" + optionId +
                ", count=" + count +
                '}';
    }
}
