package com.biubidang.runner;

import com.biubidang.Utils.RedisCache;
import com.biubidang.domain.entity.Article;
import com.biubidang.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component

public class ViewCountRunner implements CommandLineRunner {
    @Autowired(required = false)
    private ArticleMapper articleMapper;
    @Autowired
    private RedisCache redisCache;
    @Override
    public void run(String... args) throws Exception {
        List<Article> articles=articleMapper.selectList(null);
        Map<String, Integer> ViewCountMap = articles.stream()
                .collect(Collectors.toMap(new Function<Article, String>() {

                    @Override
                    public String apply(Article article) {
                        return article.getId().toString();
                    }
                }, new Function<Article, Integer>() {
                    @Override
                    public Integer apply(Article article) {
                        return article.getViewcounts().intValue();
                    }
                }));
        redisCache.setCacheMap("article:id-viewcount",ViewCountMap);
    }
}
