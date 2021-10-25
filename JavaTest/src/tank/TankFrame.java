package tank;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public static final TankFrame INSTANCE = new TankFrame();

    // 画布大小
    private static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;
    // 坦克高宽
    private static final int TANK_WIDTH = 20, TANK_HEIGHT = 20;

    // 初始位置
    private static int x = 100, y = 100;

    // 是否向某个方向移动
    private static boolean left, right, up, down;

    // 是否已有方向键被按下
    private static boolean isPress;

    // 键盘松开时间戳
    private static long loosenLeft, loosenRight, loosenUp, loosenDown;

    // 键盘松开多长时间后视为无效（用来记录斜方向） 单位 ms
    private static final long LOOSEN_TIME = 100;

    private TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
    }

    @Override
    public void paint(Graphics g) {
        moveTank();
        g.fillRect(x, y, TANK_WIDTH, TANK_HEIGHT);
    }

    class MyKeyListener extends KeyAdapter {

        // 间隔时间超过100ms，则不斜方向运动
        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                left = true;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                right = true;
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                up = true;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                down = true;
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                // 停止运动
                left = right = up = down = false;
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                x = y = 100;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                left = false;
//                loosenLeft = System.currentTimeMillis();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                right = false;
//                loosenRight = System.currentTimeMillis();
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                up = false;
//                loosenUp = System.currentTimeMillis();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                down = false;
//                loosenDown = System.currentTimeMillis();
            }
        }


    }

    private void moveTank() {
        if (left && x > 0) {
            x--;
        }
        if (right && x < GAME_WIDTH - TANK_WIDTH) {
            x++;
        }
        if (up && y > TANK_HEIGHT) {
            y--;
        }
        if (down && y < GAME_HEIGHT - TANK_HEIGHT) {
            y++;
        }
    }


}
