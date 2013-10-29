package com.ymr.firstGameTest;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame implements ApplicationListener {
	public SpriteBatch batch;
	// 声明纹理
	public Texture texture;
	public Sprite sprite;
	public TextureRegion textureRegion;

	@Override
	public void create() {
		batch = new SpriteBatch();
		// 实例化texture
		texture = new Texture(Gdx.files.internal("data/jay1.jpg"));
		textureRegion = new TextureRegion(texture, 500, 500, -500, -500);
		sprite = new Sprite(textureRegion);

		sprite.setSize(120, 120);// 设置绘制的大小，为了方便我们设置的120,120，小一点方便查看
		sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);// 设置旋转的中心点，咱们就设置为屏幕的中心点

		sprite.setRotation(50);// 这个是以上面设置的中心点为中心，旋转一定角度的设置

		sprite.setPosition(150, 110);// 起始位置设置为中心区域附近（150,110）
		sprite.setColor(1, 0, 1, 1);// 颜色就设置为粉色吧
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);// 设置背景为白色
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// 清屏

		batch.begin();
		batch.draw(texture, 0, 0, texture.getWidth(), texture.getHeight());
		batch.draw(textureRegion, 0, 0, textureRegion.getRegionHeight(),
				textureRegion.getRegionWidth());
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
