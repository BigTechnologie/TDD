package fr.dawan.formationtdd;

public class Thermometre {

//    public int procheZero(int ... temp) {
//        if(temp.length==0) {
//            return 0;
//        }
//        return -1;
//    }

//    public int procheZero(int... temp) {
//        if (temp.length == 0) {
//            return 0;
//        }
//        if (temp.length > 100) {
//            throw new IllegalArgumentException("Nombre de température > à 100");
//        }
//        return -1;
//    }

//    public int procheZero(int... temp) {
//        if (temp.length == 0) {
//            return 0;
//        }
//        if (temp.length > 100) {
//            throw new IllegalArgumentException("Nombre de température > à 100");
//        }
//        
//        int tpz=temp[0];
//        for(int t :temp) {
//            if(Math.abs(t)<Math.abs(tpz)) {
//                tpz=t;
//            }
//        }
//        return tpz;
//    }

    public int procheZero(int... temp) {
        if (temp.length == 0) {
            return 0;
        }
        if (temp.length > 100) {
            throw new IllegalArgumentException("Nombre de température > à 100");
        }
        int tpz=temp[0];
        for(int t :temp) {
            if(Math.abs(t)<Math.abs(tpz) || tpz<0 && Math.abs(t)==Math.abs(tpz)) {
                tpz=t;
            }
        }
        return tpz;

        // avec stream
//        if (temp == null || temp.length > 100)
//            throw new IllegalArgumentException();
//
//        return Arrays.stream(temp).reduce((prev, curr) -> {
//            if (Math.abs(prev) < Math.abs(curr)) {
//                return prev;
//            } else {
//                return curr;
//            }
//        }).orElse(0);
    }
}
