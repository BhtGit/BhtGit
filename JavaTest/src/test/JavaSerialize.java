package test;

import utils.Tuple;

import java.io.*;

public class JavaSerialize {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        new JavaSerialize().start();
    }

    public void start() throws IOException, ClassNotFoundException {

        Tuple.Tuple2<Boolean, String> tuple2 = Tuple.tuple2(false, "321");

        Long t1 = System.currentTimeMillis();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream obj = new ObjectOutputStream(out);
        for(int i = 0; i<10; i++) {
            obj.writeObject(tuple2);
        }
        System.out.println("java serialize: " +(System.currentTimeMillis() - t1) + "ms; 总大小：" + out.toByteArray().length );

        Long t2 = System.currentTimeMillis();
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new java.io.ByteArrayInputStream(out.toByteArray())));
        Tuple.Tuple2<Boolean, String> tuple21 = (Tuple.Tuple2<Boolean, String>) ois.readObject();
        System.out.println("java deserialize: " + (System.currentTimeMillis() - t2) + "ms;" + tuple21.one + "-" + tuple21.two);
    }

}
