package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainGame{
	public static void main(String[] args) {
		int locks = 0,state = 0;
		GameGUI gui = new GameGUI();
		GameUTIL util = new GameUTIL();
		Thread t = new Thread(util);
		Thread t1 = new Thread(util);
		Thread t2 = new Thread(util);
		Thread t3 = new Thread(util);
		Thread t4 = new Thread(util);
		Thread t5 = new Thread(util);
		Thread t6 = new Thread(util);
		Thread t11 = new Thread(util);
		Thread t22 = new Thread(util);
		Thread t33 = new Thread(util);
		Thread t44 = new Thread(util);
		Thread t55 = new Thread(util);
		Thread t66 = new Thread(util);
		Thread t_cutscene = new Thread(util);
		Thread t_cutscene1 = new Thread(util);
		Thread t_cutscene2 = new Thread(util);
		Thread t_cutscene3 = new Thread(util);
		Thread t_cutscene4 = new Thread(util);
		Thread t_cutscene5 = new Thread(util);
		util.bonus_dmg=5;
		String[] backgroundlist = {"images\\bg_1_169.jpg", 
				"images\\bg_2_169.jpg", 
				"images\\bg_3_169.jpg", 
				"images\\bg_4_169.jpg",
				"images\\bg_5_169.jpg", 
				"images\\Bg_castle_1.png"};
		new HomePage();
        t.start();
		while(util.d==0) {
			System.out.println(util.d);
		}
		t.stop();
		while(gui.a<=5) {
			if(locks == 0) {
				util.seed = System.nanoTime( );
				util.rand = new Random( util.seed );
				gui.index_button = util.rand.nextInt(23)+(gui.a*40);
				try {
					gui.add_img();
				} catch (IOException e) {
					e.printStackTrace();
				}
				t_cutscene.start();
				gui.change_to_first_cutscene();
				gui.change_to_cutscene();
				t_cutscene.stop();
				util.sound=1;
				t1.start();
				gui.change_to_fight(backgroundlist[state]);
				locks = 1;
			}
			while(util.hp_monster>0&&util.hp_player>0) {
				try {
					util.damage();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(gui.a==0&&util.hp_player<=75&&util.time==0) {
					t1.stop();
					t11.start();
					util.time=1;
				}
				else if(gui.a==1&&util.hp_player<=75&&util.time==0) {
					t2.stop();
					t22.start();
					util.time=1;
				}
				else if(gui.a==2&&util.hp_player<=75&&util.time==0) {
					t3.stop();
					t33.start();
					util.time=1;
				}
				else if(gui.a==3&&util.hp_player<=75&&util.time==0) {
					t4.stop();
					t44.start();
					util.time=1;
				}
				else if(gui.a==4&&util.hp_player<=75&&util.time==0) {
					t5.stop();
					t55.start();
					util.time=1;
				}
				else if(gui.a==5&&util.hp_player<=75&&util.time==0) {
					t6.stop();
					t66.start();
					util.time=1;
				}
			}
			if(util.hp_monster<=0) {
				state++;
				gui.monster_dead();
				util.hp_player=300;
				gui.a++;
				util.time=0;
				
				switch(gui.a) {
				
				case 1:gui.b+=6;
				t1.stop();
				t11.stop();
				util.seed = System.nanoTime( );
				util.rand = new Random( util.seed );
		        gui.index_button = util.rand.nextInt(23)+(gui.a*40);
		        gui.txt.setText(util.num_24[gui.index_button][0]);
		        util.sound=0;
		        t_cutscene1.start();
				gui.change_to_cutscene();
				t_cutscene1.stop();
				util.sound=1;
				t2.start();
				gui.change_to_fight(backgroundlist[state]);
				util.bonus_dmg=5;
				break;
				
				case 2:gui.b+=2;
				t2.stop();
				util.seed = System.nanoTime( );
				util.rand = new Random( util.seed );
		        gui.index_button = util.rand.nextInt(23)+(gui.a*40);
		        gui.txt.setText(util.num_24[gui.index_button][0]);
		        util.sound=0;
		        t_cutscene2.start();
				gui.change_to_cutscene();
				t_cutscene2.stop();
				util.sound=1;
				t3.start();
				gui.change_to_fight(backgroundlist[state]);
				util.bonus_dmg=5;
				break;
				
				case 3:gui.b+=5;
				t3.stop();
				util.seed = System.nanoTime( );
				util.rand = new Random( util.seed );
		        gui.index_button = util.rand.nextInt(23)+(gui.a*40);
		        gui.txt.setText(util.num_24[gui.index_button][0]);
		        util.sound=0;
		        t_cutscene3.start();
				gui.change_to_cutscene();
				t_cutscene3.stop();
				util.sound=1;
				t4.start();
				gui.change_to_fight(backgroundlist[state]);
				util.bonus_dmg=5;
				break;
				
				case 4:gui.b+=5;
				t4.stop();
				util.seed = System.nanoTime( );
				util.rand = new Random( util.seed );
		        gui.index_button = util.rand.nextInt(23)+(gui.a*40);
		        gui.txt.setText(util.num_24[gui.index_button][0]);
		        util.sound=0;
		        t_cutscene4.start();
				gui.change_to_cutscene();
				t_cutscene4.stop();
				util.sound=1;
				t5.start();
				gui.change_to_fight(backgroundlist[state]);
				util.bonus_dmg=5;
				break;
				
				case 5:gui.b+=2;
				t5.stop();
				util.seed = System.nanoTime( );
				util.rand = new Random( util.seed );
		        gui.index_button = util.rand.nextInt(23)+(gui.a*40);
		        gui.txt.setText(util.num_24[gui.index_button][0]);
		        util.sound=0;
		        t_cutscene5.start();
				gui.change_to_cutscene();
				t_cutscene5.stop();
				util.sound=1;
				t6.start();
				gui.change_to_fight(backgroundlist[state]);
				util.bonus_dmg=5;
				break;
				}
			}
			else if(util.hp_player<=0) {
//				t1.stop();
				t11.stop();
//				t2.stop();
				t22.stop();
//				t3.stop();
				t33.stop();
//				t4.stop();
				t44.stop();
//				t5.stop();
				t55.stop();
//				t6.stop();
				t66.stop();
				gui.player_dead();
				state = 0;
				gui.fr.dispose();
				util.hp_player=300;
				gui.a=0;
				util.sound=0;
				util.time=0;
				util.d=0;
				util.hp_monster=300;
				main(args);
			}
		}
	}

}