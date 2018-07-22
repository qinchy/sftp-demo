package com.qinchy.sftpdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@SpringBootApplication
public class SftpDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SftpDemoApplication.class, args);
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i : result
                ) {
            System.out.println(i);

        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if (null != nums && nums.length != 0 ){
            for (int i =0;i<nums.length;i++){
                for (int j=i+1;j<nums.length;j++){
                    if (nums[i] + nums[j] == target){
                        return new int[]{i,j};
                    }
                }
            }
        }
        return new int[]{0,0};
    }
}
