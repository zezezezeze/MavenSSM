package com.millery.util.file;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;

public final class ImageUtil {
	
	// 楠岃瘉鐮佸瓧绗﹂泦
		private static final char[] chars = { 
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		// 瀛楃鏁伴噺
		private static final int SIZE = 4;
		// 骞叉壈绾挎暟閲�
		private static final int LINES = 5;
		// 瀹藉害
		private static final int WIDTH = 80;
		// 楂樺害
		private static final int HEIGHT = 40;
		// 瀛椾綋澶у皬
		private static final int FONT_SIZE = 30;

		/**
		 * 鐢熸垚闅忔満楠岃瘉鐮佸強鍥剧墖
		 * Object[0] : 楠岃瘉鐮佸瓧绗︿覆	String
		 * Object[1] : 楠岃瘉鐮佸浘鐗�	BufferedImage
		 */
		public static Object[] createImage() {
			StringBuffer sb = new StringBuffer();
			// 1.鍒涘缓绌虹櫧鍥剧墖
			BufferedImage image = new BufferedImage(
				WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			// 2.鑾峰彇鍥剧墖鐢荤瑪
			Graphics graphic = image.getGraphics();
			// 3.璁剧疆鐢荤瑪棰滆壊
			graphic.setColor(Color.LIGHT_GRAY);
			// 4.缁樺埗鐭╁舰鑳屾櫙
			graphic.fillRect(0, 0, WIDTH, HEIGHT);
			// 5.鐢婚殢鏈哄瓧绗�
			Random ran = new Random();
			for (int i = 0; i <SIZE; i++) {
				// 鍙栭殢鏈哄瓧绗︾储寮�
				int n = ran.nextInt(chars.length);
				// 璁剧疆闅忔満棰滆壊
				graphic.setColor(getRandomColor());
				// 璁剧疆瀛椾綋澶у皬
				graphic.setFont(new Font(
					null, Font.BOLD + Font.ITALIC, FONT_SIZE));
				// 鐢诲瓧绗�
				graphic.drawString(
					chars[n] + "", i * WIDTH / SIZE, HEIGHT / 2);
				// 璁板綍瀛楃
				sb.append(chars[n]);
			}
			// 6.鐢诲共鎵扮嚎
			for (int i = 0; i < LINES; i++) {
				// 璁剧疆闅忔満棰滆壊
				graphic.setColor(getRandomColor());
				// 闅忔満鐢荤嚎
				graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT),
						ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
			}
			// 7.杩斿洖楠岃瘉鐮佸拰鍥剧墖
			return new Object[]{sb.toString(), image};
		}

		/**
		 * 闅忔満鍙栬壊
		 */
		public static Color getRandomColor() {
			Random ran = new Random();
			Color color = new Color(ran.nextInt(256), 
					ran.nextInt(256), ran.nextInt(256));
			return color;
		}

}
