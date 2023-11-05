class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int bill : bills){
            // if bill is 5, we don't need to give change
            if(bill == 5) five++;
            else if(bill == 10){ // if bill is 10, we need to give 5
                if(five == 0) return false;
                five--;
                ten++;
            } else { // if bill is 20, we need to give 15
                if(ten > 0 && five > 0){
                    five--;
                    ten--;
                } else if(five >= 3) five -= 3; // if we don't have 10, we need to give 3 5s
                else return false;
            }
        }
        return true;
    }
}
