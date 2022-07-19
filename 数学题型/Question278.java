/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int big = n;
            int small = 0;
            n = n / 2;
            int times = 32;
    
            loop:if(big < 20){
                for(int i = 1; i <= big; i++){
                    if(isBadVersion(i) == true){
                        n = i - 1;
                        break loop;
                    }
                }
            }
            if(big >= 20){
                while(times > 0){
                    if(isBadVersion(n) == false){
                        small = n;
                        n = (small / 2) + (big / 2);
                    }
    
                    else{
                        big = n;
                        n = (small / 2) + (big / 2);
                    }
    
                    if(big - small <= 1){
                        break;
                    }
    
                    times --;
                }
            }
            for(int i = 1; i <= 3; i++){
                if(isBadVersion(n + i) == true){
                    n = n + i;
                    break;
                }
            }
            return n;
        }
    }