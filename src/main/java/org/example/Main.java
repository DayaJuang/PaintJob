package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(getBucketCount(3.4, 1.5));
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBucket){
        // Check if the parameter is valid or not
        if(width <= 0 || height<= 0 || areaPerBucket <= 0 || extraBucket < 0){
            return -1;
        }

        // Get the number of bucket we need
        int bucket = getBucketCount(width, height, areaPerBucket);

        // reduce the amount of bucket needed with extra bucket we have
        bucket -= extraBucket;

        return bucket;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket){
        if(width <= 0 || height<= 0 || areaPerBucket <= 0){
            return -1;
        }
        // Calculate the area
        double area = width * height;

        // Get how many bucket can cover the area
        return getBucketCount(area, areaPerBucket);
    }

    public static int getBucketCount(double area, double areaPerBucket){
        if(area<= 0 || areaPerBucket <= 0){
            return -1;
        }

        // find out how many bucket can cover the area
        int bucket = 0;
        double coveredArea = 0;
        while(coveredArea < area){
            // add the covered area until it bigger or equal the area
            // add the bucket counter for every area covered
            coveredArea += areaPerBucket;
            bucket++;
        }

        return bucket;
    }
}