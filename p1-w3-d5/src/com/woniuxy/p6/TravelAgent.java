package com.woniuxy.p6;

class TravelAgent {
    public TravelAgent() {
    }

    @TravelPlan(destination = "巴黎", startDate = "2023-08-01", endDate =
            "2023-08-07")
    public void planTrip1() {
// 方法实现
    }
    @TravelPlan(destination = "东京", startDate = "2023-09-15", endDate =
            "2023-09-22", transportation = "飞机")
    public void planTrip2() {
// 方法实现
    }
}
