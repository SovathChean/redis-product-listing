package com.sovathc.redisproductlisting.core.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SequenceDAO {
    String nextvalFormatted(String name);
}
