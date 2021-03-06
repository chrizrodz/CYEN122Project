package graphics;

import gameObjects.PlayerObject;

/*
 * Singleton which tracks where the player is and how the other graphicComponents should be shifted
 */
public class Camera
{

	// Basic Header for a singleton class
	private static Camera cameraSingleton;

	public static Camera getCamera()
	{
		if (cameraSingleton == null)
		{
			cameraSingleton = new Camera();
		}
		return cameraSingleton;
	}

	private int x;
	private int y;
	private int leftScreen;
	private int topScreen;

	public Camera()
	{
		leftScreen = (-PlayerObject.WIDTH / 2) + Canvas.WIDTH / 2;
		topScreen = (-PlayerObject.HEIGHT / 2) + Canvas.HEIGHT / 2;
	}

	public int getXShift()
	{
		return x - leftScreen;
	}

	public int getYShift()
	{
		return y - topScreen;
	}

	public void setPos(int xin, int yin)
	{
		x = xin;
		y = yin;
	}

	public void moveX(int xin)
	{
		x += xin;
	}

	public void moveY(int yin)
	{
		y += yin;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

}
