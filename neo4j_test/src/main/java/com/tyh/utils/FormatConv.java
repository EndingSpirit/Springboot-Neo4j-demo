package com.tyh.utils;

import com.tyh.entity.Movie;
import com.tyh.entity.Roles;

import java.util.*;

public class FormatConv {
    public static Map<String, Object> toFormat(List<Movie> result) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        for (Movie movie : result) {
            Map<String, Object> node = new LinkedHashMap<>();
            node.put("id", movie.getId());
            node.put("name", movie.getTitle());
            node.put("released", movie.getReleased());
            node.put("tagline", movie.getTagline());
            nodes.add(node);
            for (Roles person : movie.getRoles()) {
                Map<String, Object> rel = new LinkedHashMap<>();
                rel.put("source", movie.getId());
                rel.put("target", person.getId());
                rels.add(rel);
            }
        }
        return map("nodes", nodes, "links", rels);
    }

    public static Map<String, Object> toD3Format(List<Movie> movies) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<Movie> result = movies.iterator();
        while (result.hasNext()) {
            Movie movie = result.next();
            nodes.add(map("title", movie.getTitle(),"tagline", movie.getTagline()));
            //nodes.add(map("title", movie.getTitle(), "label", "movie"));
            int target = i;
            i++;
            for (Roles role : movie.getRoles()) {
                Map<String, Object> actor = map("title", role.getPerson().getName(), "label", "actor");
                int source = nodes.indexOf(actor);
                if (source == -1) {
                    nodes.add(actor);
                    source = i++;
                }
                rels.add(map("source", source, "target", target));
            }
        }
        return map("nodes", nodes, "links", rels);
    }

    public static Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new LinkedHashMap<>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }
}
