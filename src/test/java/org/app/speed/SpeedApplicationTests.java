package org.app.speed;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpeedApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void bobbleSort() {

        int num[] = {3, 8, 4, 5, 1, 7, 2};
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "、");
        }


    }

    @Test
    void showSum(){
        int num[] = {3, 8, 4,8, 4, 5, 1, 7, 2};
        int temp[] = new int[10];

        for(int i = 0;i<num.length;i++){
            temp[num[i]] += 1;
        }

        for(int i = 0; i<temp.length;i++){
            if(temp[i]>0){
                System.out.println(i+"出现的次数："+temp[i]);
            }
        }

    }

}
