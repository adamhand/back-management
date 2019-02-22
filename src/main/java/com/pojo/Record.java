package com.pojo;

import java.util.Date;

public class Record {
    private Integer recordId;

    private String recordType;

    private Date recordStartTime;

    private Date recordStopTime;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType == null ? null : recordType.trim();
    }

    public Date getRecordStartTime() {
        return recordStartTime;
    }

    public void setRecordStartTime(Date recordStartTime) {
        this.recordStartTime = recordStartTime;
    }

    public Date getRecordStopTime() {
        return recordStopTime;
    }

    public void setRecordStopTime(Date recordStopTime) {
        this.recordStopTime = recordStopTime;
    }
}