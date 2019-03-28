public class DP_Test {

    public static int max(int a,int b){
        if (a>=b){
            return a;
        }
        else {
            return b;
        }
    }

    public static int dgs(int arry[],int i){    //递归算法
        if (i==0){
            return arry[0];
        }
        if (i==1){
            return max(arry[0],arry[1]);
        }
        else {
            int num_1 = dgs(arry,i-2)+arry[i];  //选
            int num_2 = dgs(arry,i-1);
            return max(num_1,num_2);
        }
    }


    public static int dps(int arry[]){
        int[] opt = new int[arry.length];
        opt[0] = arry[0];
        opt[1] = max(arry[0],arry[1]);
        for (int i=2;i<arry.length;i++){
            int num_1 = opt[i-2]+arry[i];
            int num_2 = opt[i-1];
            opt[i]= max(num_1,num_2);
        }
        return opt[opt.length-1];
    }

    public static void main(String[] args) {
        int[] arry = {1,2,4,1,7,8,3};
        int result = dgs(arry,arry.length-1);
//        int result = dps(arry);
        System.out.println("max:"+result);
    }
}
