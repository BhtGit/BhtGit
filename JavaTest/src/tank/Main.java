package tank;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = TankFrame.INSTANCE;
        tf.setVisible(true);

        while (true) {
            Thread.sleep(5);
            tf.repaint();
        }


    }

}
