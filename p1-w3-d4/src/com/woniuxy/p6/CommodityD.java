package com.woniuxy.p6;

import java.util.List;
import java.util.Map;

public interface CommodityD {
    List<Commodity> findAll();

    Commodity findById(int id);

    void addCommodity(Commodity commodity);

    void delCommodity(int id);

    void updateCommodity(int id, Commodity commodity);

    List<Commodity> findByType(String type);

    Map<String, Long> groupCommodityByTypename();

    Map<String, List<Commodity>> groupCommodityByType();

    List<Commodity> sortCommoditiesByPrice(boolean ascending);

}
