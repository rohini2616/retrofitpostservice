package com.example.postservice;

import java.util.List;

public class MakeResponse {
    private String status;
    private List<String> makeList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getMakeList() {
        return makeList;
    }

    public void setMakeList(List<String> makeList) {
        this.makeList = makeList;
    }
}
