package gameObjects;

import java.util.ArrayList;
import java.util.Random;

import ai.EnemyHandler;
import audio.AudioHandler;
import graphics.AnimationComponent;
import graphics.Canvas.LayerType;
import graphics.GraphicComponent;
import graphics.TempComponent;
import toolbox.DeltaTime;
import toolbox.Functions;

/*
 * Abstract class which all enemies should inherit from (maybe not bosses, we'll see)
 */
public abstract class EnemyObject extends MobileGameObject
{
	protected double speed;
	protected int damage;

	protected float attackMinRange;
	protected float attackMaxRange;

	protected boolean isAttacking;

	protected float alertDistance;

	protected float health;
	protected float maxHealth;
	

	protected ArrayList<GraphicComponent> healthSigns;

	protected Building owner;

	protected boolean isActive;
	
	private long lastAttack;
	private float attackDelay;

	public EnemyObject(int xin, int yin, int xSize, int ySize, String texture, double speedIn, int damageIn,
			int attackMaxRangeIn, int attackMinRangeIn, float alertDistanceIn, int healthIn, Building owner, float attackDelay)
	{
		super(xin, yin, xSize, ySize, texture, LayerType.ENEMIES, true, true);
		speed = speedIn;
		damage = damageIn;
		attackMaxRange = attackMaxRangeIn;
		attackMinRange = attackMinRangeIn;
		alertDistance = alertDistanceIn;
		health = maxHealth = healthIn;

		isAttacking = false;

		this.owner = owner;
		if (owner == null)
		{
			EnemyHandler.getEnemyHandler().add(this);
			isActive = true;
		}
		else
		{
			owner.addEnemy(this);
			isActive = owner.isActive();
		}
		
		this.attackDelay = attackDelay;
	}
	public EnemyObject(int xin, int yin, int xSize, int ySize, String texture, double speedIn, int damageIn,
			int attackMaxRangeIn, int attackMinRangeIn, float alertDistanceIn, int healthIn, Building owner)
	{
		this(xin,yin,xSize,ySize,texture,speedIn,damageIn,attackMaxRangeIn,attackMinRangeIn,alertDistanceIn,healthIn,owner,0);
	}

	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	
	
	
	private long lastGrowl = System.currentTimeMillis();
	private float growlDelay = 1+((new Random()).nextFloat()*4); //seconds
	
	/*
	 * Basic chase function that most enemies should inherit. This can be
	 * overridden if some enemies should do something else.
	 */
	public void update()
	{
		if(System.currentTimeMillis()-lastGrowl>growlDelay*1000)
		{
			lastGrowl = System.currentTimeMillis();
			growlDelay = 1+((new Random()).nextFloat()*4);
			playSound();
		}
		
		PlayerObject po = PlayerObject.getPlayerObject();

		if (isAttacking)
		{

			if (((AnimationComponent) gc).isDone("attacking"))
			{
				attack();
				isAttacking = false;
				lastAttack=System.currentTimeMillis();
			}
		}
		else
		{
			if (Functions.distance(this, po) < alertDistance)
			{
				if (Functions.distance(this, po) < attackMinRange)
				{

					turnTo(po.getX(), po.getY());
					if(System.currentTimeMillis()-lastAttack>attackDelay*1000)
					{
						gc.updateTexture("attacking");
						isAttacking = true;
					}
					else
					{
						gc.updateTexture("default");
					}
				}
				else
				{
					moveToPoint(po.getX(), po.getY(), speed * DeltaTime.getDeltaTime().getForEnemy());
					gc.updateTexture("walking");

				}
			}
		}
	}

	public void update(int x, int y)
	{
		if (this.x != x || this.y != y)
		{
			moveToPoint(x, y, speed * DeltaTime.getDeltaTime().getForEnemy());
			gc.updateTexture("walking");
		}
		else
		{
			gc.updateTexture("default");
		}
	}

	/*
	 * Doesn't do much now, but this is probably where I'll stuff the animation
	 * stuff. Also important if enemies do something weird while attacking.
	 */
	public void attack()
	{
		PlayerObject po = PlayerObject.getPlayerObject();

		int attackPointX = x + (xSize / 2) + (int) (Math.cos(Math.toRadians(rotation)) * attackMaxRange);
		int attackPointY = y + (ySize / 2) + (int) (Math.sin(Math.toRadians(rotation)) * attackMaxRange);

		if (po.getCollider().willCollide(attackPointX, attackPointY))
		{
			dealDamage();
		}
	}
	protected void playSound()
	{
		AudioHandler.getAudioLibrary().playSoundEffect("growl");
	}
	protected void dealDamage()
	{
		PlayerObject.getPlayerObject().takeDamage(damage, this);
	}

	/*
	 * @Override public void setPos(int x, int y) { super.setPos(x,y);
	 * if(healthSigns.size()>0) { for(GraphicComponent gc : healthSigns) {
	 * gc.setPos(x, y); } }
	 * 
	 * }
	 */
	/*
	 * When the character hits the enemy, this is called
	 */
	public void takeDamage(float dam)
	{
		if (isActive)
		{
			health -= dam;
			
			if (health <= 0)
			{
				health = 0;
				makeHealthSigns();
				die();
			}
			else
			{
				makeHealthSigns();
			}
			
		}
	}

	private void makeHealthSigns()
	{

		addLabel(new TempComponent(x, y, xSize, 5, 0, -10, 1.0f, "healthLostBar", LayerType.EFFECTS));
		addLabel(new TempComponent(x, y, (int) ((health /  maxHealth) * xSize), 5, 0, -10, 1.0f, "healthBar",
				LayerType.EFFECTS));

	}

	/*
	 * When enemies go down. TODO: death animations and kill collider (or
	 * preferably make it non-hittable).
	 */
	public void die()
	{
		if (owner == null)
		{
			EnemyHandler.getEnemyHandler().remove(this);
		}
		else
		{
			owner.remove(this);
		}
		c.kill();
		gc.changeLayer(LayerType.DEAD);
		gc.updateTexture("dying");
		((AnimationComponent) gc).freezeOnEnd();
				
	}
	
}
