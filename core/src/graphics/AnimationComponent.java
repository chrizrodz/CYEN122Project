package graphics;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/*
 * A graphic component that uses animations instead of still images.
 * 
 */
public class AnimationComponent extends GraphicComponent
{

	private HashMap<String, Animation> animations;

	private String currentTrack;
	private String defaultTrack;

	public AnimationComponent(int x, int y, int xSize, int ySize, String key, int layer)
	{
		super(x, y, xSize, ySize, "animError", layer);
		animations = ImageLibrary.getImageLibrary().findAnim(key);
		defaultTrack = currentTrack = "default";

	}

	@Override
	public boolean isDone(String track)
	{
		if (animations.get(track).isDone())
		{
			updateTexture(defaultTrack);
			return true;
		}
		return false;
	}

	/*
	 * Overrides the getTexture to actually return the frame of the currently
	 * playing animation.
	 */
	@Override
	public TextureRegion getTexture()
	{
		isDone(currentTrack);
		return animations.get(currentTrack).play();
	}

	/*
	 * Instead of changing the texture, change the entire animation.
	 */
	@Override
	public void updateTexture(String key)
	{
		currentTrack = key;
		animations.get(currentTrack).play();
	}

	@Override
	public void updateSet(String key)
	{
		animations = ImageLibrary.getImageLibrary().findAnim(key);
	}

}