package entity.player;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import ability.Ability;
import ability.ShootStraight;
import entity.base.Entity;
import entity.base.Piece;
import entity.base.Relocatable;
import entity.piece.Pawn;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Player extends Piece{

	private double speed;
	private Rectangle icon;

	public Player(int x, int y , int hp) {
		// TODO Auto-generated constructor stub
		super(x , y , hp);
		this.ability.add(new ShootStraight(10 , 10));	
	}
	
	// Getters & Setters

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public Rectangle getIcon() {
		return icon;
	}

	public void setIcon(Rectangle playerIcon) {
		this.icon = playerIcon;
	}

}
