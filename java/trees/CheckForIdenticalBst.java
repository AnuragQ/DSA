
public class CheckForIdenticalBst {
    public static void main(String[] args) {
        // int[] a = {8, 3, 6, 1, 4, 7, 10, 14, 13};
        // int[] b = {8, 10, 14, 3, 4, 6, 1, 7, 13};
       int[] a = {2, 4, 1, 3};
       int[] b={2, 4, 3, 1};
        System.out.println(isIdentical(a, b));


    }
    public static boolean isIdentical(int[] a,int[] b){

        if(a.length==0 || b.length==0) {
            return true;
        }
        if(a.length !=b.length){
            return false;
        }

        if(a[0]!=b[0]){
            return false;
        }
        
        int lcount=0;
        for(int i=1;i<a.length;i++){
            if(a[i]<a[0]){
                lcount++;
            }
        }
        int[] aleft=new int[lcount];
        int[] aright=new int[a.length-lcount-1];
        int lidx=0;
        int ridx=0;
        for(int i=1;i<a.length;i++){
            if(a[i]<a[0]){
                aleft[lidx]=a[i];
                lidx++;
            }else{
                aright[ridx]=a[i];
                ridx++;
            }
        }
        lcount=0;
        for(int i=1;i<b.length;i++){
            if(b[i]<b[0]){
                lcount++;
            }
        }
        int[] bleft=new int[lcount];
        int[] bright=new int[b.length-lcount-1];
        lidx=0;
        ridx=0;
        for(int i=1;i<b.length;i++){
            if(b[i]<b[0]){
                bleft[lidx]=b[i];
                lidx++;
            }else{
                bright[ridx]=b[i];
                ridx++;
            }
        }
        return isIdentical(aleft, bleft) && isIdentical(aright, bright);
    }
}
