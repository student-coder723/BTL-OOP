package Game;

import static Game.Menu.stage_menu;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BaseClass
{
    public static void checkPaddle(Ball ball_obj , Paddle paddle_obj , boolean goLeft , boolean goRight)
    {
        // Kiểm tra va chạm giữa bóng và paddle
        if (ball_obj.ball_iv.getBoundsInParent().intersects(paddle_obj.paddle_iv.getBoundsInParent())) {
            // Nếu bóng đang đi xuống thì mới phản lại
            if (ball_obj.getStepY() > 0) {
                ball_obj.setStepY(-ball_obj.getStepY()); // Bật ngược lên
                // Đặt bóng ngay trên paddle để tránh chui vào
                ball_obj.setY(paddle_obj.getY() - ball_obj.getHeight() - 1);

                // Đổi hướng theo phím đang nhấn
                if (goLeft) {
                    ball_obj.setStepX(-Math.abs(ball_obj.getStepX()));
                } else if (goRight) {
                    ball_obj.setStepX(Math.abs(ball_obj.getStepX()));
                }
            }
        }
    }


    public static  void checkPause(Scene scene_1 ,Ball ball_obj , Paddle paddle_obj  , Group group , Pane pane)
    {
        Text pause = new Text();
        scene_1.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e)
            {
                if(e.getCode() == KeyCode.P)
                {
                    ball_obj.setSpeed(0);
                    paddle_obj.setSpeed(0);

                    pause.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,50));
                    pause.setFill(Color.LIME);// setting colour of the text to blue
                    pause.setText("Paused");
                    if(group==null )
                    {
                        pane.getChildren().add(pause);
                        pause.setX(scene_1.getWidth()/2-260);
                        pause.setY(scene_1.getHeight()/2);
                    }
                    else
                    {
                        group.getChildren().add(pause);
                        pause.setX(scene_1.getWidth()/2-60);
                        pause.setY(scene_1.getHeight()/2);
                    }

                    Sound.mediaPlayer_background.pause();
                }
                else if(e.getCode() == KeyCode.ENTER)
                {
                    ball_obj.setSpeed(5);
                    paddle_obj.setSpeed(10);
                    if(group==null ) pane.getChildren().remove(pause);
                    else            group.getChildren().remove(pause) ;

                    Sound.mediaPlayer_background.play();
                }
                else if(e.getCode() == KeyCode.S)
                {
                    Sound.mediaPlayer_background.pause();
                }

            }
        });
    }

    public static void checkEmpty(icons icons_obj , Paddle paddle_obj)
    {
        if(icons_obj.i_empty.getBoundsInParent().intersects(paddle_obj.paddle_iv.getBoundsInParent()) )
        {
            Sound.playsound_capsule();
            icons_obj.i_empty.setImage(null);
        }
    }

    public static void check_Escape(Scene Currentscene,Stage stage , Scene Toscene)
    {
        Currentscene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e)
            {
                if(e.getCode() == KeyCode.ESCAPE)
                {
                    Sound.mediaPlayer_background.stop();
                    stage.setTitle("Arkanoid - Menu");
                    stage.setScene(Toscene);
                }

            }
        });
    }

    public static void ShowPlayerNameOnScreen(Scene scene_ , String s_name)
    {
        Text player_txt = new Text();

        player_txt.setX(560);
        player_txt.setY(40);
        player_txt.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,25));
        player_txt.setFill(Color.RED);// setting colour of the text to blue
        player_txt.setText("\" "+s_name+" \"");

        Arkanoid.group.getChildren().add(player_txt);
    }

}