package com.service.impl;

import com.dao.RecordMapper;
import com.pojo.Record;
import com.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "recordService")
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;

    @Override
    public void addRecord(Record record) {
        recordMapper.insert(record);
    }
}
