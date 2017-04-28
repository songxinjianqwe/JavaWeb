import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class RandomCodeUtils {
	// Image,ImageIO,BufferedImage,Icon,ImageIcon

	private static final int CODE_NUM = 4; // ��֤���ַ�����

	// ����ͼ����֤�����ַ���������ʹ�С
	private static Font myFont = new Font("Arial", Font.BOLD, 16);

	// ����ַ�����
	private static char[] charSequence = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	private static Random random = new Random();

	/**
	 * ���������֤��
	 * 
	 * @param request
	 * @param response
	 */
	public static void createRandomCode() {
		// ָ��ͼ����֤��ͼƬ�Ĵ�С
		int width = 80, height = 25;
		// ����һ����ͼƬ
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// ��ͼƬ�л�������
		Graphics g = image.getGraphics();
		g.setColor(getRandomColor(200, 250));
		g.fillRect(1, 1, width - 1, height - 1);
		g.setColor(new Color(102, 102, 102));
		g.drawRect(0, 0, width - 1, height - 1);
		g.setFont(myFont);
		// ���������������ͼƬ��������������
		g.setColor(getRandomColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width - 1);// ����x����
			int y = random.nextInt(height - 1);// ����y����
			int x1 = random.nextInt(6) + 1;// x��ƫ����
			int y1 = random.nextInt(12) + 1;// y��ƫ����
			g.drawLine(x, y, x + x1, y + y1);
		}
		// ���������������ͼƬ��������������
		for (int i = 0; i < 70; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(12) + 1;
			int y1 = random.nextInt(6) + 1;
			g.drawLine(x, y, x - x1, y - y1);
		}
		// �ñ�����������ϵͳ���ɵ�����ַ���
		StringBuilder sRand = new StringBuilder(CODE_NUM);
		for (int i = 0; i < CODE_NUM; i++) {
			// ȡ��һ������ַ�
			String tmp = getRandomChar();
			sRand.append(tmp);
			// ��ϵͳ���ɵ�����ַ���ӵ�ͼ����֤��ͼƬ��
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(tmp, 15 * i + 10, 20);
		}

		g.dispose();
		// ���ͼ����֤��ͼƬ
		try {
			ImageIO.write(image, "JPEG", new FileOutputStream("D:/code.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// ���������ɫ
	private static Color getRandomColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	// �������һ���ַ�
	private static String getRandomChar() {
		int index = random.nextInt(charSequence.length);
		return String.valueOf(charSequence[index]);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		createRandomCode();
	}

}
