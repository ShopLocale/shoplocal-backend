package com.shoplocal.helper.location;

import com.shoplocal.entity.Shop;

import java.util.*;
import java.lang.*;

public class DistanceHelper {

    private static final Double allowedServiceDistance = 3.0;
    public static void main(String[] args) throws java.lang.Exception {
//        User customer1 = new User("Sagar", 28.9494509,77.747575);
//        User store1 = new User("babaBestValue", 28.9495636, 77.748111);
//        User store2 = new User("elegantHonda", 28.9647044, 77.736061);
//        User store3 = new User("pnb", 28.9551864, 77.7455757);
//        User store4 = new User("jaiSaiKitchenGhar", 28.9506161,77.7463391);
//        User store6 = new User("The absolute gym", 28.9494509,77.747575);
//
////        User customer1 = new User("customerAtNutema", 28.9557792, 77.7515146);
////        User customer1 = new User("customerAtTejGarhi", 28.9629236,77.7387241);
//
//        List<User> destinationList = new ArrayList<>();
//        destinationList.add(store1);
//        destinationList.add(store2);
//        destinationList.add(store3);
//        destinationList.add(store4);
//        destinationList.add(store5);
//        destinationList.add(store6);
//
//        getSortedList(customer1, destinationList).forEach(user -> {
//            System.out.println(user.id+ " is "+ user.distance + " km away from " +customer1.id);
//        });

    }

    public static void updateShopList(Point sourcePoint, List<Shop> shopList, int radius) {
        shopList.forEach(shop -> {
            shop.setDistance(distance(sourcePoint.latitude, sourcePoint.longitude,
                    Double.parseDouble(shop.getAddress().getLatitude()), Double.parseDouble(shop.getAddress().getLongitude())));
        });
        Comparator<Shop> userComparator = Comparator.comparing(Shop::getDistance);
        shopList.removeIf(shop -> shop.getDistance() > radius);
        shopList.removeIf(shop -> !shop.getActive());
        shopList.sort(userComparator);
        shopList.forEach(shop -> System.out.println("shop:"+ shop.getShopName()+ " distance:"+shop.getDistance()));
    }

    public static Boolean isWithinAllowedDistance(Point sourcePoint, Shop shop) {
        Double serviceDistance = distance(
                sourcePoint.latitude,
                sourcePoint.longitude,
                Double.parseDouble(shop.getAddress().getLatitude()),
                Double.parseDouble(shop.getAddress().getLongitude()));

        System.out.println("serviceDistance is "+ serviceDistance);
        System.out.println("allowedServiceDistance is "+ allowedServiceDistance);
        if (serviceDistance < allowedServiceDistance)
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

    private static Double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0D;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) *
                    Math.sin(Math.toRadians(lat2)) +
                    Math.cos(Math.toRadians(lat1)) *
                            Math.cos(Math.toRadians(lat2)) *
                            Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515 * 1.609344;
            return (dist);
        }
    }
}

