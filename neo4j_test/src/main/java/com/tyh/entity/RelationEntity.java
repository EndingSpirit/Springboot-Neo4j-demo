package com.tyh.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RelationEntity {

    private List<Map<String,Object>> links;
    private List<Map<String,Object>> nodes;

}
