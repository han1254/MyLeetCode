方法一：
```java
private static int removeDuplicates(int[] nums) {
        int placePtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[placePtr]) {
                nums[++placePtr] = nums[i];
            }
        }
        return placePtr + 1;
    }
```
<img src = "img/方法一结果.PNG">