package graphics;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/*
 * Collection class which loads all our images and animations.
 * 
 */
public class ImageLibrary
{

	private static ImageLibrary imageLibrarySingleton;

	public static ImageLibrary getImageLibrary()
	{
		if (imageLibrarySingleton == null)
		{
			imageLibrarySingleton = new ImageLibrary();
		}
		return imageLibrarySingleton;
	}

	public static void reset()
	{
		imageLibrarySingleton = new ImageLibrary();
	}

	private HashMap<String, TextureRegion> images;
	private HashMap<String, Animation> animations;
	private HashMap<String, HashMap<String, Animation>> animationSet;

	private HashMap<String, Integer> setLengths;

	public ImageLibrary()
	{
		loadImages();
	}

	public void loadImages()
	{

		try
		{
			images = new HashMap<String, TextureRegion>();
			images.put("animError", new TextureRegion(new Texture("res/myTex.png"), 0, 0, 1.0f, 1.0f));
			

			images.put("gameOver", new TextureRegion(new Texture("res/cutscenes/gameOver.png"), 0, 0, 1.0f, 1.0f));
			images.put("gameWonFamine", new TextureRegion(new Texture("res/cutscenes/gameWonFamine.png"), 0, 0, 1.0f, 1.0f));
			images.put("gameWonPlague", new TextureRegion(new Texture("res/cutscenes/gameWonPlague.png"), 0, 0, 1.0f, 1.0f));
			images.put("gameWonWar", new TextureRegion(new Texture("res/cutscenes/gameWonWar.png"), 0, 0, 1.0f, 1.0f));
			images.put("gameWonDeath", new TextureRegion(new Texture("res/cutscenes/gameWonDeath.png"), 0, 0, 1.0f, 1.0f));
			images.put("titleScreen", new TextureRegion(new Texture("res/cutscenes/titleScreen.png"), 0, 0, 1.0f, 1.0f));
			images.put("prayerChoiceScreen", new TextureRegion(new Texture("res/cutscenes/prayerChoiceScreen.png"), 0, 0, 1.0f, 1.0f));
			
			images.put("intro1", new TextureRegion(new Texture("res/cutscenes/famineIntro.jpg"), 0, 0, 1.0f, 1.0f));
			images.put("intro2", new TextureRegion(new Texture("res/cutscenes/plagueIntro.jpg"), 0, 0, 1.0f, 1.0f));
			images.put("intro3", new TextureRegion(new Texture("res/cutscenes/warIntro.jpg"), 0, 0, 1.0f, 1.0f));
			images.put("intro4", new TextureRegion(new Texture("res/cutscenes/deathIntro.jpg"), 0, 0, 1.0f, 1.0f));
			

			images.put("rustySword",
					new TextureRegion(new Texture("res/items/weapons/rustySword.png"), 0, 0, 1.0f, 1.0f));
			images.put("angelicBlade",
					new TextureRegion(new Texture("res/items/weapons/AngelicSword.png"), 0, 0, 1.0f, 1.0f));
			images.put("axeOfTheFallenViking",
					new TextureRegion(new Texture("res/items/weapons/AxeOfTheFallenViking.png"), 0, 0, 1.0f, 1.0f));
			images.put("bladeOfWar",
					new TextureRegion(new Texture("res/items/weapons/BladeOfWar.png"), 0, 0, 1.0f, 1.0f));
			images.put("skeletonsArm",
					new TextureRegion(new Texture("res/items/weapons/SkeletonsArm.png"), 0, 0, 1.0f, 1.0f));
			images.put("theHandOfDeath",
					new TextureRegion(new Texture("res/items/weapons/TheHandOfDeath.png"), 0, 0, 1.0f, 1.0f));
			images.put("theLightBringer",
					new TextureRegion(new Texture("res/items/weapons/TheLightBringer.png"), 0, 0, 1.0f, 1.0f));
			images.put("ironSword",
					new TextureRegion(new Texture("res/items/weapons/IronSword.png"), 0, 0, 1.0f, 1.0f));
			images.put("legendarySword",
					new TextureRegion(new Texture("res/items/weapons/legendarySword.png"), 0, 0, 1.0f, 1.0f));
			images.put("bow",
					new TextureRegion(new Texture("res/items/weapons/bow.png"), 0, 0, 1.0f, 1.0f));

			images.put("arrow",
					new TextureRegion(new Texture("res/items/misc/arrow.png"), 0, 0, 1.0f, 1.0f));
			images.put("deathBall",
					new TextureRegion(new Texture("res/effects/deathBall.png"), 0, 0, 1.0f, 1.0f));
			images.put("elixr",
					new TextureRegion(new Texture("res/items/misc/elixr.png"), 0, 0, 1.0f, 1.0f));

			
			
			images.put("holyWater", new TextureRegion(new Texture("res/items/relics/holyWater.png"), 0, 0, 1.0f, 1.0f));
			images.put("rosary", new TextureRegion(new Texture("res/items/relics/rosary.png"), 0, 0, 1.0f, 1.0f));

			
			
			
			images.put("doorClosed", new TextureRegion(new Texture("res/items/misc/doorClosed.png"), 0, 0, 1.0f, 1.0f));
			images.put("doorOpen", new TextureRegion(new Texture("res/items/misc/doorOpen.png"), 0, 0, 1.0f, 1.0f));

			images.put("level1building:1",
					new TextureRegion(new Texture("res/buildingGenPatterns/level1building/pattern1.png"), 0, 0, 1.0f, 1.0f));
			images.put("level1building:2",
					new TextureRegion(new Texture("res/buildingGenPatterns/level1building/pattern2.png"), 0, 0, 1.0f, 1.0f));
			images.put("level1building:BOSS",
					new TextureRegion(new Texture("res/buildingGenPatterns/level1building/patternBOSS.png"), 0, 0, 1.0f, 1.0f));

			images.put("level2building:1",
					new TextureRegion(new Texture("res/buildingGenPatterns/level2building/pattern1.png"), 0, 0, 1.0f, 1.0f));
			images.put("level2building:BOSS",
					new TextureRegion(new Texture("res/buildingGenPatterns/level2building/patternBOSS.png"), 0, 0, 1.0f, 1.0f));
			images.put("level2building:2",
					new TextureRegion(new Texture("res/buildingGenPatterns/level2building/pattern2.png"), 0, 0, 1.0f, 1.0f));
			images.put("level2building:3",
					new TextureRegion(new Texture("res/buildingGenPatterns/level2building/pattern3.png"), 0, 0, 1.0f, 1.0f));

			images.put("level3building:1",
					new TextureRegion(new Texture("res/buildingGenPatterns/level3building/pattern1.png"), 0, 0, 1.0f, 1.0f));
			images.put("level3building:BOSS",
					new TextureRegion(new Texture("res/buildingGenPatterns/level3building/patternBOSS.png"), 0, 0, 1.0f, 1.0f));
			images.put("level3building:2",
					new TextureRegion(new Texture("res/buildingGenPatterns/level3building/pattern2.png"), 0, 0, 1.0f, 1.0f));
			
			images.put("level4building:1",
					new TextureRegion(new Texture("res/buildingGenPatterns/level4building/pattern1.png"), 0, 0, 1.0f, 1.0f));
			images.put("level4building:BOSS",
					new TextureRegion(new Texture("res/buildingGenPatterns/level4building/patternBOSS.png"), 0, 0, 1.0f, 1.0f));
			
			
			images.put("healthBar", new TextureRegion(new Texture("res/gui/healthFull.png"), 0, 0, 1.0f, 1.0f));
			images.put("healthLostBar", new TextureRegion(new Texture("res/gui/healthLost.png"), 0, 0, 1.0f, 1.0f));
			images.put("healthPoison", new TextureRegion(new Texture("res/gui/healthPoison.png"), 0, 0, 1.0f, 1.0f));
			images.put("inventory", new TextureRegion(new Texture("res/gui/inventory.png"), 0, 0, 1.0f, 1.0f));
			images.put("compass", new TextureRegion(new Texture("res/gui/compass.png"), 0, 0, 1.0f, 1.0f));
			images.put("quitButton", new TextureRegion(new Texture("res/gui/quit.png"), 0, 0, 1.0f, 1.0f));
			images.put("continueButton", new TextureRegion(new Texture("res/gui/continue.png"), 0, 0, 1.0f, 1.0f));
			images.put("newGameButton", new TextureRegion(new Texture("res/gui/newGame.png"), 0, 0, 1.0f, 1.0f));	
			images.put("selected", new TextureRegion(new Texture("res/gui/selected.png"), 0, 0, 1.0f, 1.0f));
			images.put("transparency", new TextureRegion(new Texture("res/gui/transparency.png"), 0, 0, 1.0f, 1.0f));
			images.put("minimize", new TextureRegion(new Texture("res/gui/minimize.png"), 0, 0, 1.0f, 1.0f));
			images.put("maximize", new TextureRegion(new Texture("res/gui/maximize.png"), 0, 0, 1.0f, 1.0f));
			
			
			
			images.put("ourFatherChoice", new TextureRegion(new Texture("res/gui/prayers/choices/ourFather.png"), 0, 0, 1.0f, 1.0f));
			images.put("gloryBeChoice", new TextureRegion(new Texture("res/gui/prayers/choices/gloryBe.png"), 0, 0, 1.0f, 1.0f));
			images.put("boltOfGodChoice", new TextureRegion(new Texture("res/gui/prayers/choices/boltOfGod.png"), 0, 0, 1.0f, 1.0f));
			images.put("deusVultChoice", new TextureRegion(new Texture("res/gui/prayers/choices/deusVult.png"), 0, 0, 1.0f, 1.0f));
			images.put("holyRetributionChoice", new TextureRegion(new Texture("res/gui/prayers/choices/holyRetribution.png"), 0, 0, 1.0f, 1.0f));
			images.put("slowTheUnholyChoice", new TextureRegion(new Texture("res/gui/prayers/choices/slowTheUnholy.png"), 0, 0, 1.0f, 1.0f));
			images.put("tueriCorpusChoice", new TextureRegion(new Texture("res/gui/prayers/choices/tueriCorpus.png"), 0, 0, 1.0f, 1.0f));
			images.put("wingsOfAngelsChoice", new TextureRegion(new Texture("res/gui/prayers/choices/wingsOfAngels.png"), 0, 0, 1.0f, 1.0f));
			
			
			images.put("ourFather", new TextureRegion(new Texture("res/gui/prayers/icons/ourFather.png"), 0, 0, 1.0f, 1.0f));
			images.put("gloryBe", new TextureRegion(new Texture("res/gui/prayers/icons/gloryBe.png"), 0, 0, 1.0f, 1.0f));
			images.put("boltOfGod", new TextureRegion(new Texture("res/gui/prayers/icons/boltOfGod.png"), 0, 0, 1.0f, 1.0f));
			images.put("deusVult", new TextureRegion(new Texture("res/gui/prayers/icons/deusVult.png"), 0, 0, 1.0f, 1.0f));
			images.put("holyRetribution", new TextureRegion(new Texture("res/gui/prayers/icons/holyRetribution.png"), 0, 0, 1.0f, 1.0f));
			images.put("slowTheUnholy", new TextureRegion(new Texture("res/gui/prayers/icons/slowTheUnholy.png"), 0, 0, 1.0f, 1.0f));
			images.put("tueriCorpus", new TextureRegion(new Texture("res/gui/prayers/icons/tueriCorpus.png"), 0, 0, 1.0f, 1.0f));
			images.put("wingsOfAngels", new TextureRegion(new Texture("res/gui/prayers/icons/wingsOfAngels.png"), 0, 0, 1.0f, 1.0f));
			
			images.put("nullBox", new TextureRegion(new Texture("res/gui/prayers/icons/nullBox.png"), 0, 0, 1.0f, 1.0f));
			
			images.put("flame", new TextureRegion(new Texture("res/effects/flame.png"), 0, 0, 1.0f, 1.0f));
			
			
			
			
			

			setLengths = new HashMap<String, Integer>();
			images.put("level1-1", new TextureRegion(new Texture("res/tiles/level1/crackedDirt.png"), 0, 0, 1.0f, 1.0f));
			setLengths.put("level1", 1);
			
			images.put("level2-1", new TextureRegion(new Texture("res/tiles/level2/mossTile.png"), 0, 0, 1.0f, 1.0f));
			setLengths.put("level2", 1);
			
			images.put("level3-1", new TextureRegion(new Texture("res/tiles/level3/redRock.png"), 0, 0, 1.0f, 1.0f));
			setLengths.put("level3", 1);
			
			images.put("level4-1", new TextureRegion(new Texture("res/tiles/level4/darkStone.png"), 0, 0, 1.0f, 1.0f));
			setLengths.put("level4", 1);
			
			

			animationSet = new HashMap<String, HashMap<String, Animation>>();

			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/character/sword/swordIdleAnim.png", 24, 34, true));
			animations.put("attacking",
					new Animation("res/character/sword/swordAttackAnim.png", 24, 17, false));
			animations.put("walking", new Animation("res/character/sword/swordWalkAnim.png", 24, 34, true));

			animationSet.put("sword", animations);

			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/character/bow/bowIdleAnim.png", 24, 34, true));
			animations.put("attacking",
					new Animation("res/character/bow/bowAttackAnim.png", 24, 50, false));
			animations.put("walking", new Animation("res/character/bow/bowWalkAnim.png", 24, 34, true));

			animationSet.put("bow", animations);



			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/goblin/goblinIdleAnim.png", 50, 10, true));
			animations.put("attacking", new Animation("res/enemy/goblin/goblinAttackAnim.png", 10, 10, false));
			animations.put("walking", new Animation("res/enemy/goblin/goblinIdleAnim.png", 50, 10, true));
			animationSet.put("goblin", animations);

			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/famineBoss/famineBossIdleAnim.png", 24, 34, true));
			animations.put("attacking", new Animation("res/enemy/famineBoss/famineBossAttackAnim.png", 24, 17, false));
			animations.put("walking", new Animation("res/enemy/famineBoss/famineBossWalk.png", 24, 34, true));
			animationSet.put("famineBoss", animations);
			
			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/plagueBoss/plagueBossIdleAnim.png", 24, 34, true));
			animations.put("attacking", new Animation("res/enemy/plagueBoss/plagueBossAttackAnim.png", 24, 17, false));
			animations.put("walking", new Animation("res/enemy/plagueBoss/plagueBossWalk.png", 24, 34, true));
			animationSet.put("plagueBoss", animations);
			
			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/warBoss/warBossIdleAnim.png", 24, 34, true));
			animations.put("attacking", new Animation("res/enemy/warBoss/warBossAttackAnim.png", 24, 17, false));
			animations.put("walking", new Animation("res/enemy/warBoss/warBossWalk.png", 24, 34, true));
			animationSet.put("warBoss", animations);

			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/deathBoss/deathBossIdleAnim.png", 24, 34, true));
			animations.put("attacking", new Animation("res/enemy/deathBoss/deathBossAttackAnim.png", 24, 17, false));
			animations.put("walking", new Animation("res/enemy/deathBoss/deathBossWalk.png", 24, 34, true));
			animationSet.put("deathBoss", animations);
			
			
			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/zombie/zombieIdleAnim.png", 50, 10, true));
			animations.put("attacking", new Animation("res/enemy/zombie/zombieAttackAnim.png", 10, 10, false));
			animations.put("walking", new Animation("res/enemy/zombie/zombieIdleAnim.png", 50, 10, true));
			animationSet.put("zombie", animations);
			
			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/warDemon/warDemonIdleAnim.png", 24, 20, true));
			animations.put("attacking", new Animation("res/enemy/warDemon/warDemonAttackAnim.png", 24, 20, false));
			animations.put("dying", new Animation("res/enemy/warDemon/warDemonDieAnim.png", 24, 15, false));
			animations.put("walking", new Animation("res/enemy/warDemon/warDemonWalkAnim.png", 24, 40, true));
			animationSet.put("demonWar", animations);

			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/famineDemon/famineDemonIdleAnim.png", 24, 20, true));
			animations.put("attacking", new Animation("res/enemy/famineDemon/famineDemonAttackAnim.png", 24, 20, false));
			animations.put("dying", new Animation("res/enemy/famineDemon/famineDemonDieAnim.png", 24, 15, false));
			animations.put("walking", new Animation("res/enemy/famineDemon/famineDemonWalkAnim.png", 24, 40, true));
			animationSet.put("demonFamine", animations);
			
			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/plagueDemon/plagueDemonIdleAnim.png", 24, 20, true));
			animations.put("attacking", new Animation("res/enemy/plagueDemon/plagueDemonAttackAnim.png", 24, 20, false));
			animations.put("dying", new Animation("res/enemy/plagueDemon/plagueDemonDieAnim.png", 24, 15, false));
			animations.put("walking", new Animation("res/enemy/plagueDemon/plagueDemonWalkAnim.png", 24, 40, true));
			animationSet.put("demonPlague", animations);
			
			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/deathDemon/deathDemonIdleAnim.png", 24, 20, true));
			animations.put("attacking", new Animation("res/enemy/deathDemon/deathDemonAttackAnim.png", 24, 20, false));
			animations.put("dying", new Animation("res/enemy/deathDemon/deathDemonDieAnim.png", 24, 15, false));
			animations.put("walking", new Animation("res/enemy/deathDemon/deathDemonWalkAnim.png", 24, 40, true));
			animationSet.put("demonDeath", animations);
			
			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/giantRat/giantRatIdleAnim.png", 50, 10, true));
			animations.put("attacking", new Animation("res/enemy/giantRat/giantRatAttackAnim.png", 10, 10, false));
			animations.put("walking", new Animation("res/enemy/giantRat/giantRatIdleAnim.png", 50, 10, true));
			animationSet.put("giantRat", animations);

			animations = new HashMap<String, Animation>();
			animations.put("default", new Animation("res/enemy/hellHound/hellHoundIdleAnim.png", 50, 10, true));
			animations.put("attacking", new Animation("res/enemy/hellHound/hellHoundAttackAnim.png", 10, 10, false));
			animations.put("walking", new Animation("res/enemy/hellHound/hellHoundIdleAnim.png", 50, 10, true));
			animationSet.put("hellHound", animations);
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	public TextureRegion find(String key)
	{
		return images.get(key);
	}

	public HashMap<String, Animation> findAnim(String key)
	{
		return animationSet.get(key);
	}

	public int lengthOfSet(String level)
	{
		return setLengths.get(level);
	}

}
