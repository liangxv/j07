package com.woniuxy.p6;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TravelPlanParser {
    public static void main(String[] args) throws Exception {
        Class<TravelAgent> travelAgentClass = TravelAgent.class;
        TravelAgent travelAgent = travelAgentClass.getConstructor().newInstance();
        Method[] methods = travelAgentClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(TravelPlan.class)) {
                Annotation[] annotations = method.getAnnotations();
                TravelPlan annotation = method.getAnnotation(TravelPlan.class);
                System.out.println(method.getName() + "的行程信息");
                System.out.println("Destination: " + annotation.destination());
                System.out.println("Start Date: " + annotation.startDate());
                System.out.println("End Date: " + annotation.endDate());
                System.out.println("Transportation: " + annotation.transportation());
                System.out.println();
            }
        }
    }
}
