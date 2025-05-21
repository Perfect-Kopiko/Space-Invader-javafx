package com.example.spaceshootergamejavafx;

import java.util.Objects;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bomb extends GameObject {
  public static final int WIDTH = 50;
  public static final int HEIGHT = 50;
  private static final double SPEED = 2.0;
  private boolean dead = false;

  private static final Image bombImage = new Image(
      Objects.requireNonNull(Bomb.class.getResourceAsStream("/bomb.png")));

  // Thêm biến thời gian để tính toán quỹ đạo
  private double time = 0;
  private final double amplitude = 120;  // biên độ lắc lư
  private final double frequency = 0.01; // tần số lắc lư
  private final double initialX;

  public Bomb(double x, double y) {
    super(x, y, WIDTH, HEIGHT);
    this.initialX = x;
  }

  @Override
  public void update() {
    y += SPEED;
    time += 1;
    // Lắc lư theo hình sin
    x = initialX + amplitude * Math.sin(frequency * time);
  }

  @Override
  public void render(GraphicsContext gc) {
    gc.drawImage(bombImage, x - WIDTH / 2, y - HEIGHT / 2, WIDTH, HEIGHT);
  }

  @Override
  public boolean isDead() {
    return dead;
  }

  public void setDead(boolean dead) { this.dead = dead; }

  @Override
  public double getWidth() {
    return WIDTH;
  }

  @Override
  public double getHeight() {
    return HEIGHT;
  }
}
