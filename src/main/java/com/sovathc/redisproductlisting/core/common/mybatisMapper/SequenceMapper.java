package com.sovathc.redisproductlisting.core.common.mybatisMapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SequenceMapper {
    String nextvalFormatted(String name);
}
